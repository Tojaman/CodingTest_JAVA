-- n개 출력 제한: LIMIT 수;
select f.ID, f.LENGTH
from FISH_INFO f
where f.LENGTH is not null
order by f.LENGTH desc, f.ID asc
LIMIT 10;