create table if not exists developer(
    id bigint default nextval('users_id_seq') not null,
    constraint developer_pk primary key (id)
) inherits (users);

create table if not exists development(
     id bigint default nextval('ticket_id_seq') not null,
     constraint development_pk primary key (id),
     developer_id bigint not null,
     foreign key (developer_id) references developer(id)
) inherits (ticket);


