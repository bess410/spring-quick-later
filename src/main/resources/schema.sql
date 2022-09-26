create table if not exists purchase (
    id serial primary key,
    product varchar(50) not null,
    price decimal not null
);