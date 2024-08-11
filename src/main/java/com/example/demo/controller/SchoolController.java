
package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.School;
import com.example.demo.model.User;
import com.example.demo.services.SchoolService;
import com.example.demo.services.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/schools")
@RequiredArgsConstructor
public class SchoolController {
    private final UserService userService;
    private final SchoolService schoolService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getSchoolById(@PathVariable("id") Long id) {

        return ResponseEntity.ok().body(schoolService.getById(id));
    }

    @PostMapping
    public ResponseEntity<?> postSchool(@RequestBody School school) {
        Long userId = school.getUser().getId();
        User user = userService.getUserById(userId);
        school.setUser(user);
        schoolService.save(school);
        return ResponseEntity.ok().body(school);
    }
}