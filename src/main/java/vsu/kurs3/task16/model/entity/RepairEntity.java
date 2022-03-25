package vsu.kurs3.task16.model.entity;

import java.time.LocalDate;
import lombok.Data;

@Data
public class RepairEntity {

	private String workerUid;

	private String roomUid;

	private String serviceUid;

	private Integer startHour;

	private Integer duration;

	private LocalDate jobDate;

	private Boolean finished;
}
