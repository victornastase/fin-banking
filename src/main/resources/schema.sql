create table if not exists clients(
                                   id int primary key,
                                   first_name text not null,
                                   last_name text not null,
                                   email text not null
);
create sequence if not exists seq_client start 1 increment 1 owned by clients.id;

create table if not exists loans(
                                   id serial primary key,
                                   term int not null,
                                   amount integer not null,
                                   interest_rate double precision not null,
                                   client_id int not null,
                                   foreign key (client_id) references clients(id)
);