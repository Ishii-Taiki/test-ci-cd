package mon.dao;

import java.util.List;

import mon.entity.Category;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import mon.ConfigAutowireable;

@Dao
@ConfigAutowireable
public interface CategoryDao {

    @Select
    List<Category> selectAll();

    @Select
    Category selectById(int id);

}
