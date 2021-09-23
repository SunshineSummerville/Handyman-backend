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

insert into category (job_description, name, price) values ('maximized', 'Masonry', 35);
insert into category (job_description, name, price) values ('real-time', 'Painting & Vinyl Wall Covering', 90);
insert into category (job_description, name, price) values ('moratorium', 'Drywall & Acoustical (FED)', 74);
insert into category (job_description, name, price) values ('national', 'Wall Protection', 92);
insert into category (job_description, name, price) values ('User-friendly', 'Wall Protection', 86);
insert into category (job_description, name, price) values ('disintermediate', 'Roofing (Metal)', 84);
insert into category (job_description, name, price) values ('human-resource', 'Site Furnishings', 94);
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


insert into app_user (firstname, lastname, email, password, phonenumber, postalcode, provincie, street, username, housenumber) values ('Chrysler', 'McAlindon', 'cmcalindon0@nytimes.com', 'HjkNcAKAK', '771 975 7158', '4298TJ', 'Cécile', 'Shasta', 'cmcalindon0', 32);
insert into app_user (firstname, lastname, email, password, phonenumber, postalcode, provincie, street, username, housenumber) values ('Lucienne', 'Turnbull', 'lturnbull1@hhs.gov', '4e54va', '690 765 9844', '8315YO', 'Bécassine', 'Sutherland', 'lturnbull1', 73);
insert into app_user (firstname, lastname, email, password, phonenumber, postalcode, provincie, street, username, housenumber) values ('Lexine', 'Dight', 'ldight2@sbwire.com', 'GuRihhtxU', '238 130 4763', '9716GD', 'Åslög', 'Redwing', 'ldight2', 76);
insert into app_user (firstname, lastname, email, password, phonenumber, postalcode, provincie, street, username, housenumber) values ('Mart', 'Magwood', 'mmagwood3@walmart.com', 'JjJ3jxw4', '885 528 8118', '3189PA', 'Vérane', 'Vahlen', 'mmagwood3', 8);
insert into app_user (firstname, lastname, email, password, phonenumber, postalcode, provincie, street, username, housenumber) values ('Revkah', 'Gartrell', 'rgartrell4@taobao.com', 'm25E7RTmJjHt', '793 902 6812', '3928NO', 'Cécilia', 'Warrior', 'rgartrell4', 8);
insert into app_user (firstname, lastname, email, password, phonenumber, postalcode, provincie, street, username, housenumber) values ('Gino', 'Franzelini', 'gfranzelini5@amazon.de', 'F451e3', '364 170 2180', '3961H6', 'Marie-thérèse', 'Grayhawk', 'gfranzelini5', 88);
insert into app_user (firstname, lastname, email, password, phonenumber, postalcode, provincie, street, username, housenumber) values ('Donnell', 'Ioannidis', 'dioannidis6@psu.edu', 'nVTZetfyTN', '643 415 4431', '83074Z', 'Åke', 'Alpine', 'dioannidis6', 60);
insert into app_user (firstname, lastname, email, password, phonenumber, postalcode, provincie, street, username, housenumber) values ('Corrine', 'Blackway', 'cblackway7@house.gov', 'MSgrnR', '173 516 2375', '07499R', 'Maëlann', 'Cambridge', 'cblackway7', 39);
insert into app_user (firstname, lastname, email, password, phonenumber, postalcode, provincie, street, username, housenumber) values ('Denys', 'Inchan', 'dinchan8@apple.com', 'hqwk0bggbKp', '122 406 5571', '8532AA', 'Maëlla', 'Brown', 'dinchan8', 21);
insert into app_user (firstname, lastname, email, password, phonenumber, postalcode, provincie, street, username, housenumber) values ('Kasey', 'Golson', 'kgolson9@storify.com', 'rKMJtY', '681 396 9593', '8412WN', 'Irène', 'Pond', 'kgolson9', 66);
insert into app_user (firstname, lastname, email, password, phonenumber, postalcode, provincie, street, username, housenumber) values ('Levon', 'Tomaino', 'ltomainoa@latimes.com', 'dDPqVbA1K', '207 760 7007', '3036YV', 'Faîtes', 'Bunker Hill', 'ltomainoa', 97);
insert into app_user (firstname, lastname, email, password, phonenumber, postalcode, provincie, street, username, housenumber) values ('Elijah', 'Ball', 'eballb@sciencedirect.com', 'vNefkUmugxWh', '422 340 8369', '2427LK', 'Amélie', 'Upham', 'eballb', 5);
insert into app_user (firstname, lastname, email, password, phonenumber, postalcode, provincie, street, username, housenumber) values ('Morganica', 'Eglington', 'meglingtonc@usatoday.com', 'cHNP6A', '824 855 5063', '09664B', 'Yénora', 'Macpherson', 'meglingtonc', 68);
insert into app_user (firstname, lastname, email, password, phonenumber, postalcode, provincie, street, username, housenumber) values ('Ruth', 'Feasey', 'rfeaseyd@yahoo.co.jp', 'fFEtcpDkB', '102 459 5620', '9463IU', 'Adélie', 'Haas', 'rfeaseyd', 96);
insert into app_user (firstname, lastname, email, password, phonenumber, postalcode, provincie, street, username, housenumber) values ('Lurline', 'Chisolm', 'lchisolme@chronoengine.com', '4rrYwd9jav', '290 241 7770', '057482', 'Styrbjörn', 'Coleman', 'lchisolme', 66);
insert into app_user (firstname, lastname, email, password, phonenumber, postalcode, provincie, street, username, housenumber) values ('Lazarus', 'Shotbolt', 'lshotboltf@uiuc.edu', 'h31xouk', '770 738 2851', '7834H8', 'Maïté', 'Chinook', 'lshotboltf', 37);
insert into app_user (firstname, lastname, email, password, phonenumber, postalcode, provincie, street, username, housenumber) values ('Torry', 'Fadden', 'tfaddeng@ucoz.com', 'gmMfDSXl', '894 956 7868', '3027M2', 'Thérèse', 'Oakridge', 'tfaddeng', 96);
insert into app_user (firstname, lastname, email, password, phonenumber, postalcode, provincie, street, username, housenumber) values ('Juliana', 'Bliben', 'jblibenh@fotki.com', 'z8lxHghvPXa4', '630 838 1129', '7952W2', 'Salomé', 'Fairview', 'jblibenh', 29);
insert into app_user (firstname, lastname, email, password, phonenumber, postalcode, provincie, street, username, housenumber) values ('Charita', 'Doggerell', 'cdoggerelli@adobe.com', 'qELAQo7gqN', '624 466 2353', '52548D', 'Bérengère', 'Banding', 'cdoggerelli', 40);
insert into app_user (firstname, lastname, email, password, phonenumber, postalcode, provincie, street, username, housenumber) values ('Budd', 'Pannaman', 'bpannamanj@slate.com', 'mHdyRBHSc', '607 412 0814', '8549HJ', 'Daphnée', 'Tomscot', 'bpannamanj', 47);


