package com.srdz.demo.domain;

public class CommonReturn {
    private int code;
    private String success;

    public CommonReturn success(){
        CommonReturn commonReturn=new CommonReturn();
        commonReturn.setCode(200);
        commonReturn.setSuccess("SUCCESS");
        return commonReturn;
    }

    public CommonReturn fail(){
        CommonReturn commonReturn=new CommonReturn();
        commonReturn.setCode(500);
        commonReturn.setSuccess("fail");
        return commonReturn;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }
}
