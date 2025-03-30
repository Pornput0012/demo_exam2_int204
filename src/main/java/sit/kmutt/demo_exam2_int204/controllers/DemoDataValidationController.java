package sit.kmutt.demo_exam2_int204.controllers;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import sit.kmutt.demo_exam2_int204.dtos.BlogDto;
import sit.kmutt.demo_exam2_int204.services.DemoDataValidationService;
import sit.kmutt.demo_exam2_int204.services.DemoDtoAndModelMapService;

import java.util.List;

@RestController
@RequestMapping("/valid")
public class DemoDataValidationController {
    @Autowired
    private DemoDtoAndModelMapService demoDtoAndModelMapService;
    @Autowired
    private Validator validator;

    @GetMapping("/{id}")
    public ResponseEntity<BlogDto> getBlogDtoById(@PathVariable @Min(0) int id) {
        return ResponseEntity.ok(demoDtoAndModelMapService.findBlogDtoById(id));
    }

    @PostMapping("")
    public ResponseEntity<BlogDto> createBlogDto(@Valid @RequestBody BlogDto blogDto) {
        return ResponseEntity.ok(demoDtoAndModelMapService.addBlogDto(blogDto));
    }

    @PostMapping("validator")
    public ResponseEntity<BlogDto> createBlogDtoValidator(@RequestBody BlogDto blogDto) {
        System.out.println(blogDto.getTitle() + " " + blogDto.getDescription());
        Errors errors = validator.validateObject(blogDto);
        if (errors.hasErrors()) {
            throw new ResponseStatusException(
                    HttpStatus.UNPROCESSABLE_ENTITY,
                    "Validation failed: " + errors.getAllErrors()
            );
        }
        return ResponseEntity.ok(demoDtoAndModelMapService.addBlogDto(blogDto));
    }


}
