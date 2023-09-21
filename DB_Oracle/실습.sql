-- 1) ��� ����鿡 ���� �����ȣ�� �̸�, ����, �Ի����� ����ϼ���.
SELECT employee_id, first_name, job_id, hire_date
FROM employees;

-- 2) �Ŵ��� ��å�� �ð� �ִ� ����� �����ȣ�� �ߺ����� �ʰ� ����ϼ���.
SELECT DISTINCT manager_id
FROM employees
WHERE manager_id IS NOT NULL;

-- 3) ��� �߿��� �޿��� 7000�̻� 12000�����̸� �̸��� 'H'�� �����ϴ� ����� �����ȣ, �̸�, �޿�, �μ���ȣ�� ����ϼ���. 
SELECT employee_id, first_name, salary, department_id
FROM employees
WHERE salary BETWEEN 7000 AND 12000
AND first_name LIKE 'H%';

-- 4) 2005�� 1�� 1�� ����(2005�� 1�� 1�� ����)�� �Ի��� ����� ���, �̸�, �Ի���, ù ���ں��� 3���ڸ� ��µ� �̸��ϰ���(��Ī : EMAIL) �� �̸��� ������ ���� ��(��Ī : EMAIL LENGTH)�� ����ϼ���.
SELECT employee_id, first_name, hire_date, SUBSTR(email, 1, 3) AS EMAIL, LENGTH(email) AS "EMAIL LENGTH"
FROM employees
WHERE hire_date >= '2005/01/01';

-- 5) ��� ����� �̸�, �Ի���, �Ի� 6���� ���� ��¥, �Ի� �� ù �ݿ���, �� �ٹ� ����, ù �޿����� ���ʷ� ǥ���ϼ���. 
-- �� �ٹ� ������ �� �� �̸� �����Ͽ� ������ ǥ���ϼ���. ù �޿����� �Ի��� ���� �� 1���Դϴ�. ����� �Ի����� �������� �������� �����ϼ���. 
SELECT first_name, hire_date, ADD_MONTHS(hire_date, 6) AS "�Ի� 6���� ��", NEXT_DAY(hire_date, '��') AS "�Ի� �� ù �ݿ���", TRUNC(MONTHS_BETWEEN(sysdate, hire_date)) AS "�� �ٹ� ����", LAST_DAY(hire_date) + 1 AS "ù �޿���"
FROM employees
ORDER BY hire_date;

-- 6) Ŀ�̼��� �޴� ������� ������� �����ȣ, �̸�, �Ի���, ������ ǥ���ϰ��� �Ѵ�. ������ �޿��� Ŀ�̼��� ���Ͽ� ���� �� �ִ�. 
-- �Ի����� ��24/03/2008 �����ϡ��� �������� ����ϰ�, ������ $��ȣ�� õ���� ���б�ȣ �� �Ҽ��� ��°�ڸ����� ǥ���� �� �ֵ��� �Ѵ�. ����� ���翡 ���Ͽ� �������� �����ϼ���.
SELECT employee_id, first_name, TO_CHAR(hire_date, 'dd/mm/yyyy day') AS �Ի���, TO_CHAR(ROUND(NVL(salary * commission_pct, 0), 2), '$999,999') AS ����
FROM employees
WHERE commission_pct != 0
ORDER BY ���� DESC;

-- 7) �μ���ȣ�� 50���� 60�� ���� ��� �޿��� 5000���� ���� ������ �����ȣ, �̸�, ����ID, �޿�, �μ���ȣ�� ����ϼ���. 
SELECT employee_id, first_name, job_id, salary, department_id
FROM employees
WHERE department_id IN (50, 60)
AND salary > 5000;

-- 8) �Լ��� �̿��Ͽ� ������̺��� ��ȭ��ȣ�� ������ȣ�� 515(515�� ����)�� ����� ���, ����ID, ��ȭ��ȣ, �μ���ȣ�� ����ϼ���. 
SELECT employee_id, job_id, phone_number, department_id
FROM employees
WHERE SUBSTR(phone_number, 1, 3) = 515;

