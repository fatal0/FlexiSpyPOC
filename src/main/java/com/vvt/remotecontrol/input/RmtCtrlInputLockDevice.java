package com.vvt.remotecontrol.input;

import java.io.Serializable;

public class RmtCtrlInputLockDevice implements Serializable {
    public String displayMessage;
    public boolean isScream;
    private static final long serialVersionUID = -7091485944237325564L;

    public RmtCtrlInputLockDevice() {
        super();
        this.isScream = false;
        this.displayMessage = null;
    }
}

