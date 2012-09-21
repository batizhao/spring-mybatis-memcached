-- drop index user;

create table user (
    id int not null,
    name varchar(80) not null,
    constraint pk_user primary key (id)
);

create table role (
    id int not null,
    name varchar(80) not null,
    constraint pk_role primary key (id)
);

create table user_role (
    userid int not null,
    roleid int not null
);
