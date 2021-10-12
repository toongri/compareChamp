package incheonpeople.compareChamp.controller;

import incheonpeople.compareChamp.domain.Champ;
import incheonpeople.compareChamp.service.ChampService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ChampController {
    private final ChampService champService;

    @Autowired
    public ChampController(ChampService champService) {
        this.champService = champService;
    }

    @GetMapping("/champs")
    public String list(Model model) {
        List<Champ> champs = champService.findChamps();
        model.addAttribute("champs", champs);
        return "champs/champlist";
    }
}
