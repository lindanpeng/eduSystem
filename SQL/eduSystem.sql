create database eduSystem character set gbk;
use eduSystem;
#用户表
create table User(
userid varchar(20) primary key,
name varchar(20)not null default '',
password varchar(20) not null default '',
level smallint(1) not null default '0'
);
#学生表
create table Student(
studentid varchar(20)  primary key,
name varchar(20) not null default '',
phone varchar(20) not null default '',
inrolltime date not null default '1970-1-1',
college varchar(20) not null default '',#需不需要？
class varchar(20) not null default ''
);
#教师表
create table Teacher(
teacherid varchar(20) primary key,
name varchar(20) not null default '',
birthday date not null default '1970-1-1' ,
phone varchar(20) not null default '',
college varchar(20) not null default ''
);

#课程表 
create table Course(
id int auto_increment primary key,
courseid int(10),
teacherid varchar(20) not null default '',
studentid varchar(20) not null default '',
score float not null default '0.0',
name varchar(20) not null default ''
);
#选课表
create table SelectCourse(
courseid int(10) auto_increment primary key,
teacherid varchar(20) not null default '',
teachername varchar(20) not null default '',
name varchar(20) not null default '', 
totalAmount int not null default '0',
selectedAmount int not null default '0', 
surplus int not null default '0',
classroom varchar(20)not null default ''
);
alter table SelectCourse add column teachername varchar(20);
#教学楼表
create table classroom(
id int auto_increment primary key,
name varchar(20) 
);
insert into classroom values(null,'第一教学楼');
insert into classroom values(null,'第二教学楼');
insert into classroom values(null,'第三教学楼');
insert into classroom values(null,'第四教学楼');
insert into classroom values(null,'第五教学楼');
#星期表
create table Day(
id int  auto_increment primary key,
day varchar(10)
);
insert into day values(null,'周五');

#时间段表
create table Time(
id int  auto_increment primary key,
time varchar(10)
); 
insert into time values(null,'3,4节');
insert into time values(null,'5,6节');
insert into time values(null,'7,8节');
insert into time values(null,'9,10节');
insert into time values(null,'11,12节');
insert into time values(null,'11,12,13节');
#课程时间关联表
create table ClassTime(
id int auto_increment primary key,
courseid int,
day varchar(10),
time varchar(10)
);
#学院表
create table college(
collegeid int(10) auto_increment primary key,
name varchar(20) not null default ''
);
insert into college values(null,'体育学院');
#班级表
create table class(
classid int(10) auto_increment primary key,
college varchar(20) not null default '',
name varchar(20) not null default ''
);
insert into class values(null,'经济管理学院','金融2班');
#公告表
create table content(
id int primary key,
content text
);
----------------------------------------------------------------------------------
触发器
delimiter //
create trigger after_insert_student
after insert on student
for each row
begin
  insert into user(userid,name,password,level) values(new.studentid,new.name,new.studentid,3);
end
//
delimiter ;
delimiter //
create trigger after_insert_teacher
after insert on teacher
for each row
begin
  insert into user(userid,name,password,level) values (new.teacherid,new.name,new.teacherid,2);
end
//
delimiter ;

delimiter //
create procedure proc4()
begin
declare countk int;
select count(*) into countk from tab1;
select countk;
end
//
delimiter ;

delimiter //
create trigger after_delete_student
after delete on student
for each row
begin
  delete from user  where userid = old.studentid;
end
//
delimiter ;
delimiter //
create trigger after_delete_teacher
after delete on teacher
for each row
begin
  delete from user  where userid = old.teacherid;
end
//
delimiter ;
insert into teacher(teacherid,name) values ('022016002','邱华');
declare cnt int;
  declare autoid varchar(20);
  declare num varchar(5);
  select count(*) into cnt from student;
  set num=LPAD(cnt,4,'0');
  set autoid=concat('201610',num);
  update student set studentid = autoid  where studentid = '';
select * from teacher order by teacherid desc limit 1;