package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;


public abstract class AbstractStorageTest {

    protected final Storage storage;
    private static final String UUID_1 = "uuid_1";
    private static final Resume resume_1 = new Resume(UUID_1, "Bill");
    private static final String UUID_2 = "uuid_2";
    private static final Resume resume_2 = new Resume(UUID_2, "John");
    private static final String UUID_3 = "uuid_3";
    private static final Resume resume_3 = new Resume(UUID_3, "Sara");
    private static final String UUID_4 = "uuid_4";
    private static final Resume resume_4 = new Resume(UUID_4, "Jessica");
    private static final String DUMMY = "dummy";
    protected static final String TEST_NAME = "testName";


    public AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() {
        storage.clear();
        storage.save(resume_1);
        storage.save(resume_2);
        storage.save(resume_3);
    }

    @Test
    public void clear() {
        storage.clear();
        assertSize(0);
        Assert.assertEquals(new ArrayList<>(), storage.getAllSorted());
    }

    @Test
    public void save() {
        assertSize(3);
        Resume addedResume = resume_4;
        storage.save(addedResume);
        assertSize(4);
        assertGet(addedResume);
    }

    @Test
    public void update() {
        assertSize(3);
        Resume updatedResume = resume_1;
        assertFullName(updatedResume, updatedResume.getFullName());
        storage.update(updatedResume, TEST_NAME);
        assertSize(3);
        Assert.assertSame(updatedResume, storage.get(UUID_1));
        assertFullName(updatedResume, TEST_NAME);
    }

    @Test
    public void get() {
        assertSize(3);
        assertGet(resume_1);
        assertGet(resume_2);
        assertGet(resume_3);
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() {
        assertSize(3);
        storage.delete(UUID_1);
        storage.get(UUID_1);
        assertSize(2);
    }

    @Test
    public void getAll() {
        assertSize(3);
        List<Resume> expected = Arrays.asList(resume_1, resume_2, resume_3);
        for(int i = 0; i < expected.size(); i++) {
            Assert.assertEquals(expected.get(i), storage.getAllSorted().get(i));
        }
    }

    @Test
    public void getSize() {
        assertSize(3);
    }

    @Test(expected = ExistStorageException.class)
    public void saveExist() {
        assertSize(3);
        storage.save(resume_1);
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        assertSize(3);
        storage.get(DUMMY);
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() {
        assertSize(3);
        storage.update(new Resume(DUMMY), TEST_NAME);
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() {
        assertSize(3);
        storage.delete(DUMMY);
    }

    void assertSize(int size) {
        assertEquals(size, storage.getSize());
    }

    private void assertGet(Resume resume) {
        assertEquals(resume, storage.get(resume.getUuid()));
    }
    private void assertFullName(Resume resume, String fullName) {
        assertEquals(resume.getFullName(), fullName);
    }
}