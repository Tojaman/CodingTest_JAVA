-- round(값, 자릿수n)
    -- 자릿수 n이 양수: 값의 자릿수까지 반올림하여 표시
    -- 자릿수 n이 음수: 반올림하여 10의 n승 자리까지 표시
    -- 자릿수 n이 0: 반올림하여 1의 자리까지 표시 
SELECT round(avg(DAILY_FEE), 0) as AVERAGE_FEE
from CAR_RENTAL_COMPANY_CAR
where CAR_TYPE = 'SUV';