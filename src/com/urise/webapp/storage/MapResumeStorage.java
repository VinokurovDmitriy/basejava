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
        System.out.println( storage.get(uuid));
        return storage.get(uuid);
    }

    @Override
    protected ArrayList<Resume> doCopyAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    protected boolean isExistResume(Object searchKey) {
        return searchKey != null;
    }

    @Override
    protected void doSave(Resume r, Object searchKey) {
        storage.put(searchKey, r);
    }

    @Override
    protected void doUpdate(Resume r, Object searchKey) {
        storage.put(searchKey, r);
    }

    @Override
    protected Resume doGet(Object searchKey) {
        System.out.println(searchKey);
        return (Resume) searchKey;
    }

    @Override
    protected void doDelete(Object searchKey) {
        storage.remove(searchKey);
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
