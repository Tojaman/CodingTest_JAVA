SELECT count(*)
from USER_INFO u
where u.JOINED like '2021%' AND
# where YEAR(u.JOINED) = 2021 AND
u.AGE BETWEEN 20 AND 29