--4. ��� ����� �޿� �ְ��, ������, �Ѿ� �� ��վ��� ǥ���Ͻÿ�. �� ���̺��� ���� Maximum, Minimum, Sum, Average�� �����ϰ� ����� ������ �ݿø��ϵ��� �ۼ��Ͻÿ�.
SELECT MAX(salary) AS Maximum, MIN(salary) AS Minimum, SUM(salary) AS Sum, ROUND(AVG(salary)) AS Average
FROM employees;

--5. ���� ���Ǹ� �����Ͽ� �� ���� ����(job_id)���� �޿� �ְ��, ������, �Ѿ� �� ��վ��� ǥ���Ͻÿ�.
SELECT job_id, MAX(salary) AS Maximum, MIN(salary) AS Minimum, SUM(salary) AS Sum, ROUND(AVG(salary)) AS Average
FROM employees
GROUP BY job_id;

--6. ������ ��� ���� ǥ���ϴ� ���Ǹ� �ۼ��Ͻÿ�.
SELECT department_id, job_id, COUNT(*)
FROM employees
GROUP BY department_id, job_id
ORDER BY department_id;

--7. ������ ���� Ȯ���Ͻÿ�. �� ���̺��� Number of Managers�� �����Ͻÿ�. (��Ʈ: MANAGER_ID ���� ���)
SELECT COUNT(DISTINCT manager_id) AS "Number of Managers"
FROM employees;

--8. �ְ� �޿��� ���� �޿��� ������ ǥ���ϴ� ���Ǹ� �ۼ��ϰ� �� ���̺��� DIFFERENCE�� �����Ͻÿ�.
SELECT MAX(salary), MIN(salary), MAX(salary) - MIN(salary) AS "DIFFERENCE"
FROM employees;

--9. ������ ��ȣ, �ش� �����ڿ� ���� ����� ���� �޿��� ǥ���Ͻÿ�. �����ڸ� �� �� ���� ���, ���� �޿��� 6,000 �̸��� �׷��� ���ܽ�Ű�� ����� �����޿��� ���� ������������ �����Ͻÿ�.
SELECT manager_id, MIN(salary)
FROM employees
WHERE manager_id IS NOT NULL
GROUP BY manager_id
HAVING MIN(salary) >= 6000
ORDER BY MIN(salary) DESC;

--10. ������ ǥ���� ���� �ش� ������ ���� �μ� ��ȣ��(�μ� 20, 50, 80, 90) �޿� �հ�� ��� ����� �޿� �Ѿ��� ���� ǥ���ϴ� ���Ǹ� �ۼ��ϰ�, �� ���� ������ �Ӹ����� �����Ͻÿ�.
SELECT job_id AS ����, department_id AS "�μ� ��ȣ",
        NVL(CASE WHEN department_id = 20 THEN SUM(salary) END, 0)  AS "20�� �μ� �հ�",
        NVL(CASE WHEN department_id = 50 THEN SUM(salary) END, 0)  AS "50�� �μ� �հ�",
        NVL(CASE WHEN department_id = 80 THEN SUM(salary) END, 0)  AS "80�� �μ� �հ�",
        NVL(CASE WHEN department_id = 90 THEN SUM(salary) END, 0)  AS "90�� �μ� �հ�", 
        SUM(salary) AS "�޿� �Ѿ�"
FROM employees
GROUP BY job_id, department_id
HAVING department_id IN (20,50,80,90)
ORDER BY department_id;

SELECT * FROM employees;
SELECT * FROM departments;
SELECT * FROM jobs;

SELECT e.department_id, department_name, employee_id, first_name, salary
FROM employees e FULL JOIN departments d ON (e.department_id = d.department_id)
WHERE salary > 13000
ORDER BY department_id;

SELECT e.department_id, department_name, employee_id, first_name, salary
FROM employees e, departments d 
WHERE(e.department_id = d.department_id)
AND salary > 13000
ORDER BY department_id;

SELECT * FROM employees;

SELECT e.department_id, department_name, ROUND(AVG(salary)), MIN(salary), MAX(salary), COUNT(*)
FROM employees e JOIN departments d ON (e.department_id = d.department_id)
GROUP BY e.department_id, department_name;

