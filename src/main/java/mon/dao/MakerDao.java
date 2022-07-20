package mon.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import mon.ConfigAutowireable;
import mon.entity.Maker;

@Dao
@ConfigAutowireable
public interface MakerDao {

    @Select
    List<Maker> selectAll();

    @Select
    Maker selectById(int id);
}