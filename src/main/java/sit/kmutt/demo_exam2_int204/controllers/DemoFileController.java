package sit.kmutt.demo_exam2_int204.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sit.kmutt.demo_exam2_int204.configs.FileStorageProperties;
import sit.kmutt.demo_exam2_int204.dtos.BlogDTO;
import sit.kmutt.demo_exam2_int204.services.DemoDtoAndModelMapService;
import sit.kmutt.demo_exam2_int204.services.DemoFileService;

import java.util.List;

@RestController
@RequestMapping("/files")
public class DemoFileController {
    @Autowired
    private FileStorageProperties fileStorageProperties;

    @Autowired
    private DemoFileService demoFileService;
    @Autowired
    private DemoDtoAndModelMapService demoDtoAndModelMapService;

    @GetMapping("/test")
    public ResponseEntity<Object> testPropertiesMapping() {
        return ResponseEntity.ok(demoFileService.getFileStorageLocation() + " has been created !!!");
    }

    @PostMapping("")
    public ResponseEntity<Object> fileUpload(@RequestParam("file") MultipartFile file) {
        demoFileService.uploadFile(file);
        return ResponseEntity.ok("You successfully uploaded ” + file.getOriginalFilename()");
    }

    @PostMapping("/demo1")
    public ResponseEntity<Object> fileUploadForm1(@ModelAttribute BlogDTO blogDto,
                                                  @RequestParam("file") MultipartFile file) {
        demoFileService.uploadFile(file);
        demoDtoAndModelMapService.addBlogDto(blogDto);
        return ResponseEntity.ok(blogDto);
    }

    @PostMapping("/demo2")
    public ResponseEntity<Object> fileUploadForm1(@ModelAttribute BlogDTO blogDto) {
        demoFileService.uploadFile(blogDto.getImage());
        demoDtoAndModelMapService.addBlogDto(blogDto);
        return ResponseEntity.ok(blogDto);
    }

    @PostMapping("/demo3")
    public ResponseEntity<Object> createUserDemo2( @ModelAttribute BlogDTO blogDto
            , @RequestPart List<MultipartFile> files) {
        demoFileService.uploadFile(files);
        return ResponseEntity.ok(blogDto);
    }

    @GetMapping("/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(
            @PathVariable String filename) {
        Resource file = demoFileService.loadFileAsResource(filename);
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG).body(file);
    }

    @DeleteMapping("/{filename:.+}")
    public ResponseEntity<Object> removeFile(@PathVariable String filename) {
        demoFileService.removeFile(filename);
        return ResponseEntity.ok(filename + " has been removed !");
    }


}
