package sit.kmutt.demo_exam2_int204.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sit.kmutt.demo_exam2_int204.dtos.BlogDTO;
import sit.kmutt.demo_exam2_int204.entities.Blog;
import sit.kmutt.demo_exam2_int204.exceptions.ItemNotFoundException;
import sit.kmutt.demo_exam2_int204.repositories.BlogRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DemoDtoAndModelMapService {

    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<BlogDTO> findAllBlogDto() {
        return blogRepository.findAll().stream().map(blog -> modelMapper.map(blog, BlogDTO.class)).collect(Collectors.toList());
    }

    public BlogDTO findBlogDtoById(int id) {
        return modelMapper.map(blogRepository.findById(id).orElseThrow(()->new ItemNotFoundException("Blog id " + id + " Not Found!")), BlogDTO.class);
    }

    public BlogDTO addBlogDto(BlogDTO blogDto) {
        Blog blog = modelMapper.map(blogDto, Blog.class);
        blog.setCreatedAt(LocalDateTime.now());

        blogRepository.save(blog);

        return modelMapper.map(blog, BlogDTO.class);
    }
}
