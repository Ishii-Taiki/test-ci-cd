package mon.web.calc;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class CalcForm {
    @NotNull(message="notnull")
    @Range(min=1,max=100,message="入力１では{1}以上{100}以下の値を入力して下さい")
    private Integer arg1;
    @NotNull(message = "notnull")
    @Range(min=1,max=100,message="入力２では{1}以上{100}以下の値を入力して下さい")
    private Integer arg2;


    private Integer selectBox;
    public Integer getArg1() {return arg1;}
    public void setArg1(Integer arg1) {this.arg1 = arg1;}
    public Integer getArg2() {return arg2;}
    public void setArg2(Integer arg2) {this.arg2 = arg2;}
    public Integer getSelectBox() {return selectBox;}
    public void setSelectBox(Integer selectBox) {this.selectBox = selectBox;}
}
