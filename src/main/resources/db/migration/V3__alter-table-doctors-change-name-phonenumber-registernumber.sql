alter table doctors
change phoneNumber phone_number varchar(20) not null,
change registerNumber register_number varchar(6) not null unique;