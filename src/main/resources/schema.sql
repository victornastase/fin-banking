create table if not exists clients(
                                   id serial primary key,
                                   first_name text not null,
                                   last_name text not null,
                                   email text not null
);