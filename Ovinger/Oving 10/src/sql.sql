-- Oppgave 1:
select * from borettslag where borettslag.etabl_aar >= 1975
and borettslag.etabl_aar <= 1985;

-- Oppgave 2:
select andelseier.fornavn, andelseier.etternavn, 'ansiennitet:',
andelseier.ansiennitet, 'år' from andelseier order by andelseier.ansiennitet
 desc;;

-- Oppgave 3:
select min(etabl_aar) from borettslag;

-- Oppgave 4:
select distinct bygning.bygn_adr, leilighet.ant_rom from bygning
 join leilighet on bygning.bygn_id = leilighet.bygn_id and
 leilighet.ant_rom >= 3;

-- Oppgave 5:
select count(bygn_id) from bygning where bygning.bolag_navn = 'Tertitten';

-- Oppgave 6:
select bygning.bolag_navn, count(bygning.bygn_id) from bygning
group by bygning.bolag_navn order by bygning.bolag_navn;

-- Oppgave 7:
select count(leilighet.leil_nr) from leilighet join bygning
where leilighet.bygn_id = bygning.bygn_id
and bygning.bolag_navn = 'Tertitten';

-- Oppgave 8:
select max(bygning.ant_etasjer) from bygning;

-- Oppgave 9:
-- Må ses på
select andelseier.fornavn, andelseier.etternavn, andelseier.telefon
 from andelseier join leilighet on leilighet.and_eier_nr is null;

-- Oppgave 10:
select bygning.bolag_navn, count(leilighet.and_eier_nr) as antall
 from bygning join leilighet on bygning.bygn_id = leilighet.bygn_id
 group by bolag_navn order by antall;

-- Oppgave 11:
select andelseier.*, leilighet.leil_nr from andelseier
left join leilighet on andelseier.and_eier_nr = leilighet.and_eier_nr;

-- Oppgave 12:
select distinct bygning.bolag_navn from bygning
where exists (select leilighet.leil_nr from leilighet
where leilighet.bygn_id = bygning.bygn_id and leilighet.ant_rom = 4);

-- Oppgave 13:
select distinct poststed.poststed, poststed.postnr,count(and_eier_nr)
from poststed join borettslag b on poststed.postnr = b.postnr
join bygning on b.bolag_navn = bygning.bolag_navn
join leilighet on bygning.bygn_id = leilighet.bygn_id
where and_eier_nr is not null;
