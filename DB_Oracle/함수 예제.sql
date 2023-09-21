-- 1) 사원 테이블에서 사원번호와 이름과 월급 조회.
SELECT employee_id, first_name, salary
FROM employees;

-- 2) 사원 테이블의 모든 컬럼 조회.
SELECT *
FROM employees;

-- 3) 사원 테이블의 사원번호와 이름, 월급 조회. 컬럼명을 한글로 '사원 번호', '사원 이름'으로 조회.
SELECT employee_id AS "사원 번호", first_name AS "사원 이름"
FROM employees;

-- 4) 사원 테이블의 이름과 월급을 이용하여 다음과 같이 조회.
SELECT first_name || ' 의 월급은 ' || salary || ' 달러입니다.'
FROM employees;

-- 5) 사원 테이블에서 중복된 데이터를 제외한 직무 조회.
SELECT DISTINCT job_id 
FROM employees;

-- 6) 모든 사원의 이름과 월급 조회. 월급이 낮은 사원부터 출력.
SELECT  first_name, salary
FROM employees
ORDER BY salary;

-- 7) 모든 사원 중 월급이 3000인 사원들의 이름, 월급, 직무를 조회.
SELECT  first_name, salary, job_id
FROM employees
WHERE salary = 3000;

-- 8) 이름이 'Steven'인 사원의 이름, 월급, 직무, 입사일, 부서번호 조회.
SELECT  first_name, salary, job_id, hire_date, department_id
FROM employees
WHERE first_name = 'Steven';

-- 9) 연봉이 3600이상인 사원들의 이름과 연봉을 조회. -- - 연봉은 월급에 수당을 더하고 12를 곱해서 구한다. -- - 수당은 월급에 커미션을 곱해서 구한다.
SELECT  first_name, ((salary + salary * NVL(commission_pct, 0)) * 12) AS 연봉
FROM employees
WHERE (salary + salary * NVL(commission_pct, 0)) * 12 >= 50000;

-- 10) 월급이 12000이하인 사원들의 이름과, 월급, 직무, 부서번호를 조회.
SELECT  first_name, salary, job_id, department_id
FROM employees
WHERE salary <= 12000;

-- 11) 직무가 'SA_MAN'이 아닌 사원들의 이름과 부서번호, 직무를 조회.
SELECT  first_name, department_id, job_id
FROM employees
WHERE job_id != 'SA_MAN';

-- 12) 월급이 1000에서 3000사이인 사원들의 이름과 월급을 조회.
SELECT  first_name, salary
FROM employees
WHERE salary >= 1000
AND salary <= 3000;

-- 13) 월급이 1000에서 3000사이가 아닌 사원들의 이름과 월급을 조회.
SELECT  first_name, salary
FROM employees
WHERE salary < 1000
OR salary > 3000;

-- 14) 2006년도에 입사한 사원들의 이름과 입사일 조회.
SELECT  first_name, hire_date
FROM employees
WHERE hire_date LIKE '06%';

-- 15) 이름의 첫 글자가 S, s로 시작하는 사원들의 이름과 월급을 조회.
SELECT  first_name, salary
FROM employees
WHERE first_name LIKE 's%'
OR first_name LIKE 'S%';

-- 16) 이름의 끝 글자가 t, T로 끝나는 사원들의 이름과 월급을 조회.
SELECT  first_name, salary
FROM employees
WHERE first_name LIKE '%t'
OR first_name LIKE '%T';

-- 17) 이름의 두 번째 철자가 m, M 인 사원의 이름과 월급을 조회.
SELECT  first_name, salary
FROM employees
WHERE first_name LIKE '_m'
OR first_name LIKE '_M';

-- 18) 이름에 A, a를 포함하고 있는 사원들의 이름을 조회.
SELECT  first_name
FROM employees
WHERE UPPER(first_name) LIKE '%A%';

-- 19) 커미션이 NULL인 사원들의 이름과 커미션을 조회.
SELECT  first_name, commission_pct
FROM employees
WHERE commission_pct IS NULL;

-- 20) 직무가 'SA_MAN', 'PU_CLERK', 'IT_PROG' 인 사원들의 이름, 월급, 직무 조회.
SELECT  first_name, salary, job_id
FROM employees
WHERE job_id IN ('SA_MAN', 'PU_CLERK', 'IT_PROG');

-- 21) 직무가 'SA_MAN', 'PU_CLERK', 'IT_PROG' 가 아닌 사원들의 이름, 월급, 직무 조회.
SELECT  first_name, salary, job_id
FROM employees
WHERE job_id NOT IN ('SA_MAN', 'PU_CLERK', 'IT_PROG');

-- 22) 직업이 'SA_MAN'이고 월급이 1200이상인 사원들의 이름, 월급, 직무를 조회.
SELECT  first_name, salary, job_id
FROM employees
WHERE job_id = 'SA_MAN'
AND salary >= 1200;

