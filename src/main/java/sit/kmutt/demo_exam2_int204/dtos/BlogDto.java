package sit.kmutt.demo_exam2_int204.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class BlogDto {
    @NotBlank
    private String title;

    @NotBlank
    @Size(min = 1, max = 100)
    private String description;

    @Email
    private String email;

    @Size(min = 2, max = 20, message = "Length 2 - 20 nly")
    private String number;

    @JsonIgnore
    private MultipartFile image;
}
