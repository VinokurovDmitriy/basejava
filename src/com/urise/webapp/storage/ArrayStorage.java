package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.List;


/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected Integer getResumeKey(Resume r) {
        for (int i = 0; i < count; i++) {
            if (storage[i] != null && storage[i].getUuid().equals(r.getUuid())) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public List<Resume> getListStorageFromStorage() {
        Resume[] allResume = Arrays.copyOf(storage, count);
        return Arrays.asList(allResume);
    }

    @Override
    protected void doSave(Resume r, Object resumeKey) {
        checkOverflow();
        storage[count++] = r;
    }

    @Override
    protected void doDelete(Object resumeKey) {
        storage[(int) resumeKey] = storage[count--];
    }

}

