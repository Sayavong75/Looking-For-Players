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