--��� ������� ���� ����� �μ���ȣ,first_name ������ ���� �μ���ȣ,�μ��̸�,�����ȣ,first_name,job_title,�޿� ������ ���
SELECT e.department_id, department_name, employee_id, first_name, job_title, salary
FROM employees e LEFT JOIN departments d ON (e.department_id = d.department_id)
    LEFT JOIN jobs j ON (e.job_id = j.job_id);

--��� �μ�����, �������, ��� ��������� �μ���ȣ�� �����ȣ ������ ����, �μ���ȣ,�μ��̸�,�����ȣ,first_name,�����ȣ,�޿�,�����ȣ,����̸� ������ ���
SELECT e1.department_id, d.department_name, e1.employee_id, e1.first_name, e1.manager_id, e1.salary, e2.employee_id, e2.first_name
FROM employees e1 LEFT JOIN employees e2 ON (e1.manager_id = e2.employee_id)
    LEFT JOIN departments d ON (e1.department_id = d.department_id)
ORDER BY e1.department_id, e1.employee_id;

--1. LOCATIONS, COUNTRIES ���̺��� ����Ͽ� ��� �μ��� �ּҸ� �����ϴ� query�� �ۼ��Ͻÿ�. ��¿� ��ġ ID, �ּ�, ��/��, ��/�� �� ������ ǥ���ϸ�, NATURAL JOIN�� ����Ͽ� ����� �����մϴ�.
SELECT location_id, street_address, city, state_province, country_name
FROM locations NATURAL JOIN countries;

-- 2. ��� ����� last_name, �Ҽ� �μ���ȣ, �μ� �̸��� ǥ���ϴ� query�� �ۼ��Ͻÿ�.
SELECT last_name, e.department_id, department_name
FROM employees e LEFT JOIN departments d ON(e.department_id = d.department_id);

-- 3. Toronto�� �ٹ��ϴ� ����� ���� ������ �ʿ�� �մϴ�. toronto���� �ٹ��ϴ� ��� ����� last_name, ����, �μ���ȣ, �μ� �̸��� ǥ���Ͻÿ�. (��Ʈ : 3-way join ���)
SELECT last_name, job_id, e.department_id, department_name, city, l.location_id
FROM employees e LEFT JOIN departments d ON(e.department_id = d.department_id)
    LEFT JOIN locations l ON(d.location_id = l.location_id)
WHERE city = 'Toronto'
ORDER BY department_id, last_name;

SELECT e.last_name, e.job_id, e.department_id, d.department_name, l.city, l.location_id
FROM employees e JOIN departments d ON(e.department_id = d.department_id),
    (SELECT location_id, city
     FROM locations) l
WHERE d.location_id = l.location_id 
AND l.city = 'Toronto'
ORDER BY department_id, last_name;

SELECT e.last_name, e.job_id, e.department_id, d.department_name, l.city, l.location_id
FROM employees e,
    (SELECT department_id, location_id, department_name
     FROM departments) d,
    (SELECT location_id, city
     FROM locations) l
WHERE e.department_id = d.department_id
AND d.location_id = l.location_id 
AND l.city = 'Toronto'
ORDER BY department_id, last_name;

-- 4. ����� last_name, ��� ��ȣ�� �ش� �������� last_name, ������ ��ȣ�� �Բ� ǥ���ϴ� ������ �ۼ��Ͻÿ�. �� ���̺��� ���� Employee, Emp#, Manager, Mgr#���� �����Ͻÿ�.
SELECT e.last_name AS "Employee", e.employee_id AS "Emp#", m.first_name AS "Manger", m.employee_id AS "Mgr#"
FROM employees e, employees m 
WHERE e.manager_id = m.employee_id
ORDER BY e.employee_id;

-- 5. King�� ���� �ش� �����ڰ� �������� ���� ��� ����� ǥ���ϵ��� 4�� ������ �����մϴ�. ��� ��ȣ������ ����� �����Ͻÿ�.
SELECT e.last_name AS "Employee", e.employee_id AS "Emp#", m.first_name AS "Manger", m.employee_id AS "Mgr#"
FROM employees e LEFT JOIN employees m ON(e.manager_id = m.employee_id)
ORDER BY e.employee_id;

