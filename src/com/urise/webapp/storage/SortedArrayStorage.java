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
        int destinationIndex = -(index + 1);
        if(count > 0) {
            System.arraycopy(storage, destinationIndex, storage, -index, count - index);
        }
        storage[destinationIndex] = r;
    }

    @Override
    protected void removeResume(int index) {
        System.arraycopy(storage, index + 1, storage, index, count - index);
    }
}
