create table if not exists refinement (
    id serial primary key,
    isApproved boolean not null,
    necessaryAdjustments varchar(255) not null,
    techLeadId bigint not null,
    developerId bigint not null,
    startedTime date,
    finishedTime date,
    ticket_id bigint not null,
    constraint refinement_ticket_fkey foreign key (ticket_id) references ticket(id),
);