package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static com.urise.webapp.storage.AbstractArrayStorage.MAX_COUNT;

public abstract class AbstractArrayStorageTest extends AbstractStorageTest{

    public AbstractArrayStorageTest(Storage storage) {
        super(storage);
    }

    @Test(expected = StorageException.class)
    public void storageOverflow() throws IOException {
        storage.clear();
        for (int i = 0; i < MAX_COUNT; i++) {
            try {
                storage.save(new Resume(TEST_NAME + i));
            } catch (StorageException e) {
                Assert.fail("Ошибка сохранения резюме. Хранилище переполненно " + e);
            }
        }
        assertSize(MAX_COUNT);
        storage.save(new Resume("dummy"));
    }
}