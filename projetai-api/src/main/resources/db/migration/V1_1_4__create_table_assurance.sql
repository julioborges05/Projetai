create table assurance(
    id serial primary key,
    title varchar(255) not null,
    message varchar(255) not null,
    status varchar(255) not null,
    developer_entity_id integer not null,
    support_entity_id integer not null,
    foreign key (developer_entity_id) references developer(id),
    foreign key (support_entity_id) references support(id)
);