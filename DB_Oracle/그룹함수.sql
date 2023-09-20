SELECT department_id, job_id, SUM(salary), ROUND(AVG(salary), 2) AS ���, MIN(salary), MAX(salary), COUNT(*)
FROM employees
WHERE department_id >= 90
GROUP BY department_id, job_id
HAVING MAX(salary) > 10000
ORDER BY department_id;

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
        NVL(SUM(salary), 0) AS "�޿� �Ѿ�"
FROM employees
GROUP BY job_id, department_id
HAVING department_id IN (20,50,80,90)
ORDER BY department_id;