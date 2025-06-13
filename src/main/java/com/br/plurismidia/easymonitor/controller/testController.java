package com.br.plurismidia.easymonitor.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
@EnableAutoConfiguration
public class testController {


    // 	GET TESTE INTEGRIDADE DA API
    @CrossOrigin
    @GetMapping("getstatusapp")
    // http://localhost:8080/api/test/getstatusapp
    public String getStatusApp() {
        System.gc();
        return "{\"status\":\"up\"}";
    }

    // 	POST TESTE INTEGRIDADE DA API
    @CrossOrigin
    @PostMapping(value = "poststatusapp")
    // http://localhost:8080/api/test/poststatusapp
    public String postStatusApp() {
        System.gc();
        return "{\"status\":\"up\"}";
    }


}
