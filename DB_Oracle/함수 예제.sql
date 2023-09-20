-- 1) ��� ���̺��� �����ȣ�� �̸��� ���� ��ȸ.
SELECT employee_id, first_name, salary
FROM employees;

-- 2) ��� ���̺��� ��� �÷� ��ȸ.
SELECT *
FROM employees;

-- 3) ��� ���̺��� �����ȣ�� �̸�, ���� ��ȸ. �÷����� �ѱ۷� '��� ��ȣ', '��� �̸�'���� ��ȸ.
SELECT employee_id AS "��� ��ȣ", first_name AS "��� �̸�"
FROM employees;

-- 4) ��� ���̺��� �̸��� ������ �̿��Ͽ� ������ ���� ��ȸ.
SELECT first_name || ' �� ������ ' || salary || ' �޷��Դϴ�.'
FROM employees;

-- 5) ��� ���̺��� �ߺ��� �����͸� ������ ���� ��ȸ.
SELECT DISTINCT job_id 
FROM employees;

-- 6) ��� ����� �̸��� ���� ��ȸ. ������ ���� ������� ���.
SELECT  first_name, salary
FROM employees
ORDER BY salary;

-- 7) ��� ��� �� ������ 3000�� ������� �̸�, ����, ������ ��ȸ.
SELECT  first_name, salary, job_id
FROM employees
WHERE salary = 3000;

-- 8) �̸��� 'Steven'�� ����� �̸�, ����, ����, �Ի���, �μ���ȣ ��ȸ.
SELECT  first_name, salary, job_id, hire_date, department_id
FROM employees
WHERE first_name = 'Steven';

-- 9) ������ 3600�̻��� ������� �̸��� ������ ��ȸ. -- - ������ ���޿� ������ ���ϰ� 12�� ���ؼ� ���Ѵ�. -- - ������ ���޿� Ŀ�̼��� ���ؼ� ���Ѵ�.
SELECT  first_name, ((salary + salary * NVL(commission_pct, 0)) * 12) AS ����
FROM employees
WHERE (salary + salary * NVL(commission_pct, 0)) * 12 >= 50000;

-- 10) ������ 12000������ ������� �̸���, ����, ����, �μ���ȣ�� ��ȸ.
SELECT  first_name, salary, job_id, department_id
FROM employees
WHERE salary <= 12000;

-- 11) ������ 'SA_MAN'�� �ƴ� ������� �̸��� �μ���ȣ, ������ ��ȸ.
SELECT  first_name, department_id, job_id
FROM employees
WHERE job_id != 'SA_MAN';

-- 12) ������ 1000���� 3000������ ������� �̸��� ������ ��ȸ.
SELECT  first_name, salary
FROM employees
WHERE salary >= 1000
AND salary <= 3000;

-- 13) ������ 1000���� 3000���̰� �ƴ� ������� �̸��� ������ ��ȸ.
SELECT  first_name, salary
FROM employees
WHERE salary < 1000
OR salary > 3000;

-- 14) 2006�⵵�� �Ի��� ������� �̸��� �Ի��� ��ȸ.
SELECT  first_name, hire_date
FROM employees
WHERE hire_date LIKE '06%';

-- 15) �̸��� ù ���ڰ� S, s�� �����ϴ� ������� �̸��� ������ ��ȸ.
SELECT  first_name, salary
FROM employees
WHERE first_name LIKE 's%'
OR first_name LIKE 'S%';

-- 16) �̸��� �� ���ڰ� t, T�� ������ ������� �̸��� ������ ��ȸ.
SELECT  first_name, salary
FROM employees
WHERE first_name LIKE '%t'
OR first_name LIKE '%T';

-- 17) �̸��� �� ��° ö�ڰ� m, M �� ����� �̸��� ������ ��ȸ.
SELECT  first_name, salary
FROM employees
WHERE first_name LIKE '_m'
OR first_name LIKE '_M';

