import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int count = 0;

    void clear() {
        Arrays.fill(storage, 0, count, null);
        count = 0;
    }

    void save(Resume r) {
        int index = findIndex(r.uuid);
        if (index < 0) {
            storage[count] = r;
            count++;
        } else {
            System.out.println("Resume with this uuid already exists");
        }
    }

    Resume get(String uuid) {
        int index = findIndex(uuid);
        return index >= 0 ? storage[index] : null;
    }

    void delete(String uuid) {
        int index = findIndex(uuid);
        if (storage[index].uuid.equals(uuid)) {
            count--;
            System.arraycopy(storage, index + 1, storage, index, count - index);
            storage[count] = null;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, count);
    }

    int size() {
        return count;
    }

    private int findIndex(String uuid) {
        for (int i = 0; i < count; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
