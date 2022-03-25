package vsu.kurs3.task16.component;

import java.util.Set;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import vsu.kurs3.task16.model.input.CreateAutoRequest;

public class AutoRequestValidatorComponent {

	private final ValidatorFactory timetable = Validation.buildDefaultValidatorFactory();

	private final Validator validator = timetable.getValidator();

	public boolean validate(CreateAutoRequest request) {
		Set<ConstraintViolation<CreateAutoRequest>> errors = validator.validate(request);

		return errors.isEmpty();
	}
}
