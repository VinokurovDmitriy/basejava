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
        return Arrays.binarySearch(storage, 0, count, searchKey);
    }

    @Override
    public void insertResume(Resume r, int index) {
        index = -(index + 1);
        if(storage[index] != null){
            storage[count] = storage[index];
        }
        storage[index] = r;
    }

    @Override
    protected void remove(int index) {
        System.arraycopy(storage, index + 1, storage, index, count - index);
        storage[count] = null;
    }
}
