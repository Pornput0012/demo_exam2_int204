package sit.kmutt.demo_exam2_int204.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sit.kmutt.demo_exam2_int204.entities.Blog;
import sit.kmutt.demo_exam2_int204.services.BlogService;

import java.util.List;

@RestController
@RequestMapping("/api/blogs")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping("")
    public List<Blog> getAllBlogs() {
        return blogService.getAllBlogs();
    }
}