-- 18) �̸��� A, a�� �����ϰ� �ִ� ������� �̸��� ��ȸ.
SELECT  first_name
FROM employees
WHERE UPPER(first_name) LIKE '%A%';

-- 19) Ŀ�̼��� NULL�� ������� �̸��� Ŀ�̼��� ��ȸ.
SELECT  first_name, commission_pct
FROM employees
WHERE commission_pct IS NULL;

-- 20) ������ 'SA_MAN', 'PU_CLERK', 'IT_PROG' �� ������� �̸�, ����, ���� ��ȸ.
SELECT  first_name, salary, job_id
FROM employees
WHERE job_id IN ('SA_MAN', 'PU_CLERK', 'IT_PROG');

-- 21) ������ 'SA_MAN', 'PU_CLERK', 'IT_PROG' �� �ƴ� ������� �̸�, ����, ���� ��ȸ.
SELECT  first_name, salary, job_id
FROM employees
WHERE job_id NOT IN ('SA_MAN', 'PU_CLERK', 'IT_PROG');

-- 22) ������ 'SA_MAN'�̰� ������ 1200�̻��� ������� �̸�, ����, ������ ��ȸ.
SELECT  first_name, salary, job_id
FROM employees
WHERE job_id = 'SA_MAN'
AND salary >= 1200;

-- 23) ��� ���̺��� �̸��� ��ȸ. �� ù ��° �÷��� �̸��� �빮�ڷ� ����ϰ�, �ι�° �÷��� �̸��� �ҹ��ڷ� ����ϰ�, �� ��° �÷��� �̸��� ù ��° ö�ڴ� �빮�ڷ�, �������� �ҹ��ڷ� ��ȸ.
SELECT  UPPER(first_name), LOWER(first_name), INITCAP(first_name)
FROM employees;

-- 24) �̸��� alexander(��� �ҹ��ڷ� ��ȯ)�� ����� �̸��� ���� ��ȸ.
SELECT  first_name, salary
FROM employees
WHERE LOWER(first_name) = 'alexander';

-- 25) ���� �ܾ� SMITH���� SMI�� �߶� ��ȸ.
SELECT SUBSTR('SMITH',1,3)
FROM dual;

-- 26) ������� �̸�(last_name)�� �̸��� ö�� ������ ���.
SELECT  last_name, LENGTH(last_name)
FROM employees;

-- 27) �̸��� �ҹ��� a�� �����ϴ� ��� �� ��° �ڸ��� ��ġ�ϴ��� ��ȸ.
SELECT CONCAT(first_name, CONCAT(' ', last_name)), INSTR(CONCAT(first_name, last_name), 'a')
FROM employees;

-- 28) ������� �̸��� ������ ��ȸ. �� ���� �÷��� �ڸ����� 10�ڸ��� �ϰ�, ������ ����ϰ� ���� ������ �ڸ��� *(��ǥ)�� ä���� ��ȸ.
SELECT first_name, LPAD(salary, 10, '*')
FROM employees;

-- 29) ������� �̸��� ���� ��ȸ. �� ������ 1000�� �׸�(��) �ϳ��� ���.
SELECT first_name, LPAD(' ', LENGTH(salary/1000) + 1, '��')
FROM employees;

-- 30) ���� 876.567�� �Ҽ��� �� ��° �ڸ����� ���(�ݿø� ó��)
SELECT ROUND(876.567, 2)
FROM dual;

-- 31) ���� 876.567�� �Ҽ� ù° �ڸ����� ���(���� ó��)
SELECT TRUNC(876.567, 1)
FROM dual;

-- 32) ���� 10�� 3���� ���� ������ ���� ���.
SELECT MOD(10, 3)
FROM dual;

-- 33) ��� ��ȣ�� ��� ��ȣ�� Ȧ���̸� 1, ¦���̸� 0�� ���.
SELECT employee_id, 
    CASE WHEN MOD(employee_id, 2) = 0 THEN 0
         ELSE 1
    END AS Ȧ¦
FROM employees;

