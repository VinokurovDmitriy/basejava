package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * Array based storage for Resumes
 */
public interface Storage {

    void clear() throws IOException;

    void save(Resume r);

    void update(Resume r, String fullName);

    List<Resume> getAllSorted();

    Resume get(String uuid);

    void delete(String uuid) throws FileNotFoundException;

    int getSize();
}
