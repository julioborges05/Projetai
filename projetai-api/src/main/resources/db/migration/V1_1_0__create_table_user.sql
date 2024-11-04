create table users
(
    id        bigint,
    name      varchar(255) not null,
    email     varchar(255) not null,
    user_type varchar(255) not null,
    constraint users_pk primary key (id)
);

create sequence users_id_seq;

---- client table

create table if not exists client
(
    id    bigint default nextval('users_id_seq') not null,
    name  varchar(255)                           not null,
    email varchar(255)                           not null,
    constraint client_pk primary key (id)
);

create or replace function insert_user_from_client()
    returns trigger as
$$
begin
    insert into users (id, name, email, user_type)
    values (new.id, new.name, new.email, 'CLIENT');
    return new;
end;
$$ language plpgsql;

create trigger after_client_insert
    after insert
    on client
    for each row
execute function insert_user_from_client();

---- support table

create table if not exists support
(
    id           bigint                default nextval('users_id_seq') not null,
    name         varchar(255) not null,
    email        varchar(255) not null,
    is_available boolean      not null default true,
    constraint support_pk primary key (id)
);

create or replace function insert_user_from_support()
    returns trigger as
$$
begin
    insert into users (id, name, email, user_type)
    values (new.id, new.name, new.email, 'SUPPORT');
    return new;
end;
$$ language plpgsql;

create trigger after_support_insert
    after insert
    on support
    for each row
execute function insert_user_from_support();

---- developer table

create table if not exists developer
(
    id    bigint default nextval('users_id_seq') not null,
    name  varchar(255)                           not null,
    email varchar(255)                           not null,
    constraint developer_pk primary key (id)
);

create or replace function insert_user_from_developer()
    returns trigger as
$$
begin
    insert into users (id, name, email, user_type)
    values (new.id, new.name, new.email, 'DEVELOPER');
    return new;
end;
$$ language plpgsql;

create trigger after_developer_insert
    after insert
    on developer
    for each row
execute function insert_user_from_developer();

---- techLead table

create table if not exists tech_lead
(
    id    bigint default nextval('users_id_seq') not null,
    name  varchar(255)                           not null,
    email varchar(255)                           not null,
    constraint tech_lead_pk primary key (id)
);

create or replace function insert_user_from_tech_lead()
    returns trigger as
$$
begin
    insert into users (id, name, email, user_type)
    values (new.id, new.name, new.email, 'TECH_LEAD');
    return new;
end;
$$ language plpgsql;

create trigger after_tech_lead_insert
    after insert
    on tech_lead
    for each row
execute function insert_user_from_tech_lead();


