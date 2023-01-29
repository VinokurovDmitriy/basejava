package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage implements Storage{

    protected static final int MAX_COUNT = 10000;
    protected Resume[] storage = new Resume[MAX_COUNT];
    protected int count = 0;

    @Override
    public void clear() {
        Arrays.fill(storage, 0, count, null);
        count = 0;
    }

    @Override
    public void save(Resume r) {
        String uuid = r.getUuid();
        int index = getIndex(uuid);
        if (count == MAX_COUNT - 1) {
            throw new StorageException("The maximum number of resume has been reached", uuid);
        } else if(getIndex(uuid) < 0) {
            insertResume(r, index);
            count++;
        } else {
            throw new ExistStorageException(uuid);
        }
    }

    @Override
    public void update(Resume r) {
        String uuid = r.getUuid();
        int index = getIndex(uuid);
        if (index >= 0) {
            storage[index] = r;
        } else {
            throw new NotExistStorageException(uuid);
        }
    }

    @Override
    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            return storage[index];
        }
        throw new NotExistStorageException(uuid);
    }
    @Override
    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index >=0 && storage[index].getUuid().equals(uuid)) {
            count--;
            removeResume(index);
            storage[count] = null;
        } else {
            throw new NotExistStorageException(uuid);
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    @Override
    public Resume[] getAll() {return Arrays.copyOf(storage, count);}

    @Override
    public int size() {return count;}

    protected abstract int getIndex(String uuid);

    protected abstract void insertResume(Resume r, int index);

    protected abstract void removeResume(int index);
}
