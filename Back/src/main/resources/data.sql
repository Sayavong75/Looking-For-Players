insert into player(id, username) values (nextval('player_id_seq'),'Saya');
insert into player(id, username) values (nextval('player_id_seq'),'Guigui');


insert into game (id, id_steam, name_game, img_url_game) values (nextval('game_id_seq'), 10, 'Counter-Strike', 'https://steamcdn-a.akamaihd.net/steam/apps/10/header.jpg?t=1568751918');
insert into game (id, id_steam, name_game, img_url_game) values (nextval('game_id_seq'), 440, 'Team Fortress 2', 'https://steamcdn-a.akamaihd.net/steam/apps/440/header.jpg?t=1577610485');
insert into game (id, id_steam, name_game, img_url_game) values (nextval('game_id_seq'), 570, 'Dota 2', 'https://steamcdn-a.akamaihd.net/steam/apps/570/header.jpg?t=1581406684');
insert into game (id, id_steam, name_game, img_url_game) values (nextval('game_id_seq'), 230410, 'Warframe', 'https://steamcdn-a.akamaihd.net/steam/apps/230410/header.jpg?t=1576268096');

insert into session (id, date_of_gaming_session, game_id) values (nextval('session_id_seq'),'04/03/2020',1);
insert into session (id, date_of_gaming_session, game_id) values (nextval('session_id_seq'),'18/02/2020',3);

insert into player_sessions (players_id, sessions_id) values (1,1);
insert into player_sessions (players_id, sessions_id) values (2,1);
insert into player_sessions (players_id, sessions_id) values (1,2);

insert into game_sessions (game_idx, session_idx) values (1,1);
insert into game_sessions (game_idx, session_idx) values (3,2);

insert into player_games (players_id, games_id) values (1,1);
insert into player_games (players_id, games_id) values (1,3);
insert into player_games (players_id, games_id) values (2,1);

-- Ajout Guigui
-- insert into rating (id, rating_given_by_one_player_to_another_player,rating_received_by_one_player_from_another_player,player_id) values (1,5,4,2);
-- insert into rating (id, rating_given_by_one_player_to_another_player,player_id) values (nextval('rating_id_seq'),5,2);
-- insert into rating (id, rating_given_by_one_player_to_another_player,player_id) values (nextval('rating_id_seq'),3,1);
-- insert into rating (id, rating_given_by_one_player_to_another_player,player_id) values (nextval('rating_id_seq'),4,2);

-- insert into player_ratings (player_id, ratings_id) values (1,1);
-- insert into player_ratings (player_id, ratings_id) values (2,2);
-- insert into player_ratings (player_id, ratings_id) values (1,3);

-- insert into session_ratings (session_id, ratings_id) values (1,1);
-- insert into session_ratings (session_id, ratings_id) values (1,2);
-- insert into session_ratings (session_id, ratings_id) values (2,3);

insert into rating (id, rating_ofaplayer, evaluated_player_id/*, session_of_evaluation_id*/) values (nextval('rating_id_seq'),4,2/*,1*/);
insert into rating (id, rating_ofaplayer, evaluated_player_id/*, session_of_evaluation_id*/) values (nextval('rating_id_seq'),4,1/*,1*/);

/*insert into player_ratings (player_id, ratings_id) values (1,1);*/
/*insert into player_ratings (player_id, ratings_id) values (2,2);*/
-- Ajout Guigui


-- Ajouts Saya
/*insert into favorite (id, player_id, date_of_favorite_player_added) values (nextval('favorite_id_seq'),1,'01/01/2020');
insert into favorite (id, player_id, date_of_favorite_player_added) values (nextval('favorite_id_seq'),2,'20/02/2020');
insert into favorite (id, player_id, date_of_favorite_player_added) values (nextval('favorite_id_seq'),3,'01/01/2020');

insert into player_favorites (player_id, favorites_id) values (1,1);
insert into player_favorites (player_id, favorites_id) values (2,2);*/
