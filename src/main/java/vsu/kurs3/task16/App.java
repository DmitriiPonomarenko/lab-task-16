package vsu.kurs3.task16;

import vsu.kurs3.task16.component.AutoRequestValidatorComponent;
import vsu.kurs3.task16.model.input.CreateAutoRequest;
import vsu.kurs3.task16.repository.AutoRepository;
import vsu.kurs3.task16.repository.ServiceRepository;
import vsu.kurs3.task16.service.AssignAutoService;

public class App {

	public static void main(String[] args) {
		AssignAutoService assignAutoService = new AssignAutoService(new AutoRepository(), new ServiceRepository(), new AutoRequestValidatorComponent());
		CreateAutoRequest request = new CreateAutoRequest();
		request.setModel("xyz");
		request.setMark("abc");
		request.setColor("white");
		request.setYob(2016);
		assignAutoService.processRequest(request);
	}
}
