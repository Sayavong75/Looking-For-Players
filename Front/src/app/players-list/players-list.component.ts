import { Component, OnInit } from '@angular/core';
import {ApiConnectionService} from '../service/api-connection.service';
import {Player} from '../class/player';

@Component({
  selector: 'app-players-list',
  templateUrl: './players-list.component.html',
  styleUrls: ['./players-list.component.css']
})
export class PlayersListComponent implements OnInit {

  players: Player[];

  constructor(private connectionService: ApiConnectionService) { }

  ngOnInit() {
    this.connectionService.getPlayers().subscribe(
      players => this.players = players
    );
  }

}
