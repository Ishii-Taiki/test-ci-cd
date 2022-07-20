package mon.entity;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;

@Entity
public class Maker {

    @Id
    @Column(name = "maker_id")
    private int makerId;

    @Column(name = "maker_name")
    private String makerName;

    public int getMakerId() {
        return makerId;
    }

    public void setMakerId(int makerId) {
        this.makerId = makerId;
    }

    public String getMakerName() {
        return makerName;
    }

    public void setMakerName(String makerName) {
        this.makerName = makerName;
    }
}
