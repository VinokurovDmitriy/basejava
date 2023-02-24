package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.List;

/**
 * Array based storage for Resumes
 */
public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected Object getResumeKey(Resume r) {
        return Arrays.binarySearch(storage, 0, count, r);
    }

    @Override
    public List<Resume> getListStorageFromStorage() {
        System.out.println(Arrays.copyOf(storage, count));
        return Arrays.asList(Arrays.copyOf(storage, count));
    }

    @Override
    protected void doSave(Resume r, Object resumeKey) {
        checkOverflow();
        int destinationIndex = -((int) resumeKey + 1);
        if (destinationIndex != count) {
            System.arraycopy(storage, destinationIndex, storage, destinationIndex + 1, count - destinationIndex);
        }
        storage[destinationIndex] = r;
        count++;
    }

    @Override
    protected void doDelete(Object resumeKey) {
        int index = (int) resumeKey;
        System.arraycopy(storage, index + 1, storage, index, (count--) - index);
    }
}
