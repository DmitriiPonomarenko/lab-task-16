package vsu.kurs3.task16.repository;

import java.util.HashMap;
import java.util.Map;

import vsu.kurs3.task16.exception.EventAlreadyExistsException;
import vsu.kurs3.task16.model.entity.EventEntity;

public class AutoRepository {

	private final Map<String, EventEntity> storage = new HashMap<>();

	public EventEntity findById(String uid) {
		return storage.get(uid);
	}

	public void insert(EventEntity entity) {
		if (storage.containsKey(entity.getAutoUid())) {
			throw new EventAlreadyExistsException(entity.getAutoUid());
		}
		storage.put(entity.getAutoUid(), entity);
	}

	public boolean existsByRegNumber(String regNumber) {
		return storage.values().stream().anyMatch(x -> regNumber.equals(x.getRegNumber()));
	}

	public EventEntity findByRegnumber(String regNumber) {
		return storage.values().stream()
				.filter(x -> regNumber.equals(x.getRegNumber()))
				.findFirst()
				.orElse(null);
	}
}
