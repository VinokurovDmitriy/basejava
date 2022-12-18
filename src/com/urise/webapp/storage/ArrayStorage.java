package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

    private final static int MAX_COUNT = 10000;
    Resume[] storage = new Resume[MAX_COUNT];
    private int count = 0;

    public void clear() {
        Arrays.fill(storage, 0, count, null);
        count = 0;
    }

    public void save(Resume r) {
        if (count == MAX_COUNT - 1) {
            System.out.println("The maximum number of resume has been reached");
            return;
        }
        String uuid = r.getUuid();
        if (findIndex(uuid) < 0) {
            storage[count] = r;
            count++;
        } else {
            System.out.printf("%ncom.urise.webapp.model.Resume with uuid %s already exists", uuid);
        }
    }

    public void update(String oldUuid, String newUuid) {
        int index = findIndex(oldUuid);
        if (index >= 0) {
            storage[index].setUuid(newUuid);
        } else {
            System.out.printf("%ncom.urise.webapp.model.Resume with uuid %s is not exists", oldUuid);
        }
    }

    public Resume get(String uuid) {
        int index = findIndex(uuid);
        if (index >= 0) {
            return storage[index];
        }
        return null;
    }

    public void delete(String uuid) {
        int index = findIndex(uuid);
        if (storage[index].getUuid().equals(uuid)) {
            count--;
            System.arraycopy(storage, index + 1, storage, index, count - index);
            storage[count] = null;
        } else {
            System.out.println("com.urise.webapp.model.Resume with this uuid is not exists");
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, count);
    }

    public int size() {
        return count;
    }

    private int findIndex(String uuid) {
        for (int i = 0; i < count; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
