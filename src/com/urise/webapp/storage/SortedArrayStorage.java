package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Array based storage for Resumes
 */
public class SortedArrayStorage extends AbstractArrayStorage {

    private static final Comparator<Resume> RESUME_COMPARATOR = Comparator.comparing(Resume::getUuid);
    @Override
    protected Integer getSearchKey(String uuid) {
        Resume searchKey = new Resume(uuid, "dummy");
        return Arrays.binarySearch(storage, 0, count, searchKey, RESUME_COMPARATOR);
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
