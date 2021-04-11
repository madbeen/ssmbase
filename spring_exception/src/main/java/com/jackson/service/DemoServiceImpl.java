package com.jackson.service;

import com.jackson.exception.MyException;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

@Service
public class DemoServiceImpl implements DemoService {
    @Override
    public void castExp() {
        System.out.println("類型轉換異常...");
        Object str = "jackson";
        Integer number = (Integer) str;
    }

    @Override
    public void divide0Exp() {
        System.out.println("/0異常...");
        int i = 1/0;
    }

    @Override
    public void fileNotFoundExp() throws FileNotFoundException {
        System.out.println("FileNotFound異常...");
        FileInputStream fileInputStream = new FileInputStream("c:/xxx/xxx");
    }

    @Override
    public void npExp() {
        System.out.println("NullPointer異常...");
        String str = null;
        str.length();
    }

    @Override
    public void customExp() throws MyException {
        System.out.println("自定義異常...");
        throw new MyException();
    }
}
