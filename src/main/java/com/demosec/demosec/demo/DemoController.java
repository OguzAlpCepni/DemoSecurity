package com.demosec.demosec.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth/democont")
public class DemoController {

    @GetMapping
    public ResponseEntity<String> sayhello() {
        return ResponseEntity.ok("Hello from secure");
    }
}
