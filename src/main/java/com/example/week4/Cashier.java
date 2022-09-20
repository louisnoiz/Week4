package com.example.week4;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Cashier {
    @RequestMapping(value = "/getChange/{cash}", method = RequestMethod.GET)
    public Change getChange(@PathVariable int cash) {
        Change allcash = new Change();
        allcash.setB1000(cash/1000);
        cash %= 1000;
        allcash.setB500(cash/500);
        cash %= 500;
        allcash.setB100(cash/100);
        cash %= 100;
        allcash.setB20(cash/20);
        cash %= 20;
        allcash.setB10(cash/10);
        cash %= 10;
        allcash.setB5(cash/5);
        cash %= 5;
        allcash.setB1(cash);
        return allcash;
    }
}
