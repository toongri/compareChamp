package incheonpeople.compareChamp.controller;

import incheonpeople.compareChamp.dto.NumNamVicPic;
import incheonpeople.compareChamp.service.GameService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/games")
    public String list(Model model) {
        List<NumNamVicPic> games = gameService.findAll();
        model.addAttribute("games", games);
        return "games/gamelist";
    }
}
