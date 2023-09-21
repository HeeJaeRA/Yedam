SELECT employee_id, first_name, salary
FROM employees;

DESC employees;

SELECT *
FROM employees;

SELECT employee_id AS 사원번호, first_name , salary
FROM employees;

SELECT first_name || '의 월급은 ' || salary || '달러입니다.' AS 월급
FROM employees;

SELECT DISTINCT job_id
FROM employees;

SELECT first_name, salary
FROM employees
ORDER BY salary;

SELECT first_name, salary, job_id
FROM employees
WHERE salary = 3000;

SELECT first_name, salary*12 AS 연봉
FROM employees
WHERE (salary*12) >= 36000;

SELECT first_name, department_id, job_id
FROM employees
WHERE job_id != 'SA_MAN';

SELECT first_name, salary
FROM employees
WHERE salary BETWEEN 1000 and 3000;

SELECT first_name, hire_date
FROM employees
WHERE hire_date LIKE '06%';

SELECT first_name, salary
FROM employees
WHERE first_name LIKE 's%'
OR first_name LIKE 'S%';

SELECT first_name, department_id, manager_id
FROM employees
WHERE first_name LIKE '%t%'
OR first_name LIKE '%T%';

SELECT first_name, salary
FROM employees
WHERE first_name LIKE '_m%';

SELECT first_name, commission_pct
FROM employees
WHERE commission_pct IS NULL;

SELECT first_name, job_id
FROM employees
WHERE job_id NOT IN ('SA_MAN', 'PU_CLRK', 'IT_PROG');
