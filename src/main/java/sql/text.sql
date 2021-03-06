drop table if exists memo CASCADE;
create table memo
(
    id bigint generated by default as identity,
    name varchar(30),
    data varchar(255),
    time timestamp,
    primary key(id)
);

drop table if exists memo CASCADE;
create table memo
(
    id bigint generated by default as identity,
    name varchar(30),
    data varchar(255),
    time TIMESTAMP DEFAULT NOW(),
    primary key(id)
);

drop table if exists memo CASCADE;
create table memo
(
    id bigint generated by default as identity,
    name varchar(30),
    data varchar(255),
    time timestamp default curdate(),
    primary key(id)
);

drop table if exists memo CASCADE;
create table memo
(
    id bigint generated by default as identity,
    name varchar(30),
    data varchar(255),
    time timestamp default CURRENT_TIMESTAMP,
    primary key(id)
);


drop table if exists memo CASCADE;
create table memo
(
    id bigint generated by default as identity,
    name varchar(30),
    data varchar(255),
    time timestamp default localTIMESTAMP,
    primary key(id)
);
select * from memo

drop table if exists memo CASCADE;
create table memo
(
    id bigint generated by default as identity,
    name varchar(30),
    data varchar(255),
    time timestamp,
    primary key(id)
);