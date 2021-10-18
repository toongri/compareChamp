package incheonpeople.compareChamp.controller;

import incheonpeople.compareChamp.dto.*;
import incheonpeople.compareChamp.service.GameService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    /*
    @GetMapping("/lanes")
    public String lanelist(Model model) {
        List<NumNamVicPic> games = gameService.findByLane();
        model.addAttribute("games", games);
        return "games/lanelist";
    }
    */
    @GetMapping("/lanes")
    @ResponseBody
    public List<NumNamVicPicDto> lanelist() {
        List<NumNamVicPicDto> games = gameService.findByLane("Top");
        return games;
    }

    @GetMapping("/opgg/top")
    public String opggtop(Model model) {
        List<NumNamVicPicDto> games = gameService.findByLane("Top");
        model.addAttribute("games", games);
        //model.addAttribute("champNumDto", new ChampNumDto());
        return "LOL/LOLTop";
    }
    @GetMapping("/opgg/mid")
    public String opggmid(Model model) {
        List<NumNamVicPicDto> games = gameService.findByLane("Middle");
        model.addAttribute("games", games);
        return "LOL/LOLMid";
    }
    @GetMapping("/opgg/jungle")
    public String opggjug(Model model) {
        List<NumNamVicPicDto> games = gameService.findByLane("Jungle");
        model.addAttribute("games", games);
        return "LOL/LOLJungle";
    }
    @GetMapping("/opgg/bot")
    public String opggbot(Model model) {
        List<NumNamVicPicDto> games = gameService.findByLane("Bot");
        model.addAttribute("games", games);
        return "LOL/LOLBot";

    }@GetMapping("/opgg/sup")
    public String opggsup(Model model) {
        List<NumNamVicPicDto> games = gameService.findByLane("Supporter");
        model.addAttribute("games", games);
        return "LOL/LOLSup";
    }
    @RequestMapping(value = "/opgg/tochamp",method = RequestMethod.POST)
    public String tochamp(Model model, @ModelAttribute ChampNumDto champNumDto) {
        int firstChampNumber = champNumDto.getFirstChampNumber();
        String lane = champNumDto.getLane();
        double vicRate = champNumDto.getVicRate();
        List<NumNamVicPicAmtDto> games = gameService.findByChamp(firstChampNumber, lane);

        int secondChampNumber = champNumDto.getSecondChampNumber();
        if (secondChampNumber == -1)
            secondChampNumber = games.get(0).getChampNumber();
        if (vicRate == -1)
            vicRate = games.get(0).getVictoryRate();
        System.out.println(secondChampNumber + "DFSDFASFSDFas");
        model.addAttribute("games", games);
        List<ForCompareChampDto> forCompareChampDtos = gameService.compareByChamp(firstChampNumber, secondChampNumber, lane, vicRate);
        model.addAttribute("firstChampion", forCompareChampDtos.get(0));

        model.addAttribute("secondChampion", forCompareChampDtos.get(1));
        model.addAttribute("tableExplain", new TableExplainDto());
        model.addAttribute("lane", lane);
        return "/LOL/LOLMATCH";
    }

//    @RequestMapping(value = "/opgg/tochamp",method = RequestMethod.POST)
//    public String tochamp(Model model, @ModelAttribute ChampNumDto champNumDto) {
//        int champNum = champNumDto.getChampNumber();
//        String lane = champNumDto.getLane();
//        System.out.println(champNum + " " + lane);
//        List<NumNamVicPicAmtDto> games = gameService.findByChamp(champNum, lane);
//        model.addAttribute("games", games);
//        return "/games/champlist";
//    }

    @GetMapping("/champlist")
    public String champlist(Model model) {
        return "games/champlist";
    }
    /*
    @GetMapping("/champslist")
    public String champlist(Model model) {
        List<NumNamVicPicAmtDto> games = gameService.findByChamp(99, "Supporter");
        model.addAttribute("games", games);
        return "games/champlist";
    }
     */
    @GetMapping("/comparechamp")
    @ResponseBody
    public List<ForCompareChampDto> compareList() {
        List<ForCompareChampDto> games = gameService.compareByChamp(24, 39, "Top", 55.0);
        return games;
    }
}
