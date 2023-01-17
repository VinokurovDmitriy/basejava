package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class SortedArrayStorage extends AbstractArrayStorage implements Storage{

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, count, searchKey);
    }

    @Override
    public void insertResume(Resume r, int index) {
        int destinationIndex = -(index + 1);
        //Не могу понять почему это не работает? Все лргично вроде. Элемент который сейчас на нужном индексе вставляем в конец
//        а на его место вставляем новое резюме по указанному индексу. ЧЯДНТ?
//        if(storage[index] != null){
//            storage[count] = storage[index];
//        }
//        storage[index] = r;
        if(count > 0) {
            System.arraycopy(storage, destinationIndex, storage, -index, count - index);
        }
        storage[destinationIndex] = r;
    }

    @Override
    protected void remove(int index) {
        System.arraycopy(storage, index + 1, storage, index, count - index);
        storage[count] = null;
    }
}
