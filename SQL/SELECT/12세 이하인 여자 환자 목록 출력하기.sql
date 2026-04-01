-- COALESCE(값, 기본값): 값이 NULL일 때 기본값 출력 함수
-- order by 조건문 여러개일 경우 그냥 ,(콤마)로 나열
SELECT p.PT_NAME, p.PT_NO, p.GEND_CD, p.AGE, COALESCE(p.TLNO, 'NONE') as TLNO
from PATIENT p
where p.AGE <= 12 AND p.GEND_CD = 'W'
order by p.AGE desc, p.PT_NAME asc;