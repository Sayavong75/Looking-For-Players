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
        console.log(this.player);
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
  }

  updatePlayerProfile(gameId) {
    console.log('fonction update');
    this.player.games.splice(gameId, 1);
    this.connectionService.updatePlayer(this.player as Player, this.playerId as number).subscribe(
      value => {
        console.log('Retour suite à la mise à jour de la fiche Joueur :');
        console.log(value);
      }, error => {
        console.log('erreur de mise à jour :')
        console.log(error);
      }
    );
  }

  getFavorites() {
    for (let favorite of this.favoritesFromPlayers) {
      for (let player of this.players) {
        if (favorite.favoritePlayerId === player.id) {
          this.favorites.push(player);
          console.log(player.username);
        }
      }
    }
  }

}


