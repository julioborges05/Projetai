create table if not exists refinement (
    id serial primary key,
    is_approved boolean,
    necessary_adjustments varchar(255),
    tech_lead_id bigint not null,
    developer_id bigint not null,
    started_time date,
    finished_time date,
    ticket_id bigint not null,
    constraint refinement_ticket_fk foreign key (ticket_id) references ticket(id),
    constraint refinement_developer_fk foreign key (developer_id) references developer(id),
    constraint refinement_tech_lead_fk foreign key (tech_lead_id) references tech_lead(id)
);