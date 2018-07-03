create table if not exists products (
products_id int primary key,
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

create table if not exists product_description (
products_id int primary key,
language_id int,
products_name varchar(64) not null,
products_description text not null,
products_url varchar(255) not null,
products_viewed int
);

create table if not exists product_options(
products_options_id int primary key,
language_id int,
products_options_name varchar(32)
);

create table if not exists products_attributes(
products_attributes_id int primary key,
products_id int not null,
options_id int,
options_values_id int,
options_values_price decimal(10,2) not null,
price_prefix char(1)
);

create table if not exists products_options_values_to_products_options(
products_options_values_to_products_options_id int primary key,
products_options_id int not null,
products_options_values_id int not null
);

create table if not exists products_options_values(
products_options_values_id int primary key,
language_id int not null,
products_options_values_name varchar(64)
);

create table if not exists languages(
languages_id int primary key,
name varchar(32) not null,
code char(2) not null,
image varchar(64)
directory varchar(32)
sort_order int
);

create table if not exists products_to_categories(
products_id int primary key,
categories_id int not null
);

create table if not exists categories(
categories_id int primary key,
categories_image varchar(64),
parent_id int,
sort_order int,
date_added timestamp,
last_modified timestamp
);

create table if not exists categories_description(
categories_id int primary key,
language_id int,
categories_name varchar(32) not null
);

create table if not exists reviews(
reviews_id int primary key,
products_id int not null,
customers_id int not null,
customers_name varchar(64) not null,
reviews_rating smallint not null,
date_added timestamp not null,
last_modified timestamp not null,
reviews_read int
);

create table if not exists reviews_description(
reviews_id int primary key,
languages_id int,
reviews_text text not null
);


create table if not exists manufacturers(
manufacturers_id int primary key,
manufacturers_name varchar(32) not null,
manufacturers_image varchar(64)
);

create table if not exists manufacturers_info(
manufacturers_id int primary key,
languages_id int,
manufacturers_url varchar(255),
url_clicked int,
date_last_click timestamp,
date_added timestamp
);

create table if not exists customers_basket(
customers_basket_id int primary key,
customers_id int not null,
products_id text not null,
customers_basket_quantity smallint,
final_price decimal(8,2)
customers_basket_date_added timestamp not null
);

create table if not exists customers(
customers_id int primary key,
customers_gender char(1),
customers_firstname varchar(32) not null,
customers_lastname varchar(32) not null,
customers_dob timestamp,
customers_email_address varchar(96) not null,
customers_default_address_id int,
customers_telephone varchar(32),
customers_fax varchar(32),
customers_password varchar(40) not null,
customers_newsletter char(1)
);

create table if not exists customers_basket_attributes(
customers_basket_attributes_id int primary key,
customers_id int,
products_id text,
products_options_id int,
products_options_values_id int
);

create table if not exists customers_info(
customers_info_id int primary key,
customers_info_date_of_last_logon timestamp
customers_info_number_of_logons int,
customers_info_date_account_created timestamp,
customers_info_date_account_last_modified timestamp
);

create table if not exists specials(
specials_id int primary key,
products_id int not null,
specials_new_products_price int not null,
specials_date_added timestamp not null,
specials_last_modified timestamp not null
);

create table if not exists orders(
orders_id int primary key,
customers_id int not null, 
customers_name varchar(64) not null,
customers_street_address varchar(64) not null,
customers_suburb varchar(32),
customers_city varchar(32) not null,
customers_postcode varchar(10) not null,
customers_state varchar(32) not null,
customers_country varchar(32) not null,
customers_telephone varchar(32) not null,
customers_email_address varchar(96) not null,
customers_address_format_id int,
delivery_name varchar(64) not null,
delivery_street_address varchar(64) not null,
delivery_suburb varchar(32),
delivery_city varchar(32) not null,
delivery_postcode varchar(10) not null,
delivery_state varchar(32) not null,
delivery_country varchar(32) not null,
delivery_address_format_id int,
payment_method varchar(12) not null,
cc_type varchar(20),
cc_owner varchar(64),
cc_number varchar(32),
cc_expires varchar(4),
last_modified timestamp,
date_purchased timestamp not null,
shipping_cost decimal(10,2) not null,
shipping_method varchar(32) not null,
orders_status varchar(10) not null,
orders_date_finished timestamp not null,
comments text,
currency char(3),
currency_value decimal(16,6)
);
