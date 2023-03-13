package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.List;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage extends AbstractStorage {

    protected static final int MAX_COUNT = 10000;
    protected Resume[] storage = new Resume[MAX_COUNT];
    protected int count = 0;

    @Override
    public void clear() {
        Arrays.fill(storage, 0, count, null);
        count = 0;
    }

    @Override
    public List<Resume> doCopyAll() {
        return Arrays.asList(Arrays.copyOf(storage, count));
    }
    @Override
    public int getSize() {
        return count;
    }

    @Override
    protected boolean isExistResume(Object resumeKey) {
        return (int) resumeKey >= 0;
    }

    @Override
    protected void doUpdate(Resume r, Object resumeKey) {
        storage[(int) resumeKey] = r;
    }

    @Override
    protected Resume doGet(Object resumeKey) {
        return storage[(int) resumeKey];
    }

    protected void checkOverflow(String uuid) {
        if (count == MAX_COUNT) {
            throw new StorageException("Хранилище переполнено", uuid);
        }
    }
}
