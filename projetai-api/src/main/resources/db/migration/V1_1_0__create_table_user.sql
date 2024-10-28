create table users (
    id bigint,
    name varchar(255) not null,
    email varchar(255) not null,
    constraint users_pk primary key (id)
);

create sequence users_id_seq;

create table if not exists client (
    id bigint default nextval('users_id_seq') not null,
    constraint client_pk primary key (id)
) inherits (users);

create table if not exists support (
    id bigint default nextval('users_id_seq') not null,
    is_available boolean not null default true,
    constraint support_pk primary key (id)
) inherits (users);