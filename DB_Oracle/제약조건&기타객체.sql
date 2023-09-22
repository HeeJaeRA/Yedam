SELECT * FROM emp;

DESC emp;

ALTER TABLE emp
MODIFY empid NUMBER(6) PRIMARY KEY;

ALTER TABLE emp
MODIFY empname NOT NULL;

ALTER TABLE emp
DROP CONSTRAINT SYS_C008353;

ALTER TABLE emp
RENAME CONSTRAINT SYS_C008352 TO emp_empid_pk;

SELECT * FROM user_constraints;

SELECT * FROM emp_details_view;

CREATE VIEW vdept70
AS  SELECT employee_id no, first_name name, salary * 12 annsal
    FROM employees
    WHERE department_id = 70;

RENAME vdept70 TO vdept80;

CREATE OR REPLACE VIEW vdept80
AS  SELECT employee_id no, first_name name, salary * 12 annsal, hire_date hiredate
    FROM employees
    WHERE department_id = 80;

SELECT * FROM vdept80;

DROP VIEW vdept80;

CREATE INDEX emp_sal_idx
ON emp(sal);

SELECT * FROM user_indexes
WHERE TABLE_NAME = 'EMP';

CREATE INDEX emp_empname_idx
ON emp(UPPER(empname));

SELECT * FROM dept;

CREATE SEQUENCE dept_no_seq
    INCREMENT   BY 10
    START       WITH 100
    MAXVALUE    200
    NOCYCLE
    NOCACHE;
    
INSERT INTO dept
VALUES (dept_no_seq.NEXTVAL, 'aaa', '부산', sysdate);

SELECT dept_no_seq.NEXTVAL
FROM dual;

SELECT * FROM user_sequences;

ALTER SEQUENCE dept_no_seq
    INCREMENT   BY 100
    MAXVALUE    2000
    NOCYCLE
    NOCACHE;
    
DROP SEQUENCE dept_no_seq;

CREATE SYNONYM e
FOR employees;

CREATE SYNONYM e2
FOR emp;

SELECT * FROM e;

SELECT * FROM e2;

SELECT * FROM user_synonyms;

DROP TABLE emp;