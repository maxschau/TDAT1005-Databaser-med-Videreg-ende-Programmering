-- Oppgave 1.1
select convert(game.mdate,getdate(), 105), game.team1,game.team2 from game;