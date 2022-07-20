package mon.web.input;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/input")
public class InputController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model) {
        return modelAndView(model, new InputForm());
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String confirm(@Validated InputForm form,
                          BindingResult bindingResult, Model model) {
        if (form.getHobby().length == 0) {
            return modelAndView(model, new InputForm());
        }
        return "input/confirm";
    }

    @RequestMapping(value = "/back", method = RequestMethod.POST)
    public String back(InputForm form, Model model) {
        return modelAndView(model, form);

    }

    private String modelAndView(Model model, InputForm form){
        List<String> hobbyList = initial();
        model.addAttribute("HOBBYLIST", hobbyList);
        model.addAttribute(form);

        return "input/index";
    }



    public List<String> initial(){
        ArrayList<String> ary = new ArrayList<String>();
        ary.add("読書");
        ary.add("ゴルフ");
        ary.add("将棋");
        ary.add("テニス");
        ary.add("登山");
        ary.add("エアロビクス");
        ary.add("ダイビング");
        return ary;
    }

}

