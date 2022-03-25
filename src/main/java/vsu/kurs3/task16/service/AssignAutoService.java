package vsu.kurs3.task16.service;

import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import vsu.kurs3.task16.component.AutoRequestValidatorComponent;
import vsu.kurs3.task16.exception.EventAlreadyExistsException;
import vsu.kurs3.task16.exception.EventNotExistsException;
import vsu.kurs3.task16.model.entity.EventEntity;
import vsu.kurs3.task16.model.entity.ServiceEntity;
import vsu.kurs3.task16.model.input.AssignAutoRequest;
import vsu.kurs3.task16.model.input.CreateAutoRequest;
import vsu.kurs3.task16.model.input.ServiceDto;
import vsu.kurs3.task16.repository.AutoRepository;
import vsu.kurs3.task16.repository.ServiceRepository;

@RequiredArgsConstructor
public class AssignAutoService {

	private final AutoRepository autoRepository;

	private final ServiceRepository serviceRepository;

	private final AutoRequestValidatorComponent autoRequestValidatorComponent;

	public void processRequest(AssignAutoRequest request) {
		String regNumber = request.getRegNumber();
		EventEntity eventEntity = autoRepository.findByRegnumber(regNumber);
		if (eventEntity == null) {
			throw new EventNotExistsException(regNumber);
		}

		insertServices(eventEntity.getAutoUid(), request.getServiceList());
	}

	public void processRequest(CreateAutoRequest request) {
		if (!autoRequestValidatorComponent.validate(request)) {
			throw new RuntimeException();
		}
		
		String regNumber = request.getRegNumber();
		EventEntity eventEntity = autoRepository.findByRegnumber(regNumber);
		if (eventEntity != null) {
			throw new EventAlreadyExistsException(eventEntity.getAutoUid());
		}

		eventEntity = new EventEntity();
		eventEntity.setAutoUid(UUID.randomUUID().toString());
		eventEntity.setRegNumber(regNumber);
		eventEntity.setModel(request.getModel());

		autoRepository.insert(eventEntity);

		insertServices(eventEntity.getAutoUid(), request.getServiceList());
	}

	private void insertServices(String autoUid, List<ServiceDto> serviceList) {
		serviceList.forEach(s -> {
			ServiceEntity serviceEntity = new ServiceEntity();
			serviceEntity.setServiceUid(UUID.randomUUID().toString());
			serviceEntity.setAutoUid(autoUid);
			serviceEntity.setType(s.getType());
			serviceEntity.setPlaceExecDate(s.getPlanExecDate());
			serviceEntity.setDifficulty(s.getDifficulty());

			serviceRepository.insert(serviceEntity);
		});
	}
}
