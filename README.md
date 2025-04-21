Employee Database : 
a dashboard created to view the employee status and adding and deleting new employee data 
need to setup SQL DB in local 
setup the username and password in application.properties

run query to create table : CREATE TABLE employees (
    employee_name VARCHAR(100),
    emp_id INT PRIMARY KEY,
    mobile VARCHAR(15),
    location VARCHAR(100),
    project VARCHAR(100)
);

run query to insert dummy data : INSERT INTO employees (employee_name, emp_id, mobile, location, project)
VALUES ('Bhanu pratap', Nyk1234, '87970336XX', 'Gurgaon', 'ProjectBhanu');
