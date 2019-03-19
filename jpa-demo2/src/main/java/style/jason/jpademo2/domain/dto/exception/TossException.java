package style.jason.jpademo2.domain.dto.exception;

public class TossException extends RuntimeException {

    private int code;
    private String message;

    public TossException(Throwable throwable) {
        super(throwable);
    }

    public TossException(String message) {
        super(message);
    }

    public TossException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public TossException(ResultCode resultCode) {
        code = resultCode.code;
        message = resultCode.message;
    }

    public TossException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        String s = this.getClass().getName() + ", code:" + this.code + (this.message == null ? "" : ",msg:" + this.message);
        String message = this.getLocalizedMessage();
        return message != null ? s + ": " + message : s;
    }
}
