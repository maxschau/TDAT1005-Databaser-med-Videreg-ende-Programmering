-- Oppgave D:
-- Oppgave 1:
select bedrift.navn, bedrift.telefon, bedrift.epost from bedrift;

-- Oppgave 2:
select oppdrag.oppdragsnr, bedrift.navn, bedrift.telefon from oppdrag
join bedrift on bedrift.orgNr = oppdrag.orgNr;

-- Oppgave 3:
select kandidater.fornavn, kandidater.etternavn, kvalifikasjon.beskrivelse from kandidater
join kvalifikasjon_kandidat on kandidater.kandidatNr = kvalifikasjon_kandidat.kandidatNr
join kvalifikasjon on kvalifikasjon.kvalifikasjonsNr = kvalifikasjon_kandidat.kvalifikasjonrNr;

-- Oppgave 4:
select kandidater.fornavn, kandidater.etternavn, kvalifikasjon.beskrivelse from kvalifikasjon
join kvalifikasjon_kandidat on kvalifikasjon.kvalifikasjonsNr = kvalifikasjon_kandidat.kvalifikasjonrNr
right join kandidater on kandidater.kandidatNr = kvalifikasjon_kandidat.kandidatNr;

-- Oppgave 5:
select kandidater.fornavn, kandidater.etternavn, oppdrag.virkeligSlutt, oppdrag.oppdragsNr, bedrift.navn
from kandidater join oppdrag on kandidater.kandidatNr = oppdrag.kandidatNr
join bedrift on bedrift.orgNr = oppdrag.orgNr
where kandidater.kandidatNr = 1;

