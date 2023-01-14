package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class SortedArrayStorage extends AbstractArrayStorage implements Storage{

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        System.out.println(searchKey);
        return Arrays.binarySearch(storage, 0, count, searchKey);
    }

    @Override
    public void insertResume(Resume r, int index) {
        index = -(getIndex(r.getUuid()) + 1);
        Resume movableResume = storage[index];
        storage[index] = r;
        storage[count] = movableResume;
    }
}
