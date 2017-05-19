package com.vvt.remotecontrol.output;

import java.io.Serializable;

public class RmtCtrlOutputStatusMessage implements Serializable {
    private boolean isSuccess;
    private String message;
    private static final long serialVersionUID = 6704006669196536832L;

    public RmtCtrlOutputStatusMessage() {
        super();
    }

    public String getMessage() {
        return this.message;
    }

    public boolean isSuccess() {
        return this.isSuccess;
    }

    public void setMessage(String arg1) {
        this.message = arg1;
    }

    public void setSuccess(boolean arg1) {
        this.isSuccess = arg1;
    }
}

