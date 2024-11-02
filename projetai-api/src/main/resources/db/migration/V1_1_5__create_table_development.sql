create table if not exists development (
    id serial primary key,
    type varchar(255),
    status varchar(255),
    developerId bigint not null,
    startedTime date,
    finishedTime date,
    ticket_id bigint not null,

    constraint development_ticket_fkey foreign key (ticket_id) references ticket(id),
);