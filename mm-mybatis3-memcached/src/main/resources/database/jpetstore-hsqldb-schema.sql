-- drop index user;

create table user (
    id int not null,
    name varchar(80) not null,
    constraint pk_profile primary key (id)
);
