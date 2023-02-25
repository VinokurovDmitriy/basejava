package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < count; i++) {
            if (storage[i] != null && storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public ArrayList<Resume> doGetAll() {
        return new ArrayList<>(List.of(Arrays.copyOf(storage, count)));
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

