package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.lang.reflect.InvocationTargetException;

public class MainReflection {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Resume r = new Resume("dummy");
        System.out.println(r.getClass().getDeclaredMethod("toString").invoke(r));
    }

}
