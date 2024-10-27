create table users (
    id serial primary key,
    name varchar(255) not null,
    email varchar(255) not null
);

create table if not exists client (
) inherits (users);

create table if not exists support (
    is_available boolean not null default true
) inherits (users);