-- 9) ������̺��� �����ȣ, ����̸�, ����, �Ի��� ����(�Ի����̿�), ������ �޴��� ���θ� ��Ÿ���� ���, �μ���ȣ�� ����ϼ���. 
--- ������ �޿��� Ŀ�̼��� ���ؼ� ����ϰ�, ������ �޿��� ������ ���� ���� 12�� ���ؼ� ���Ѵ�. - ���� ���� ���� ���� �ʵ��� �����Ѵ�.
--- ����� ������ ������ ���ԵǾ����� COMM, ���Ե��� �ʾ����� NOCOMM�� ǥ���Ͻÿ�. - ����� �μ���ȣ �� ������ ���Ͽ� �������� �����Ͻÿ�. 
SELECT employee_id, first_name, (salary + salary * NVL(commission_pct, 0)) * 12 AS ����, hire_date, NVL2(commission_pct, 'COMM', 'NOCOMM') AS ���, department_id
FROM employees
ORDER BY department_id, ����; 

-- 10) ������̺��� �����ȣ, ����̸�, �μ���ȣ �� �ٹ������� ǥ���ϼ���. �ٹ������� 20�� �μ��� ����̸� 'Canada', 80�μ��� �����̸� 'UK'�� ǥ���ϰ� ������ �������� 'USA'�� ǥ���ϼ���. (CASE �� ���)
SELECT employee_id, first_name, department_id, department_id, 
    CASE WHEN department_id = 20 THEN 'Canada'
         WHEN department_id = 80 THEN 'UK'
         ELSE 'USA'
    END AS �ٹ�����
FROM employees;

-- 11. DEPARTMENTS ���̺�� LOCATIONS ���̺� ���Ͽ� JOIN�� �����Ͽ� �μ���ȣ, �μ��̸�, ���ø��� ����Ͻÿ�. (JOIN ����� ����)
SELECT d.department_id, d.department_name, l.city
FROM departments d LEFT JOIN locations l ON (d.location_id = l.location_id)
ORDER BY department_id;

-- 12. EMPLOYEES, DEPARTMENTS ���̺�κ��� ���, �̸�(FIRST_NAME), �ҼӺμ���ȣ, �ҼӺμ� �̸��� ǥ���ϵ� �μ��� �������� ���� ����� �Բ� ǥ���Ͻÿ�. 
SELECT e.employee_id, e.first_name, e.department_id, d.department_name
FROM employees e LEFT JOIN departments d ON (e.department_id = d.department_id)
ORDER BY employee_id;

-- 13. EMPLOYEES ���̺��� �μ���ȣ�� �μ��� �ٹ��ο���, ��ձ޿��� �����Ͽ� ������ ǥ���Ͻÿ�. 
SELECT department_id, COUNT(NVL(department_id, 1)) AS �ٹ��ο�, TRUNC(AVG(salary))
FROM employees
GROUP BY department_id
ORDER BY department_id;

-- 14. ���������� ����Ͽ� IT �μ����� �ٹ��ϴ� ������� �����ȣ, �̸�(FIRST_NAME), ����(JOB_ID)�� ǥ���Ͻÿ�. 
SELECT employee_id, first_name, job_id
FROM employees 
WHERE department_id = 
    (SELECT department_id
     FROM departments
     WHERE UPPER(department_name) = 'IT');
     
-- 15.HR ����ڷ� �����Ͽ� ������ �䱸���״�� PROF ���̺��� �����Ͻÿ�.
CREATE TABLE prof(
    profno      NUMBER(4)       primary key,
    name        VARCHAR2(15)    NOT NULL,
    id          VARCHAR2(15)    NOT NULL,
    hiredate    DATE,
    pay         NUMBER(4)
);

DESC prof;

SELECT * FROM prof;
-- 16. ������ ���� PROF ���̺� DML ��ɹ��� �ۼ��Ͻÿ�.
INSERT INTO prof
VALUES (1001, 'Mark', 'm1001', '07/03/01', 800);

INSERT INTO prof
VALUES (1003, 'Adam', 'a1003', '11/03/02', '');

INSERT INTO prof
VALUES (1004, 'Tom', 't1004', '20/02/25', 900);

UPDATE prof
SET pay = 1200
WHERE profno = 1001;

DELETE prof
WHERE profno = 1004;

COMMIT;