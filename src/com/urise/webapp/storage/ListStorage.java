package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

/**
 * Array based storage for Resumes
 */
public class ListStorage extends AbstractStorage {

    private final List<Resume> storage = new ArrayList<>();

    @Override
    protected Integer getResumeKey(Resume r) {
        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i).getUuid().equals(r.getUuid())) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected ArrayList<Resume> doGetAll() {
        return (ArrayList<Resume>) storage;
    }

    @Override
    public List<Resume> getAllSorted() {
        return storage;
    }

    @Override
    protected boolean isExistResume(Object resumeKey) {
        return (int) resumeKey >= 0;
    }

    @Override
    public int getSize() {
        return storage.size();
    }

    @Override
    protected void doSave(Resume r, Object resumeKey) {
        storage.add(r);
    }

    @Override
    protected void doUpdate(Resume r, Object resumeKey) {
        storage.set((int) resumeKey, r);
    }

    @Override
    protected Resume doGet(Object resumeKey) {
        return storage.get((int) resumeKey);
    }

    @Override
    protected void doDelete(Object resumeKey) {
        storage.remove((int) resumeKey);
    }

    @Override
    public void clear() {
        storage.clear();
    }
}