-- 34) �����ȣ�� ¦���� ������� ��� ��ȣ�� �̸��� ��ȸ.
SELECT employee_id, first_name
FROM employees
WHERE MOD(employee_id, 2) = 0
ORDER BY employee_id;

-- 35) ����� �̸��� �Ի��� ��¥���� ���ñ��� �� �� ���� �ٹ��ߴ��� ��ȸ(����).
SELECT first_name, ROUND(MONTHS_BETWEEN(sysdate, hire_date))
FROM employees;

-- 36) 2018�� 10�� 1�Ͽ��� 2019�� 6�� 1�� ������ ���ϼ� ���.
SELECT TO_DATE('19/06/01') - TO_DATE('18/10/01')
FROM dual;

-- 37) 2018�� 10�� 1�Ͽ��� 2019�� 6�� 1�� ������ �� ��(Week) ���� ���(����).
SELECT ROUND((TO_DATE('19/06/01') - TO_DATE('18/10/01')) / 7) AS ��
FROM dual;

-- 38) 2023�� 5�� 1�Ϸκ��� 100�� ���� ��¥ ���.
SELECT ADD_MONTHS(TO_DATE('23/05/01'), 100)
FROM dual;

-- 39) 2023�� 5�� 1�Ϸκ��� 100�� �� ��¥ ���.
SELECT TO_DATE('23/05/01') + 100
FROM dual;

-- 40) 2023�� 6�� 30�� ���� �ٷ� ���ƿ� ȭ������ ��¥ ���
SELECT NEXT_DAY(TO_DATE('23/06/30'), 'ȭ')
FROM dual;

-- 41) 2023�� 9�� 19�� ���� �ٷ� ���ƿ� ������� ��¥ ���
SELECT NEXT_DAY(TO_DATE('23/09/19'), '��')
FROM dual;

-- 42) ���� ���� ���ƿ� �ݿ����� ��¥ ���
SELECT NEXT_DAY(sysdate, '��')
FROM dual;

-- 43) 2020�� 5�� 22�Ϻ��� 100�� �ڿ� ���ƿ��� ȭ������ ��¥ ���
SELECT NEXT_DAY(ADD_MONTHS(TO_DATE('20/05/22'), 100), 'ȭ')
FROM dual;

-- 44) ���ú��� 100�� �ڿ� ���ƿ��� �������� ��¥ ���
SELECT NEXT_DAY(ADD_MONTHS(sysdate, 100), '��')
FROM dual;

-- 45) 2019�� 5�� 22�� �ش� ���� ������ ��¥�� ��� �Ǵ��� ��ȸ
SELECT LAST_DAY(TO_DATE('19/05/22'))
FROM dual;

-- 46) ���ú��� �̹� �� ���ϱ��� �� ��ĥ ���Ҵ��� ��ȸ
SELECT LAST_DAY(sysdate) - sysdate
FROM dual;

-- 47) �̸��� SUSAN�� ����� �̸�, �Ի���, �Ի��� ���� ������ ��¥�� ��ȸ
SELECT first_name, hire_date, LAST_DAY(hire_date)
FROM employees;

ALTER SESSION SET NLS_DATE_FORMAT ='RRRR-MM-DD HH24:MI';

SELECT sysdate FROM dual;

-- 48) �̸�(last_name)�� GRANT(�빮�ڷ� ��ȯ)�� ����� �̸��� �Ի��� ������ ����ϰ�, GRANT�� ���޿� õ������ ������ �� �ִ� �޸�(,)�� �ٿ� ��ȸ
SELECT first_name, TO_CHAR(hire_date, 'DAY') AS "�Ի��� ����", TO_CHAR(salary, 'L999,999')
FROM employees
WHERE UPPER(last_name) = 'GRANT';

-- 50) 2008�⵵�� �Ի��� ����� �̸��� �Ի��� ��ȸ(to_char �Լ� ���)
SELECT first_name, hire_date
FROM employees
WHERE TO_CHAR(hire_date) LIKE '2008%';

