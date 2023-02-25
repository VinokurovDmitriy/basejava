package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractStorage implements Storage {

    protected abstract Object getSearchKey(String uuid);
    protected abstract ArrayList<Resume> doGetAll();

    protected abstract boolean isExistResume(Object resumeKey);

    protected abstract void doSave(Resume r, Object resumeKey);

    protected abstract void doUpdate(Resume r, Object resumeKey);

    protected abstract Resume doGet(Object resumeKey);

    protected abstract void doDelete(Object resumeKey);

    @Override
    public void save(Resume r) {
        Object searchKey = getNotExistingSearchKey(getSearchKey(r.getUuid()), r.getUuid());
        doSave(r, searchKey);
    }

    @Override
    public void update(Resume r, String fullName) {
        r.setFullName(fullName);
        Object searchKey = getExistingSearchKey(r.getUuid());
        doUpdate(r, searchKey);
    }


    @Override
    public Resume get(String uuid) {
        Object searchKey = getExistingSearchKey(uuid);
        return doGet(searchKey);
    }

    @Override
    public List<Resume> getAllSorted() {
        List<Resume> listStorage = doGetAll();
        return listStorage.stream().sorted(Comparator.comparing(Resume::getUuid).thenComparing(Resume::getFullName)).toList();
    };
    @Override
    public void delete(String uuid) {
        Object searchKey = getExistingSearchKey(uuid);
        doDelete(searchKey);
    }

    private Object getExistingSearchKey(String uuid) {
        if (isExistResume(uuid)) {
            return getSearchKey(uuid);
        }
        throw new NotExistStorageException(uuid);
    }

    private Object getNotExistingSearchKey(Object resumeKey, String uuid) {
        if (!isExistResume(resumeKey)) {
            return resumeKey;
        }
        throw new ExistStorageException(uuid);
    }
}
