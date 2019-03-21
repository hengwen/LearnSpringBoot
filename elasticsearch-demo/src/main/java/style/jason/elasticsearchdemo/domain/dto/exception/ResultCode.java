package style.jason.elasticsearchdemo.domain.dto.exception;

public enum ResultCode {
    UNKNOWN_ERROR(1001, "未知错误"),
    USER_NOT_FOUND(5001, "用户不存在");

    public final int code;
    public final String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
