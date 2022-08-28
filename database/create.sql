use bookstoreservlet;

create table categories(
	category_id bigint not null primary key auto_increment,
    name varchar(255) null
);

create table editorial_categories(
	editorial_cat_id bigint not null primary key auto_increment,
    editorial_cat_name varchar(255) null
);


create table editorial(
	article_id bigint not null primary key auto_increment,
	editorial_cat_id bigint not null,
    article_title varchar(255) null,
    article_desc varchar(255) null,
    item_id bigint not null,
    foreign key(editorial_cat_id) references editorial_categories(editorial_cat_id),
	foreign key(item_id) references items(item_id)
);


create table items(
	item_id bigint not null primary key auto_increment,
    category_id bigint not null,
    name varchar(255) null,
    author varchar(255) null,
    price float default 0,
    product_url varchar(255) null,
    image_url varchar(255) null,
    notes varchar(255) null,
    is_recommended int default 0,
    foreign key(category_id) references categories(category_id)
);

create table role(
	role_id bigint not null primary key auto_increment,
	code varchar(255) not null,
    name varchar(255) not null
);

create table card_types(
	card_type_id bigint not null primary key auto_increment,
    name varchar(255) null
);

create table members(
	member_id bigint not null primary key auto_increment,
    member_login varchar(255) not null,
    member_password varchar(255) not null,
    role_id bigint not null,
    first_name varchar(255) null,
    last_name varchar(255) null,
    email varchar(255) null,
    phone varchar(255) null,
    address varchar(255) null,
    notes varchar(255) null,
	card_type_id bigint not null,
    card_number varchar(255) null,
    foreign key(role_id) references role(role_id),
    foreign key(card_type_id) references card_types(card_type_id)
);

create table orders(
	order_id bigint not null primary key auto_increment,
    member_id bigint not null,
    payment varchar(255) null,
    shipping varchar(255) null,
	orderdate timestamp null,
    foreign key(member_id) references members(member_id)
);

create table orderDetails(
	id bigint not null primary key auto_increment,
    order_id bigint not null,
    item_id bigint not null,
    item_desc varchar(255) null,
    quantity int default 0,
    price float default 0,
	foreign key(order_id) references orders(order_id),
	foreign key(item_id) references items(item_id)
);

create table rating(
	id bigint primary key not null auto_increment,
    item_id bigint not null,
	rating varchar(10),
    customer varchar(20),
	comment text,
    foreign key(item_id) references items(item_id)
);

create table topic_messages(
	message_id bigint not null primary key auto_increment,
    topic varchar(255) not null,
    author varchar(255) not null,
    date_entered timestamp null
);

create table messages(
	id bigint not null primary key auto_increment,
    message_id bigint not null,
    message text not null,
	author varchar(255) not null,
    date_entered timestamp null,
    foreign key(message_id) references topic_messages(message_id)
);


