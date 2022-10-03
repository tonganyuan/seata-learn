create table if not exists `security-demo`.`users` (
`id` int not null auto_increment,
username varchar(32) not null,
password varchar(32) not null,
enabled int not null,
primary key (`id`)
);

create table if not exists `security-demo`.`authorities` (
`id` int not null auto_increment,
username varchar(32) not null,
authority varchar(32) not null,
primary key (`id`)
);
