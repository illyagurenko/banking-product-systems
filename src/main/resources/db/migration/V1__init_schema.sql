create table clients(
    id bigserial primary key,
    first_name varchar(30) not null,
    last_name varchar(30) not null,
    phone_number varchar(12) not null unique,
    password_hash varchar(255) not null,
    role varchar(15) not null
);

create table product_applications(
    id bigserial primary key,
    client_id bigint not null,
    product_type varchar(30) not null,
    status varchar(30) not null,
    rejection_reason varchar(255),
    created_at timestamp with time zone default current_timestamp,
    updated_at timestamp with time zone default current_timestamp,
    constraint fk_client foreign key (client_id) references clients(id)
);

create table accounts(
    id bigserial primary key,
    main_client_id bigint not null,
    account_type varchar(30) not null,
    balance numeric(19, 4) not null default 0.0000,
    status varchar(30) not null,
    constraint fk_main_client foreign key (main_client_id) references clients(id)
);

create table cards(
    id bigserial primary key,
    account_id bigint not null,
    card_number varchar(255) not null unique,
    card_type varchar(30) not null,
    holder_name varchar(30) not null,
    constraint fk_account foreign key (account_id) references accounts(id)
);

create index idx_clients_phone_number on clients(phone_number);
create index idx_cards_card_number on cards(card_number);