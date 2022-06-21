-- a) Tampilkan dependent_name dan relationship dengan employee yang namanya diawali huruf R ?
select * from tb_dependent td where dependent_name like 'r%';

-- b) Banyaknya employee yang mengerjakan project PNum = 1 ?
select count(*) from tb_works_on two where id_project = 1;

-- c) Banyaknya employee yang memiliki salary lebih dari 3500000 ? 
select * from tb_employee te where salary > 3500000;

-- d) Banyaknya project yang dikerjakan DNum =2 ? 
select count(*) from tb_project tp where id_dept = 2;

-- e) Hitung total dan rata-rata salary dari setiap departemen ? 
select te.id_dept, td.department_name, sum(salary) total_salary, avg(salary) average_salary from tb_employee te join tb_department td on td.id_dept = te.id_dept group by te.id_dept ;

-- f) Banyaknya employee dari setiap department dan urutkan berdasarkan employee terbanyak ? 
select td.department_name, te.id_dept, count(*) jumlah_karyawan from tb_employee te join tb_department td on td.id_dept = te.id_dept group by id_dept;

-- g) Total hours perweek dari semua employee untuk setiap project ? 
select two.id_project, sum(two.hours) hours_total from tb_works_on two join tb_employee te on te.id_ssn = two.id_ssn group by two.id_project;

-- h) Employee yang memiliki total hours perweek lebih besar dari 140 hours dan urutkan berdasarkan jumlah jam kerja terbanyak? 
select * from (select te.id_ssn, te.fname, te.lname, te.salary, sum(two.hours) hours_total from tb_works_on two join tb_employee te on te.id_ssn = two.id_ssn group by two.id_ssn) as a where hours_total > 140;

-- i) Kelompokkan bonus employee berdasarkan jumlah jam kerjanya ?
-- (Jika >= 200 hours, maka bonus = 50%; Jika >= 150 hours, maka bonus = 25%, Selainnya bonus = 10%) 
select *, case 
	when hours_total >= 200 then 'Bonus 50%'
	when hours_total >= 150 then 'Bonus 25%'
	else 'Bonus 10%'
end as bonus
from (
	select te.id_ssn, te.fname, te.lname, te.salary, sum(two.hours) hours_total
	from tb_works_on two 
	join tb_employee te on te.id_ssn = two.id_ssn 
	group by two.id_ssn) as a;

-- j) Banyaknya project yang dikerjakan tiap employee dan urutkan dari yang terbanyak ? 
select id_ssn, count(*) from tb_works_on two group by id_ssn order by 2 desc;

-- k) Employee yang bekerja pada 4 project ? 
select * from (select id_ssn, count(*) jumlah_project from tb_works_on two group by id_ssn order by 2 desc) as a where jumlah_project > 4;

-- l) Employee yang memiliki rata-rata hours perweek = 70 jam dan bekerja pada 2 project ?
-- berdasarkan data tidak ada yang bekerja 70 jam perminggu, 
-- namun berikut query untuk mencari yang bekerja 70 jam perminggu
select * 
	from (
		select te.id_ssn, 
		te.fname, te.lname, 
		te.salary, avg(two.hours) 
		avg_work_hours, count(*) 
		jumlah_project 
		from tb_works_on two 
		join tb_employee te on te.id_ssn = two.id_ssn 
		group by two.id_ssn) as tbl1 
	where avg_work_hours = 75 and jumlah_project = 2;

-- m) Banyaknya Dependent berdasarkan relationship dengan employee ? 
select td.id_ssn, te.fname, count(id_dependent) jumlah_dependent, td.relationship from tb_dependent td join tb_employee te on te.id_ssn = td.id_ssn group by relationship;

-- n) Berapa lama Manager tiap Department sudah menjabat ? 
select *, datediff('2022-6-21', manager_start_date) hari_menjabat from tb_department td;

-- o) Lokasi project yang menjadi tempat lebih dari satu department?
select * from (select project_location, count(*) jml_project from tb_project tp group by project_location) as tbl1 where jml_project > 1;