-- 51) ������ 1500 �̻��� ����� �̸���, ���޿� õ������ ������ �� �ִ� �޸�(,)�� ȭ������� �ٿ� ��ȸ
SELECT first_name, TO_CHAR(salary, 'L999,999') AS ����
FROM employees;

-- 52) 2005�� 06�� 14�Ͽ� �Ի��� ����� �̸��� �Ի��� ��ȸ(to_date �Լ� ���)
SELECT first_name, hire_date
FROM employees
WHERE hire_date = TO_DATE('05/06/14');

-- 53) ����� �̸��� Ŀ�̼��� ��ȸ. (�� Ŀ�̼��� NULL�� ������� 0)
SELECT first_name, NVL(commission_pct, 0) AS Ŀ�̼�
FROM employees;

-- 54) ������ 'SA_MAN' �Ǵ� 'IT_PROG' �� ����� ����, �߰�����, ���޿� ��ȸ - �߰����� : ���� * Ŀ�̼�(�� Ŀ�̼��� NULL�� ��� 0) - ���޿� : ���� + �߰�����
SELECT salary, salary * NVL(commission_pct, 0) AS �߰�����,  salary + (salary * NVL(commission_pct, 0)) AS ���޿�
FROM employees
WHERE job_id in ('SA_MAN', 'IT_PROG');

-- 55) ����� �̸��� �μ� ��ȣ, ���ʽ� ��ȸ  ���ʽ� : �μ� ��ȣ�� 10���̸� 300, 20���̸� 400, ������ �μ� ��ȣ�� 0
SELECT first_name, department_id, 
    CASE department_id WHEN 10 THEN 300
                       WHEN 20 THEN 400
                       ELSE 0
                    
    END AS ���ʽ�
FROM employees
ORDER BY department_id;

-- 56) ��� ��ȣ�� ��� ��ȣ�� ¦������ Ȧ�������� ��ȸ
SELECT employee_id,
    CASE WHEN MOD(employee_id, 2) = 0 THEN '¦��'
         ELSE 'Ȧ��'
    END AS Ȧ¦
FROM employees;

-- 57) ����� �̸�, ����, ���ʽ� ��ȸ  �� ������ 'SA_MAN'�̸� ���ʽ� 5000 ������ ������ ���ʽ� 2000
SELECT first_name, job_id,
    CASE job_id WHEN 'SA_MAN' THEN 5000
                ELSE 2000
    END AS ���ʽ�
FROM employees
ORDER BY ���ʽ� DESC;

-- 58) ����� �̸�, ����, ����, ���ʽ� ��ȸ  - ���ʽ� : ������ 3000�̻��̸� 500, ������ 2000�̻� 3000�̸��̸� 300, ������ 1000�̻� 2000�̸��̸� 200, �������� 0
SELECT first_name, job_id, salary,
    CASE WHEN salary >= 3000 THEN 500
         WHEN salary >= 2000 THEN 300
         WHEN salary >= 1000 THEN 200
         ELSE 0
    END AS ���ʽ�
FROM employees
ORDER BY ���ʽ�;

-- 59) ����� �̸�, ����, Ŀ�̼�, ���ʽ� ��ȸ. ���ʽ� : Ŀ�̼��� NULL�̸� 500, NULL�� �ƴϸ� 0
SELECT first_name, job_id, NVL(commission_pct, 0) AS Ŀ�̼�, NVL2(commission_pct, 0, 500) AS ���ʽ�
FROM employees
ORDER BY ���ʽ� DESC;

-- 60) ����� �̸�, ����, ���ʽ� ��ȸ  - ���ʽ��� ������ 'SA_MAN', 'PU_CLERK' �̸� 500, 'ST_CLERK', 'FI_ACCOUNT'�̸� 400 ������ 0
SELECT first_name, job_id, 
    CASE WHEN job_id IN('SA_MAN', 'PU_CLERK') THEN 500
         WHEN job_id IN('ST_CLERK', 'FI_ACCOUNT') THEN 400
         ELSE 0
    END AS ���ʽ�
FROM employees
ORDER BY ���ʽ� DESC;