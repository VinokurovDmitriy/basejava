package com.urise.webapp.storage;

import com.urise.webapp.ResumeTestData;
import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;


public abstract class AbstractStorageTest {

    protected final Storage storage;
    private static final String UUID_1 = "uuid_1";
    private static final String UUID_2 = "uuid_2";
    private static final String UUID_3 = "uuid_3";
    private static final String UUID_4 = "uuid_4";
    private static final Resume RESUME_1;
    private static final Resume RESUME_2;
    private static final Resume RESUME_3;
    private static final Resume RESUME_4;
    private static final String DUMMY = "dummy";
    protected static final String TEST_NAME = "testName";

    static {
//        RESUME_1 = new Resume(UUID_1, "Bill");
//        RESUME_2 = new Resume(UUID_2, "John");
//        RESUME_3 = new Resume(UUID_2, "Mike");
//        RESUME_4 = new Resume(UUID_2, DUMMY);
        RESUME_1 = ResumeTestData.getResume(UUID_1, "Bran");
        RESUME_2 = ResumeTestData.getResume(UUID_2, "Ned");
        RESUME_3 = ResumeTestData.getResume(UUID_3, "Robert");
        RESUME_4 = ResumeTestData.getResume(UUID_3, "Hodor");
    }


    public AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() throws IOException {
        storage.clear();

        storage.save(RESUME_1);
        storage.save(RESUME_2);
        storage.save(RESUME_3);
    }

    @Test
    public void clear() throws IOException {
        storage.clear();
        assertSize(0);
        assertEquals(new ArrayList<>(), storage.getAllSorted());
    }

    @Test
    public void save() {
        assertSize(3);
        Resume addedResume = RESUME_4;
        storage.save(addedResume);
        assertSize(4);
        assertGet(addedResume);
    }

    @Test
    public void update() {
        assertSize(3);
        storage.update(RESUME_1, TEST_NAME);
        assertSize(3);
        assertGet(new Resume(RESUME_1.getUuid(), TEST_NAME));
    }

    @Test
    public void get() {
        assertSize(3);
        System.out.println();
        assertGet(RESUME_1);
        assertGet(RESUME_2);
        assertGet(RESUME_3);
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() throws FileNotFoundException {
        assertSize(3);
        storage.delete(UUID_1);
        storage.get(UUID_1);
        assertSize(2);
    }

    @Test
    public void getAllSorted() {
        assertSize(3);
        List<Resume> sortedStorage = Arrays.asList(RESUME_3, RESUME_1, RESUME_2);
        Collections.sort(sortedStorage);
        List<Resume> list = storage.getAllSorted();
        assertEquals(list, sortedStorage);
    }

    @Test
    public void getSize() {
        assertSize(3);
    }

    @Test(expected = ExistStorageException.class)
    public void saveExist() {
        assertSize(3);
        storage.save(RESUME_1);
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
    public void deleteNotExist() throws FileNotFoundException {
        assertSize(3);
        storage.delete(DUMMY);
    }

    void assertSize(int size) {
        assertEquals(size, storage.getSize());
    }

    private void assertGet(Resume resume) {
        assertEquals(resume, storage.get(resume.getUuid()));
    }
}