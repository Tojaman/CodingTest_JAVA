-- DATE_FORMAT(date, 'format')
-- %Y(4자리 년), %y(2자리 년), %m(2자리 월), %d(2자리 일) 등...
SELECT DR_NAME, DR_ID, MCDP_CD, DATE_FORMAT(HIRE_YMD, '%Y-%m-%d') as HIRE_YMD
from DOCTOR
where MCDP_CD = 'CS' or MCDP_CD = 'GS'
order by HIRE_YMD desc;