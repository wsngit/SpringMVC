package ru.vlsu.ispi.kpp.SpringMVC;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Date;
import java.util.Random;

@RestController
@RequestMapping("/response")
public class ResponseController {
    @GetMapping("/status")
    public String status(HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_BAD_GATEWAY);
        return "";
    }

    @GetMapping("/redirect")
    public RedirectView redirect() {
        return new RedirectView("/random/form");
    }

    @GetMapping("/redirect2")
    public ModelAndView redirec2() {
        return new ModelAndView("redirect:/random/form");
    }

    @GetMapping("/headers")
    public int header(HttpServletResponse response) {
        Random rand = new Random();
        response.setHeader("value1", "" + rand.nextInt(100));
        response.setIntHeader("value2", rand.nextInt(100));
        response.setDateHeader("value3", new Date().getTime());
        return rand.nextInt();
    }
}
