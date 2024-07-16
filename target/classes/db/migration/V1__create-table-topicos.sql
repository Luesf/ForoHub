create table topicos(

    id bigint not null auto_increment,
    user_id varchar(100) not null,
    curso varchar(100) not null,
    titulo varchar(100) not null,
    mensaje varchar(200) not null,

    primary key(id)
)