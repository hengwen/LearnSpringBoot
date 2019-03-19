package style.jason.jpademo2.domain.dto;

import style.jason.jpademo2.domain.dto.exception.ResultCode;
import style.jason.jpademo2.domain.dto.exception.TossException;

import java.io.Serializable;

public class ResultResponse<DATA> implements Serializable {

    private int code;
    private DATA data;
    private String message;

    private final static int DEFAULT_SUCCESS_CODE = 200;
    private final static String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";
    private final static String DEFAULT_ERROR_MESSAGE = "UNKNOW ERROR";

    public ResultResponse() {

    }

    public static <DATA> ResultResponse createSuccessResponse(DATA data) {
        return new ResultResponse<>().generateSuccess(data);
    }

    public static <DATA> ResultResponse createErrorResponse(ResultCode resultCode) {
        return new ResultResponse<>().generateError(resultCode);
    }

    public static <DATA> ResultResponse createErrorResponse(int code, String message, DATA data) {
        return new ResultResponse<>().generateError(code, message, data);
    }

    public static <DATA> ResultResponse createErrorResponse(TossException tossException) {
        return new ResultResponse<>().generateError(tossException);
    }

    private ResultResponse<DATA> generateSuccess(DATA data) {
        code = DEFAULT_SUCCESS_CODE;
        message = DEFAULT_SUCCESS_MESSAGE;
        this.data = data;
        return this;
    }

    private ResultResponse<DATA> generateError(ResultCode resultCode) {
        code = resultCode.code;
        message = resultCode.message;
        data = null;
        return this;
    }

    private ResultResponse<DATA> generateError(int code, String message, DATA data) {
        this.code = code;
        this.message = message;
        this.data = data;
        return this;
    }

    private ResultResponse<DATA> generateError(TossException tossException) {
        code = tossException.getCode();
        message = tossException.getMessage();
        data = null;
        return this;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DATA getData() {
        return data;
    }

    public void setData(DATA data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

