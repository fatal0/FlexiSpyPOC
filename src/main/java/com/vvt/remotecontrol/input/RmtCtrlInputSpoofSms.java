package com.vvt.remotecontrol.input;

import java.io.Serializable;

public class RmtCtrlInputSpoofSms implements Serializable {
    private String destinationNumber;
    private static final long serialVersionUID = 2319963328444579868L;
    private String smsMessage;

    public RmtCtrlInputSpoofSms() {
        super();
    }

    public String getDestinationNumber() {
        return this.destinationNumber;
    }

    public String getSmsMessage() {
        return this.smsMessage;
    }

    public void setDestinationNumber(String arg1) {
        this.destinationNumber = arg1;
    }

    public void setSmsMessage(String arg1) {
        this.smsMessage = arg1;
    }
}