-- 23) 사원 테이블의 이름을 조회. 단 첫 번째 컬럼은 이름을 대문자로 출력하고, 두번째 컬럼은 이름을 소문자로 출력하고, 세 번째 컬럼은 이름의 첫 번째 철자는 대문자로, 나머지는 소문자로 조회.
SELECT  UPPER(first_name), LOWER(first_name), INITCAP(first_name)
FROM employees;

-- 24) 이름이 alexander(모두 소문자로 변환)인 사원의 이름과 월급 조회.
SELECT  first_name, salary
FROM employees
WHERE LOWER(first_name) = 'alexander';

-- 25) 영어 단어 SMITH에서 SMI만 잘라서 조회.
SELECT SUBSTR('SMITH',1,3)
FROM dual;

-- 26) 사원들의 이름(last_name)과 이름의 철자 개수를 출력.
SELECT  last_name, LENGTH(last_name)
FROM employees;

-- 27) 이름에 소문자 a가 존재하는 경우 몇 번째 자리에 위치하는지 조회.
SELECT CONCAT(first_name, CONCAT(' ', last_name)), INSTR(CONCAT(first_name, last_name), 'a')
FROM employees;

-- 28) 사원들의 이름과 월급을 조회. 단 월급 컬럼의 자릿수를 10자리로 하고, 월급을 출력하고 남은 나머지 자리에 *(별표)를 채워서 조회.
SELECT first_name, LPAD(salary, 10, '*')
FROM employees;

-- 29) 사원들의 이름과 월급 조회. 단 월급은 1000을 네모(■) 하나로 출력.
SELECT first_name, LPAD(' ', LENGTH(salary/1000) + 1, '■')
FROM employees;

-- 30) 숫자 876.567을 소수점 두 번째 자리까지 출력(반올림 처리)
SELECT ROUND(876.567, 2)
FROM dual;

-- 31) 숫자 876.567을 소수 첫째 자리까지 출력(버림 처리)
SELECT TRUNC(876.567, 1)
FROM dual;

-- 32) 숫자 10을 3으로 나눈 나머지 값을 출력.
SELECT MOD(10, 3)
FROM dual;

-- 33) 사원 번호와 사원 번호가 홀수이면 1, 짝수이면 0을 출력.
SELECT employee_id, 
    CASE WHEN MOD(employee_id, 2) = 0 THEN 0
         ELSE 1
    END AS 홀짝
FROM employees;

-- 34) 사원번호가 짝수인 사원들의 사원 번호와 이름을 조회.
SELECT employee_id, first_name
FROM employees
WHERE MOD(employee_id, 2) = 0
ORDER BY employee_id;

-- 35) 사원의 이름과 입사한 날짜부터 오늘까지 총 몇 달을 근무했는지 조회(정수).
SELECT first_name, ROUND(MONTHS_BETWEEN(sysdate, hire_date))
FROM employees;

-- 36) 2018년 10월 1일에서 2019년 6월 1일 사이의 총일수 출력.
SELECT TO_DATE('19/06/01') - TO_DATE('18/10/01')
FROM dual;

-- 37) 2018년 10월 1일에서 2019년 6월 1일 사이의 총 주(Week) 수를 출력(정수).
SELECT ROUND((TO_DATE('19/06/01') - TO_DATE('18/10/01')) / 7) AS 주
FROM dual;

-- 38) 2023년 5월 1일로부터 100달 뒤의 날짜 출력.
SELECT ADD_MONTHS(TO_DATE('23/05/01'), 100)
FROM dual;

-- 39) 2023년 5월 1일로부터 100일 후 날짜 출력.
SELECT TO_DATE('23/05/01') + 100
FROM dual;

-- 40) 2023년 6월 30일 이후 바로 돌아올 화요일의 날짜 출력
SELECT NEXT_DAY(TO_DATE('23/06/30'), '화')
FROM dual;

-- 41) 2023년 9월 19일 이후 바로 돌아올 토요일의 날짜 출력
SELECT NEXT_DAY(TO_DATE('23/09/19'), '토')
FROM dual;

-- 42) 오늘 이후 돌아올 금요일의 날짜 출력
SELECT NEXT_DAY(sysdate, '금')
FROM dual;

-- 43) 2020년 5월 22일부터 100달 뒤에 돌아오는 화요일의 날짜 출력
SELECT NEXT_DAY(ADD_MONTHS(TO_DATE('20/05/22'), 100), '화')
FROM dual;

-- 44) 오늘부터 100달 뒤에 돌아오는 월요일의 날짜 출력
SELECT NEXT_DAY(ADD_MONTHS(sysdate, 100), '월')
FROM dual;

-- 45) 2019년 5월 22일 해당 달의 마지막 날짜가 어떻게 되는지 조회
SELECT LAST_DAY(TO_DATE('19/05/22'))
FROM dual;

