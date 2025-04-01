package sit.kmutt.demo_exam2_int204.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SchoolDTO {
    @NotBlank
    private String schoolName;
}
