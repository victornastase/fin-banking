delete from loans;
delete from clients;
alter sequence seq_client restart with 1;

insert into clients(id, first_name, last_name, email) values
(nextval('seq_client'), 'John', 'Doe', 'jhon@j.com'),
(nextval('seq_client'), 'Jane', 'Doe', 'jane@j.com'),
(nextval('seq_client'), 'Jack', 'Doe', 'jack@j.com');

insert into loans(term, amount, interest_rate, client_id) values
(12, 1000, 0.08, 1),
(24, 2000, 0.05, 1),
(36, 3000, 0.03, 3);