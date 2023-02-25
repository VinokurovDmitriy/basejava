package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.*;

/**
 * Array based storage for Resumes
 */
public class MapUuidStorage extends AbstractStorage {

    private final Map<Object, Resume> storage = new HashMap<>();

    @Override
    protected Object getResumeKey(Resume r) {
        return r.getUuid();
    }

    @Override
    public ArrayList<Resume> doGetAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    protected boolean isExistResume(Object resumeKey) {
        return storage.containsKey(resumeKey);
    }

    @Override
    public int getSize() {
        return storage.size();
    }

    @Override
    protected void doSave(Resume r, Object resumeKey) {
        storage.put(resumeKey, r);
    }

    @Override
    protected void doUpdate(Resume r, Object resumeKey) {
        storage.put(resumeKey, r);
    }

    @Override
    protected Resume doGet(Object resumeKey) {
        return storage.get(resumeKey);
    }

    @Override
    protected void doDelete(Object resumeKey) {
        storage.remove(resumeKey);
    }

    @Override
    public void clear() {
        storage.clear();
    }
}
