package ar.edu.unlp.api.exceptions;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ApiErrors {
    private List<String> errors;

    public ApiErrors(BindingResult bindingResult) {
        this.errors = new ArrayList<>();
        bindingResult.getAllErrors().forEach(error -> this.errors.add(((FieldError) error).getField() + ": " + error.getDefaultMessage()));
    }

    public ApiErrors(BusinessException ex) {
        this.errors = Arrays.asList(ex.getMessage());
    }

    public ApiErrors(ResponseStatusException ex) {
        this.errors = Arrays.asList(ex.getReason());
    }

    public List<String> getErrors() {
        return errors;
    }

}
