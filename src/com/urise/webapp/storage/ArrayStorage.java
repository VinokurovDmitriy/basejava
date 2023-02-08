package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;


/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected Integer getResumeKey(String uuid) {
        for (int i = 0; i < count; i++) {
            if (storage[i] != null && storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void insertResume(Resume r, Object resumeKey) {
        checkOverflow();
        storage[count++] = r;
    }

    @Override
    protected void removeResume(Object resumeKey) {
        storage[(int) resumeKey] = storage[count--];
    }
}

