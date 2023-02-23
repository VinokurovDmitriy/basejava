package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.*;

/**
 * Array based storage for Resumes
 */
public class MapStorageResumeKey extends MapStorageUuidKey {

    private final Map<Object, Resume> storage = new HashMap<>();

    @Override
    protected Resume getResumeKey(Resume r) {
      return r;
    }
}
