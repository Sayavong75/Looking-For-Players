import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Player} from '../class/player';
import {Game} from '../class/game';
import {Favorite} from '../class/favorite';
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

  addPlayer(player): Observable<Player> {
    return this.http.post<Player>('http://localhost:8080/api/players', player);
  }

  // Favori
  getFavorites(): Observable<Favorite[]> {
    return this.http.get<Favorite[]>('http://localhost:8080/api/favorites');
  }

  // Game
  getGames(): Observable<Game[]> {
    return this.http.get<Game[]>('http://localhost:8080/api/games');
    }

  // Session
  getSessionsOfOnePlayer(playerId): Observable<Session[]> {
    return this.http.get<Session[]>(`http://localhost:8080/api/sessions/player/${playerId}`);
  }

  addSession(session): Observable<Session> {
    return this.http.post<Session>('http://localhost:8080/api/sessions', session);
  }
}
