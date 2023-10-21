create sequence file_seq start with 1 increment by 1
create sequence item_seq start with 1 increment by 1
create sequence permission_group_seq start with 1 increment by 1
create sequence permission_seq start with 1 increment by 1
create table file (id integer not null, item_id integer unique, "binary" oid, primary key (id))
create table item (id integer not null, item integer unique, parent_item_id integer, permission_group_id integer, name varchar(255), type varchar(255) check (type in ('SPACE','FOLDER','FILE')), primary key (id))
create table permission (group_id integer, id integer not null, permission_level varchar(255) check (permission_level in ('VIEW','EDIT')), user_email varchar(255), primary key (id))
create table permission_group (id integer not null, group_name varchar(255), primary key (id))
alter table if exists file add constraint FK5gx9qw46gc6mr17noimfp2o4y foreign key (item_id) references item
alter table if exists item add constraint FKer2key5c3b9yifswtd4qtmu2e foreign key (item) references file
alter table if exists item add constraint FKa3rmlgvinyx0de6jvogft00r8 foreign key (parent_item_id) references item
alter table if exists item add constraint FKjtcinrue6wu7cvno03243s3jy foreign key (permission_group_id) references permission_group
alter table if exists permission add constraint FKqp7umovkuakff1jilk6dp9l1x foreign key (group_id) references permission_group
insert into permission_group (group_name,id) values ('Admin',1)
insert into permission (group_id,permission_level,user_email,id) values (1,'VIEW','view@gmail.com',1)
insert into permission (group_id,permission_level,user_email,id) values (1,'EDIT','edit@gmail.com',2)
