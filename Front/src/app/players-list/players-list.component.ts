import { Component, OnInit } from '@angular/core';
import {ApiConnectionService} from '../service/api-connection.service';
import {Player} from '../class/player';
import {Favorite} from '../class/favorite';

@Component({
  selector: 'app-players-list',
  templateUrl: './players-list.component.html',
  styleUrls: ['./players-list.component.css']
})
export class PlayersListComponent implements OnInit {

  players: Player[];
  player: Player = new Player();
  favoritesFromPlayers: Favorite[] = [];
  favoritesList: Player[] = [];
  favorites: Favorite[];

  constructor(private connectionService: ApiConnectionService) { }

  ngOnInit() {
    this.connectionService.getPlayers().subscribe(
      players => this.players = players
    );
    this.connectionService.getFavorites().subscribe(
      favorites => this.favorites = favorites
    );
  }

  getFavoriteUsername(playerId) {
    for (const player of this.players) {
      if (playerId === player.id) {
        return player.username;
      }
    }
  }

}
