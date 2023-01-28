create table users (
    id  bigserial,
    username varchar (30) not null unique,
    password varchar (80) not null,
    primary key(id)
);

create table roles (
    id   serial,
    name varchar(50) not null,
    primary key (id)
);

CREATE TABLE users_roles (
    user_id          bigint not null,
    role_id          int not null,
    primary key (user_id, role_id),
    foreign key (user_id) references users (id),
    foreign key (role_id) references roles (id)
);

insert into roles (name)
values
('ROLE_USER'), ('ROLE_ADMIN'), ('ROLE_MANAGER'), ('ROLE_SADMIN') );

insert into users (username, password)
values
('user', '$2a$04$Fx/SX9. BAvtPLMyIIqqFx.hLY2Xp8nnhpZvEEVINvVpwIPbA3v/.i');
('admin', '$2a$04$Fx/SX9. BAvtPLMyIIqqFx.hLY2Xp8nnhpZvEEVINvVpwIPbA3v/.i');
('manager', '$2a$04$Fx/SX9. BAvtPLMyIIqqFx.hLY2Xp8nnhpZvEEVINvVpwIPbA3v/.i');
('sadmin', '$2a$04$Fx/SX9. BAvtPLMyIIqqFx.hLY2Xp8nnhpZvEEVINvVpwIPbA3v/.i');

insert into users_roles (user_id, role_id)
values
(1, 1);
(2, 1);
(2, 2);
(2, 3);
(3, 1);
(3, 3);
(4, 1);
(4, 2);
(4, 3);
(4, 4);