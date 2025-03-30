package sit.kmutt.demo_exam2_int204.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sit.kmutt.demo_exam2_int204.dtos.BlogDto;
import sit.kmutt.demo_exam2_int204.entities.Blog;
import sit.kmutt.demo_exam2_int204.exceptions.ItemNotFoundException;
import sit.kmutt.demo_exam2_int204.repositories.BlogRepository;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DemoDtoAndModelMapService {

    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<BlogDto> findAllBlogDto() {
        return blogRepository.findAll().stream().map(blog -> modelMapper.map(blog, BlogDto.class)).collect(Collectors.toList());
    }

    public BlogDto findBlogDtoById(int id) {
        return modelMapper.map(blogRepository.findById(id).orElseThrow(()->new ItemNotFoundException("Blog id " + id + " Not Found!")), BlogDto.class);
    }

    public BlogDto addBlogDto(BlogDto blogDto) {
        Blog blog = modelMapper.map(blogDto, Blog.class);
        blog.setCreatedAt(LocalDateTime.now());

        blogRepository.save(blog);

        return modelMapper.map(blog, BlogDto.class);
    }
}
