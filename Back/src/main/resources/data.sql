insert into player(id, username) values (nextval('player_id_seq'),'Saya');
insert into player(id, username) values (nextval('player_id_seq'),'Guigui');
insert into player(id, username) values (nextval('player_id_seq'),'Wizard');

insert into game (id, id_steam, name_game, img_url_game) values (nextval('game_id_seq'), 10, 'Counter-Strike', 'https://steamcdn-a.akamaihd.net/steam/apps/10/header.jpg?t=1568751918');
insert into game (id, id_steam, name_game, img_url_game) values (nextval('game_id_seq'), 440, 'Team Fortress 2', 'https://steamcdn-a.akamaihd.net/steam/apps/440/header.jpg?t=1577610485');
insert into game (id, id_steam, name_game, img_url_game) values (nextval('game_id_seq'), 570, 'Dota 2', 'https://steamcdn-a.akamaihd.net/steam/apps/570/header.jpg?t=1581406684');
insert into game (id, id_steam, name_game, img_url_game) values (nextval('game_id_seq'), 230410, 'Warframe', 'https://steamcdn-a.akamaihd.net/steam/apps/230410/header.jpg?t=1576268096');
insert into game (id, id_steam, name_game, img_url_game) values (nextval('game_id_seq'), 271590, 'Grand Theft Auto V', 'https://steamcdn-a.akamaihd.net/steam/apps/271590/header.jpg?t=1579797647');
insert into game (id, id_steam, name_game, img_url_game) values (nextval('game_id_seq'), 1085660, 'Destiny 2', 'https://steamcdn-a.akamaihd.net/steam/apps/1085660/header.jpg?t=1583858222');
insert into game (id, id_steam, name_game, img_url_game) values (nextval('game_id_seq'), 582010, 'MONSTER HUNTER: WORLD', 'https://steamcdn-a.akamaihd.net/steam/apps/582010/header.jpg?t=1583974232');
insert into game (id, id_steam, name_game, img_url_game) values (nextval('game_id_seq'), 578080 , 'PLAYERUNundry''S BATTLEGROUNDS', 'https://steamcdn-a.akamaihd.net/steam/apps/578080/header.jpg?t=1581036302');
insert into game (id, id_steam, name_game, img_url_game) values (nextval('game_id_seq'), 730, 'Counter-Strike: Global Offensive', 'https://steamcdn-a.akamaihd.net/steam/apps/730/header.jpg?t=1580765900');
insert into game (id, id_steam, name_game, img_url_game) values (nextval('game_id_seq'), 346110, 'ARK: Survival Evolved', 'https://steamcdn-a.akamaihd.net/steam/apps/346110/header.jpg?t=1583178772');
insert into game (id, id_steam, name_game, img_url_game) values (nextval('game_id_seq'), 1100600, 'Football Manager 2020', 'https://steamcdn-a.akamaihd.net/steam/apps/1100600/header.jpg?t=1584981392');
insert into game (id, id_steam, name_game, img_url_game) values (nextval('game_id_seq'), 203160, 'Tomb Raider', 'https://steamcdn-a.akamaihd.net/steam/apps/203160/header.jpg?t=1584650700');
insert into game (id, id_steam, name_game, img_url_game) values (nextval('game_id_seq'), 397540, 'Borderlands 3', 'https://steamcdn-a.akamaihd.net/steam/apps/397540/header.jpg?t=1584481269');
insert into game (id, id_steam, name_game, img_url_game) values (nextval('game_id_seq'), 252490, 'Rust', 'https://steamcdn-a.akamaihd.net/steam/apps/252490/header.jpg?t=1579783966');
insert into game (id, id_steam, name_game, img_url_game) values (nextval('game_id_seq'), 238960, 'Path of Exile', 'https://steamcdn-a.akamaihd.net/steam/apps/238960/header.jpg?t=1584387270');

insert into session (id, date_of_gaming_session, game_id) values (nextval('session_id_seq'),'04/03/2020',1);
insert into session (id, date_of_gaming_session, game_id) values (nextval('session_id_seq'),'18/02/2020',3);

insert into session_players (players_id, sessions_id) values (1,1);
insert into session_players (players_id, sessions_id) values (2,1);
insert into session_players (players_id, sessions_id) values (1,2);

insert into game_sessions (game_idx, session_idx) values (1,1);
insert into game_sessions (game_idx, session_idx) values (3,2);

insert into player_games (players_id, games_id) values (1,1);
insert into player_games (players_id, games_id) values (1,3);
insert into player_games (players_id, games_id) values (2,1);

-- Ajout Guigui

insert into rating (id, rating_ofaplayer, evaluated_player_id) values (nextval('rating_id_seq'),4,2);
insert into rating (id, rating_ofaplayer, evaluated_player_id) values (nextval('rating_id_seq'),3,1);

insert into player_ratings (player_id,ratings_id) values (1,1);
insert into player_ratings (player_id,ratings_id) values (2,2);

-- Ajout Guigui


-- Ajouts Saya
insert into favorite (id, favorite_player_id, date_of_favorite_player_added) values (nextval('favorite_id_seq'),2,'01/01/2020');
insert into favorite (id, favorite_player_id, date_of_favorite_player_added) values (nextval('favorite_id_seq'),3,'20/02/2020');
insert into favorite (id, favorite_player_id, date_of_favorite_player_added) values (nextval('favorite_id_seq'),1,'01/01/2020');

insert into player_favorites (player_id, favorites_id) values (1,1);
insert into player_favorites (player_id, favorites_id) values (2,3);
insert into player_favorites (player_id, favorites_id) values (3,2);
