create table if not exists development (
    id serial primary key,
    type varchar(255),
    status varchar(255),
    developer_id bigint not null,
    started_time date,
    finished_time date,
    ticket_id bigint not null,
    estimated_hours integer,
    constraint development_ticket_fk foreign key (ticket_id) references ticket(id),
    constraint development_developer_fk foreign key (developer_id) references developer(id)
);