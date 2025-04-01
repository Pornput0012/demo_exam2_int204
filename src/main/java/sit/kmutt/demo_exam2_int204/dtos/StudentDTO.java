package sit.kmutt.demo_exam2_int204.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class StudentDTO {

    private String studentName;

    @NotNull
    private LocalDate dateOfBirth;

    @NotNull
    private SchoolDTO school;
}
