package com.vvt.remotecontrol.input;

import com.vvt.base.RunningMode;
import java.io.Serializable;

public class RmtCtrlInputRunningMode implements Serializable {
    private RunningMode mRunningMode;
    private static final long serialVersionUID = -1911685578861733038L;

    public RmtCtrlInputRunningMode() {
        super();
    }

    public RunningMode getRunningMode() {
        return this.mRunningMode;
    }

    public void setRunningMode(RunningMode arg1) {
        this.mRunningMode = arg1;
    }
}

