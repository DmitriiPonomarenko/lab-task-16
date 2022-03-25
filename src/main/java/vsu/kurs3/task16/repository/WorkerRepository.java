package vsu.kurs3.task16.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import vsu.kurs3.task16.model.entity.WorkerEntity;

public class WorkerRepository {

	private final Map<String, WorkerEntity> storage = new HashMap<>();

	public WorkerEntity findById(String uid) {
		return storage.get(uid);
	}

	public void insert(WorkerEntity entity) {
		storage.put(entity.getWorkerUid(), entity);
	}

	public WorkerEntity delete(String uid) {
		return storage.remove(uid);
	}

	public List<WorkerEntity> findByType(String type) {
		return storage.values().stream()
				.filter(x -> type.equals(x.getType()))
				.collect(Collectors.toList());
	}
}
