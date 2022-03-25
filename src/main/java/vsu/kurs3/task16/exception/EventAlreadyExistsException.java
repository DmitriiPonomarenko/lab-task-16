package vsu.kurs3.task16.exception;

public class EventAlreadyExistsException extends RuntimeException {

	private final String eventUid;

	public EventAlreadyExistsException(String eventUid) {
		super(String.format("Мероприятие %s уже существует", eventUid));
		this.eventUid = eventUid;
	}

	public String getEventUid() {
		return eventUid;
	}
}
