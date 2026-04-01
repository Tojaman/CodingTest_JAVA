-- 보통 WHERE 컬럼명 IN (값1, 값2, 값3)으로 사용
-- 하지만 WHERE 값 IN (컬럼명1, 컬럼명2, 컬럼명3)처럼 특정 값이 여러 컬럼에 포함되는지 확인하는 방법도 가능
select d.ID, d.EMAIL, d.FIRST_NAME, d.LAST_NAME
from DEVELOPER_INFOS d
# where SKILL_1 = 'Python' || SKILL_2 = 'Python' || SKILL_3 = 'Python'
where 'Python' IN (SKILL_1, SKILL_2, SKILL_3)
order by d.ID asc;