-- 46) 오늘부터 이번 달 말일까지 총 며칠 남았는지 조회
SELECT LAST_DAY(sysdate) - sysdate
FROM dual;

-- 47) 이름이 SUSAN인 사원의 이름, 입사일, 입사한 달의 마지막 날짜를 조회
SELECT first_name, hire_date, LAST_DAY(hire_date)
FROM employees;

ALTER SESSION SET NLS_DATE_FORMAT ='RRRR-MM-DD HH24:MI';

SELECT sysdate FROM dual;

-- 48) 이름(last_name)이 GRANT(대문자로 변환)인 사원의 이름과 입사한 요일을 출력하고, GRANT의 월급에 천단위를 구분할 수 있는 콤마(,)를 붙여 조회
SELECT first_name, TO_CHAR(hire_date, 'DAY') AS "입사한 요일", TO_CHAR(salary, 'L999,999')
FROM employees
WHERE UPPER(last_name) = 'GRANT';

-- 50) 2008년도에 입사한 사원의 이름과 입사일 조회(to_char 함수 사용)
SELECT first_name, hire_date
FROM employees
WHERE TO_CHAR(hire_date) LIKE '2008%';

-- 51) 월급이 1500 이상인 사원의 이름과, 월급에 천단위를 구분할 수 있는 콤마(,)와 화폐단위를 붙여 조회
SELECT first_name, TO_CHAR(salary, 'L999,999') AS 월급
FROM employees;

-- 52) 2005년 06월 14일에 입사한 사원의 이름과 입사일 조회(to_date 함수 사용)
SELECT first_name, hire_date
FROM employees
WHERE hire_date = TO_DATE('05/06/14');

-- 53) 사원의 이름과 커미션을 조회. (단 커미션이 NULL인 사원들은 0)
SELECT first_name, NVL(commission_pct, 0) AS 커미션
FROM employees;

-- 54) 직업이 'SA_MAN' 또는 'IT_PROG' 인 사원의 월급, 추가수당, 월급여 조회 - 추가수당 : 월급 * 커미션(단 커미션이 NULL인 경우 0) - 월급여 : 월급 + 추가수당
SELECT salary, salary * NVL(commission_pct, 0) AS 추가수당,  salary + (salary * NVL(commission_pct, 0)) AS 월급여
FROM employees
WHERE job_id in ('SA_MAN', 'IT_PROG');

-- 55) 사원의 이름과 부서 번호, 보너스 조회  보너스 : 부서 번호가 10번이면 300, 20번이면 400, 나머지 부서 번호는 0
SELECT first_name, department_id, 
    CASE department_id WHEN 10 THEN 300
                       WHEN 20 THEN 400
                       ELSE 0
                    
    END AS 보너스
FROM employees
ORDER BY department_id;

-- 56) 사원 번호와 사원 번호가 짝수인지 홀수인지를 조회
SELECT employee_id,
    CASE WHEN MOD(employee_id, 2) = 0 THEN '짝수'
         ELSE '홀수'
    END AS 홀짝
FROM employees;

-- 57) 사원의 이름, 직업, 보너스 조회  단 직무가 'SA_MAN'이면 보너스 5000 나머지 직무는 보너스 2000
SELECT first_name, job_id,
    CASE job_id WHEN 'SA_MAN' THEN 5000
                ELSE 2000
    END AS 보너스
FROM employees
ORDER BY 보너스 DESC;

-- 58) 사원의 이름, 직업, 월급, 보너스 조회  - 보너스 : 월급이 3000이상이면 500, 월급이 2000이상 3000미만이면 300, 월급이 1000이상 2000미만이면 200, 나머지는 0
SELECT first_name, job_id, salary,
    CASE WHEN salary >= 3000 THEN 500
         WHEN salary >= 2000 THEN 300
         WHEN salary >= 1000 THEN 200
         ELSE 0
    END AS 보너스
FROM employees
ORDER BY 보너스;

-- 59) 사원의 이름, 직업, 커미션, 보너스 조회. 보너스 : 커미션이 NULL이면 500, NULL이 아니면 0
SELECT first_name, job_id, NVL(commission_pct, 0) AS 커미션, NVL2(commission_pct, 0, 500) AS 보너스
FROM employees
ORDER BY 보너스 DESC;

-- 60) 사원의 이름, 직업, 보너스 조회  - 보너스는 직무가 'SA_MAN', 'PU_CLERK' 이면 500, 'ST_CLERK', 'FI_ACCOUNT'이면 400 나머지 0
SELECT first_name, job_id, 
    CASE WHEN job_id IN('SA_MAN', 'PU_CLERK') THEN 500
         WHEN job_id IN('ST_CLERK', 'FI_ACCOUNT') THEN 400
         ELSE 0
    END AS 보너스
FROM employees
ORDER BY 보너스 DESC;