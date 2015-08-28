/* pass=admin1 */
insert into user(date_created, email, first_name, last_name, password, role) values ("2015-08-17 15:36:43", "admin@admin.lt", "Admin", "Admin", "$2a$10$k8vbxDO1XSww2iccooPAb.EG6FjwR9gnXUwoVqGom31Ye3B3CC.Ge", "1");
/* pass=user1 */
/*insert into user(date_created, email, first_name, last_name, password, points_to_give, user_points, role) values ("2015-08-17 15:36:43", "user@user.lt", "User", "User", "$2a$10$eN0WzyLuSFBwX2oLDBdKFeV.Hlxork4nqT8map6u.e7UGEj/a4uIO", "1000", "10000", "0");
insert into user(date_created, email, first_name, last_name, password, points_to_give, role) values ("2015-08-17 15:36:43", "user2@user.lt", "User2", "User2", "$2a$10$eN0WzyLuSFBwX2oLDBdKFeV.Hlxork4nqT8map6u.e7UGEj/a4uIO", "1000", "0");
insert into user(date_created, email, first_name, last_name, password, points_to_give, role) values ("2015-08-17 15:36:43", "user3@user.lt", "User3", "User3", "$2a$10$eN0WzyLuSFBwX2oLDBdKFeV.Hlxork4nqT8map6u.e7UGEj/a4uIO", "1000", "0");
insert into user(date_created, email, first_name, last_name, password, points_to_give, role) values ("2015-08-17 15:36:43", "user4@user.lt", "User4", "User4", "$2a$10$eN0WzyLuSFBwX2oLDBdKFeV.Hlxork4nqT8map6u.e7UGEj/a4uIO", "1000", "0");
insert into user(date_created, email, first_name, last_name, password, points_to_give, role) values ("2015-08-17 15:36:43", "user5@user.lt", "User5", "User5", "$2a$10$eN0WzyLuSFBwX2oLDBdKFeV.Hlxork4nqT8map6u.e7UGEj/a4uIO", "1000", "0");
insert into user(date_created, email, first_name, last_name, password, points_to_give, role) values ("2015-08-17 15:36:43", "user6@user.lt", "User6", "User6", "$2a$10$eN0WzyLuSFBwX2oLDBdKFeV.Hlxork4nqT8map6u.e7UGEj/a4uIO", "1000", "0");
insert into user(date_created, email, first_name, last_name, password, points_to_give, role) values ("2015-08-17 15:36:43", "user7@user.lt", "User7", "User7", "$2a$10$eN0WzyLuSFBwX2oLDBdKFeV.Hlxork4nqT8map6u.e7UGEj/a4uIO", "1000", "0");
*/

insert into application_setting(property, value) values ('one_time_limit', 80);
insert into application_setting(property, value) values ('monthly_limit', 800);

INSERT INTO category (enabled, name) VALUES (0, 'Achievement');
INSERT INTO category (enabled, name) VALUES (1, 'Hard Work');
INSERT INTO category (enabled, name) VALUES (1, 'Friendliness');
INSERT INTO category (enabled, name) VALUES (1, 'Teamwork');
INSERT INTO category (enabled, name) VALUES (1, 'Other');

/*
INSERT INTO points_transfer_info (comment, date_created, from_userid, points, to_userid, category_id) VALUES ('qweee', '2015-08-19 17:40:29', '3', '2', '2', 1);
INSERT INTO points_transfer_info (comment, date_created, from_userid, points, to_userid, category_id) VALUES ('qweee', '2015-08-18 12:40:29', '3', '2', '2', 1);
INSERT INTO points_transfer_info (comment, date_created, from_userid, points, to_userid, category_id) VALUES ('qweee', '2015-08-19 17:40:29', '3', '2', '2', 1);
INSERT INTO points_transfer_info (comment, date_created, from_userid, points, to_userid, category_id) VALUES ('qweee', '2015-08-19 17:19:29', '3', '2', '2', 2);
INSERT INTO points_transfer_info (comment, date_created, from_userid, points, to_userid, category_id) VALUES ('qweee', '2015-08-19 17:40:29', '3', '2', '2', 1);
INSERT INTO points_transfer_info (comment, date_created, from_userid, points, to_userid, category_id) VALUES ('qweee', '2015-08-19 17:40:30', '3', '2', '2', 2);
INSERT INTO points_transfer_info (comment, date_created, from_userid, points, to_userid, category_id) VALUES ('qweee', '2015-08-19 17:40:29', '3', '2', '2', 1);
INSERT INTO points_transfer_info (comment, date_created, from_userid, points, to_userid, category_id) VALUES ('qweee', '2015-08-19 17:40:29', '3', '2', '2', 1);
INSERT INTO points_transfer_info (comment, date_created, from_userid, points, to_userid, category_id) VALUES ('qweee', '2015-08-19 17:40:29', '3', '2', '2', 1);
INSERT INTO points_transfer_info (comment, date_created, from_userid, points, to_userid, category_id) VALUES ('qweee', '2015-08-16 17:40:29', '3', '2', '2', 2);
INSERT INTO points_transfer_info (comment, date_created, from_userid, points, to_userid, category_id) VALUES ('qweee', '2015-08-19 17:40:29', '3', '2', '2', 1);
INSERT INTO points_transfer_info (comment, date_created, from_userid, points, to_userid, category_id) VALUES ('qweee', '2015-08-19 17:40:29', '3', '2', '2', 1);
INSERT INTO points_transfer_info (comment, date_created, from_userid, points, to_userid, category_id) VALUES ('qweee', '2015-08-19 17:40:29', '3', '2', '2', 1);
INSERT INTO points_transfer_info (comment, date_created, from_userid, points, to_userid, category_id) VALUES ('qweee', '2015-08-18 17:40:29', '3', '2', '2', 1);
*/

/*
insert into shop_item (date_added, deleted, description, image, image_name, image_type, name, quantity, value) values ('2015-08-18 17:40:29', false, 'Cuts the grass so quickly', 'http://www.savasodyba.lt/wp-content/uploads/2009/05/zoliapjove.jpg', 'car.jpg', 'image/jpeg', 'Grass car', '5', '50')
*/

/*insert into points_transfer_info(comment, date_created, from_userid, points, to_userid) values ("aaaa", '2015.05.12', 1, 100, 1);
insert into points_transfer_info(comment, date_created, from_userid, points, to_userid) values ("aaaa", '2015.05.12', 2, 100, 1);
insert into points_transfer_info(comment, date_created, from_userid, points, to_userid) values ("aaaa", '2015.07.02', 2, 100, 1);
insert into points_transfer_info(comment, date_created, from_userid, points, to_userid) values ("aaaa", '2015.07.02', 3, 100, 1);
insert into points_transfer_info(comment, date_created, from_userid, points, to_userid) values ("aaaa", '2015.08.02', 3, 100, 1);
insert into points_transfer_info(comment, date_created, from_userid, points, to_userid) values ("aaaa", '2015.05.02', 3, 100, 1);
insert into points_transfer_info(comment, date_created, from_userid, points, to_userid) values ("aaaa", '2015.08.30', 3, 100, 2);*/