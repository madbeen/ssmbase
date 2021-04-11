package com.jackson.aop.impl;

import com.jackson.aop.Target;

public class TargetImpl implements Target {
    @Override
    public void save() {
        System.out.println("save() running.....");
    }
}
