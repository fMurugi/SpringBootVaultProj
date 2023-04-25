DROP TABLE IF EXISTS employee;

CREATE TABLE employee (
  nationalId VARCHAR(10) NOT NULL,
  firstName VARCHAR(100) NOT NULL,
  lastName VARCHAR(100) NOT NULL
);

INSERT INTO employee(nationalId,firstName,lastName)values("555","Fioo","uuuuuu");
-- INSERT INTO employee(empId,empName)values("222","bbb");
-- INSERT INTO employee(empId,empName)values("333","ccc");