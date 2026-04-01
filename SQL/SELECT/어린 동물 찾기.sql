SELECT a.ANIMAL_ID, a.NAME
from ANIMAL_INS a
where a.INTAKE_CONDITION != 'Aged'
order by a.ANIMAL_ID asc;