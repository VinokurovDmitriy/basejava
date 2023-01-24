package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;


/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage implements Storage{

    @Override
    protected int getIndex(String uuid) {
        for (int i = 0; i < count; i++) {
            if (storage[i].equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void insertResume(Resume r, int index) {storage[count] = r;}

    @Override
    protected void removeResume(int index) {
        storage[index] = storage[count];
    }
}

