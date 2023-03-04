package com.urise.webapp;

import com.urise.webapp.model.Resume;
import com.urise.webapp.storage.MapUuidStorage;

/**
 * Test for your com.urise.webapp.storage.ArrayStorage implementation
 */
public class MainTestArrayStorage{
     private final static MapUuidStorage ARRAY_STORAGE = new MapUuidStorage();

    public static void main(String[] args) {
        Resume r1 = new Resume("uuid1", "Alex", personal);
        Resume r2 = new Resume("uuid2", "Mike", personal);
        Resume r3 = new Resume("uuid3", "Sara", personal);

        ARRAY_STORAGE.save(r3);
        ARRAY_STORAGE.save(r2);
        ARRAY_STORAGE.save(r1);

        printAll();
        System.out.println("Get r1: " + ARRAY_STORAGE.get(r1.getUuid()));
        System.out.println("Size: " + ARRAY_STORAGE.getSize());
//        System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));
        ARRAY_STORAGE.update(r1, "testName");

        printAll();
        ARRAY_STORAGE.delete(r1.getUuid());
        printAll();
        ARRAY_STORAGE.clear();
        printAll();

        System.out.println("Size: " + ARRAY_STORAGE.getSize());
    }

    static void printAll() {
        System.out.println("\nGet All");
        ARRAY_STORAGE.getAllSorted().forEach(System.out::println);
//        for (Resume r : ARRAY_STORAGE.getAll()) {
//            System.out.println(r);
//        }
    }
}
