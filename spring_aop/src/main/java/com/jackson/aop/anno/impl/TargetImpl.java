package com.jackson.aop.anno.impl;

import com.jackson.aop.anno.Target;
import org.springframework.stereotype.Component;

@Component(value = "target")
public class TargetImpl implements Target {
    @Override
    public void save() {
        System.out.println("save() running.....");
    }
}
