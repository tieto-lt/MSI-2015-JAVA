/* pass=admin1 */
insert into user(date_created, email, first_name, last_name, password, role) values ("2015-08-17 15:36:43", "admin@admin.lt", "Admin", "Admin", "$2a$10$k8vbxDO1XSww2iccooPAb.EG6FjwR9gnXUwoVqGom31Ye3B3CC.Ge", "1");
/* pass=user1 */
insert into user(date_created, email, first_name, last_name, password, points_to_give, role) values ("2015-08-17 15:36:43", "user@user.lt", "User", "User", "$2a$10$eN0WzyLuSFBwX2oLDBdKFeV.Hlxork4nqT8map6u.e7UGEj/a4uIO", "1000", "0");

insert into application_setting(property, value) values ('one_time_limit', 100);
insert into application_setting(property, value) values ('monthly_limit', 1000);

/*insert into points_transfer_info(comment, date_created, from_userid, points, to_userid) values ("aaaa", '2015.05.12', 1, 100, 1);
insert into points_transfer_info(comment, date_created, from_userid, points, to_userid) values ("aaaa", '2015.05.12', 2, 100, 1);
insert into points_transfer_info(comment, date_created, from_userid, points, to_userid) values ("aaaa", '2015.07.02', 2, 100, 1);
insert into points_transfer_info(comment, date_created, from_userid, points, to_userid) values ("aaaa", '2015.07.02', 3, 100, 1);
insert into points_transfer_info(comment, date_created, from_userid, points, to_userid) values ("aaaa", '2015.08.02', 3, 100, 1);
insert into points_transfer_info(comment, date_created, from_userid, points, to_userid) values ("aaaa", '2015.05.02', 3, 100, 1);
insert into points_transfer_info(comment, date_created, from_userid, points, to_userid) values ("aaaa", '2015.08.30', 3, 100, 2);*/