package com.galvanize.guestbook.exception;

/**
 * APIException global application exception class.
 */
public class APIException extends Exception{

    private String errCode;
    private String errMsg;

//    public APIException() {
//    }


    public APIException(String errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
