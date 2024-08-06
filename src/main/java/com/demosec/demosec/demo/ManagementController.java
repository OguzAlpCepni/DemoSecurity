package com.demosec.demosec.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/management")
public class ManagementController {

    @GetMapping
    public ResponseEntity get(){
        return ResponseEntity.ok("Get:: management controller");
    }
    @PostMapping
    public ResponseEntity post(){
        return ResponseEntity.ok("post:: management controller");
    }
    @PutMapping
    public ResponseEntity put(){
        return ResponseEntity.ok("Get:: management controller");
    }
    @DeleteMapping
    public ResponseEntity delete(){
        return ResponseEntity.ok("Get:: management controller");
    }
}
