-- 특정 문자열이 포함되었는지 확인: LIKE
-- where 열 LIKE "특정문자열"
-- "%문자열": 문자열로 끝
-- "문자열%": 문자열로 시작
-- "010-1234-____": 길이 제한('010-1234-' 다음 4자리 숫자가 있는 데이터 조회)
-- ""
SELECT FACTORY_ID, FACTORY_NAME, ADDRESS
from FOOD_FACTORY
where ADDRESS LIKE '강원도%';