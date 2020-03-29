import {Component, OnInit} from '@angular/core';
import {ApiConnectionService} from '../service/api-connection.service';
import {Player} from '../class/player';
import {ActivatedRoute} from '@angular/router';
import {Favorite} from '../class/favorite';
import {Session} from '../class/session';

@Component({
  selector: 'app-player-profile',
  templateUrl: './player-profile.component.html',
  styleUrls: ['./player-profile.component.css']
})
export class PlayerProfileComponent implements OnInit {

  player: Player = new Player();
  playerId;
  players: Player[] = [];
  favoritesFromPlayers: Favorite[] = [];
  favorites: Player[] = [];
  sessions: Session[] = [];

  constructor(private connectionService: ApiConnectionService, private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.playerId = this.route.snapshot.paramMap.get('playerId');
    this.connectionService.getOnePlayer(this.playerId).subscribe(
      player => {
        this.player = player;
      }
    );
    this.connectionService.getPlayers().subscribe(
      players => {
        this.players = players;
        for (const favorite of this.player.favorites) {
          this.favoritesFromPlayers.push(favorite);
        }
        this.getFavorites();
      }
    );
    this.connectionService.getSessionsOfOnePlayer(this.playerId).subscribe(
      sessions => {
        this.sessions = sessions;
      }
    );
  }

  updatePlayerProfile(gameId) {
    console.log('fonction update');
    this.player.games.splice(gameId, 1);
    this.connectionService.updatePlayer(this.player as Player, this.playerId as number).subscribe(
      value => {
        console.log('Retour suite à la mise à jour de la fiche Joueur :');
        console.log(value);
      }, error => {
        console.log('erreur de mise à jour :');
        console.log(error);
      }
    );
  }

  getFavorites() {
    for (const favorite of this.favoritesFromPlayers) {
      for (const player of this.players) {
        if (favorite.favoritePlayer === player.id) {
          this.favorites.push(player);
        }
      }
    }
  }

  getPlayersInOneSession(players) {
    let res = [];
    for (let sessionPlayer of players) {
      for (let player of this.players) {
        if (player.id === sessionPlayer) {
          res.push(player.username);
        }
      }
    }
    return res;
  }

  getDateOfAddingInFavorites(favoritePlayerId) {
    for (let favorite of this.player.favorites) {
      if (favorite.favoritePlayer === favoritePlayerId) {
        return favorite.dateOfFavoritePlayerAdded;
      }
    }
  }

  public get hasGames(): boolean {
    return this.player.games.length !== 0;
  }

  public get hasFavorites(): boolean {
    return this.player.favorites.length !== 0;
  }

  public get hasSessions(): boolean {
    return this.player.sessions.length !== 0;
  }

}
