import {Game} from './game';
import {Favorite} from './favorite';
import {Rating} from './rating';

export class Player {
  id: number;
  username: string;
  games: Game[];
  favorite: Favorite[];
  ratings: Rating[];
}
