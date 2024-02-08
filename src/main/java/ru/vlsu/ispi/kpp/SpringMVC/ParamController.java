package ru.vlsu.ispi.kpp.SpringMVC;
import org.springframework.web.bind.annotation.*;
import ru.vlsu.ispi.kpp.SpringMVC.pojo.RandomParams;

import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/param")
public class ParamController {

    @GetMapping("/path/{min}/{max}")
    public int pathParam(@PathVariable int min, @PathVariable int max) {
        Random rand = new Random();
        int rnd = min <= max ? rand.nextInt(min, max + 1): 0 ;
        return rnd;
    }

    @GetMapping("/reqParams")
    public int reqParams(@RequestParam(name = "min") int min, @RequestParam int max) {
        Random rand = new Random();
        int rnd = min <= max ? rand.nextInt(min, max + 1): 0 ;
        return rnd;
    }

    @GetMapping("/reqParams2")
    public int reqParams2(@RequestParam(required = false, defaultValue = "0") int min, @RequestParam int max) {
        Random rand = new Random();
        int rnd = min <= max ? rand.nextInt(min, max + 1): 0 ;
        return rnd;
    }

    @GetMapping("/all")
    public Map all(@RequestParam Map<String,String> allParams) {
        return allParams;
    }

    @PostMapping("/form")
    public int form(@ModelAttribute RandomParams params) {
        Random rand = new Random();
        int rnd = params.getMin() <= params.getMax() ?
                rand.nextInt(params.getMin(),  params.getMax() + 1):
                0 ;
        return rnd;
    }

    @PostMapping(value = "/json", consumes = "application/json")
    public int json(@RequestBody RandomParams params) {
        Random rand = new Random();
        int rnd = params.getMin() <= params.getMax() ?
                rand.nextInt(params.getMin(),  params.getMax() + 1):
                0 ;
        return rnd;
    }

}
