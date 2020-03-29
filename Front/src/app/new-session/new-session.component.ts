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
  sessionForm;
  session: Session;
  game: Game;
  games: Game[];
  player: Player;
  dateValue: Date = new Date();
  usernameValue: string = null;

  constructor(private connectionService: ApiConnectionService, private formBuilder: FormBuilder) {
    this.sessionForm = this.formBuilder.group({
      dateSession: '',
      game: '',
      player: '',
    });
  }

  ngOnInit() {
    this.connectionService.getGames().subscribe(
      games => this.games = games
    );
  }

  onSubmit(session) {
    this.dateValue = session.dateSession;
    console.log(session);
    // console.log('date : ' + this.dateValue);
    // this.connectionService.addSession(session).subscribe(
    //   saveSession => {
    //     console.log(saveSession);
    //     this.sessionForm.reset();
    //   });
  }
}
