-- Oppgave 1A:
select * from ordredetalj natural join ordrehode
where ordredetalj.ordrenr = ordrehode.ordrenr and ordrehode.levnr = 44;

-- Oppgave 1B:
select levinfo.navn, levby from levinfo join prisinfo on levinfo.levnr = prisinfo.levnr
and prisinfo.delnr = 1;

-- Oppgave 1C:
select levinfo.levnr, levinfo.navn, prisinfo.pris from levinfo
join prisinfo on levinfo.levnr = prisinfo.levnr
and prisinfo.delnr = 201
order by prisinfo.pris limit 1;


-- Oppgave 1D:
select distinct ordrehode.ordrenr, ordrehode.dato, delinfo.delnr,
delinfo.beskrivelse, ordredetalj.kvantum, prisinfo.pris,
prisinfo.pris * ordredetalj.kvantum as 'Beregnet beløp' from ordrehode
join ordredetalj on ordrehode.ordrenr = ordredetalj.ordrenr
join delinfo on ordredetalj.delnr = delinfo.delnr
join prisinfo on delinfo.delnr = prisinfo.delnr
where ordredetalj.ordrenr = 16 group by beskrivelse;

-- Oppgave 1E:
select distinct prisinfo.delnr, prisinfo.levnr from prisinfo
where pris >
(select pris from prisinfo where katalognr ='X7770')

-- Oppgave 1F:
create table sammenheng(
levby varchar(30) primary key,
fylke varchar(30)
;


create table utensammenheng(
levnr int primary key not null,
navn varchar(30),
adresse varchar(30),
postnr int,
levby varchar(30),
foreign key (levby) references sammenheng(levby)
);

insert into sammenheng
select distinct levinfo.levby, levinfo.fylke from levinfo;

insert into utensammenheng
select distinct levinfo.levnr, levinfo.navn, levinfo.adresse, levinfo.postnr, levinfo.levby
from levinfo;

-- Oppgave 1F II:
create view view1 as
select utensammenheng.levnr, utensammenheng.navn, utensammenheng.adresse,
utensammenheng.postnr, utensammenheng.levby, sammenheng.fylke
from utensammenheng join sammenheng
on utensammenheng.levby = sammenheng.levby;


-- Oppgave 1G:
select levinfo.levby from levinfo
where levinfo.levby not in (select levinfo.levby from levinfo
join prisinfo on levinfo.levnr = prisinfo.levnr);

-- Oppgave 1H:
select prisinfo.levnr from prisinfo
join delinfo on delinfo.delnr = prisinfo.delnr
join ordredetalj on delinfo.delnr = ordredetalj.delnr
where ordredetalj.ordrenr = 18
order by prisinfo.pris limit 1;

-- Oppgave 2:
-- Oppgave 2A:
use bok;
select forlag.forlag_navn from forlag
where (left(forlag.telefon,1) = 2)
union
select forlag.forlag_navn from forlag
where (left(forlag.telefon,1) != 2 or forlag.telefon is null);

-- Oppgave 2B:
select avg(a.y) from (
select avg(forfatter.dod_aar - forfatter.fode_aar) as y from forfatter
where forfatter.fode_aar is not null and forfatter.dod_aar is not null
union
select avg(year(current_date) - forfatter.fode_aar) as y from forfatter
where forfatter.dod_aar is null and forfatter.fode_aar > 1900) a;

-- Oppgave 2C:
select (100*((select count(forfatter.forfatter_id) as antall from forfatter
where forfatter.fode_aar is not null and forfatter.dod_aar is not null
or forfatter.fode_aar > 1900 and forfatter.dod_aar is null) /
(select count(forfatter_id)))) as andel from forfatter;












