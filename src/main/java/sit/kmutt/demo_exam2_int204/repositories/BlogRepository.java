package sit.kmutt.demo_exam2_int204.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.kmutt.demo_exam2_int204.entities.Blog;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
}
