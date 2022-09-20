package com.example.week4;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class MathAPI {
    @RequestMapping(value = "/myPlus/{num1}/{num2}", method = RequestMethod.GET)
    public String myPlus(@PathVariable double num1, @PathVariable double num2){
        return String.valueOf(num1 + num2);
    }
    @RequestMapping(value = "/myMinus/{num1}/{num2}", method = RequestMethod.GET)
    public String myMinus(@PathVariable double num1, @PathVariable double num2){
        return String.valueOf(num1 - num2);
    }
    @RequestMapping(value = "/myMulti/{num1}/{num2}", method = RequestMethod.GET)
    public String myMulti(@PathVariable double num1, @PathVariable double num2){ return String.valueOf(num1 * num2); }
    @RequestMapping(value = "/myDivide/{num1}/{num2}", method = RequestMethod.GET)
    public String myDivide(@PathVariable double num1, @PathVariable double num2){
        return String.valueOf(num1 / num2);
    }
    @RequestMapping(value = "/myMod/{num1}/{num2}", method = RequestMethod.GET)
    public String myMod(@PathVariable double num1, @PathVariable double num2) {return String.valueOf(num1 % num2);}
    @RequestMapping(value = "/myMax", method = RequestMethod.POST)
    public String myMax(@RequestBody MultiValueMap<String, String> n) {
        Map<String, String> d =n.toSingleValueMap();
        if ((Double.parseDouble(d.get("num1"))) > (Double.parseDouble(d.get("num2")))){
            return d.get("num1");
        }else {
            return d.get("num2");
        }


    }
}
