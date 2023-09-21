--4. 모든 사원의 급여 최고액, 최저액, 총액 및 평균액을 표시하시오. 열 레이블을 각각 Maximum, Minimum, Sum, Average로 지정하고 결과를 정수로 반올림하도록 작성하시오.
SELECT MAX(salary) AS Maximum, MIN(salary) AS Minimum, SUM(salary) AS Sum, ROUND(AVG(salary)) AS Average
FROM employees;

--5. 위의 질의를 수정하여 각 업무 유형(job_id)별로 급여 최고액, 최저액, 총액 및 평균액을 표시하시오.
SELECT job_id, MAX(salary) AS Maximum, MIN(salary) AS Minimum, SUM(salary) AS Sum, ROUND(AVG(salary)) AS Average
FROM employees
GROUP BY job_id;

--6. 업무별 사원 수를 표시하는 질의를 작성하시오.
SELECT department_id, job_id, COUNT(*)
FROM employees
GROUP BY department_id, job_id
ORDER BY department_id;

--7. 관리자 수를 확인하시오. 열 레이블은 Number of Managers로 지정하시오. (힌트: MANAGER_ID 열을 사용)
SELECT COUNT(DISTINCT manager_id) AS "Number of Managers"
FROM employees;

--8. 최고 급여와 최저 급여의 차액을 표시하는 질의를 작성하고 열 레이블을 DIFFERENCE로 지정하시오.
SELECT MAX(salary), MIN(salary), MAX(salary) - MIN(salary) AS "DIFFERENCE"
FROM employees;

--9. 관리자 번호, 해당 관리자에 속한 사원의 최저 급여를 표시하시오. 관리자를 알 수 없는 사원, 최저 급여가 6,000 미만인 그룹은 제외시키고 결과를 최저급여에 대한 내림차순으로 정렬하시오.
SELECT manager_id, MIN(salary)
FROM employees
WHERE manager_id IS NOT NULL
GROUP BY manager_id
HAVING MIN(salary) >= 6000
ORDER BY MIN(salary) DESC;

--10. 업무를 표시한 다음 해당 업무에 대해 부서 번호별(부서 20, 50, 80, 90) 급여 합계와 모든 사원의 급여 총액을 각각 표시하는 질의를 작성하고, 각 열에 적합한 머리글을 지정하시오.
SELECT job_id AS 업무, department_id AS "부서 번호",
        NVL(CASE WHEN department_id = 20 THEN SUM(salary) END, 0)  AS "20번 부서 합계",
        NVL(CASE WHEN department_id = 50 THEN SUM(salary) END, 0)  AS "50번 부서 합계",
        NVL(CASE WHEN department_id = 80 THEN SUM(salary) END, 0)  AS "80번 부서 합계",
        NVL(CASE WHEN department_id = 90 THEN SUM(salary) END, 0)  AS "90번 부서 합계", 
        SUM(salary) AS "급여 총액"
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

--모든 사원정보 포함 결과를 부서번호,first_name 순으로 정렬 부서번호,부서이름,사원번호,first_name,job_title,급여 순으로 출력
SELECT e.department_id, department_name, employee_id, first_name, job_title, salary
FROM employees e LEFT JOIN departments d ON (e.department_id = d.department_id)
    LEFT JOIN jobs j ON (e.job_id = j.job_id);

--모든 부서정보, 사원정보, 사원 상관정보를 부서번호와 사원번호 순으로 정렬, 부서번호,부서이름,사원번호,first_name,상관번호,급여,상관번호,상관이름 순으로 출력
SELECT e1.department_id, d.department_name, e1.employee_id, e1.first_name, e1.manager_id, e1.salary, e2.employee_id, e2.first_name
FROM employees e1 LEFT JOIN employees e2 ON (e1.manager_id = e2.employee_id)
    LEFT JOIN departments d ON (e1.department_id = d.department_id)
ORDER BY e1.department_id, e1.employee_id;

--1. LOCATIONS, COUNTRIES 테이블을 사용하여 모든 부서의 주소를 생성하는 query를 작성하시오. 출력에 위치 ID, 주소, 구/군, 시/도 및 국가를 표시하며, NATURAL JOIN을 사용하여 결과를 생성합니다.
SELECT location_id, street_address, city, state_province, country_name
FROM locations NATURAL JOIN countries;

-- 2. 모든 사원의 last_name, 소속 부서번호, 부서 이름을 표시하는 query를 작성하시오.
SELECT last_name, e.department_id, department_name
FROM employees e LEFT JOIN departments d ON(e.department_id = d.department_id);

