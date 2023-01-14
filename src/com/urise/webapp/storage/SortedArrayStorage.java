package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class SortedArrayStorage extends AbstractArrayStorage implements Storage{

    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, count, searchKey);
    }

    public void insertResume(Resume r, int index) {
        index = -(index + 1);
        Resume movableResume = storage[index];
        storage[index] = r;
        storage[count] = movableResume;
    }
}
