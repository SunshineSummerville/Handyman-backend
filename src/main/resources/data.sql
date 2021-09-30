/*
Spring runt dit SQL-bestand automatisch. Spring zoekt namelijk naar een bestand dat data.sql heet (in deze folder) en
voert de SQL commando's voor je uit. Dit is een van de manier om de database te vullen. Om dit te laten werken, is het
volgende aan application.properties toegevoegd:

spring.datasource.initialization-mode=always

Zoals gezegd, dit is een van de manieren. De huidige opzet avn deze applicatie heeft een vast aantal user-rollen. Deze
kunnen niet door eindgebruikers, moderators of admins toegevoegd worden. Alleen de programmeur kan user-rollen
toevoegen. Daarom is er ook geen Service & repo voor de user-rollen geprogrammeerd. De enige manier om dan iets in de
database te krijgen is via SQL statements in dit bestand.

 */
INSERT INTO role(name) VALUES('ROLE_USER');
INSERT INTO role(name) VALUES('ROLE_HANDYMAN');
INSERT INTO role(name) VALUES('ROLE_ADMIN');

insert into category (job_description, name, price) values ('plumbing is for the pipes', 'Plumber', 35);
insert into category (job_description, name, price) values ('paint the walls and stuff', 'Painter', 90);
insert into category (job_description, name, price) values ('Switch a lightbulb', 'Electrician', 74);
insert into category (job_description, name, price) values ('Get some glass windows', 'Glazier', 92);
insert into category (job_description, name, price) values ('Landscaping & weeding', 'Gardener', 86);
insert into category (job_description, name, price) values ('Need a new lock?', 'Locksmith', 84);
insert into category (job_description, name, price) values ('human-resource', 'Carpenter', 94);
insert into category (job_description, name, price) values ('Intuitive', 'Fire Protection', 80);
insert into category (job_description, name, price) values ('Function-based', 'Fire Protection', 77);
insert into category (job_description, name, price) values ('Implemented', 'Waterproofing & Caulking', 92);
insert into category (job_description, name, price) values ('website', 'Roofing (Metal)', 32);
insert into category (job_description, name, price) values ('Synergized', 'Electrical and Fire Alarm', 29);
insert into category (job_description, name, price) values ('Expanded', 'Soft Flooring and Base', 47);
insert into category (job_description, name, price) values ('circuit', 'Waterproofing & Caulking', 75);
insert into category (job_description, name, price) values ('time-frame', 'Epoxy Flooring', 98);
insert into category (job_description, name, price) values ('stable', 'Waterproofing & Caulking', 36);
insert into category (job_description, name, price) values ('algorithm', 'Fire Sprinkler System', 41);
insert into category (job_description, name, price) values ('Future-proofed', 'EIFS', 48);
insert into category (job_description, name, price) values ('upward-trending', 'Marlite Panels (FED)', 64);
insert into category (job_description, name, price) values ('holistic', 'Electrical', 88);



