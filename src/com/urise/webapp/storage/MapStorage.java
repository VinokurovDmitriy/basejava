package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;

/**
 * Array based storage for Resumes
 */
public class MapStorage extends AbstractStorage {

    Map<Object, Resume> storage = new HashMap<>();
    @Override
    protected String getResumeKey(String uuid) {return uuid;}

    @Override
    protected boolean isExistResume(Object resumeKey) {return storage.containsKey(resumeKey);}

    @Override
    public int getSize() {return storage.size();}
    @Override
    protected void doSave(Resume r, Object resumeKey) {storage.put(resumeKey, r);}

    @Override
    protected void doUppdate(Resume r, Object resumeKey) {storage.put(resumeKey, r);}

    @Override
    protected Resume doGet(Object resumeKey) {return storage.get(resumeKey);}

    @Override
    protected void doDelete(Object resumeKey) {storage.remove(resumeKey);}

    @Override
    public void clear() {storage.clear();}

    @Override
    public Resume[] getAll() {
        int size = storage.size();
        return storage.values().toArray(new Resume[size]);
    }
}
