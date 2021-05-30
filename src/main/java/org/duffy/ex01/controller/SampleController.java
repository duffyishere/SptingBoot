package org.duffy.ex01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SampleController {

    @GetMapping("/hello")
    public Map<String, String[]> test(){

        Map<String, String[]> map = new HashMap<>();

        return map;
    }
}
