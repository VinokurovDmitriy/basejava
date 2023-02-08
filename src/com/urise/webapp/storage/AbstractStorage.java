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
    protected abstract void insertResume(Resume r, Object resumeKey);
    protected abstract void updateResume(Resume r, Object resumeKey);
    protected abstract Resume getResume(Object resumeKey);
    protected abstract void removeResume(Object resumeKey);
    @Override
    public void save(Resume r) {
        String uuid = r.getUuid();
        Object resumeKey = getResumeKey(uuid);
        if (!isExistResume(resumeKey)) {
            insertResume(r, resumeKey);
        } else {
            throw new ExistStorageException(uuid);
        }
    }

    @Override
    public void update(Resume r) {
        String uuid = r.getUuid();
        Object resumeKey = getResumeKey(uuid);
        if (isExistResume(resumeKey)) {
            updateResume(r, resumeKey);
        } else {
            throw new NotExistStorageException(uuid);
        }
    }

    @Override
    public Resume get(String uuid) {
        Object resumeKey = getResumeKey(uuid);
        if (isExistResume(resumeKey)) {
            return getResume(resumeKey);
        }
        throw new NotExistStorageException(uuid);
    }
    @Override
    public void delete(String uuid) {
        Object resumeKey = getResumeKey(uuid);
        if (isExistResume(resumeKey)) {
           removeResume(resumeKey);
        } else {
            throw new NotExistStorageException(uuid);
        }
    }
}
