package com.demosec.demosec.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    @GetMapping
    public ResponseEntity get(){
        return ResponseEntity.ok("Get:: admin controller");
    }
    @PostMapping
    public ResponseEntity post(){
        return ResponseEntity.ok("post:: admin controller");
    }
    @PutMapping
    public ResponseEntity put(){
        return ResponseEntity.ok("Get:: admin controller");
    }
    @DeleteMapping
    public ResponseEntity delete(){
        return ResponseEntity.ok("Get:: admin controller");
    }


}
