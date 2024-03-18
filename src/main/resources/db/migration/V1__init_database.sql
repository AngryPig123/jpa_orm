use jpa;
create table album
(
    id     bigint not null,
    artist varchar(255),
    etc    varchar(255),
    primary key (id)
) engine = InnoDB;

create table book
(
    id     bigint not null,
    artist varchar(255),
    isbn   varchar(255),
    primary key (id)
) engine = InnoDB;

create table category_item
(
    category_id bigint not null,
    item_id     bigint not null,
    primary key (category_id, item_id)
) engine = InnoDB;

create table categories
(
    id        bigint not null auto_increment,
    parent_id bigint,
    name      varchar(255),
    primary key (id)
) engine = InnoDB;

create table deliveries
(
    id             bigint not null auto_increment,
    city           varchar(255),
    detail_address varchar(255),
    zip_code       varchar(255),
    status         enum ('READY','COMP'),
    primary key (id)
) engine = InnoDB;

create table items
(
    price          integer,
    stock_quantity integer,
    id             bigint      not null auto_increment,
    item_type      varchar(31) not null,
    name           varchar(255),
    primary key (id)
) engine = InnoDB;

create table members
(
    id             bigint not null auto_increment,
    city           varchar(255),
    detail_address varchar(255),
    name           varchar(255),
    zip_code       varchar(255),
    primary key (id)
) engine = InnoDB;

create table movie
(
    id       bigint not null,
    actor    varchar(255),
    director varchar(255),
    primary key (id)
) engine = InnoDB;

create table order_item
(
    count       integer,
    order_price integer,
    id          bigint not null auto_increment,
    item_id     bigint,
    order_id    bigint,
    primary key (id)
) engine = InnoDB;

create table orders
(
    delivery_id bigint,
    id          bigint not null auto_increment,
    member_id   bigint,
    order_date  datetime(6),
    status      enum ('ORDER','CANCEL'),
    primary key (id)
) engine = InnoDB;

alter table book
    add constraint UK_ehpdfjpu1jm3hijhj4mm0hx9h unique (isbn);

alter table orders
    add constraint UK_9ct0l8xfeaiqruabcqjh1neui unique (delivery_id);

alter table album
    add constraint FKaoosc4pj90yflqvufo2y0671h foreign key (id) references items (id);

alter table book
    add constraint FK96glxj076jtovdo06xygvnqnc foreign key (id) references items (id);

alter table category_item
    add constraint FKdt7x624ch04wibi27g2mttpp8 foreign key (category_id) references categories (id);

alter table category_item
    add constraint FKdcl2aonq4tor3rs8j3av2a8jh foreign key (item_id) references items (id);

alter table categories
    add constraint FKsaok720gsu4u2wrgbk10b5n8d foreign key (parent_id) references categories (id);

alter table movie
    add constraint FKdrmhe8a03ivqelji1ux3tvs4y foreign key (id) references items (id);

alter table order_item
    add constraint FKo5d8io03ue2y89j3wbnju0let foreign key (item_id) references items (id);

alter table order_item
    add constraint FKt4dc2r9nbvbujrljv3e23iibt foreign key (order_id) references orders (id);

alter table orders
    add constraint FK8w9m21riko8j8eit0yvog02nr foreign key (delivery_id) references deliveries (id);

alter table orders
    add constraint FK2vq7lo4gkknrmghj3rqpqqg6s foreign key (member_id) references members (id);