insert into reservation (reservation_date, category_id, customer_id, handyman_id) values ('8/6/2021', 2, 14, 11);
insert into reservation (reservation_date, category_id, customer_id, handyman_id) values ('6/20/2021', 19, 2, 4);
insert into reservation (reservation_date, category_id, customer_id, handyman_id) values ('6/3/2021', 11, 3, 16);
insert into reservation (reservation_date, category_id, customer_id, handyman_id) values ('8/7/2021', 12, 2, 10);
insert into reservation (reservation_date, category_id, customer_id, handyman_id) values ('9/15/2021', 18, 16, 6);
insert into reservation (reservation_date, category_id, customer_id, handyman_id) values ('12/16/2020', 4, 6, 15);
insert into reservation (reservation_date, category_id, customer_id, handyman_id) values ('11/5/2020', 14, 16, 9);
insert into reservation (reservation_date, category_id, customer_id, handyman_id) values ('5/26/2021', 16, 11, 2);
insert into reservation (reservation_date, category_id, customer_id, handyman_id) values ('10/29/2020', 12, 12, 7);
insert into reservation (reservation_date, category_id, customer_id, handyman_id) values ('5/18/2021', 3, 13, 5);
insert into reservation (reservation_date, category_id, customer_id, handyman_id) values ('2/14/2021', 19, 17, 13);
insert into reservation (reservation_date, category_id, customer_id, handyman_id) values ('10/4/2020', 7, 8, 16);
insert into reservation (reservation_date, category_id, customer_id, handyman_id) values ('10/28/2020', 11, 18, 9);
insert into reservation (reservation_date, category_id, customer_id, handyman_id) values ('6/13/2021', 16, 14, 6);
insert into reservation (reservation_date, category_id, customer_id, handyman_id) values ('2/4/2021', 2, 3, 12);
insert into reservation (reservation_date, category_id, customer_id, handyman_id) values ('8/16/2021', 10, 11, 10);
insert into reservation (reservation_date, category_id, customer_id, handyman_id) values ('4/16/2021', 6, 17, 11);
insert into reservation (reservation_date, category_id, customer_id, handyman_id) values ('1/8/2021', 19, 14, 3);
insert into reservation (reservation_date, category_id, customer_id, handyman_id) values ('2/18/2021', 7, 4, 5);
insert into reservation (reservation_date, category_id, customer_id, handyman_id) values ('12/2/2020', 14, 12, 4);

