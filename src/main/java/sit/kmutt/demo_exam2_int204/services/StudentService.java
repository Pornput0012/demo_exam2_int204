package sit.kmutt.demo_exam2_int204.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sit.kmutt.demo_exam2_int204.dtos.StudentDTO;
import sit.kmutt.demo_exam2_int204.entities.School;
import sit.kmutt.demo_exam2_int204.entities.Student;
import sit.kmutt.demo_exam2_int204.repositories.SchoolRepository;
import sit.kmutt.demo_exam2_int204.repositories.StudentRepository;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private SchoolRepository schoolRepository;
    @Autowired
    private SchoolService schoolService;

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student createStudent(StudentDTO student) {
        if (schoolService.findSchoolByName(student.getSchool().getSchoolName()) == null) {
            schoolService.createSchool(student.getSchool());
        }
        Student newStudent = modelMapper.map(student, Student.class);
        newStudent.setSchool(modelMapper.map(student.getSchool(), School.class));
        return studentRepository.save(newStudent);
    }
}
