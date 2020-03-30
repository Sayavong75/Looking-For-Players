import { Component, OnInit } from '@angular/core';
import {ApiConnectionService} from '../service/api-connection.service';
import {Session} from '../class/session';
import DateTimeFormat = Intl.DateTimeFormat;

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  sessions: Session[] = [];
  incommingSessions: Session[] = []; // pour sélectionner les sessions à venir seulement (tri sur la date)
  topSessions: Session[] = []; // pour sélectionner les 5 plus grosses sessions à venir

  constructor(private apiConnectionService: ApiConnectionService) { }

  ngOnInit() {
    this.apiConnectionService.getAllSessions().subscribe(
      sessions => {
        this.sessions = sessions;
        console.log(this.sessions);
        console.log(Date.now());
        console.log(this.sessions[0].dateOfGamingSession.getTime());
        this.getTopSessions();
        console.log('coucou');
      }
    );
  }

  getTopSessions() {
    // sélection des sessions à venir en premier
    for (let session of this.sessions) {
      console.log('passage fonction');
      console.log(session);
      if (session.dateOfGamingSession.getDate() >= Date.now()) {
        this.incommingSessions.push(session);
      }
    }
  }

}
