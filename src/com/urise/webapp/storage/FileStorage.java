package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.io.File;

/**
 * Array based storage for Resumes
 */
public class FileStorage extends AbstractFileStorage {
    FileStorage(File directory) {
        super(directory);
    }

    @Override
    public void doWrite(Resume r, File directory) {
    }

    @Override
    public Resume doRead(File File) {
        return null;
    }

    @Override
    public Resume doGet(File file) {
        return null;
    }
}

