package out.Homework10;

import java.util.Objects;

public class Log{
    private String timestamp;
    private String level;
    private String logger;
    private String message;
    private String source;

    public Log(String timestamp, String level, String logger, String message, String source) {
        this.timestamp = timestamp;
        this.level = level;
        this.logger = logger;
        this.message = message;
        this.source = source;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLogger() {
        return logger;
    }

    public void setLogger(String logger) {
        this.logger = logger;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return "Log{" +
                "timestamp='" + timestamp + '\'' +
                ", level='" + level + '\'' +
                ", logger='" + logger + '\'' +
                ", message='" + message + '\'' +
                ", source='" + source + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Log log = (Log) o;
        if (this.message.compareTo(log.message) == 0) {
            return true;
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(message);
    }
}
