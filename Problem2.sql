/*
1. Create a cte that is a union of the first_player and second_player from the matches table and the player_id from the players table. 
2. Then create another cte that ranks the players by the sum of their scores for each group_id. In case of tie it will take lowest player_id.
3. Finally, select the group_id and the player_id for the player with the rank 1 for each group_id.
*/

with cte as
(select first_player 'p1',second_player 'p2',first_score 's1',second_score 's2', group_id
from matches m1 join players p 
on m1.first_player=p.player_id
union all
select second_player 'p1',first_player 'p2', second_score 's1', first_score 's2', group_id
from matches m2 join players p 
on m2.first_player=p.player_id
),
cte2 as 
(select p1,group_id, dense_rank() over (partition by group_id order by sum(s1) desc,p1) 'rnk' from cte
group by p1)
select group_id, p1 'player_id'
from cte2 
where rnk = 1