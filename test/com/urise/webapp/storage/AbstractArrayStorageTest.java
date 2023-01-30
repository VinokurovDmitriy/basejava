package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public abstract class AbstractArrayStorageTest {

    private final Storage storage;
    private static final String UUID_1 = "uuid_1";
    private static final String UUID_2 = "uuid_2";
    private static final String UUID_3 = "uuid_3";
    private static final String UUID_4 = "uuid_4";
    protected static final int MAX_COUNT = 10000;
    private static final String DUMMY = "dummy";

    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }

    @Test
    public void clear() {
        assertSize(3);
        storage.clear();
        assertSize(0);
        //Assert.assertEquals(new Resume[MAX_COUNT], storage);
        //вот тут не знаю как сравнить. Типы разные. storage это обьект либо SortedArrayStorage, либо ArrayStorage, а сравнивать надо с массивом резюме
    }

    @Test(expected = ExistStorageException.class)
    public void save() {
        assertSize(3);
        Resume addedResume = new Resume(UUID_4);
        storage.save(addedResume);
        assertSize(4);
        assertResume(addedResume);
        storage.save(new Resume(UUID_1));
    }

    @Test(expected = NotExistStorageException.class)
    public void update() {
        assertSize(3);
        Resume updatedResume = new Resume(UUID_1);
        storage.update(updatedResume);
        assertSize(3);
        assertResume(updatedResume);
        storage.update(new Resume(DUMMY));
    }

    @Test(expected = NotExistStorageException.class)
    public void get() {
        assertSize(3);
        Resume testResume = new Resume(UUID_1);
        assertResume(testResume);
        storage.get(DUMMY);
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() {
        assertSize(3);
        storage.delete(UUID_1);
        assertSize(2);
        storage.get(UUID_1);
    }

    @Test
    public void getAll() {
        assertSize(3);
//        for (Resume resume : storage) {
//            Assert.assertNotEquals(null, resume);
//        }
    }

    @Test
    public void size() {
        assertSize(3);
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        assertSize(3);
        storage.get(DUMMY);
    }

    @Test(expected = StorageException.class)
    public void storageOverflow() {
        storage.clear();
        assertSize(0);
        for (int i = 0; i < MAX_COUNT; i++) {
            try{
                storage.save(new Resume());
            } catch (ExistStorageException e){
                Assert.fail("Ошибка сохранения резюме. " + e);
            }
        }
        storage.save(new Resume());
    }

    private void assertSize(int size) {
        Assert.assertEquals(size, storage.size());
    }

    private void assertResume(Resume resume) {
        Assert.assertEquals(resume, storage.get(resume.getUuid()));
    }
}