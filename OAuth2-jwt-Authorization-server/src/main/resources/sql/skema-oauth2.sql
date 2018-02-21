create database db_oauth2_authorization;

use db_oauth2_authorization;

create table users(

    idusers bigint auto_increment,
    username varchar(255) not null,
    firstname varchar(255) not null,
    email varchar(255) not null,
    lastname varchar(255) not null,
    password varchar(255) not null,
    activated boolean default null,
    activationkey varchar(255) null,
    resetpasswordkey varchar(255) null,

    CONSTRAINT pk_users_idusers PRIMARY KEY (idusers)
);

insert into users(username, firstname, email, lastname, password)
values ('dickanirwansyah', 'Muhammad dicka', 'dickanirwansyah@gmail.com', 'Nirwansyah', '$2a$10$epYzM2vJVX/fVkq8R5GtYeBP0kwAlYrlQpwG2k/yIu7ZlNk03fQEG');

insert into users(username, firstname, email, lastname, password)
values ('sitasinthya', 'Sita', 'sitasinthya@gmail.com', 'Sinthya', '$2a$10$epYzM2vJVX/fVkq8R5GtYeBP0kwAlYrlQpwG2k/yIu7ZlNk03fQEG');

create table role(

    idrole bigint auto_increment,
    name varchar(255) not null,
    description varchar(255) not null,

    CONSTRAINT pk_role_idrole PRIMARY KEY (idrole)
);

insert into role(name, description)
values ('ROLE_ADMIN', 'ADMIN ACCESS');

insert into role(name, description)
values ('ROLE_STAFF', 'STAFF ACCESS');

insert into role(name, description)
values ('ROLE_USER', 'USER ACCESS');

create table users_role(

    idusers bigint not null,
    idrole bigint not null,

    CONSTRAINT pk_users_role PRIMARY KEY (idusers, idrole),
    CONSTRAINT fk_users_role_idusers FOREIGN KEY (idusers) REFERENCES
    users(idusers),
    CONSTRAINT fk_users_role_idrole FOREIGN KEY (idrole) REFERENCES
    role(idrole)
);

insert into users_role(idusers, idrole)
values (1, 1);
insert into users_role(idusers, idrole)
values (1, 2);
insert into users_role(idusers, idrole)
values (1, 3);
insert into users_role(idusers, idrole)
values (2, 2);


create table oauth_client_details (
    client_id VARCHAR(256) PRIMARY KEY,
    resource_ids VARCHAR(256),
    client_secret VARCHAR(256),
    scope VARCHAR(256),
    authorized_grant_types VARCHAR(256),
    web_server_redirect_uri VARCHAR(256),
    authorities VARCHAR(256),
    access_token_validity INTEGER,
    refresh_token_validity INTEGER,
    additional_information VARCHAR(4096),
    autoapprove VARCHAR(256)
);


CREATE TABLE oauth_access_token (
  token_id VARCHAR(256) DEFAULT NULL,
  token BLOB,
  authentication_id VARCHAR(256) DEFAULT NULL,
  user_name VARCHAR(256) DEFAULT NULL,
  client_id VARCHAR(256) DEFAULT NULL,
  authentication BLOB,
  refresh_token VARCHAR(256) DEFAULT NULL
);


CREATE TABLE oauth_refresh_token (
  token_id VARCHAR(256) DEFAULT NULL,
  token BLOB,
  authentication BLOB
);