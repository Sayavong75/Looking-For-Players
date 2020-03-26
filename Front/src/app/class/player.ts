import {Game} from './game';
import {Favorite} from './favorite';
import {GivenRating} from './givenRating';
import {Session} from './session';
import {ReceivedRating} from './receivedRating';

export class Player {
  id: number;
  username: string;
  sessions: Session[];
  games: Game[];
  favorites: Favorite[];
  givenRatings: GivenRating[];
  receivedRatings: ReceivedRating[];
}
