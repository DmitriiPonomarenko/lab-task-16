package vsu.kurs3.task16.model.input;

import java.time.LocalDate;
import lombok.Data;
import vsu.kurs3.task16.model.EventType;

@Data
public class ServiceDto {

	private EventType type;

	private Integer difficulty;

	private LocalDate planExecDate;
}
