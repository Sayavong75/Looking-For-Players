import {Component, OnInit} from '@angular/core';
import {Player} from '../class/player';
import {Game} from '../class/game';
import {ApiConnectionService} from '../service/api-connection.service';
import {FormBuilder} from '@angular/forms';
import {Favorite} from '../class/favorite';
import {Session} from '../class/session';

@Component({
  selector: 'app-new-session',
  templateUrl: './new-session.component.html',
  styleUrls: ['./new-session.component.css']
})
export class NewSessionComponent implements OnInit {
  theDate: any;
  sessionForm;
  session: Session;
  game: Game;
  games: Game[];
  player: Player;
  players: Player[];
  favorite: Favorite;
  favorites: Favorite[];
  gameName;
  public minDate: Date = new Date(Date.now());
  public maxDate: Date = new Date ('12/31/2020');
  public value: Date = new Date (Date.now());
  usernameValue: string = null;

  constructor(private connectionService: ApiConnectionService, private formBuilder: FormBuilder) {
    this.sessionForm = this.formBuilder.group({
      username: '',
      gameName: '',
      dateSession: ''
    });
  }

  ngOnInit() {
    this.connectionService.getGames().subscribe(
      games => this.games = games
    );
  }

  onSubmit(session) {
    console.log(session);
  }
}
