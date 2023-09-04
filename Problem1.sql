/*
1. First create a cte that ranks the orders by order_date for each seller_id and then select the item_id and seller_id for the second order.
2. Then create another cte that joins the first cte with the Items table to get the item_brand for the second order.
3. Finally, join the second cte with the Users table to get the favorite_brand for each seller_id and compare it with the item_brand for the second order.
*/

with cte as
(
  select item_id,seller_id from
  (
  select  item_id, seller_id, rank() over (partition by seller_id order by order_date) 'rnk'
  from 
  Orders
  ) a
  where rnk = 2
),

cte2 as 
(
select i.item_brand, cte.seller_id from 
cte join Items i
on cte.item_id = i.item_id
)

select u.user_id 'seller_id', if(cte2.item_brand= u.favorite_brand, 'yes','no') '2nd_item_fav_brand'
from 
Users u 
left join 
cte2
on u.user_id = cte2.seller_id
