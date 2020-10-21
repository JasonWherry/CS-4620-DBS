select	first_name, last_name, cname
from	Ambassador, Committee
where 	cname=comm_name AND dept_name='School of Electrical Engineering and Computer Science';

select	MAX(pnum)
from	Projects;

select	P.pnum
from	Ambassador A, Projects P
where	A.comm_name=P.comm_name AND A.first_name='Lydia';
-
select	Q.pno
from	Works_on Q, Committee C
where	Q.committee_name=C.cname AND Q.committee_name='Historian';
