package com.projetodeestudo.course.service.exceptions;

public class DatabaseException extends RuntimeException{

    public static final long serialVersionUID = 1L;
    public DatabaseException(String msg) {
        super(msg);
    }
}