-- 6. ����� last_name, �μ� ��ȣ, ���� �μ��� �ٹ��ϴ� ��� ����� �̸��� ǥ���ϴ� ������ �ۼ��Ͻÿ�. �� ���� ������ ���̺��� �����Ӱ� ������ ���ϴ�.
SELECT e1.last_name AS "��� �̸�", e1.department_id AS "�μ� ��ȣ", e2.last_name "���� �̸�"
FROM employees e1 LEFT JOIN employees e2 ON(e1.department_id = e2.department_id)
WHERE(e1.last_name != e2.last_name)
ORDER BY e1.department_id, e1.last_name;

-- 7. ����, �޿��� ���� ������ �ʿ�� �մϴ�. ���� JOBS���̺��� ������ ǥ���� ����, ��� ����� �̸�, ����, �μ� �̸�, �޿��� ǥ���ϴ� query�� �ۼ��Ͻÿ�.
SELECT * FROM jobs;

SELECT j.job_title, e.first_name AS �����, e.job_id AS ����, d.department_name AS �μ���, e.salary AS �޿�
FROM jobs j LEFT JOIN employees e ON(j.job_id = e.job_id)
    LEFT JOIN departments d ON(e.department_id = d.department_id)
ORDER BY j.job_id, e.first_name;

-- 1. Zlotkey�� ������ �μ��� ���� ��� ����� �̸��� �Ի����� ǥ���ϴ� ���Ǹ� �ۼ��Ͻÿ�. Zlotkey�� ������� �����Ͻÿ�.
SELECT last_name, hire_date
FROM employees
WHERE department_id = 
    (SELECT department_id
     FROM employees
     WHERE INITCAP(last_name) = 'Zlotkey')
AND INITCAP(last_name) != 'Zlotkey';

-- 2. �޿��� ��� �޿����� ���� ��� ����� ��� ��ȣ�� �̸��� ǥ���ϴ� ���Ǹ� �ۼ��ϰ� ����� �޿��� ���� ������������ �����Ͻÿ�.
SELECT employee_id, first_name, salary
FROM employees
WHERE salary > ALL
    (SELECT AVG(salary)
     FROM employees)
ORDER BY salary;

-- 3. �̸��� u�� ���Ե� ����� ���� �μ����� ���ϴ� ��� ����� ��� ��ȣ�� �̸��� ǥ���ϴ� ���Ǹ� �ۼ��ϰ� ���Ǹ� �����Ͻÿ�.
SELECT employee_id, last_name
FROM employees
WHERE department_id = ANY
    (SELECT department_id
     FROM employees
     WHERE UPPER(last_name) LIKE '%U%');

-- 4. �μ� ��ġ ID�� 1700�� ��� ����� �̸�, �μ� ��ȣ �� ���� ID�� ǥ���Ͻÿ�.
SELECT last_name, department_id, job_id
FROM employees
WHERE department_id = ANY
    (SELECT department_id
     FROM departments
     WHERE location_id = 1700);
     
-- 5. King���� �����ϴ�(manager�� King) ��� ����� �̸��� �޿��� ǥ���Ͻÿ�.
SELECT last_name, salary
FROM employees
WHERE manager_id = ANY
    (SELECT employee_id
     FROM employees
     WHERE last_name = 'King');
     
-- 6. Executive �μ��� ��� ����� ���� �μ� ��ȣ, �̸�, ���� ID�� ǥ���Ͻÿ�.
SELECT department_id, last_name, job_id
FROM employees
WHERE department_id = ANY
    (SELECT department_id
     FROM departments
     WHERE department_name = 'Executive');
     
-- 7. ��� �޿����� ���� �޿��� �ް�, �̸��� u�� ���Ե� ����� ���� �μ��� �ٹ��ϴ� ��� ����� �����ȣ, �̸�, �޿��� ǥ���Ͻÿ�.
SELECT employee_id, last_name, salary
FROM employees
WHERE salary > ALL
    (SELECT AVG(salary)
     FROM employees)
AND department_id = ANY
    (SELECT department_id
     FROM employees
     WHERE UPPER(last_name) LIKE '%U%')
ORDER BY salary;