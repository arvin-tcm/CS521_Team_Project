drop database if exists CS521_TEAM_PROJECT ;

create database  if not exists CS521_TEAM_PROJECT;
create table if not exists CS521_TEAM_PROJECT.user_record(
    user_id bigint not null auto_increment,
    user_name varchar(100) unique not null,
    primary key(user_id)
);

create table if not exists CS521_TEAM_PROJECT.course_record(
    course_id bigint not null auto_increment, 
    course_name varchar(50) not null,
    institution_name varchar(50) not null,
    time_stamp_year int not null,
    time_stamp_month int not null,
    time_stamp_semester varchar(10) not null,
    primary key(course_id)
);

create table if not exists CS521_TEAM_PROJECT.gpa_record(
    gpa_id bigint not null auto_increment,
    gpa double not null,
    user_id bigint not null,
    course_id bigint not null,
    foreign key(user_id)
    references CS521_TEAM_PROJECT.user(user_id)
    on delete cascade
);