insert into app_user (firstname, lastname, email, password, phonenumber, postalcode, provincie, street, username, housenumber) values ('Chrysler', 'McAlindon', 'cmcalindon0@nytimes.com', '$2a$12$vzp7o52s1SR0wNj38YU6tu/k/r2nQKY2Ys3EJ08ZMjWY9pScFFy3W', '771 975 7158', '4298TJ', 'Noord-Brabant', 'Shasta', 'cmcalindon0', 32);
insert into app_user (firstname, lastname, email, password, phonenumber, postalcode, provincie, street, username, housenumber) values ('Lucienne', 'Turnbull', 'lturnbull1@hhs.gov', '$2a$12$vzp7o52s1SR0wNj38YU6tu/k/r2nQKY2Ys3EJ08ZMjWY9pScFFy3W', '690 765 9844', '8315YO', 'Zuid-Holland', 'Sutherland', 'lturnbull1', 73);
insert into app_user (firstname, lastname, email, password, phonenumber, postalcode, provincie, street, username, housenumber) values ('Lexine', 'Dight', 'ldight2@sbwire.com', '$2a$12$vzp7o52s1SR0wNj38YU6tu/k/r2nQKY2Ys3EJ08ZMjWY9pScFFy3W', '238 130 4763', '9716GD', 'Åslög', 'Redwing', 'ldight2', 76);
insert into app_user (firstname, lastname, email, password, phonenumber, postalcode, provincie, street, username, housenumber) values ('Mart', 'Magwood', 'mmagwood3@walmart.com', '$2a$12$vzp7o52s1SR0wNj38YU6tu/k/r2nQKY2Ys3EJ08ZMjWY9pScFFy3W', '885 528 8118', '3189PA', 'Vérane', 'Vahlen', 'mmagwood3', 8);
insert into app_user (firstname, lastname, email, password, phonenumber, postalcode, provincie, street, username, housenumber) values ('Revkah', 'Gartrell', 'rgartrell4@taobao.com', '$2a$12$vzp7o52s1SR0wNj38YU6tu/k/r2nQKY2Ys3EJ08ZMjWY9pScFFy3W', '793 902 6812', '3928NO', 'Cécilia', 'Warrior', 'rgartrell4', 8);
insert into app_user (firstname, lastname, email, password, phonenumber, postalcode, provincie, street, username, housenumber) values ('Gino', 'Franzelini', 'gfranzelini5@amazon.de', '$2a$12$vzp7o52s1SR0wNj38YU6tu/k/r2nQKY2Ys3EJ08ZMjWY9pScFFy3W', '364 170 2180', '3961H6', 'Flevoland', 'Grayhawk', 'gfranzelini5', 88);
insert into app_user (firstname, lastname, email, password, phonenumber, postalcode, provincie, street, username, housenumber) values ('Donnell', 'Ioannidis', 'dioannidis6@psu.edu', '$2a$12$vzp7o52s1SR0wNj38YU6tu/k/r2nQKY2Ys3EJ08ZMjWY9pScFFy3W', '643 415 4431', '83074Z', 'Zeeland', 'Alpine', 'dioannidis6', 60);
insert into app_user (firstname, lastname, email, password, phonenumber, postalcode, provincie, street, username, housenumber) values ('Corrine', 'Blackway', 'cblackway7@house.gov', '$2a$12$vzp7o52s1SR0wNj38YU6tu/k/r2nQKY2Ys3EJ08ZMjWY9pScFFy3W', '173 516 2375', '07499R', 'Drenthe', 'Cambridge', 'cblackway7', 39);
insert into app_user (firstname, lastname, email, password, phonenumber, postalcode, provincie, street, username, housenumber) values ('Denys', 'Inchan', 'dinchan8@apple.com', '$2a$12$vzp7o52s1SR0wNj38YU6tu/k/r2nQKY2Ys3EJ08ZMjWY9pScFFy3W', '122 406 5571', '8532AA', 'Maëlla', 'Brown', 'dinchan8', 21);
insert into app_user (firstname, lastname, email, password, phonenumber, postalcode, provincie, street, username, housenumber) values ('Kasey', 'Golson', 'kgolson9@storify.com', '$2a$12$vzp7o52s1SR0wNj38YU6tu/k/r2nQKY2Ys3EJ08ZMjWY9pScFFy3W', '681 396 9593', '8412WN', 'Irène', 'Pond', 'kgolson9', 66);
insert into app_user (firstname, lastname, email, password, phonenumber, postalcode, provincie, street, username, housenumber) values ('Levon', 'Tomaino', 'ltomainoa@latimes.com', '$2a$12$vzp7o52s1SR0wNj38YU6tu/k/r2nQKY2Ys3EJ08ZMjWY9pScFFy3W', '207 760 7007', '3036YV', 'Overijssel', 'Bunker Hill', 'ltomainoa', 97);
insert into app_user (firstname, lastname, email, password, phonenumber, postalcode, provincie, street, username, housenumber) values ('Elijah', 'Ball', 'eballb@sciencedirect.com', '$2a$12$vzp7o52s1SR0wNj38YU6tu/k/r2nQKY2Ys3EJ08ZMjWY9pScFFy3W', '422 340 8369', '2427LK', 'Drenthe', 'Upham', 'eballb', 5);
insert into app_user (firstname, lastname, email, password, phonenumber, postalcode, provincie, street, username, housenumber) values ('Morganica', 'Eglington', 'meglingtonc@usatoday.com', '$2a$12$vzp7o52s1SR0wNj38YU6tu/k/r2nQKY2Ys3EJ08ZMjWY9pScFFy3W', '824 855 5063', '09664B', 'Gelderland', 'Macpherson', 'meglingtonc', 68);
insert into app_user (firstname, lastname, email, password, phonenumber, postalcode, provincie, street, username, housenumber) values ('Ruth', 'Feasey', 'rfeaseyd@yahoo.co.jp', '$2a$12$vzp7o52s1SR0wNj38YU6tu/k/r2nQKY2Ys3EJ08ZMjWY9pScFFy3W', '102 459 5620', '9463IU', 'Adélie', 'Haas', 'rfeaseyd', 96);
insert into app_user (firstname, lastname, email, password, phonenumber, postalcode, provincie, street, username, housenumber) values ('Lurline', 'Chisolm', 'lchisolme@chronoengine.com', '$2a$12$vzp7o52s1SR0wNj38YU6tu/k/r2nQKY2Ys3EJ08ZMjWY9pScFFy3W', '290 241 7770', '057482', 'Styrbjörn', 'Coleman', 'lchisolme', 66);
insert into app_user (firstname, lastname, email, password, phonenumber, postalcode, provincie, street, username, housenumber) values ('Lazarus', 'Shotbolt', 'lshotboltf@uiuc.edu', '$2a$12$vzp7o52s1SR0wNj38YU6tu/k/r2nQKY2Ys3EJ08ZMjWY9pScFFy3W', '770 738 2851', '7834H8', '', 'Chinook', 'lshotboltf', 37);
insert into app_user (firstname, lastname, email, password, phonenumber, postalcode, provincie, street, username, housenumber) values ('Torry', 'Fadden', 'tfaddeng@ucoz.com', '$2a$12$vzp7o52s1SR0wNj38YU6tu/k/r2nQKY2Ys3EJ08ZMjWY9pScFFy3W', '894 956 7868', '3027M2', 'Thérèse', 'Flevoland', 'tfaddeng', 96);
insert into app_user (firstname, lastname, email, password, phonenumber, postalcode, provincie, street, username, housenumber) values ('Juliana', 'Bliben', 'jblibenh@fotki.com', '$2a$12$vzp7o52s1SR0wNj38YU6tu/k/r2nQKY2Ys3EJ08ZMjWY9pScFFy3W', '630 838 1129', '7952W2', 'Salomé', 'Utrecht', 'jblibenh', 29);
insert into app_user (firstname, lastname, email, password, phonenumber, postalcode, provincie, street, username, housenumber) values ('Charita', 'Doggerell', 'cdoggerelli@adobe.com', '$2a$12$vzp7o52s1SR0wNj38YU6tu/k/r2nQKY2Ys3EJ08ZMjWY9pScFFy3W', '624 466 2353', '52548D', 'Noord-Holland', 'Banding', 'cdoggerelli', 40);
insert into app_user (firstname, lastname, email, password, phonenumber, postalcode, provincie, street, username, housenumber) values ('Budd', 'Pannaman', 'bpannamanj@slate.com', '$2a$12$vzp7o52s1SR0wNj38YU6tu/k/r2nQKY2Ys3EJ08ZMjWY9pScFFy3W', '607 412 0814', '8549HJ', 'Groningen', 'Tomscot', 'bpannamanj', 47);


