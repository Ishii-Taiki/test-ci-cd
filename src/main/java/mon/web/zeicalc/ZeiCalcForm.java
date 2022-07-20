package mon.web.zeicalc;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ZeiCalcForm {
    @Min(1)
    @NotNull
    private int price;

    public int getPrice(){
        return price;
    }

    public void setPrice(int price){
        this.price = price;
    }

}
