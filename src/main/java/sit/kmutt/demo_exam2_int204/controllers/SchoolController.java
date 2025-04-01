package sit.kmutt.demo_exam2_int204.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sit.kmutt.demo_exam2_int204.entities.School;
import sit.kmutt.demo_exam2_int204.services.SchoolService;

import java.util.List;

@RestController
@RequestMapping("/api/schools")
public class SchoolController {
    @Autowired
    private SchoolService schoolService;

    @GetMapping("")
    public ResponseEntity<List<School>> getAllSchools() {
        return ResponseEntity.ok(schoolService.findAll());
    }
}
