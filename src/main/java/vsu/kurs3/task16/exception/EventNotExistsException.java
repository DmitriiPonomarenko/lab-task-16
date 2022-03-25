package vsu.kurs3.task16.exception;

public class EventNotExistsException extends RuntimeException {

	private final String eventNumber;

	public EventNotExistsException(String eventNumber) {
		super(String.format("Мероприятие %s не существует", eventNumber));
		this.eventNumber = eventNumber;
	}

	public String getEventNubmer() {
		return eventNumber;
	}
}
