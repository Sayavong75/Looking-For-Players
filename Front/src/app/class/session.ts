import {Game} from './game';
import {Player} from './player';

export class Session {
  id: number;
  dateOfGamingSession: Date;
  game: Game;
  playersId: Player[];
}
