package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;

/**
 * Array based storage for Resumes
 */
public class ListStorage extends AbstractStorage{

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
        } catch(IndexOutOfBoundsException e) {
            return false;
        }
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
    protected void doUppdate(Resume r, Object resumeKey) {
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

    @Override
    public Resume[] getAll() {
        int size = storage.size();
        return storage.toArray(new Resume[size]);
    }
}
