package mon.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

import mon.ConfigAutowireable;
import mon.entity.Goods;
import mon.entity.GoodsJoinMakerCate;

@Dao
@ConfigAutowireable
public interface GoodsDao {

    @Select
    List<Goods> selectAll();

    @Select
    Goods selectById(int id);

    @Select
    List<GoodsJoinMakerCate> selectAllGoodsMakerCategory();

    @Select
    GoodsJoinMakerCate selectGoodsMakerCategory(int id);

    @Insert
    int insert(Goods goods);

    @Update
    int update(Goods goods);

    @Delete
    int delete(Goods goods);

}