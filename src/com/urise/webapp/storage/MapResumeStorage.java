package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.*;

/**
 * Array based storage for Resumes
 */
public class MapResumeStorage extends AbstractStorage {

    private final Map<Object, Resume> storage = new HashMap<>();

    @Override
    protected Object getSearchKey(String uuid) {
        return storage.get(uuid);
    }

    @Override
    protected ArrayList<Resume> doGetAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    protected boolean isExistResume(Object resumeKey) {
        return storage.get(resumeKey) != null;
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
        System.out.println(resumeKey);
        return (Resume) resumeKey;
    }

    @Override
    protected void doDelete(Object resumeKey) {
        storage.remove(resumeKey);
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public int getSize() {
        return storage.size();
    }
}
