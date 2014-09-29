package no.lynogtorden.hjerter.event;

public class FailureEvent extends Event {
    private String message;

    public FailureEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
