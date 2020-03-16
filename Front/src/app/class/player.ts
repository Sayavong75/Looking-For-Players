import {Game} from './game';
import {Favorite} from './favorite';

export class Player {
  id: number;
  username: string;
  games: Game[];
  favorite: Favorite[];
}