-- 3. Toronto에 근무하는 사원에 대한 보고서를 필요로 합니다. toronto에서 근무하는 모든 사원의 last_name, 직무, 부서번호, 부서 이름을 표시하시오. (힌트 : 3-way join 사용)
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

-- 4. 사원의 last_name, 사원 번호를 해당 관리자의 last_name, 관리자 번호와 함께 표시하는 보고서를 작성하시오. 열 레이블을 각각 Employee, Emp#, Manager, Mgr#으로 지정하시오.
SELECT e.last_name AS "Employee", e.employee_id AS "Emp#", m.first_name AS "Manger", m.employee_id AS "Mgr#"
FROM employees e, employees m 
WHERE e.manager_id = m.employee_id
ORDER BY e.employee_id;

-- 5. King과 같이 해당 관리자가 지정되지 않은 모든 사원을 표시하도록 4번 문장을 수정합니다. 사원 번호순으로 결과를 정렬하시오.
SELECT e.last_name AS "Employee", e.employee_id AS "Emp#", m.first_name AS "Manger", m.employee_id AS "Mgr#"
FROM employees e LEFT JOIN employees m ON(e.manager_id = m.employee_id)
ORDER BY e.employee_id;

-- 6. 사원의 last_name, 부서 번호, 같은 부서에 근무하는 모든 사원의 이름을 표시하는 보고서를 작성하시오. 각 열에 적절한 레이블을 자유롭게 지정해 봅니다.
SELECT e1.last_name AS "사원 이름", e1.department_id AS "부서 번호", e2.last_name "동료 이름"
FROM employees e1 LEFT JOIN employees e2 ON(e1.department_id = e2.department_id)
WHERE(e1.last_name != e2.last_name)
ORDER BY e1.department_id, e1.last_name;

-- 7. 직무, 급여에 대한 보고서를 필요로 합니다. 먼저 JOBS테이블의 구조를 표시한 다음, 모든 사원의 이름, 직무, 부서 이름, 급여를 표시하는 query를 작성하시오.
SELECT * FROM jobs;

SELECT j.job_title, e.first_name AS 사원명, e.job_id AS 직무, d.department_name AS 부서명, e.salary AS 급여
FROM jobs j LEFT JOIN employees e ON(j.job_id = e.job_id)
    LEFT JOIN departments d ON(e.department_id = d.department_id)
ORDER BY j.job_id, e.first_name;

-- 1. Zlotkey와 동일한 부서에 속한 모든 사원의 이름과 입사일을 표시하는 질의를 작성하시오. Zlotkey는 결과에서 제외하시오.
SELECT last_name, hire_date
FROM employees
WHERE department_id = 
    (SELECT department_id
     FROM employees
     WHERE INITCAP(last_name) = 'Zlotkey')
AND INITCAP(last_name) != 'Zlotkey';

-- 2. 급여가 평균 급여보다 많은 모든 사원의 사원 번호와 이름을 표시하는 질의를 작성하고 결과를 급여에 대해 오름차순으로 정렬하시오.
SELECT employee_id, first_name, salary
FROM employees
WHERE salary > ALL
    (SELECT AVG(salary)
     FROM employees)
ORDER BY salary;

-- 3. 이름에 u가 포함된 사원과 같은 부서에서 일하는 모든 사원의 사원 번호와 이름을 표시하는 질의를 작성하고 질의를 실행하시오.
SELECT employee_id, last_name
FROM employees
WHERE department_id = ANY
    (SELECT department_id
     FROM employees
     WHERE UPPER(last_name) LIKE '%U%');

-- 4. 부서 위치 ID가 1700인 모든 사원의 이름, 부서 번호 및 업무 ID를 표시하시오.
SELECT last_name, department_id, job_id
FROM employees
WHERE department_id = ANY
    (SELECT department_id
     FROM departments
     WHERE location_id = 1700);
     
-- 5. King에게 보고하는(manager가 King) 모든 사원의 이름과 급여를 표시하시오.
SELECT last_name, salary
FROM employees
WHERE manager_id = ANY
    (SELECT employee_id
     FROM employees
     WHERE last_name = 'King');
     
-- 6. Executive 부서의 모든 사원에 대한 부서 번호, 이름, 업무 ID를 표시하시오.
SELECT department_id, last_name, job_id
FROM employees
WHERE department_id = ANY
    (SELECT department_id
     FROM departments
     WHERE department_name = 'Executive');
     
-- 7. 평균 급여보다 많은 급여를 받고, 이름에 u가 포함된 사원과 같은 부서에 근무하는 모든 사원의 사원번호, 이름, 급여를 표시하시오.
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