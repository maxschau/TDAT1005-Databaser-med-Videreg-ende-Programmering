-- Oppgave 1.1:
select mdate, team1, team2 from game order by id;

-- Oppgave 1.2:
select team1, team2, count(matchid) from game
left join goal g on game.id = g.matchid
group by matchid;

-- Oppgave 1.3:
select mdate, teamname from game
join eteam on game.team1 = eteam.id or game.team2 = eteam.id
where coach = 'Fernando Santos';

-- Oppgave 1.4:
select eteam.teamname, count(goal.teamid) as mal from eteam
join goal on eteam.id = goal.teamid
where mal >= 4
group by teamid
order by mal desc;

-- Oppgave 1.5:
select teamname from eteam
where id not in
(select goal.teamid from goal);

-- Oppgave 1.6:
select goal.player, eteam.teamname from goal
join eteam on goal.teamid = eteam.id
join game on game.id = goal.matchid
where game.stadium = 'National Stadium Warsaw'
group by player;

-- Oppgave 1.7:
select goal.player, eteam.teamname, count(*) as mal from goal
join eteam on eteam.id = goal.teamid
group by player
having mal >= 3
order by mal desc;

-- Oppgave 1.8:

