package sit.kmutt.demo_exam2_int204.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sit.kmutt.demo_exam2_int204.dtos.SchoolDTO;
import sit.kmutt.demo_exam2_int204.entities.School;
import sit.kmutt.demo_exam2_int204.repositories.SchoolRepository;

import java.util.List;

@Service
public class SchoolService {
    @Autowired
    private SchoolRepository schoolRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<School> findAll() {
        return schoolRepository.findAll();
    }

    public School createSchoolDTO(SchoolDTO schoolDTO) {
        return schoolRepository.save(modelMapper.map(schoolDTO, School.class));
    }

    public School createSchool(SchoolDTO school) {
        return schoolRepository.save(modelMapper.map(school, School.class));
    }

    public School findSchoolByName(String schoolName) {
        return schoolRepository.findFirstBySchoolNameLike(schoolName).orElse(null);
    }
}
