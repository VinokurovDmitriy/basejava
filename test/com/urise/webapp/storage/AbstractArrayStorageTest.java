package com.urise.webapp.storage;

public abstract class AbstractArrayStorageTest extends AbstractStorageTest{

    public AbstractArrayStorageTest(Storage storage) {
        super(storage);
    }

//    @Test(expected = StorageException.class)
//    public void storageOverflow() {
//        clear();
//        for (int i = 0; i < MAX_COUNT; i++) {
//            try {
//                storage.save(new Resume(TEST_NAME + i));
//            } catch (StorageException e) {
//                Assert.fail("Ошибка сохранения резюме. Хранилище переполненно " + e);
//            }
//        }
//        assertSize(MAX_COUNT);
//        storage.save(new Resume());
//    }
}