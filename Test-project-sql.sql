create database project_test;
use project_test;
#employee table
create  table employee(
emp_id int primary key not null auto_increment,
name varchar(32),
social_status varchar(32),
SSN int,
gender varchar(10),
start_date date,
email varchar(32),
education varchar(32)
);
drop table employee;
#department tabel
create  table department(
dep_id int primary key not null auto_increment,
name varchar(32)
);
#dep2emp
create  table dep2emp(
emp_id int ,
dep_id int ,
primary key(emp_id,dep_id),
foreign key (emp_id) references employee(emp_id) on delete cascade on update cascade,
foreign key (dep_id) references department(dep_id) on delete cascade on update cascade
);
#employee address
create table emp_address(
emp_id int primary key,
city varchar(32),
foreign key (emp_id) references employee(emp_id)on delete cascade on update cascade
);
#employee mobile number
create table mobileNumber(
emp_id int,
mobileNumber real,
primary key(emp_id,mobileNumber),
foreign key (emp_id) references employee(emp_id) on delete cascade on update cascade
);
alter table mobilenumber modify mobileNumber int;
# salary 
create table salary(
salary_id int auto_increment not null primary key,
num_hours_worked int,
year int,
month int,
emp_id int ,
foreign key (emp_id) references employee(emp_id)
);
#bounses
create table bounses(
boun_id int auto_increment  primary key,
salary_id int,
year int,
month int ,
type varchar(32),
num_of_hours int,
foreign key (salary_id) references salary (salary_id)
);
#deduction
create table deduction(
ded_id int auto_increment  primary key,
salary_id int,
year int,
month int ,
type varchar(32),
num_of_hours int,
foreign key (salary_id) references salary (salary_id)
);
describe employee;









