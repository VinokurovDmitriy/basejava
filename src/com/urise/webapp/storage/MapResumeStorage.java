package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.*;

/**
 * Array based storage for Resumes
 */
public class MapResumeStorage extends AbstractStorage {

    private final Map<Object, Resume> storage = new HashMap<>();

    @Override
    protected Resume getResumeKey(Resume r) {
      return r;
    }

    @Override
    protected ArrayList<Resume> doGetAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    protected boolean isExistResume(Object resumeKey) {
        return false;
    }

    @Override
    protected void doSave(Resume r, Object resumeKey) {

    }

    @Override
    protected void doUpdate(Resume r, Object resumeKey) {

    }

    @Override
    protected Resume doGet(Object resumeKey) {
        return null;
    }

    @Override
    protected void doDelete(Object resumeKey) {

    }

    @Override
    public void clear() {

    }

    @Override
    public int getSize() {
        return 0;
    }
}
