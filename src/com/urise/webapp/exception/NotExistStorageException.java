package com.urise.webapp.exception;

public class NotExistStorageException extends StorageException {

    public NotExistStorageException(String uuid) {
        super("com.urise.webapp.model.Resume with " + uuid + " is not exists");
    }
}
