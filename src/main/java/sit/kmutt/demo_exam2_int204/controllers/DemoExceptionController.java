package sit.kmutt.demo_exam2_int204.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sit.kmutt.demo_exam2_int204.exceptions.ItemNotFoundException;
import sit.kmutt.demo_exam2_int204.services.DemoDtoAndModelMapService;
import sit.kmutt.demo_exam2_int204.services.DemoExceptionService;

@RestController
@RequestMapping("/exception")
public class DemoExceptionController {
    @Autowired
    private DemoExceptionService demoExceptionService;
    @Autowired
    private DemoDtoAndModelMapService demoDtoAndModelMapService;

    @GetMapping("")
    public String customException_ItemNotFound() {
        return demoDtoAndModelMapService.findBlogDtoById(999).toString();
    }

    // Handle Exception ระดับ class
//    @ExceptionHandler(ItemNotFoundException.class)
//    public ItemNotFoundException handleItemNotFoundException(ItemNotFoundException e) {
//        return e;
//    }
}
