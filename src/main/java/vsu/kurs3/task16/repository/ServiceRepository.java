package vsu.kurs3.task16.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import vsu.kurs3.task16.model.entity.ServiceEntity;

public class ServiceRepository {

	private final Map<String, ServiceEntity> storage = new HashMap<>();

	public void insert(ServiceEntity serviceEntity) {
		storage.put(serviceEntity.getServiceUid(), serviceEntity);
	}

	public List<ServiceEntity> findAllByAutoUid(String autoUid) {
		return storage.values().stream().filter(x -> autoUid.equals(x.getAutoUid())).collect(Collectors.toList());
	}

	public ServiceEntity findByUid(String serviceUid) {
		return storage.get(serviceUid);
	}
}
