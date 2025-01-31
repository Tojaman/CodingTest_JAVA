-- 다중 정렬
-- order by의 첫번째 조건이 같다면 다음 조건을 적용
-- ex. TOTAL_ORDER이 다르다면 TOTAL_ORDER 값의 desc로 정렬
--     TOTAL_ORDER이 같다면 SHIPMENT_ID 값의 asc로 정렬
SELECT FLAVOR
from FIRST_HALF
order by TOTAL_ORDER desc, SHIPMENT_ID asc;