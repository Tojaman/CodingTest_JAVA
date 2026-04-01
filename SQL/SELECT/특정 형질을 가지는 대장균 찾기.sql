-- 비트 연산자(&)
select count(*) as COUNT
from ECOLI_DATA e
where e.GENOTYPE & 2 = 0
AND (e.GENOTYPE & 1 = 1 OR e.GENOTYPE & 4 = 4)