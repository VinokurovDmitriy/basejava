package com.urise.webapp.storage;

import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.ArrayList;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractListStorage extends AbstractStorage {

    ArrayList<Resume> storage = new ArrayList<>();
    @Override
    protected Integer getResumeKey(String uuid) {
        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected boolean isExistResume(Object resumeKey) {
        try{
            return storage.get((int) resumeKey) != null;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    @Override
    public int getSize() {
        return storage.size();
    }
    @Override
    protected void insertResume(Resume r, Object resumeKey) {
        storage.add(r);
    }

    @Override
    protected void updateResume(Resume r, Object resumeKey) {
        storage.set((int) resumeKey, r);
    }

    @Override
    protected Resume getResume(Object resumeKey) {
        return storage.get((int) resumeKey);
    }

    @Override
    protected void removeResume(Object resumeKey) {
        storage.remove((int) resumeKey);
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public Resume[] getAll() {
        return storage.toArray(new Resume[storage.size()]);
    }
}
