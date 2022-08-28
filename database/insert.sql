insert into categories(name) values("programing");
insert into categories(name) values("database");
insert into categories(name) values("design");


insert into items values(1,1,"Lập trình Perl & CGI", "Nguyễn Văn A", 45000, "localhost", "/template/IMAGES/BOOKS/020135358X.gif", "Sách trên máy chủ localhost", 1);
insert into items values(2,2,"Database Oralce 8", "Nguyễn Văn B", 32000, "localhost", "/template/IMAGES/BOOKS/0072122420.jpg", "Sách trên máy chủ localhost", 1);
insert into items values(3,3,"Thiết kế Website với HTML4", "Nguyễn Văn C", 43000, "localhost", "/template/IMAGES/BOOKS/0201354934.jpg", "Sách trên máy chủ localhost", 1);
insert into items values(4,1,"Sách LT Perl", "Nguyễn Thái Ngọc", 99000, "localhost", "/template/IMAGES/BOOKS/0596000278.jpg", "Sách trên máy chủ localhost", 1);
insert into items values(5,1,"Lập trình PHP & MySQL", "Trần Trung Nghĩa", 63000, "localhost", "/template/IMAGES/BOOKS/0672317842.jpg", "Sách trên máy chủ localhost", 1);
insert into items values(6,1,"Sách ColdFusion", "Đinh Công Trứ", 32000, "localhost", "/template/IMAGES/BOOKS/0672317966.jpg", "Sách trên máy chủ localhost", 1);
insert into items values(7,2,"Sách Step By Step", "Nguyễn Thái Ngọc", 90000, "localhost", "/template/IMAGES/BOOKS/0735609667.jpg", "Sách trên máy chủ localhost", 1);
insert into items values(8,2,"Database MySQL", "Trần Trung Nghĩa", 60000, "localhost", "/template/IMAGES/BOOKS/0735709211.jpg", "Sách trên máy chủ localhost", 1);
insert into items values(9,2,"Flash 4", "Đinh Công Trứ", 30000, "localhost", "/template/IMAGES/BOOKS/0735709491.jpg", "Sách trên máy chủ localhost", 1);
insert into items values(10,3,"Sách Web Application", "Nguyễn Bình", 90000, "localhost", "/template/IMAGES/BOOKS/0735709971.jpg", "Sách trên máy chủ localhost", 1);
insert into items values(11,3,"Sách ColdFusion 4", "Trần Đề", 60000, "localhost", "/template/IMAGES/BOOKS/0761530169.jpg", "Sách trên máy chủ localhost", 1);
insert into items values(12,3,"Sách ColdFusion 5", "Đinh Văn Giỏi", 30000, "localhost", "/template/IMAGES/BOOKS/0782127738.jpg", "Sách trên máy chủ localhost", 1);

insert into editorial_categories values(1, "recommended");
insert into editorial_categories(editorial_cat_name) values("advertise");
insert into editorial_categories(editorial_cat_name) values("new");


insert into editorial values(1,1,"Recommended Module", "Sách được khuyến nghị hiển thị cho người dùng", 1);
insert into editorial values(2,2,"Advertise Module", "Sách được quảng cáo cho trang", 2);
insert into editorial values(3,3,"New Module", "Sách mới về", 3);
insert into editorial values(4,1,"Recommended Module", "Sách được khuyến nghị hiển thị cho người dùng", 4);
insert into editorial values(5,1,"Recommended Module", "Sách được khuyến nghị hiển thị cho người dùng", 5);
insert into editorial values(6,1,"Recommended Module", "Sách được khuyến nghị hiển thị cho người dùng", 6);
insert into editorial values(7,2,"Advertise Module", "Sách được quảng cáo cho trang", 7);
insert into editorial values(8,2,"Advertise Module", "Sách được quảng cáo cho trang", 8);
insert into editorial values(9,2,"Advertise Module", "Sách được quảng cáo cho trang", 9);
insert into editorial values(10,3,"New Module", "Sách mới về", 10);
insert into editorial values(11,3,"New Module", "Sách mới về", 11);
insert into editorial values(12,3,"New Module", "Sách mới về", 12);


insert into role values(1, "ADMIN", "Quản trị");
insert into role values(2, "USER", "Người dùng");


insert into card_types(name) values("Sacombank");
insert into card_types(name) values("HDBank");


insert into members values(1, "admin", "admin", 1, "admin", "admin", "admin@gmail.com", "0939111", "Việt Nam", "Tài khoản quản trị website", 1, "36399");
insert into members values(2, "pdanh", "pdanh", 2, "Anh", "Phan", "pdanh2682000@gmail.com", "0335479939", "Việt Nam", "Tài khoản người dùng", 2, "12345");


insert into topic_messages(topic, author, date_entered) values("Review sách Perl", "Trần Công Thoại", curdate());
insert into topic_messages(topic, author, date_entered) values("Nội dung sách Database", "Đình Phong", curdate());
insert into topic_messages(topic, author, date_entered) values("Mình cần giúp đỡ", "Mai Văn Thúy", curdate());
insert into topic_messages(topic, author, date_entered) values("Sách trong đây hay không?", "Đoàn Dự", curdate());
insert into topic_messages(topic, author, date_entered) values("Mua sách như thế nào", "Triển Chiêu", curdate());
insert into topic_messages(topic, author, date_entered) values("Có thanh toán qua thẻ ko ạ!", "Kiều Phong", curdate());
insert into topic_messages(topic, author, date_entered) values("Cảm ơn BookStore Danh Uy nhìu", "Mộ Dung Công Tử", curdate());
insert into topic_messages(topic, author, date_entered) values("Sách rất tôt!", "Doãn Chí Bình", curdate());

insert into messages(message_id, message, author, date_entered) values(1, "Perl rất hay nha bạn!", "Ngô Khả", curdate());
insert into messages(message_id, message, author, date_entered) values(2, "Database ổn", "Hắc Bạch Công Tử", curdate());
insert into messages(message_id, message, author, date_entered) values(3, "Giúp gì thằng kia", "Cô Long", curdate());
insert into messages(message_id, message, author, date_entered) values(4, "Không ổn đâu cút đi", "Dương Quá", curdate());
insert into messages(message_id, message, author, date_entered) values(5, "Mua bằng tiền", "Đại ka dang hồ", curdate());
insert into messages(message_id, message, author, date_entered) values(6, "Có chứ bạn", "Dang hồ Khải", curdate());
insert into messages(message_id, message, author, date_entered) values(7, "Ok cảm ơn bạn", "Tuyền 6 múi", curdate());
insert into messages(message_id, message, author, date_entered) values(8, "Không tốt tao bán chi", "Tàu Khựa", curdate());
