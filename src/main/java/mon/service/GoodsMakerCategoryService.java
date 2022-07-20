package mon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mon.dao.CategoryDao;
import mon.dao.GoodsDao;
import mon.dao.MakerDao;
import mon.entity.Category;
import mon.entity.Goods;
import mon.entity.GoodsJoinMakerCate;
import mon.entity.Maker;

@Service
public class GoodsMakerCategoryService {

    @Autowired
    GoodsDao goodsDao;

    @Autowired
    MakerDao makerDao;

    @Autowired
    CategoryDao categoryDao;

    // ３つのテーブル結合情報取得（全件）
    public List<GoodsJoinMakerCate> getGoodsMakerCategoryList() {
        return goodsDao.selectAllGoodsMakerCategory();
    }

    // ３つのテーブル結合情報取得（1件）
    public GoodsJoinMakerCate getGoodsMakerCategory(int id) {
        return goodsDao.selectGoodsMakerCategory(id);
    }

    public List<Goods> getGoodsList() {
        return goodsDao.selectAll();
    }

    public Goods getGoods(int id) {
        return goodsDao.selectById(id);
    }

    public List<Maker> getMakerList() {
        return makerDao.selectAll();
    }

    public Maker getMaker(int id) {
        return makerDao.selectById(id);
    }

    public List<Category> getCategoryList() {
        return categoryDao.selectAll();
    }


    public Category getCategory(int id) {
        return categoryDao.selectById(id);
    }

    public int insert(Goods goods) {
        return goodsDao.insert(goods);
    }

    public int update(Goods goods) {
        return goodsDao.update(goods);
    }

    public int delete(Goods goods) {
        return goodsDao.delete(goods);
    }
}