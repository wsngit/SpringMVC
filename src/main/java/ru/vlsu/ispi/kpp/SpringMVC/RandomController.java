package ru.vlsu.ispi.kpp.SpringMVC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/random")
public class RandomController {

    @Autowired
    private ApplicationContext appContext;

    @GetMapping("/one")
    public String oneRandom(Model model) {
        RandomService randomService = (RandomService) appContext.getBean("singletonService");
        model.addAttribute("random", randomService.get());
        return "random";
    }

    @GetMapping("/request")
    public String requestRandom(Model model) {
        RandomService randomService = (RandomService) appContext.getBean("requestService");
        model.addAttribute("random", randomService.get());
        return "random";
    }

    @GetMapping("/session")
    public String sessionRandom(Model model) {
        RandomService randomService = (RandomService) appContext.getBean("sessionService");
        model.addAttribute("random", randomService.get());
        return "random";
    }
}
