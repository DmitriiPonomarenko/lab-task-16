package vsu.kurs3.task16.model.entity;

import java.time.LocalDate;
import lombok.Data;
import vsu.kurs3.task16.model.EventType;

@Data
public class ServiceEntity {

	private String serviceUid;

	private String autoUid;

	private EventType type;

	private Integer difficulty;

	private LocalDate placeExecDate;

	private LocalDate realExecDate;
}