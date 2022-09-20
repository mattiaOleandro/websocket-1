package co.develhope.websocket1.entities;

public class MessageDTO {

    private String type;
    private String message;

    public MessageDTO() {
    }

    public MessageDTO(String type, String message) {
        this.setType(type);
        this.setMessage(message);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "MessageDTO{" +
                "type='" + getType() + '\'' +
                ", message='" + getMessage() + '\'' +
                '}';
    }
}