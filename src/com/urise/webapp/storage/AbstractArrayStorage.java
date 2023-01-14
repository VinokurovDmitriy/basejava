package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage implements Storage{

    protected final int MAX_COUNT = 10000;
    protected Resume[] storage = new Resume[MAX_COUNT];
    protected int count = 0;

    public void clear() {
        Arrays.fill(storage, 0, count, null);
        count = 0;
    }

    public void save(Resume r) {
        String uuid = r.getUuid();
        if (count == MAX_COUNT - 1) {
            System.out.println("The maximum number of resume has been reached");
        } else if(getIndex(uuid) < 0) {
            insertResume(r);
            count++;
        } else {
            System.out.printf("%ncom.urise.webapp.model.Resume with uuid %s already exists", uuid);
        }
    }

    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index >= 0) {
            storage[index] = r;
        } else {
            System.out.printf("%ncom.urise.webapp.model.Resume with uuid %s is not exists", r.getUuid());
        }
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            return storage[index];
        }
        System.out.printf("%ncom.urise.webapp.model.Resume with uuid %s is not exists%n", uuid);
        return null;
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (storage[index].getUuid().equals(uuid)) {
            count--;
            storage[index] = storage[count];
            storage[count] = null;
        } else {
            System.out.println("com.urise.webapp.model.Resume with this uuid is not exists");
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {return Arrays.copyOf(storage, count);}

    public int getCount() {return count;}

    protected abstract int getIndex(String uuid);

    protected abstract void insertResume(Resume r);
}
