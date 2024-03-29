package com.urise.webapp;

import com.urise.webapp.model.Resume;
import com.urise.webapp.storage.MapUuidStorage;

import java.io.FileNotFoundException;

/**
 * Test for your com.urise.webapp.storage.ArrayStorage implementation
 */
public class MainTestArrayStorage{
     private final static MapUuidStorage ARRAY_STORAGE = new MapUuidStorage();

    public static void main(String[] args) throws FileNotFoundException {
        Resume r1 = new Resume("uuid1", "Alex");
        Resume r2 = new Resume("uuid2", "Mike");
        Resume r3 = new Resume("uuid3", "Sara");

        ARRAY_STORAGE.save(r3);
        ARRAY_STORAGE.save(r2);
        ARRAY_STORAGE.save(r1);

        printAll();
        System.out.println("Get r1: " + ARRAY_STORAGE.get(r1.getUuid()));
        System.out.println("Size: " + ARRAY_STORAGE.getSize());
        System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));
        ARRAY_STORAGE.update(r1, "testName");

        printAll();
        ARRAY_STORAGE.delete(r1.getUuid());
        printAll();
        ARRAY_STORAGE.clear();
        printAll();
    }

    static void printAll() {
        System.out.println("\nGet All");
        ARRAY_STORAGE.getAllSorted().forEach(System.out::println);
        for (Object r : ARRAY_STORAGE.getAllSorted()) {
            System.out.println(r);
        }
    }
}
