create table pet_type
(
    pet_type_id   bigint generated by default as identity,
    pet_type_name varchar(255),
    primary key (pet_type_id)
) ;
insert into pet_type (pet_type_name) values ('German'),('Bulldog'),('Boxer'),('Poodle');