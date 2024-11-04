create table contact_analysis (
    id serial primary key,
    is_replied boolean not null default false,
    comment varchar(255) not null,
    contact_id bigint not null,
    constraint contact_fkey foreign key (contact_id) references contact(id)
);