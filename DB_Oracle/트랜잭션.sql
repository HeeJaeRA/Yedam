CREATE TABLE dept(
    deptno      NUMBER(4),
    dname       VARCHAR2(20),
    loc         VARCHAR2(10),
    hiredate    DATE
);

INSERT INTO dept
VALUES (10, 'ACCOUNITNG', 'NEW YORK', SYSDATE);

INSERT INTO dept(deptno, dname, loc)
VALUES (20, 'RESERCH', '대구');

INSERT INTO dept
VALUES (30, 'SALES', NULL, '');

INSERT INTO dept
VALUES (40, 'SALES', '서울', '23-09-08');

INSERT INTO dept
VALUES (50, 'TESTING', 'BOSTON', '22-12-08');

SELECT * FROM dept;

CREATE TABLE emp(
    empid       NUMBER(6),
    empname     VARCHAR2(20),
    mgr         NUMBER(6),
    sal         NUMBER(8,2),
    deptid      NUMBER(4),
    hiredate    DATE
);

INSERT INTO emp
    SELECT employee_id, first_name, manager_id, salary, department_id, hire_date 
    FROM employees
    WHERE department_id = 30;

COMMIT;

DELETE emp;

ROLLBACK;

DELETE emp
WHERE empid = 117;

DELETE emp
WHERE empname = 'Den';

DELETE emp
WHERE deptid = ANY
    (SELECT deptno
     FROM dept
     WHERE LOWER(dname) = 'sales');

SELECT * FROM dept;
SELECT * FROM emp;

UPDATE emp
SET deptid = 60
WHERE empid = 114;

UPDATE emp
SET empname = '라희재'
WHERE empid = 117;

UPDATE emp
SET mgr = 
    (SELECT manager_id
     FROM employees
     WHERE LOWER(first_name) = 'donald')
WHERE deptid = ANY
    (SELECT department_id
     FROM employees
     WHERE LOWER(first_name) = 'alexander');
     
COMMIT;

DELETE emp
WHERE empid = 117;

UPDATE emp
SET mgr = 100
WHERE empid = 118;

SAVEPOINT a;

SELECT * FROM emp;

UPDATE emp
SET deptid = 80
WHERE deptid = 30;

ROLLBACK TO SAVEPOINT a;
ROLLBACK;

INSERT INTO emp
    SELECT employee_id, first_name, manager_id, salary, department_id, hire_date
    FROM employees
    WHERE department_id = 50;
    
SELECT * FROM dict;
SELECT * FROM user_tables;
SELECT * FROM user_objects;
SELECT * FROM user_catalog;

CREATE TABLE dept30
AS  (SELECT employee_id empno, first_name empname, salary * 12 annsal, hire_date hiredate
     FROM employees
     WHERE department_id = 30);
    
ALTER TABLE dept30
ADD job VARCHAR2(10);

ALTER TABLE dept30
MODIFY job VARCHAR2(15) default 'aa';

INSERT INTO dept30 (empno, empname, annsal, hiredate)
VALUES (777, 'SSS', 50000, SYSDATE);

UPDATE dept30
SET job = '개발자'
WHERE empno != 777;

ALTER TABLE dept30
DROP COLUMN job;

SELECT * FROM dept30;

COMMENT ON TABLE dept30
IS '부서번호 30번 데이터';

SELECT * FROM user_tab_comments;

COMMENT ON COLUMN dept30.annsal
IS '연봉';

SELECT * FROM user_col_comments;

DROP TABLE test;

RENAME dept30 TO d30;

RENAME d30 TO dept30;

SELECT * FROM dept30;

ALTER TABLE dept30 RENAME COLUMN annsal TO 연봉;