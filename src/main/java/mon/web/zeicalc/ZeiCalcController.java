package mon.web.zeicalc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/zeicalc")
public class ZeiCalcController {
    private final int ZEI=10;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model) {
        ZeiCalcForm zeiCalcForm = new ZeiCalcForm();
        model.addAttribute(zeiCalcForm);
        return "zeicalc/index";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String kekka(@Validated ZeiCalcForm zeiCalcForm,
                        BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "zeicalc/index";
        }
        model.addAttribute("result",
                zeiCalcForm.getPrice()*(100+ZEI)/100);
        return "zeicalc/index";
    }
}
