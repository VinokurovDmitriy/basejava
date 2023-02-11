package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractStorage implements Storage {

    protected abstract Object getResumeKey(String uuid);

    protected abstract boolean isExistResume(Object resumeKey);

    protected abstract void doSave(Resume r, Object resumeKey);

    protected abstract void doUpdate(Resume r, Object resumeKey);

    protected abstract Resume doGet(Object resumeKey);

    protected abstract void doDelete(Object resumeKey);

    @Override
    public void save(Resume r) {
        Object searchKey = getNotExistingSearchKey(r);
        doSave(r, searchKey);
    }

    @Override
    public void update(Resume r) {
        Object searchKey = getExistingSearchKey(r.getUuid());
        doUpdate(r, searchKey);
    }

    @Override
    public Resume get(String uuid) {
        Object searchKey = getExistingSearchKey(uuid);
        return doGet(searchKey);
    }

    @Override
    public void delete(String uuid) {
        Object searchKey = getExistingSearchKey(uuid);
        doDelete(searchKey);
    }

    private Object getExistingSearchKey(String uuid) {
        Object resumeKey = getResumeKey(uuid);
        if (isExistResume(resumeKey)) {
            return resumeKey;
        } else {
            throw new NotExistStorageException(uuid);
        }
    }

    private Object getNotExistingSearchKey(Resume r) {
        String uuid = r.getUuid();
        Object resumeKey = getResumeKey(uuid);
        if (!isExistResume(resumeKey)) {
            return resumeKey;
        } else {
            throw new ExistStorageException(uuid);
        }
    }
}
