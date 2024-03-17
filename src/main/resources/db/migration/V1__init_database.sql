use jpa;

create table authorities
(
    id                 bigint not null auto_increment,
    created_by         varchar(255),
    created_date       varchar(255),
    last_modified_by   varchar(255),
    last_modified_date varchar(255),
    name               varchar(255),
    primary key (id)
) engine=InnoDB;

create table card
(
    id            bigint not null,
    card_number   varchar(255),
    card_password varchar(255),
    card_type     enum ('SAMSUNG','HYUNDAI','HANS','VISA'),
    primary key (id)
) engine=InnoDB;

create table items
(
    price              integer,
    quantity           integer,
    id                 bigint not null auto_increment,
    created_by         varchar(255),
    created_date       varchar(255),
    last_modified_by   varchar(255),
    last_modified_date varchar(255),
    name               varchar(255),
    primary key (id)
) engine=InnoDB;

create table payment_histories
(
    id                 bigint not null auto_increment,
    user_id            bigint,
    created_by         varchar(255),
    created_date       varchar(255),
    last_modified_by   varchar(255),
    last_modified_date varchar(255),
    description        tinytext,
    payment_method     enum ('PHONE','CARD'),
    payment_status     enum ('APPROVE','REJECT','CANCEL','REFUND'),
    primary key (id)
) engine=InnoDB;

create table payments
(
    id                 bigint      not null auto_increment,
    user_id            bigint,
    payment_type       varchar(31) not null,
    created_by         varchar(255),
    created_date       varchar(255),
    last_modified_by   varchar(255),
    last_modified_date varchar(255),
    primary key (id)
) engine=InnoDB;

create table phone
(
    id         bigint not null,
    tel_number varchar(255),
    agency     enum ('KT','SKT','LG'),
    primary key (id)
) engine=InnoDB;

create table role_authority
(
    authority_id       bigint not null,
    role_id            bigint not null,
    created_by         varchar(255),
    created_date       varchar(255),
    last_modified_by   varchar(255),
    last_modified_date varchar(255),
    primary key (authority_id, role_id)
) engine=InnoDB;

create table roles
(
    id                 bigint not null auto_increment,
    created_by         varchar(255),
    created_date       varchar(255),
    last_modified_by   varchar(255),
    last_modified_date varchar(255),
    name               varchar(255),
    primary key (id)
) engine=InnoDB;

create table shopping
(
    id                 bigint not null auto_increment,
    user_id            bigint,
    created_by         varchar(255),
    created_date       varchar(255),
    last_modified_by   varchar(255),
    last_modified_date varchar(255),
    primary key (id)
) engine=InnoDB;

create table shopping_cart
(
    id                 bigint not null auto_increment,
    item_id            bigint,
    shopping_id        bigint,
    created_by         varchar(255),
    created_date       varchar(255),
    last_modified_by   varchar(255),
    last_modified_date varchar(255),
    primary key (id)
) engine=InnoDB;

create table user_detail
(
    user_id                bigint not null,
    company_detail_address varchar(255),
    company_zip_code       varchar(255),
    created_by             varchar(255),
    created_date           varchar(255),
    home_detail_address    varchar(255),
    home_tel_number        varchar(255),
    home_zip_code          varchar(255),
    last_modified_by       varchar(255),
    last_modified_date     varchar(255),
    sub_detail_address     varchar(255),
    sub_tel_number         varchar(255),
    sub_zip_code           varchar(255),
    home_agency            enum ('KT','SKT','LG'),
    sub_agency             enum ('KT','SKT','LG'),
    primary key (user_id)
) engine=InnoDB;

create table users
(
    is_lock            bit,
    try_count          integer,
    id                 bigint not null auto_increment,
    role_id            bigint,
    created_by         varchar(255),
    created_date       varchar(255),
    email              varchar(255),
    last_modified_by   varchar(255),
    last_modified_date varchar(255),
    password           varchar(255),
    encoder_type       enum ('BCRYPT','SHA256','NOOP'),
    primary key (id)
) engine=InnoDB;

alter table shopping
    add constraint UK_c9lht0ant90ori2hu1pukh4m6 unique (user_id);

alter table users
    add constraint UK_krvotbtiqhudlkamvlpaqus0t unique (role_id);

alter table card
    add constraint FK4icukr6rc06i29b8p5u4gc7cq foreign key (id) references payments (id);

alter table payment_histories
    add constraint FKjskvqxf9nbal6nrwe4xmt7127 foreign key (user_id) references users (id);

alter table payments
    add constraint FKj94hgy9v5fw1munb90tar2eje foreign key (user_id) references users (id);

alter table phone
    add constraint FKq19bjbx70nu8qp08pff21yomu foreign key (id) references payments (id);

alter table role_authority
    add constraint FKpduid6tx7e38l03s86446514r foreign key (authority_id) references authorities (id);

alter table role_authority
    add constraint FK78r7yh1uqg30liv2n75ay99j foreign key (role_id) references roles (id);

alter table shopping
    add constraint FK3y6865fmdy2b7ay7vsycgk592 foreign key (user_id) references users (id);

alter table shopping_cart
    add constraint FKtaouqcsyw7asfaenuekof50ka foreign key (item_id) references items (id);

alter table shopping_cart
    add constraint FK1h52n7h8focpy65hee6tvmg0e foreign key (shopping_id) references shopping (id);

alter table user_detail
    add constraint FKr6i0t96qgu9l8l5nn2vqo8rcl foreign key (user_id) references users (id);

alter table users
    add constraint FKp56c1712k691lhsyewcssf40f foreign key (role_id) references roles (id);