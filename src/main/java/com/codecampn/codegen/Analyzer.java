package com.codecampn.codegen;

import com.codecampn.codegen.model.Info;

import java.lang.reflect.Field;
import java.util.Arrays;

public class Analyzer {

    // introspect structure of object/class via reflection
    public void checkObject(Object object) throws IllegalAccessException {
        Class<?> clazz = object.getClass();
        String clazzName = clazz.getSimpleName();
        Info clazzInfoAnnotation = clazz.getAnnotation(Info.class);

        System.out.println("Name: " + clazzName);
        for (Field field : clazz.getDeclaredFields()) {
            System.out.println("Field name: " + field.getName());
            field.setAccessible(true);
            System.out.println("Field value: " + field.get(object));
        }

        if (clazzInfoAnnotation != null) {
            System.out.println("Metadata from annotation: " + Arrays.toString(clazzInfoAnnotation.metadata()));
        } else {
            System.out.println("No metadata in annotation");
        }
    }
}
