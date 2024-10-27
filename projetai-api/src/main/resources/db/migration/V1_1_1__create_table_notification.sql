create table notification(
    id serial primary key,
    title varchar(255) not null,
    message varchar(255) not null,
    type varchar(255) not null,
    user_id integer not null,
    read boolean not null default false,
    foreign key (user_id) references users(id)
);