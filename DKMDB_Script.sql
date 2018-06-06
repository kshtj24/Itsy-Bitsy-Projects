create table products (
products_id int primary key not null,
products_quantity int not null,
products_model varchar(12) not null,
products_image varchar(128) not null,
products_price decimal(10,2) not null,
products_date_added timestamp not null default now(),
products_last_modified timestamp not null default now(),
products_date_available timestamp not null default now(),
products_weight decimal(7,2),
products_status smallint default 0,
products_tax_class_id int, --<fk2>
manufacturers_id int --<fk1>
);
