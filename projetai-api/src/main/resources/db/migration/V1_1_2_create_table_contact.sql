create table contact (
    id serial primary key,
    title varchar(255) not null,
    message varchar(255) not null,
    type varchar(255) not null,
    client_id bigint not null,
    support_id bigint not null,
    foreign key (client_id) references client(id),
    foreign key (support_id) references support(id)
);