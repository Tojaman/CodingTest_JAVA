# SQL 문법

문제 풀이하면서 주석으로 적어둔 SQL 문법만 모아 정리한 문서.

| 문법 | 용도 | 대표 형태 |
|---|---|---|
| `DATE_FORMAT()` | 날짜 형식을 원하는 문자열로 변환 | `DATE_FORMAT(col, '%Y-%m-%d')` |
| `ORDER BY` | 조회 결과 정렬 | `ORDER BY col1 DESC, col2 ASC` |
| `LIKE` | 문자열 패턴 검색 | `WHERE col LIKE '문자열%'` |
| SQL 실행 순서 | SQL이 처리되는 흐름 이해 | `FROM -> JOIN -> WHERE -> ...` |
| `ROUND()` | 숫자 반올림 | `ROUND(value, n)` |
| `COALESCE()` | `NULL`을 기본값으로 대체 | `COALESCE(col, 'NONE')` |
| `IN` | 여러 값 중 하나와 일치하는지 확인 | `WHERE col IN ('A', 'B')` |
| `LIMIT` | 결과 개수 제한 | `LIMIT 10` |
| `&` | 비트 단위 AND 연산 | `WHERE flags & 2 = 2` |

## DATE_FORMAT

- `DATE_FORMAT()`  
  날짜 값을 원하는 문자열 형식으로 변환할 때 사용
- `%Y`  
  4자리 연도
- `%y`  
  2자리 연도
- `%m`  
  2자리 월
- `%d`  
  2자리 일

```sql
SELECT DATE_FORMAT(appointment_date, '%Y-%m-%d') AS appointment_date
FROM appointment;
```

```sql
SELECT DATE_FORMAT(b.published_date, '%Y-%m-%d') AS published_date
FROM book b;
```

## ORDER BY

- `ORDER BY`  
  조회 결과를 정렬할 때 사용
- `ORDER BY col DESC`  
  해당 컬럼 기준 내림차순 정렬
- `ORDER BY col ASC`  
  해당 컬럼 기준 오름차순 정렬
- `ORDER BY col1 DESC, col2 ASC`  
  첫 번째 기준으로 먼저 정렬하고, 값이 같을 때 두 번째 기준 적용

```sql
SELECT flavor
FROM first_half
ORDER BY total_order DESC, shipment_id ASC;
```

## LIKE

- `LIKE`  
  문자열이 특정 패턴과 일치하는지 확인할 때 사용
- `%`  
  글자 수 상관없이 여러 글자를 의미
- `_`  
  정확히 한 글자를 의미
- `'문자열%'`  
  특정 문자열로 시작
- `'%문자열'`  
  특정 문자열로 끝
- `'%문자열%'`  
  특정 문자열 포함
- `'010-1234-____'`  
  `010-1234-` 뒤에 정확히 4글자 존재

```sql
SELECT factory_id, factory_name, address
FROM food_factory
WHERE address LIKE '강원도%';
```

```sql
SELECT *
FROM used_goods_board
WHERE title LIKE '%자전거%';
```

## SQL 실행 순서

- SQL은 작성 순서와 실제 처리 순서가 다름
- 보통 아래 순서로 이해하면 됨

```text
FROM
-> JOIN
-> WHERE
-> GROUP BY
-> HAVING
-> SELECT
-> ORDER BY
-> LIMIT
```

```sql
SELECT b.title, r.reply_text
FROM used_goods_board b
JOIN used_goods_reply r
  ON b.board_id = r.board_id
WHERE b.created_date >= '2022-10-01';
```

## ROUND

- `ROUND(value, n)`  
  숫자를 반올림할 때 사용
- `n > 0`  
  소수점 이하 자리까지 반올림
- `n = 0`  
  일의 자리까지 반올림
- `n < 0`  
  십의 자리, 백의 자리처럼 정수 자리 기준 반올림

```sql
SELECT ROUND(AVG(daily_fee), 0) AS avg_fee
FROM car_rental_company_car
WHERE car_type = 'SUV';
```

```sql
SELECT ROUND(123.456, 2);
SELECT ROUND(123.456, 0);
SELECT ROUND(123.456, -1);
```

## COALESCE

- `COALESCE(value, default)`  
  값이 `NULL`일 때 기본값으로 대체
- 여러 값을 넣으면 왼쪽부터 검사해서 `NULL`이 아닌 첫 번째 값 반환

```sql
SELECT pt_name, pt_no, gend_cd, age, COALESCE(tlno, 'NONE') AS tlno
FROM patient
WHERE age <= 12
  AND gend_cd = 'W';
```

```sql
SELECT COALESCE(NULL, NULL, 'A', 'B');
```

## IN

- `IN`  
  값이 여러 후보 중 하나와 일치하는지 확인할 때 사용
- 여러 개의 `OR` 조건을 짧게 줄일 수 있음
- 왼쪽에 값을 두고 오른쪽에 여러 컬럼을 두는 형태도 가능
- 예시: `'Python' IN (skill_1, skill_2, skill_3)`

```sql
SELECT id, email, first_name, last_name
FROM developer_infos
WHERE skill_1 IN ('Python', 'Java')
   OR skill_2 IN ('Python', 'Java')
   OR skill_3 IN ('Python', 'Java');
```

```sql
SELECT *
FROM employee
WHERE department IN ('HR', 'DEV', 'DATA');
```

```sql
SELECT id, email, first_name, last_name
FROM developer_infos
WHERE 'Python' IN (skill_1, skill_2, skill_3);
```

## LIMIT

- `LIMIT n`  
  조회 결과를 앞에서부터 `n`개만 가져올 때 사용
- 보통 `ORDER BY`와 함께 사용

```sql
SELECT id, length
FROM fish_info
ORDER BY length DESC
LIMIT 10;
```

## 비트 연산자 &

- `a & b`  
  두 값을 비트 단위로 AND 연산
- 정수형 값을 2진수 비트로 나눈 뒤, 같은 자릿수끼리 비교
- 특정 비트가 켜져 있는지 검사할 때 자주 사용
- 대응되는 비트가 모두 `1`일 때만 결과가 `1`
- 플래그 값 검사에서 자주 사용

```text
비트 연산은 정수 값을 2진수로 펼쳐 놓고 각 자리를 비교하는 방식이다.

예를 들어
7  -> 0111
5  -> 0101

7 & 5 -> 0101 -> 5
7 & 4 -> 0100 -> 4
7 & 3 -> 0011 -> 3
7 & 8 -> 0000 -> 0
```

```sql
SELECT id, genotype
FROM ecoli_data
WHERE genotype & 2 = 2;
```

```text
genotype = 6  -> 0110
2        = 2  -> 0010

0110 & 0010 = 0010
```

```text
`genotype & 2 = 2` 의미
- `genotype`의 비트 중에서 `2`에 해당하는 자리(0010)가 켜져 있는지 확인
- 결과가 `2`와 같으면 해당 비트가 포함된 것
- 결과가 `0`이면 해당 비트가 없는 것
```
