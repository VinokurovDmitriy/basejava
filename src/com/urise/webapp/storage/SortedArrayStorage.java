package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Array based storage for Resumes
 */
public class SortedArrayStorage extends AbstractArrayStorage {
    private static final Comparator<Resume> RESUME_COMPARATOR = (o1, o2) -> o1.getUuid().compareTo(o2.getUuid());

    @Override
    protected Object getSearchKey(String uuid) {
        Resume r = new Resume("dummy");
        return Arrays.binarySearch(storage, 0, count, r, RESUME_COMPARATOR);
    }

    @Override
    public ArrayList<Resume> doGetAll() {
        return new ArrayList<>(List.of(Arrays.copyOf(storage, count)));
    }

    @Override
    protected void doSave(Resume r, Object resumeKey) {
        System.out.println(r);
        System.out.println(resumeKey);
        checkOverflow();
        System.out.println();
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
