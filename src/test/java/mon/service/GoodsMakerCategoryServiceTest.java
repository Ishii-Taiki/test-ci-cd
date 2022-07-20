package mon.service;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import mon.entity.Category;
import mon.entity.Goods;
import mon.entity.GoodsJoinMakerCate;

@SpringBootTest
//@Import(DataSourceConfiguration.class)
@Transactional
@Rollback
class GoodsMakerCategoryServiceTest {

    @Autowired
    GoodsMakerCategoryService goodsService;

    @Test
    public void testGetGoodsMakerCategoryList() {
        List<GoodsJoinMakerCate> list = goodsService
                .getGoodsMakerCategoryList();
        GoodsJoinMakerCate goods = list.get(2);
        assertThat(goods.getGoodsName(),is("キリン天然水"));
        assertThat( goods.getMakerName(),is("キリンドウ"));
        assertThat(goods.getCategoryName(),is("飲料水"));
    }

    @Test
    public void testGetGoodsMakerCategory() {
        GoodsJoinMakerCate goods = goodsService.getGoodsMakerCategory(3);
        assertThat(goods.getGoodsName(),is("キリン天然水"));
        assertThat( goods.getMakerName(),is("キリンドウ"));
        assertThat(goods.getCategoryName(),is("飲料水"));
    }



    @Test
    public void testGetCategory() {
        Category category = goodsService.getCategory(5);
        assertThat(category.getCategoryName(),is("生活用品"));
    }

    @Test
    public void testInsert() {
        List<Goods> list1=goodsService.getGoodsList();
        Goods obj = new Goods();
        obj.setGoodsName("赤ちゃんおむつピっピーちゃん");
        obj.setGoodsTanka(1000);
        obj.setCategoryId(1);
        obj.setMakerId(1);
        goodsService.insert(obj);
        List<Goods> list2=goodsService.getGoodsList();
        assertThat(list1.size()+1,is(list2.size()));
    }

    @Test
    public void testUpdate() {
        GoodsJoinMakerCate goods = goodsService.getGoodsMakerCategory(3);
        goods.setGoodsTanka(100);
        goodsService.update(goods);
        //更新確認
        GoodsJoinMakerCate goodsAfter = goodsService.getGoodsMakerCategory(3);
        assertThat(goodsAfter.getGoodsTanka(),is(100));
    }

    @Test
    public void testDelete() {
        List<Goods> list1=goodsService.getGoodsList();
        Goods goods = goodsService.getGoods(1);
        goodsService.delete(goods);
        List<Goods> list2=goodsService.getGoodsList();
        assertThat(list1.size()-1,is(list2.size()));
    }
}
