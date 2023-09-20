SELECT department_id, job_id, SUM(salary), ROUND(AVG(salary), 2) AS 평균, MIN(salary), MAX(salary), COUNT(*)
FROM employees
WHERE department_id >= 90
GROUP BY department_id, job_id
HAVING MAX(salary) > 10000
ORDER BY department_id;

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
        NVL(SUM(salary), 0) AS "급여 총액"
FROM employees
GROUP BY job_id, department_id
HAVING department_id IN (20,50,80,90)
ORDER BY department_id;