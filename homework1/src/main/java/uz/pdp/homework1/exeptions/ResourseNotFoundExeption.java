package uz.pdp.homework1.exeptions;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
@AllArgsConstructor
public class ResourseNotFoundExeption extends RuntimeException {
    private String resourseName;
    private String resourceField;
    private Object object;
}
