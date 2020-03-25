import {Game} from './game';
import {Favorite} from './favorite';
import {Rating} from './rating';
import {Session} from './session';

export class Player {
  id: number;
  username: string;
  sessions: Session[];
  games: Game[];
  favorites: Favorite[];
  ratings: Rating[];
}
