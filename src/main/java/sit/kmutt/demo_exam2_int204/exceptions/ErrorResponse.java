package sit.kmutt.demo_exam2_int204.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor // สร้าง constructor เฉพาะ field ที่เป็น final
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {
    private final int status; // เวลาเรียกใช้ต้อง HttpStatus.STATUS.value() เพื่อดึง status code เป็น int
    private final String message;
    private final String instance; // uri ที่เกิด Error
    private String stackTrace;

    private List<ValidationError> errors;

    @Getter
    @Setter
    @RequiredArgsConstructor
    private static class ValidationError {
        private final String field;
        private final String message;
    }

    public void addValidationError(String field, String message){
        if(Objects.isNull(errors)){
            errors = new ArrayList<>();
        }
        errors.add(new ValidationError(field, message));
    }
}