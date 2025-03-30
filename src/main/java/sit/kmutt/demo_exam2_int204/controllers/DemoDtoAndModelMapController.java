package sit.kmutt.demo_exam2_int204.controllers;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sit.kmutt.demo_exam2_int204.dtos.BlogDto;
import sit.kmutt.demo_exam2_int204.services.DemoDtoAndModelMapService;

import java.util.List;

@RestController
@RequestMapping("/dto")
public class DemoDtoAndModelMapController {
    @Autowired
    private DemoDtoAndModelMapService demoDtoAndModelMapService;

    @GetMapping("")
    public ResponseEntity<List<BlogDto>> getAllBlogDto() {
        return ResponseEntity.ok(demoDtoAndModelMapService.findAllBlogDto());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogDto> getBlogDtoById(@PathVariable int id) {
        return ResponseEntity.ok(demoDtoAndModelMapService.findBlogDtoById(id));
    }

    @PostMapping("")
    public ResponseEntity<BlogDto> createBlogDto(@RequestBody BlogDto blogDto) {
        return ResponseEntity.ok(demoDtoAndModelMapService.addBlogDto(blogDto));
    }
}
