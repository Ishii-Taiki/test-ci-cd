package mon.web.calc;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/calc")
public class CalcController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model) {
        CalcForm calcForm = new CalcForm();
        model.addAttribute(calcForm);
        return "calc/index";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String kekka(@Validated CalcForm calcForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "calc/index";
        }

        int result = 0;
        int selectValue = calcForm.getSelectBox();
        int value1 = calcForm.getArg1();
        int value2 = calcForm.getArg2();

        if (selectValue == 1) {
            result = value1 + value2;
        }

        if (selectValue == 2) {
            result = value1 - value2;
        }

        if (selectValue == 3) {
            result = value1 * value2;
        }

        if (selectValue == 4) {
            result = value1 / value2;
        }

        model.addAttribute("result", result);
        return "calc/index";
        }

}
