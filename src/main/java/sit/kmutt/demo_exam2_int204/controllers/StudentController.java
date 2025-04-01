package sit.kmutt.demo_exam2_int204.controllers;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sit.kmutt.demo_exam2_int204.dtos.StudentDTO;
import sit.kmutt.demo_exam2_int204.entities.Student;
import sit.kmutt.demo_exam2_int204.services.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("")
    public List<Student> getAllStudents() {
        return studentService.findAll();
    }

    @GetMapping("/schools")
    public List<StudentDTO> getStudentsSchool() {
        return studentService.findAll().stream().map(std -> modelMapper.map(std, StudentDTO.class)).toList();
    }

    @PostMapping("")
    public Student addStudent(@Valid @RequestBody StudentDTO studentDTO) {
        return studentService.createStudent(studentDTO);
    }
}
