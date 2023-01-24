package com.urise.webapp.exception;

public class ExistStorageException extends StorageException {

    public ExistStorageException(String uuid) {
        super("com.urise.webapp.model.Resume with uuid " + uuid + " already exists", uuid);
    }
}
