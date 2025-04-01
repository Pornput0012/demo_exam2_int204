package sit.kmutt.demo_exam2_int204.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.kmutt.demo_exam2_int204.entities.School;

import java.util.Optional;

public interface SchoolRepository extends JpaRepository<School, Integer> {
    Optional<School> findFirstBySchoolNameLike(String schoolName);
}