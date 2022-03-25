package vsu.kurs3.task16.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import vsu.kurs3.task16.model.entity.RoomEntity;
import vsu.kurs3.task16.model.entity.ServiceEntity;
import vsu.kurs3.task16.repository.RepairRepository;
import vsu.kurs3.task16.repository.RoomRepository;
import vsu.kurs3.task16.repository.ServiceRepository;

@RequiredArgsConstructor
public class RepairService {

	private final ServiceRepository serviceRepository;

	private final RepairRepository repairRepository;

	private final RoomRepository roomRepository;

	public void processRepairAuto(String serviceUid) {
		ServiceEntity serviceEntity = serviceRepository.findByUid(serviceUid);

		List<RoomEntity> roomList = roomRepository.findByType(serviceEntity.getType());

		RoomEntity freeRoom = null;

		for(RoomEntity roomEntity: roomList) {
			if (repairRepository.isRoomFree(roomEntity.getRoomUid(), roomEntity.getSize())) {
				freeRoom = roomEntity;
				break;
			}
		}

	}
}
