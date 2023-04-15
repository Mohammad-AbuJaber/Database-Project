drop database sal;
create database sal;
use sal;

CREATE TABLE Department (
  Department_ID   int(10) NOT NULL AUTO_INCREMENT, 
  Department_Name varchar(10), 
  PRIMARY KEY (Department_ID)
  );
  
  CREATE TABLE Employee_Address (
  id     int(10) NOT NULL AUTO_INCREMENT, 
  City   varchar(10), 
  PRIMARY KEY (id)
  );
 

  
CREATE TABLE Employee (
  Employee_ID        int(10) NOT NULL AUTO_INCREMENT, 
  Employee_Fname     varchar(10), 
  Employee_Lname     varchar(10), 
  Employee_SSN       int(10), 
  Department_ID      int(10) NOT NULL, 
  Employee_Address_ID int(10) NOT NULL, 
  PRIMARY KEY (Employee_ID),
  FOREIGN KEY (Employee_Address_ID) REFERENCES Employee_Address(id) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (Department_ID) REFERENCES Department (Department_ID) ON DELETE CASCADE ON UPDATE CASCADE
);


CREATE TABLE Bank_Account (
  Account_ID  int(15) NOT NULL AUTO_INCREMENT, 
  Employee_ID int(10) NOT NULL, 
  PRIMARY KEY (Account_ID),
  FOREIGN KEY (Employee_ID) REFERENCES Employee (Employee_ID) ON DELETE CASCADE ON UPDATE CASCADE
  );

CREATE TABLE Mobile_Numbers (
  Mobile_Number varchar(15) NOT NULL, 
  Employee_ID   int(10) NOT NULL,
  FOREIGN KEY (Employee_ID) REFERENCES Employee (Employee_ID) ON DELETE CASCADE ON UPDATE CASCADE
  );

CREATE TABLE Bonuses (
  Bonus_ID    int(10) NOT NULL AUTO_INCREMENT, 
  Total_Bonus int(10), 
  PRIMARY KEY (Bonus_ID)
  );

CREATE TABLE Employee_Bonuses (
  Employee_ID int(10) NOT NULL, 
  Bonus_ID    int(10) NOT NULL,
  FOREIGN KEY (Employee_ID) REFERENCES Employee (Employee_ID) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (Bonus_ID) REFERENCES Bonuses (Bonus_ID) ON DELETE CASCADE ON UPDATE CASCADE
  );

CREATE TABLE Extra_Time (
  Extra_Time_ID   int(10) NOT NULL AUTO_INCREMENT, 
  Total_Bonus     int(10), 
  Number_Of_Hours int(10),
  PRIMARY KEY (Extra_Time_ID),
  FOREIGN KEY (Extra_Time_ID) REFERENCES Bonuses (Bonus_ID) ON DELETE CASCADE ON UPDATE CASCADE
  );

CREATE TABLE Job_Title (
  Job_Title_ID          int(10) NOT NULL AUTO_INCREMENT, 
  Job_Title_Description varchar(50), 
  Total_Bonus           int(10),
  PRIMARY KEY (Job_Title_ID),
  FOREIGN KEY (Job_Title_ID) REFERENCES Bonuses (Bonus_ID) ON DELETE CASCADE ON UPDATE CASCADE
  );

CREATE TABLE Deduction (
  Deduction_ID    int(10) NOT NULL AUTO_INCREMENT, 
  Total_Deduction int(10), 
  PRIMARY KEY (Deduction_ID)
  );

CREATE TABLE Employee_Deduction (
  Employee_ID  int(10) NOT NULL, 
  Deduction_ID int(10) NOT NULL,
  FOREIGN KEY (Employee_ID) REFERENCES Employee (Employee_ID) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (Deduction_ID) REFERENCES Deduction (Deduction_ID) ON DELETE CASCADE ON UPDATE CASCADE
  );

CREATE TABLE Leave_of_absence (
  Leave_ID           int(10) NOT NULL AUTO_INCREMENT, 
  Leave_reason       varchar(50), 
  Number_Of_Absences int(10), 
  Total_Deduction    int(10),
  PRIMARY KEY (Leave_ID),
  FOREIGN KEY (Leave_ID) REFERENCES Deduction (Deduction_ID) ON DELETE CASCADE ON UPDATE CASCADE
  );

CREATE TABLE Taxes (
  Tax_ID     int(10) NOT NULL AUTO_INCREMENT, 
  Tax_Amount int(10),
  PRIMARY KEY (Tax_ID),
  FOREIGN KEY (Tax_ID) REFERENCES Deduction (Deduction_ID) ON DELETE CASCADE ON UPDATE CASCADE
  );


insert into Department (Department_Name)
values("delete");
select * from Department;

select D.Department_ID,D.Department_Name,E.Employee_ID
from Employee E, Department D
where E.Department_ID = D.Department_ID;
describe Employee;

insert into Employee (Employee_Fname,Employee_Lname,Employee_SSN,Department_ID,Employee_Address_ID)
values ("m","A",14,1,1);
select E.Employee_ID, E.Employee_Fname, E.Employee_Lname, E.Employee_SSN, D.Department_Name, EA.City 
from Employee E, Department D, Employee_Address EA
WHERE EA.id = E.Employee_Address_ID 
AND   E.Department_ID = D.Department_ID; 

select max(Employee_ID) from Employee;
select D.Department_ID,D.Department_Name from Department D;
select max(Department_ID) from Department;
SELECT * FROM Employee_Address;
SELECT * FROM Employee;
select count(Employee_ID) from Employee;
select count(Department_ID) from Department;


SELECT D.Department_ID, D.Department_Name,
       (SELECT COUNT(*) 
        FROM Employee E
        WHERE E.Department_ID = D.Department_ID
       ) as NumberOfEmployeesPerDepatment 
FROM Department D;

SELECT COUNT(E.Employee_ID) 
FROM Employee E , Department D
WHERE E.Department_ID = D.Department_ID AND E.Department_ID = 12;

SELECT * FROM Department;

delete from Department where Department_Name = 's';
        
   INSERT INTO Employee_Address (city)
  VALUES ("Ramallah");
  select * from Employee_Address;
  delete from Employee_Address where city = "Jenin";
  
  select D.Department_ID,D.Department_Name
  from Department D
  where D.Department_Name ="marketing";
   select D.Department_ID,D.Department_Name
  from Department D
  where D.Department_Name ="c" or D.Department_ID =6 ;
  
  update Department 
  set Department_Name = "COMP" 
  where Department_ID = 1;
  
  delete from Department where Department_ID = 10;
  select Department_Name from Department where Department_ID = 14;
  select Department_ID from Department where Department_Name = "IT";