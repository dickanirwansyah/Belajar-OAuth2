create database db_oauth2_resources;

use db_oauth2_resources;

create table table_category(
    idcategory varchar(255) not null unique,
    name varchar(255) not null,
    description varchar(255) not null,
    disabled boolean default true,

    CONSTRAINT pk_table_category_idcategory PRIMARY KEY (idcategory)
);

create table table_product(
    idproduct varchar(255) not null unique,
    idcategory varchar(255) not null,
    name varchar(255) not null,
    quantity int not null,
    unitprice decimal not null,
    description varchar(255) not null,
    disabled boolean default true,

    CONSTRAINT pk_table_product_idproduct PRIMARY KEY (idproduct),
    CONSTRAINT fk_table_product_idcategory FOREIGN KEY (idcategory)
    REFERENCES table_category(idcategory)
);