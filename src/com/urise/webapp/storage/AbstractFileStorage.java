package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public abstract class AbstractFileStorage extends AbstractStorage<File> {
    private final File directory;
    AbstractFileStorage(File directory) {
        Objects.requireNonNull(directory, "directory is not be null");
        if(!directory.isDirectory()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + " is not directory");
        }
        if(!directory.canRead() || !directory.canWrite()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + " is not readable/writable");
        }
        this.directory = directory;
    }

    @Override
    protected File getSearchKey(String uuid) {
        return new File(directory, uuid);
    }

    @Override
    protected List<Resume> doCopyAll() {
        List<Resume> files = null;
        for ( File file : Objects.requireNonNull(new File("./storage").listFiles())){
            if (file.isFile()) {
                files.add(doRead(file));
            }
        }
        return files;
    }

    @Override
    protected boolean isExistResume(File file) {
        return file.exists();
    }

    @Override
    protected void doSave(Resume r, File file) {
        try {
            file.createNewFile();
            doWrite(r, file);
        } catch (IOException e) {
            throw new StorageException("Io error", file.getName(), e);
        }
    }

    @Override
    protected void doUpdate(Resume r, File file) {
        doWrite(r, file);
    }

    @Override
    protected Resume doGet(File file) {
        return doRead(file);
    }

    @Override
    protected void doDelete(File file) throws FileNotFoundException {
        if(!file.delete()) {
            throw new FileNotFoundException();
        };
    }

    @Override
    public void clear() throws IOException {
        for(File file : Objects.requireNonNull(directory.listFiles())) {
            file.delete();
        }
    }

    @Override
    public int getSize() {
        return Objects.requireNonNull(directory.listFiles()).length;
    }

    public abstract void doWrite(Resume r, File directory);
    public abstract Resume doRead(File file);
}
