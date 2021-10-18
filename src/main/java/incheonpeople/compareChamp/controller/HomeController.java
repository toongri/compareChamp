package incheonpeople.compareChamp.controller;


import incheonpeople.compareChamp.dto.MessageDTO;
import incheonpeople.compareChamp.dto.NumNamVicPicAmtDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class HomeController {
    @RequestMapping(value = "/dataSend",method = RequestMethod.POST)
    public String home(Model model, MessageDTO dto) {
        model.addAttribute("msg",dto.getResult()+"/ this is the value sent by the server ");
        return "index :: #resultDiv";
    }
}