insert into reservation (reservation_date, category_id, customer_id, handyman_id) values ('8/6/2021', 2, 1, 2);
insert into reservation (reservation_date, category_id, customer_id, handyman_id) values ('6/20/2021', 19, 3, 4);
insert into reservation (reservation_date, category_id, customer_id, handyman_id) values ('6/3/2021', 11, 5, 6);
insert into reservation (reservation_date, category_id, customer_id, handyman_id) values ('8/7/2021', 12, 7, 8);
insert into reservation (reservation_date, category_id, customer_id, handyman_id) values ('9/15/2021', 18, 9,10);
insert into reservation (reservation_date, category_id, customer_id, handyman_id) values ('12/16/2020', 4, 11, 12);
insert into reservation (reservation_date, category_id, customer_id, handyman_id) values ('11/5/2020', 14, 13, 14);
insert into reservation (reservation_date, category_id, customer_id, handyman_id) values ('5/26/2021', 16, 15, 16);
insert into reservation (reservation_date, category_id, customer_id, handyman_id) values ('10/29/2020', 12, 17, 18);
insert into reservation (reservation_date, category_id, customer_id, handyman_id) values ('5/18/2021', 3, 19, 20);
insert into reservation (reservation_date, category_id, customer_id, handyman_id) values ('2/14/2021', 19, 1, 2);
insert into reservation (reservation_date, category_id, customer_id, handyman_id) values ('10/4/2020', 7, 3, 4);
insert into reservation (reservation_date, category_id, customer_id, handyman_id) values ('10/28/2020', 11, 5, 6);
insert into reservation (reservation_date, category_id, customer_id, handyman_id) values ('6/13/2021', 16, 7, 8);
insert into reservation (reservation_date, category_id, customer_id, handyman_id) values ('2/4/2021', 2, 9, 10);
insert into reservation (reservation_date, category_id, customer_id, handyman_id) values ('8/16/2021', 10, 11, 12);
insert into reservation (reservation_date, category_id, customer_id, handyman_id) values ('4/16/2021', 6, 13, 14);
insert into reservation (reservation_date, category_id, customer_id, handyman_id) values ('1/8/2021', 19, 15, 16);
insert into reservation (reservation_date, category_id, customer_id, handyman_id) values ('2/18/2021', 7, 17, 20);
insert into reservation (reservation_date, category_id, customer_id, handyman_id) values ('12/2/2020', 14, 19, 4);

