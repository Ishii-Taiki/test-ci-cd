package mon.entity;

import java.io.Serializable;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;

@Entity
public class GoodsJoinMakerCate extends Goods implements Serializable{

    @Column(name = "maker_name")
    private String makerName;

    @Column(name = "category_name")
    private String categoryName;

    public String getMakerName() {
        return makerName;
    }

    public void setMakerName(String makerName) {
        this.makerName = makerName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

}
