package sit.kmutt.demo_exam2_int204.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.kmutt.demo_exam2_int204.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}