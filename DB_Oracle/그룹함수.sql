SELECT department_id, job_id, SUM(salary), ROUND(AVG(salary), 2) AS 평균, MIN(salary), MAX(salary), COUNT(*)
FROM employees
WHERE department_id >= 90
GROUP BY department_id, job_id
HAVING MAX(salary) > 10000
ORDER BY department_id;

SELECT employee_id, first_name, e.department_id, department_name
FROM employees e, departments d;

SELECT *
FROM employees e, departments d
WHERE e.department_id = d.department_id;

SELECT employee_id, first_name, e.job_id, job_title, salary
FROM employees e, jobs j
WHERE e.salary between j.min_salary and j.max_salary
ORDER BY employee_id;

SELECT employee_id, first_name, e.department_id, department_name
FROM employees e, departments d
WHERE e.department_id(+) = d.department_id
ORDER BY employee_id;

SELECT e.first_name || '의 매니저 이름은 ' || m.first_name || '입니다' AS manager
FROM employees e, employees m
WHERE e.manager_id = m.employee_id;

SELECT employee_id, first_name, e.department_id, department_name
FROM employees e CROSS JOIN departments d;

SELECT employee_id, first_name, department_id, department_name
FROM employees NATURAL JOIN departments;

SELECT employee_id, first_name, department_id, department_name
FROM employees LEFT JOIN departments USING(department_id);

SELECT employee_id, first_name, e.department_id, department_name
FROM employees e LEFT JOIN departments d ON(e.department_id = d.department_id);

SELECT employee_id, first_name, e.department_id, department_name
FROM employees e FULL JOIN departments d ON(e.department_id = d.department_id);

SELECT first_name, job_id
FROM employees
WHERE job_id =
    (SELECT job_id 
     FROM employees
     WHERE employee_id = 182);

SELECT first_name, job_id, department_id, salary
FROM employees
WHERE salary = 
    (SELECT MIN(salary)
     FROM employees);

SELECT department_id, ROUND(AVG(salary))
FROM employees
GROUP BY department_id
HAVING AVG(salary) >
    (SELECT MIN(AVG(salary))
     FROM employees
     GROUP BY department_id)
ORDER BY department_id;

SELECT first_name, salary 
FROM employees
WHERE salary = ANY 
    (SELECT MIN(salary)
     FROM employees
     GROUP BY department_id);
     
SELECT first_name, salary, commission_pct, department_id
FROM employees
WHERE (salary, NVL(commission_pct, -1)) IN
    (SELECT salary, NVL(commission_pct, -1)
     FROM employees
     WHERE department_id = 20)
AND department_id != 20;

SELECT first_name, salary, commission_pct, department_id
FROM employees
WHERE salary IN
    (SELECT salary
     FROM employees
     WHERE department_id = 20)
AND NVL(commission_pct, -1) IN
    (SELECT NVL(commission_pct, -1)
     FROM employees
     WHERE department_id = 20)
AND department_id != 20;