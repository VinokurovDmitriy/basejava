package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

/**
 * Array based storage for Resumes
 */
public class ListStorage extends AbstractStorage<Integer> {

    private final List<Resume> storage = new ArrayList<>();

    @Override
    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected ArrayList<Resume> doCopyAll() {
        return new ArrayList<>(storage);
    }

    @Override
    protected boolean isExistResume(Integer resumeKey) {
        return resumeKey >= 0;
    }

    @Override
    public int getSize() {
        return storage.size();
    }

    @Override
    protected void doSave(Resume r, Integer resumeKey) {
        storage.add(r);
    }

    @Override
    protected void doUpdate(Resume r, Integer resumeKey) {
        storage.set(resumeKey, r);
    }

    @Override
    protected Resume doGet(Integer resumeKey) {
        return storage.get(resumeKey);
    }

    @Override
    protected void doDelete(Integer resumeKey) {
        storage.remove((int) resumeKey);
    }

    @Override
    public void clear() {
        storage.clear();
    }
}
