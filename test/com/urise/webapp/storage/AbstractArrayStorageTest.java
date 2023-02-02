package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.urise.webapp.storage.AbstractArrayStorage.MAX_COUNT;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;


public abstract class AbstractArrayStorageTest {

    private final Storage storage;
    private static final String UUID_1 = "uuid_1";
    private static final Resume resume_1 = new Resume(UUID_1);
    private static final String UUID_2 = "uuid_2";
    private static final Resume resume_2 = new Resume(UUID_2);
    private static final String UUID_3 = "uuid_3";
    private static final Resume resume_3 = new Resume(UUID_3);
    private static final String UUID_4 = "uuid_4";
    private static final Resume resume_4 = new Resume(UUID_4);
    private static final String DUMMY = "dummy";


    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() {
        storage.clear();
        storage.save(resume_1);
        storage.save(resume_2);
        storage.save(resume_3);
        assertSize(3);
    }

    @Test
    public void clear() {
        storage.clear();
        assertSize(0);
        assertArrayEquals(new Resume[0], storage.getAll());

    }

    @Test
    public void save() {
        Resume addedResume = resume_4;
        storage.save(addedResume);
        assertSize(4);
        assertGet(addedResume);
    }

    @Test
    public void update() {
        Resume updatedResume = resume_1;
        storage.update(updatedResume);
        assertSize(3);
        assertGet(updatedResume);
    }

    @Test
    public void get() {
        assertGet(resume_1);
    }

    @Test
    public void delete() {
        storage.delete(UUID_1);
        assertSize(2);
    }

    @Test
    public void getAll() {
        Resume[] expected = new Resume[] {resume_1, resume_2, resume_3};
        assertArrayEquals(expected, storage.getAll());

    }

    @Test
    public void size() {
        assertSize(3);
    }

    @Test(expected = ExistStorageException.class)
    public void saveExist() {
        storage.save(resume_1);
        assertSize(3);
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get(DUMMY);
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() {
        storage.update(new Resume(DUMMY));
        assertSize(3);
    }
    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() {
        storage.delete(DUMMY);
        assertSize(3);
    }

    @Test(expected = StorageException.class)
    public void storageOverflow() {
        storage.clear();
        assertSize(0);
        for (int i = 0; i < MAX_COUNT; i++) {
            try{
                storage.save(new Resume());
            } catch (StorageException e){
                Assert.fail("Ошибка сохранения резюме. Хранилище переполненно " + e);
            }
        }
        assertSize(MAX_COUNT);
        storage.save(new Resume());
    }
    private void assertSize(int size) {
        assertEquals(size, storage.size());
    }

    private void assertGet(Resume resume) {
        assertEquals(resume, storage.get(resume.getUuid()));
    }
}