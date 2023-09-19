DESC employees;

SELECT * FROM employees;

SELECT employee_id, first_name, salary, salary*12 AS ¿¬ºÀ
FROM employees;

SELECT employee_id, first_name || ' ' || last_name AS "EMPLOYEE_NAME", salary
FROM employees;

SELECT DISTINCT department_id FROM employees;

SELECT employee_id, first_name, department_id
FROM employees
WHERE department_id = 50;

SELECT employee_id, first_name, salary, job_id
FROM employees
WHERE employee_id >= 150;

SELECT employee_id, salary
FROM employees
WHERE salary between 8000 and 10000;

SELECT first_name, job_id, salary, department_id
FROM employees
WHERE department_id in (10, 50, 100);

SELECT first_name, hire_date, job_id, commission_pct
FROM employees
WHERE first_name LIKE 'D%';

SELECT first_name, hire_date
FROM employees
WHERE first_name LIKE '%s';

SELECT first_name, job_id, department_id
FROM employees
WHERE first_name LIKE '%a%';

SELECT *
FROM employees
WHERE job_id LIKE 'SA\_%' ESCAPE '\';

SELECT first_name, commission_pct, department_id
FROM employees
WHERE commission_pct IS NULL;

SELECT first_name, commission_pct, department_id
FROM employees
WHERE commission_pct IS NOT NULL;

SELECT *
FROM employees
WHERE salary > 10000
OR department_id = 100;

SELECT *
FROM employees
WHERE salary >= 10000
OR department_id = 30;

SELECT *
FROM employees
WHERE department_id NOT IN(10, 20, 30);

SELECT *
FROM employees
WHERE salary NOT BETWEEN 5000 AND 10000;

SELECT *
FROM employees
WHERE salary >= 1000
AND department_id >= 100;

SELECT *
FROM employees
WHERE first_name LIKE '%a%'
OR first_name LIKE '%A%';

SELECT employee_id, first_name, department_id, salary
FROM employees
WHERE department_id <= 50
ORDER BY department_id, salary DESC;

SELECT *
FROM employees
WHERE hire_date LIKE '05/%';

