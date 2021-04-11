package com.jackson.service;

import com.jackson.exception.MyException;

import java.io.FileNotFoundException;

public interface DemoService {
    void castExp();
    void divide0Exp();
    void fileNotFoundExp() throws FileNotFoundException;
    void npExp();
    void customExp() throws MyException;
}
