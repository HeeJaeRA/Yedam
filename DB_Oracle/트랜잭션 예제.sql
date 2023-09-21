-- 1) 모든 사원들에 대해 사원번호와 이름, 업무, 입사일을 출력하세요.
SELECT employee_id, first_name, job_id, hire_date
FROM employees;

-- 2) 매니저 직책을 맡고 있는 사원의 사원번호를 중복되지 않게 출력하세요.
SELECT DISTINCT manager_id
FROM employees
WHERE manager_id IS NOT NULL;

-- 3) 사원 중에서 급여가 7000이상 12000이하이며 이름이 'H'로 시작하는 사원의 사원번호, 이름, 급여, 부서번호를 출력하세요. 
SELECT employee_id, first_name, salary, department_id
FROM employees
WHERE salary BETWEEN 7000 AND 12000
AND first_name LIKE 'H%';

-- 4) 2005년 1월 1일 이후(2005년 1월 1일 포함)에 입사한 사원의 사번, 이름, 입사일, 첫 문자부터 3문자만 출력된 이메일계정(별칭 : EMAIL) 및 이메일 계정의 글자 수(별칭 : EMAIL LENGTH)를 출력하세요.
SELECT employee_id, first_name, hire_date, SUBSTR(email, 1, 3) AS EMAIL, LENGTH(email) AS "EMAIL LENGTH"
FROM employees
WHERE hire_date >= '2005/01/01';

-- 5) 모든 사원의 이름, 입사일, 입사 6개월 후의 날짜, 입사 후 첫 금요일, 총 근무 개월, 첫 급여일을 차례로 표시하세요. 
-- 총 근무 개월은 한 달 미만 절삭하여 정수로 표시하세요. 첫 급여일은 입사한 다음 달 1일입니다. 결과는 입사일을 기준으로 오름차순 정렬하세요. 
SELECT first_name, hire_date, ADD_MONTHS(hire_date, 6) AS "입사 6개월 후", NEXT_DAY(hire_date, '금') AS "입사 후 첫 금요일", TRUNC(MONTHS_BETWEEN(sysdate, hire_date)) AS "총 근무 개월", LAST_DAY(hire_date) + 1 AS "첫 급여일"
FROM employees
ORDER BY hire_date;

-- 6) 커미션을 받는 사원들을 대상으로 사원번호, 이름, 입사일, 수당을 표시하고자 한다. 수당은 급여와 커미션을 곱하여 구할 수 있다. 
-- 입사일은 ‘24/03/2008 월요일’의 형식으로 출력하고, 수당은 $기호와 천단위 구분기호 및 소수점 둘째자리까지 표시할 수 있도록 한다. 결과는 수당에 대하여 내림차순 정렬하세요.
SELECT employee_id, first_name, TO_CHAR(hire_date, 'dd/mm/yyyy day') AS 입사일, TO_CHAR(ROUND(NVL(salary * commission_pct, 0), 2), '$999,999') AS 수당
FROM employees
WHERE commission_pct != 0
ORDER BY 수당 DESC;

-- 7) 부서번호가 50번과 60번 직원 가운데 급여가 5000보다 많은 직원의 사원번호, 이름, 업무ID, 급여, 부서번호를 출력하세요. 
SELECT employee_id, first_name, job_id, salary, department_id
FROM employees
WHERE department_id IN (50, 60)
AND salary > 5000;

-- 8) 함수를 이용하여 사원테이블에서 전화번호의 지역번호가 515(515로 시작)인 사원의 사번, 업무ID, 전화번호, 부서번호를 출력하세요. 
SELECT employee_id, job_id, phone_number, department_id
FROM employees
WHERE SUBSTR(phone_number, 1, 3) = 515;

-- 9) 사원테이블에서 사원번호, 사원이름, 연봉, 입사한 연도(입사일이용), 수당을 받는지 여부를 나타내는 비고, 부서번호를 출력하세요. 
--- 수당은 급여와 커미션을 곱해서 계산하고, 연봉은 급여와 수당을 더한 값에 12를 곱해서 구한다. - 연봉 값은 널이 되지 않도록 주의한다.
--- 비고열은 연봉에 수당이 포함되었으면 COMM, 포함되지 않았으면 NOCOMM을 표시하시오. - 결과는 부서번호 및 연봉에 대하여 오름차순 정렬하시오. 
SELECT employee_id, first_name, (salary + salary * NVL(commission_pct, 0)) * 12 AS 연봉, hire_date, NVL2(commission_pct, 'COMM', 'NOCOMM') AS 비고, department_id
FROM employees
ORDER BY department_id, 연봉; 

-- 10) 사원테이블에서 사원번호, 사원이름, 부서번호 및 근무지역을 표시하세요. 근무지역은 20번 부서의 사원이면 'Canada', 80부서의 직원이면 'UK'를 표시하고 나머지 직원들은 'USA'로 표시하세요. (CASE 문 사용)
SELECT employee_id, first_name, department_id, department_id, 
    CASE WHEN department_id = 20 THEN 'Canada'
         WHEN department_id = 80 THEN 'UK'
         ELSE 'USA'
    END AS 근무지역
FROM employees;

-- 11. DEPARTMENTS 테이블과 LOCATIONS 테이블에 대하여 JOIN을 수행하여 부서번호, 부서이름, 도시명을 출력하시오. (JOIN 방식은 자유)
SELECT d.department_id, d.department_name, l.city
FROM departments d LEFT JOIN locations l ON (d.location_id = l.location_id)
ORDER BY department_id;

-- 12. EMPLOYEES, DEPARTMENTS 테이블로부터 사번, 이름(FIRST_NAME), 소속부서번호, 소속부서 이름을 표시하되 부서가 정해지지 않은 사원도 함께 표시하시오. 
SELECT e.employee_id, e.first_name, e.department_id, d.department_name
FROM employees e LEFT JOIN departments d ON (e.department_id = d.department_id)
ORDER BY employee_id;

-- 13. EMPLOYEES 테이블에서 부서번호와 부서별 근무인원수, 평균급여를 버림하여 정수로 표시하시오. 
SELECT department_id, COUNT(NVL(department_id, 1)) AS 근무인원, TRUNC(AVG(salary))
FROM employees
GROUP BY department_id
ORDER BY department_id;

-- 14. 서브쿼리를 사용하여 IT 부서에서 근무하는 사원들의 사원번호, 이름(FIRST_NAME), 업무(JOB_ID)를 표시하시오. 
SELECT employee_id, first_name, job_id
FROM employees 
WHERE department_id = 
    (SELECT department_id
     FROM departments
     WHERE UPPER(department_name) = 'IT');
     
-- 15.HR 사용자로 접속하여 다음의 요구사항대로 PROF 테이블을 생성하시오.
CREATE TABLE prof(
    profno      NUMBER(4)       primary key,
    name        VARCHAR2(15)    NOT NULL,
    id          VARCHAR2(15)    NOT NULL,
    hiredate    DATE,
    pay         NUMBER(4)
);

DESC prof;

SELECT * FROM prof;
-- 16. 다음과 같이 PROF 테이블에 DML 명령문을 작성하시오.
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