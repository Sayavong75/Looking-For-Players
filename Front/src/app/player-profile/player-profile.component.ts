import {Component, OnInit} from '@angular/core';
import {ApiConnectionService} from '../service/api-connection.service';
import {Player} from '../class/player';
import {ActivatedRoute} from '@angular/router';
import {Favorite} from '../class/favorite';

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
        for (let favorite of this.player.favorites) {
          this.favoritesFromPlayers.push(favorite);
        }
        this.getFavoriteUsername();
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
        console.log(error);
      }
    );
  }

  getFavoritePlayerInformation(playerId) {
    const res = [];
    for (const player of this.players) {
      console.log(this.players);
      console.log(player.username);
      console.log(player.id);
      console.log(playerId);

      if (player.id === playerId) {
        console.log(true);
      } else {
        console.log(false);
      }

      if (player.id === playerId) {
        /*res.push(player.username);*/
        return player.username;
      }
    }
    /*return res;*/
  }

  getFavoriteUsername() {
    for (let favorite of this.favoritesFromPlayers) {
      for (let player of this.players) {
        if (favorite.favoritePlayer === player.id) {
          this.favorites.push(player);
          console.log(player.username);
        }
      }
    }
  }

}


