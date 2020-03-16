import { Component, OnInit } from '@angular/core';
import {ApiConnectionService} from '../service/api-connection.service';
import {Player} from '../class/player';

@Component({
  selector: 'app-player-profile',
  templateUrl: './player-profile.component.html',
  styleUrls: ['./player-profile.component.css']
})
export class PlayerProfileComponent implements OnInit {
  players: Player[];

  constructor(private connectionService: ApiConnectionService) { }

  ngOnInit() {
    this.connectionService.getPlayers().subscribe(
      players => this.players = players
    );
  }

}
