import {Component, OnInit} from '@angular/core';
import {ApiConnectionService} from '../service/api-connection.service';
import {Player} from '../class/player';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-player-profile',
  templateUrl: './player-profile.component.html',
  styleUrls: ['./player-profile.component.css']
})
export class PlayerProfileComponent implements OnInit {

  player: Player = new Player();
  playerId;
  players: Player[] = [];

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
      }
    );
  }

  updatePlayerProfile(gameId) {
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

    for (let player of this.players) {
      console.log(this.players);
      console.log(player.username);
      console.log(player.id);
      console.log(playerId);
      if (player.id === playerId) {
        return player.username;
      } else {
        return 'toto n\'est pas dans les favoris';
      }
    }
  }
}


