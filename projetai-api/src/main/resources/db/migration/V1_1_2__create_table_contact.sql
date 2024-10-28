create table contact (
    id serial primary key,
    title varchar(255) not null,
    message varchar(255) not null,
    type varchar(255) not null,
    client_id bigint not null,
    support_id bigint not null,
    constraint contact_client_fkey foreign key (client_id) references client(id),
    constraint contact_support_fkey foreign key (support_id) references support(id)
);