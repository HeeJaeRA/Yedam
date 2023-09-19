SELECT * FROM dual;

SELECT first_name, LOWER(first_name), UPPER(first_name), INITCAP(first_name)
FROM employees
WHERE LOWER(first_name) = 'kevin';

SELECT CONCAT (first_name, CONCAT(' ', last_name)) AS fullname
FROM employees;

SELECT SUBSTR ('yedam', 1, 2), INSTR ('yedam', 's'), LENGTH ('yedam')
FROM dual;

SELECT first_name
FROM employees
WHERE INSTR(LOWER(first_name),'z') != 0;

SELECT first_name, LPAD(salary,10,'*'), RPAD(salary,10,'*')
FROM employees
WHERE LOWER(SUBSTR(first_name,1,1)) = 'a'
ORDER BY salary;

SELECT TRIM('   yedam    ')
FROM dual;

SELECT TRIM('y' FROM 'yyyyedamyyyyy')
FROM dual;

SELECT ROUND(128.578, 1), TRUNC(128.578, 1), MOD(10, 7)
FROM dual;

SELECT *
FROM NLS_SESSION_PARAMETERS;

ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD HH24:MI:SS' ;

SELECT sysdate, ROUND(sysdate, 'dd'), TRUNC(sysdate, 'dd')
FROM dual;

SELECT sysdate, ROUND(sysdate, 'day'), TRUNC(sysdate, 'day')
FROM dual;

SELECT sysdate, ROUND(sysdate, 'mon'), TRUNC(sysdate, 'mon')
FROM dual;

SELECT sysdate, ROUND(sysdate, 'year'), TRUNC(sysdate, 'year')
FROM dual;

SELECT TO_CHAR(hire_date, 'YYYY"��" MM"��"')
FROM employees;

SELECT TO_CHAR(hire_date, 'YY-MONTH-DD DAY')
FROM employees;

SELECT TO_CHAR(sysdate, 'FMYY-MM-DDTHSP DAY HH24:MI:SS PM')
FROM dual;

SELECT first_name, TO_CHAR(salary, 'L999,999')
FROM employees;

SELECT first_name, LPAD('��', salary/1000, '��')
FROM employees
WHERE salary/1000 >= 1;

ALTER SESSION SET NLS_DATE_LANGUAGE = AMERICAN;

SELECT first_name, hire_date
FROM employees
WHERE hire_date = TO_DATE('june 21,2007', 'MONTH DD,YYYY');

ALTER SESSION SET NLS_DATE_LANGUAGE = KOREAN;

SELECT first_name, hire_date
FROM employees
WHERE hire_date = TO_DATE('6�� 21,2007', 'fxMONTH DD,YYYY');

CREATE TABLE test (
id NUMBER(3),
name VARCHAR2(10),
hire_date DATE);

ALTER SESSION SET NLS_DATE_FORMAT = 'RRRR-MM-DD';

ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD';

INSERT INTO test
VALUES (5, 'EEE', '95-10-01');

INSERT INTO test
VALUES (6, 'FFF', '10-10-01');

SELECT * FROM test;

SELECT sysdate FROM dual;

SELECT ADD_MONTHS(sysdate, 6) AS "6���� ��" FROM dual;

SELECT sysdate+6 AS "6�� ��" FROM dual;

SELECT NEXT_DAY(sysdate, '��') AS "������ ������" FROM dual;

SELECT first_name, hire_date, TRUNC((sysdate - hire_date)/30) AS "�Ի� �� ���"
FROM employees
ORDER BY hire_date;

SELECT first_name, hire_date, TRUNC(MONTHS_BETWEEN(sysdate, hire_date)) AS "�Ի� �� ���"
FROM employees
ORDER BY hire_date;

SELECT first_name, salary, (salary * NVL(commission_pct, 0)) AS �߰�����, NVL2(TO_CHAR(commission_pct), '����', '����') AS ���翩��
FROM employees
ORDER BY �߰����� DESC;

SELECT employee_id, first_name, salary, (salary * NVL(commission_pct, 0)) AS �߰�����, TO_CHAR((salary + (salary * NVL(commission_pct ,0))) * 12, 'L999,999') AS ����
FROM employees
ORDER BY ���� DESC;

SELECT first_name, job_id, salary,
    CASE job_id WHEN 'IT_PROG' THEN salary * 1.1
                WHEN 'SA_MAN' THEN salary * 1.2
                WHEN 'SA_REP' THEN salary * 1.3
                ELSE salary
    END AS �λ�޿�
FROM employees
ORDER BY �λ�޿� DESC;

SELECT first_name, salary,
    CASE WHEN salary < 1000 THEN salary * 1.3
         WHEN salary < 2000 THEN salary * 1.2
         WHEN salary < 3000 THEN salary * 1.1
         ELSE salary
    END AS �λ�޿�
FROM employees
ORDER BY �λ�޿�;

SELECT employee_id, MOD(employee_id, 2) AS ������,
    DECODE(MOD(employee_id, 2), 0, '¦��', 
                                1, 'Ȧ��')
    AS Ȧ¦
FROM employees;