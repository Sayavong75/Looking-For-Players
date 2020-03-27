import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Player} from '../class/player';
import {Game} from '../class/game';
import {Session} from '../class/session';

@Injectable({
  providedIn: 'root'
})
export class ApiConnectionService {

  constructor(private http: HttpClient) {
  }

  // Player
  getPlayers(): Observable<Player[]> {
    return this.http.get<Player[]>('http://localhost:8080/api/players');
  }

  getOnePlayer(playerId): Observable<Player> {
    return this.http.get<Player>(`http://localhost:8080/api/players/${playerId}`);
  }

  updatePlayer(player, playerId) {
    return this.http.put(`http://localhost:8080/api/players/${playerId}`, player);
  }

  // Session
  getSessionsOfOnePlayer(playerId): Observable<Session[]> {
    return this.http.get<Session[]>(`http://localhost:8080/api/sessions/player/${playerId}`);
  }

}
