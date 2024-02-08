package ru.vlsu.ispi.kpp.SpringMVC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.vlsu.ispi.kpp.SpringMVC.pojo.RandomParams;

import java.util.Random;

@Controller
@RequestMapping(value = {"/", "/random", "/rnd"})
public class RandomController {

    @Autowired
    private ApplicationContext appContext;

    @GetMapping({"", "/", "/one/**", })
    @PostMapping("/")
    @PutMapping("/")
    @DeleteMapping("/")
    @PatchMapping("/")
    public String oneRandom(Model model) {
        RandomService randomService = (RandomService) appContext.getBean("requestService");
        model.addAttribute("random", randomService.get());
        return "random";
    }

    @RequestMapping(value = "/two", method = { RequestMethod.GET, RequestMethod.POST })
    public String twoRandom(Model model) {
        RandomService randomService = (RandomService) appContext.getBean("requestService");
        model.addAttribute("random", randomService.get());
        return "random";
    }

    @GetMapping("/range/{min}/{max}")
    @ResponseBody
    public int threeRandom(@PathVariable int min, @PathVariable int max) {
        Random rand = new Random();
        int rnd = min <= max ? rand.nextInt(min, max + 1): 0 ;
        return rnd;
    }

    @GetMapping("/form")
    public String formRandom(Model model) {
        model.addAttribute("params", new RandomParams(0,100));
        return "randomForm";
    }
}
