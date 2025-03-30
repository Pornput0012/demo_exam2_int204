package sit.kmutt.demo_exam2_int204.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sit.kmutt.demo_exam2_int204.entities.Blog;
import sit.kmutt.demo_exam2_int204.repositories.BlogRepository;

import java.util.List;

@Service
public class BlogService {
    @Autowired
    private BlogRepository blogRepository;

    public List<Blog> getAllBlogs() {
        return  blogRepository.findAll();
    }
}
