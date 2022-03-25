package vsu.kurs3.task16.model.input;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CreateAutoRequest extends AssignAutoRequest {

	@NotBlank
	private String model;

	@NotBlank
	private String mark;

	@NotBlank
	private String color;

	@NotNull
	@Min(1950)
	private Integer yob;
}
