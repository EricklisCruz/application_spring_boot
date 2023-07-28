package com.projetodeestudo.course.service.exceptions;


public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(Integer id) {
        super("ResourceNotFound. Id: " + id);
    }
}
