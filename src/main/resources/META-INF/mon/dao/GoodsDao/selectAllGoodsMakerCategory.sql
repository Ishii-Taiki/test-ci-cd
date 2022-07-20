select g.*, c.category_name, m.maker_name
from goods as g
left outer join maker as m on g.maker_id = m.maker_id
left outer join category as c on g.category_id = c.category_id
order by g.goods_id