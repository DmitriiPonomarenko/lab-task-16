package vsu.kurs3.task16.repository;

import java.util.ArrayList;
import java.util.List;
import vsu.kurs3.task16.model.entity.RepairEntity;

public class RepairRepository {

	private final List<RepairEntity> storage = new ArrayList<>();

	public void insert(RepairEntity repairEntity) {
		storage.add(repairEntity);
	}

	public boolean isWorkerFree(String workerUid) {
		return storage.stream()
				.allMatch(x -> workerUid.equals(x.getWorkerUid())
						&& Boolean.TRUE.equals(x.getFinished()));
	}

	public boolean isRoomFree(String roomUid, Integer size) {
		return size > storage.stream()
				.filter(x -> roomUid.equals(x.getRoomUid())
						&& Boolean.FALSE.equals(x.getFinished()))
				.count();
	}
}
