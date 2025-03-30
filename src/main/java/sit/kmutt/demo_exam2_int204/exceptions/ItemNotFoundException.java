package sit.kmutt.demo_exam2_int204.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(String message) {
        super(message);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}

//@ResponseStatus(HttpStatus.NOT_FOUND)
//public class ItemNotFoundException extends ResponseStatusException {
//    public ItemNotFoundException(String message) {
//        super(HttpStatus.NOT_FOUND,message);
//    }
//}