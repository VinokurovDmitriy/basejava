package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import org.junit.Test;

public abstract class AbstractArrayStorageTest extends AbstractStorageTest{

    public AbstractArrayStorageTest(Storage storage) {
        super(storage);
    }

    @Test(expected = StorageException.class)
    public void storageOverflow() {
//        storage.clear();
//        for (int i = 0; i < MAX_COUNT; i++) {
//            try {
//                storage.save(new Resume(TEST_NAME + i, objective, achievment));
//            } catch (StorageException e) {
//                Assert.fail("Ошибка сохранения резюме. Хранилище переполненно " + e);
//            }
//        }
//        assertSize(MAX_COUNT);
//        storage.save(new Resume("dummy", objective, achievment));
    }
}