insert into user_role (user_id, role_id) values (1,1);
insert into user_role (user_id, role_id) values (2,2);
insert into user_role (user_id, role_id) values (3,1);
insert into user_role (user_id, role_id) values (4,2);
insert into user_role (user_id, role_id) values (5,1);
insert into user_role (user_id, role_id) values (6,2);
insert into user_role (user_id, role_id) values (7,1);
insert into user_role (user_id, role_id) values (8,2);
insert into user_role (user_id, role_id) values (9,1);
insert into user_role (user_id, role_id) values (10,2);
insert into user_role (user_id, role_id) values (11,1);
insert into user_role (user_id, role_id) values (12,2);
insert into user_role (user_id, role_id) values (13,1);
insert into user_role (user_id, role_id) values (14,2);
insert into user_role (user_id, role_id) values (15,1);
insert into user_role (user_id, role_id) values (16,2);
insert into user_role (user_id, role_id) values (17,1);
insert into user_role (user_id, role_id) values (18,2);
insert into user_role (user_id, role_id) values (19,1);
insert into user_role (user_id, role_id) values (20,2);
insert into user_role (user_id, role_id) values (1,3);

insert into category_handymen (category_id, handymen_id) values (1,2);
insert into category_handymen (category_id, handymen_id) values (2,2);
insert into category_handymen (category_id, handymen_id) values (3,4);
insert into category_handymen (category_id, handymen_id) values (4,4);
insert into category_handymen (category_id, handymen_id) values (5,6);
insert into category_handymen (category_id, handymen_id) values (6,6);
insert into category_handymen (category_id, handymen_id) values (7,8);
insert into category_handymen (category_id, handymen_id) values (8,8);
insert into category_handymen (category_id, handymen_id) values (9,10);
insert into category_handymen (category_id, handymen_id) values (10,10);