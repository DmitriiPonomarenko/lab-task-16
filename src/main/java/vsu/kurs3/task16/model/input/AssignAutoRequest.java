package vsu.kurs3.task16.model.input;

import java.util.List;
import lombok.Data;

@Data
public class AssignAutoRequest {

	private String regNumber;

	private List<ServiceDto> serviceList;
}
