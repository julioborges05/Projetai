create table if not exists ticket (
    id bigint,
    title varchar(255) not null,
    message varchar(255) not null,
    type varchar(255) not null,
    client_id bigint not null,
    foreign key (client_id) references users(id),
    constraint ticket_pk primary key (id)
);

create sequence ticket_id_seq;

create table if not exists comment (
    id serial primary key,
    message varchar(255) not null,
    ticket_id bigint not null,
    user_id bigint not null,
    foreign key (ticket_id) references ticket(id),
    foreign key (user_id) references users(id)
);