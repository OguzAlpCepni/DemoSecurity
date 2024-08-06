package com.demosec.demosec.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

    @GetMapping
    @PreAuthorize("hasAuthority('admin:read')")
    public ResponseEntity get(){
        return ResponseEntity.ok("Get:: admin controller");
    }
    @PostMapping
    @PreAuthorize("hasAuthority('admin:create')")
    public ResponseEntity post(){
        return ResponseEntity.ok("post:: admin controller");
    }
    @PutMapping
    @PreAuthorize("hasAuthority('admin:update')")
    public ResponseEntity put(){
        return ResponseEntity.ok("Get:: admin controller");
    }
    @DeleteMapping
    @PreAuthorize("hasAuthority('admin:delete')")
    public ResponseEntity delete(){
        return ResponseEntity.ok("Get:: admin controller");
    }


}
