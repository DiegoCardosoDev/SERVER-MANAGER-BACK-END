create sequence hibernate_sequence start 1 increment 1;

    create table server_db (
       id int8 not null,
        image_url varchar(255),
        ip_andress varchar(255),
        memory varchar(255),
        name varchar(255),
        status int4,
        type varchar(255),
        primary key (id)
    );

    alter table server_db 
       add constraint UK_229mdo83gi93u3rviuk841j92 unique (ip_andress);
insert into  server_db(id,ip_andress, name, memory, type,image_url,status)
values (1,'192.168.15.7', 'Red Hat Enterprise Linux', '16GB', 'DELL TOWER', 'http://localhost:8080/server/image/server7.png', 0 );

insert into  server_db(id,ip_andress, name, memory, type,image_url,status)
values (2,'192.168.1.21', 'windows server', '16GB', 'Personal Pc', 'http://localhost:8080/server/image/server2.png', 1 );

insert into  server_db(id,ip_andress, name, memory, type,image_url,status)
values (3,'122.133.14.1', 'aws linux', '16GB', 'web server', 'http://localhost:8080/server/image/server2.png', 0 );

insert into  server_db(id,ip_andress, name, memory, type,image_url,status)
values (4,'192.168.15.3', 'Linux mint', '32GB', 'Workspace', 'http://localhost:8080/server/image/server3.png', 0 );

insert into  server_db(id,ip_andress, name, memory, type,image_url,status)
values (5,'192.168.1.58', 'Fedora Linux', '1T', 'Desenvolvimento', 'http://localhost:8080/server/image/server4.png', 1 );

insert into  server_db(id,ip_andress, name, memory, type,image_url,status)
values (6,'192.168.1.14', 'S 2008', '32gb', 'DATA BASE', 'http://localhost:8080/server/image/server5.png', 0 );

insert into  server_db(id,ip_andress, name, memory, type,image_url,status)
values (7,'122.133.15.1', 'UBUNTU LINUX', '120GB', 'INFRA', 'http://localhost:8080/server/image/server6.png', 0 );