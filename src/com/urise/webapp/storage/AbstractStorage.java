package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractStorage<SK> implements Storage {

    private static final Logger LOG = Logger.getLogger(AbstractStorage.class.getName());

    protected abstract SK getSearchKey(String uuid);
    protected abstract List<Resume> doCopyAll();

    protected abstract boolean isExistResume(SK resumeKey);

    protected abstract void doSave(Resume r, SK resumeKey);

    protected abstract void doUpdate(Resume r, SK resumeKey);

    protected abstract Resume doGet(SK resumeKey);

    protected abstract void doDelete(SK resumeKey) throws FileNotFoundException;

    @Override
    public void save(Resume r) {
        SK searchKey = getNotExistingSearchKey(r.getUuid());
        doSave(r, searchKey);
    }

    @Override
    public void update(Resume r, String fullName) {
        Resume updateResume = new Resume(r.getUuid(), fullName);
        SK searchKey = getExistingSearchKey(r.getUuid());
        doUpdate(updateResume, searchKey);
    }


    @Override
    public Resume get(String uuid) {
        SK searchKey = getExistingSearchKey(uuid);
        return doGet(searchKey);
    }

    @Override
    public List<Resume> getAllSorted() {
        List<Resume> listStorage = doCopyAll();
        Collections.sort(listStorage);
        return listStorage;
    };
    @Override
    public void delete(String uuid) throws FileNotFoundException {
        SK searchKey = getExistingSearchKey(uuid);
        doDelete(searchKey);
    }

    private SK getExistingSearchKey(String uuid) {
        SK searchKey = getSearchKey(uuid);
        if (isExistResume(searchKey)) {
            return searchKey;
        }
        throw new NotExistStorageException(uuid);
    }

    private SK getNotExistingSearchKey(String uuid) {
        SK searchKey = getSearchKey(uuid);
        if (!isExistResume(searchKey)) {
            return searchKey;
        }
        throw new ExistStorageException(uuid);
    }
}
