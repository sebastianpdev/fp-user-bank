create database fpbank with owner postgres;

\c fp-bank

create schema bank_schema;

alter schema bank_schema owner to postgres;

create sequence bank_schema.cliente_id_seq
    start with 1 increment by 1
    no minvalue no maxvalue cache 1;

create table bank_schema.persona
(
    id             bigint  default nextval('cliente_id_seq')
        constraint cliente_pk
            primary key,
    tipo_identificacion     varchar not null,
    identificacion          varchar not null,
    nombres                 varchar(255) not null,
    apellidos               varchar(255) not null,
    edad                    integer,
    email                   varchar not null,
    birth_date              date not null,
    date_created            timestamp not null,
    date_modified           timestamp not null
);

alter table bank_schema.cuenta owner to postgres;

create sequence bank_schema.cuenta_id_seq
    start with 1 increment by 1
    no minvalue no maxvalue cache 1;

create table bank_schema.cuenta
(
    id bigint default nextval('cuenta_id_seq')
        constraint cuenta_pk
            primary key,
    numero_cuenta   varchar not null,
    tipo_cuenta     varchar not null,
    saldo           numeric(15, 2) not null,
    estado          varchar not null,
    exenta_gmf      boolean default true,
    date_created    timestamp not null,
    date_modified   timestamp not null,
    cliente_id    bigint
        constraint cuenta_cliente_id_fk
            references bank_schema.cliente
);

alter table bank_schema.cuenta owner to postgres;