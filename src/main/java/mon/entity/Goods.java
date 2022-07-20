package mon.entity;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Version;
import org.springframework.stereotype.Controller;

@Entity
public class Goods {
    @Id
    @Column(name = "goods_id")
    private int goodsId;

    @Column(name = "goods_name")
    private String goodsName;

    @Column(name = "goods_tanka")
    private int goodsTanka;

    @Column(name = "category_id")
    private int categoryId;

    @Column(name = "maker_id")
    private int makerId;

    @Version
    @Column(name = "version")
    private int version;

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public int getGoodsTanka() {
        return goodsTanka;
    }

    public void setGoodsTanka(int goodsTanka) {
        this.goodsTanka = goodsTanka;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getMakerId() {
        return makerId;
    }

    public void setMakerId(int makerId) {
        this.makerId = makerId;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
