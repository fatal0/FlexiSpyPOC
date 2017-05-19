package com.vvt.remotecontrol;

import java.io.Serializable;

public class ControlCommand implements Serializable {
    private Object data;
    private RemoteFunction function;
    private static final long serialVersionUID = -5746797506814872054L;

    public ControlCommand() {
        super();
    }

    public ControlCommand(RemoteFunction arg1, Object arg2) {
        super();
        this.function = arg1;
        this.data = arg2;
    }

    public boolean equals(Object arg8) {
        boolean v3 = true;
        if((arg8 instanceof ControlCommand)) {
            Object v2 = arg8;
            int v1 = this.data != null || ((ControlCommand)v2).data != null ? 0 : 1;
            int v0 = this.data == null || !this.data.equals(((ControlCommand)v2).data) ? 0 : 1;
            if(this.function == ((ControlCommand)v2).function) {
                if(v1 != 0) {
                }
                else if(v0 == 0) {
                    v3 = false;
                }

                return v3;
            }

            v3 = false;
        }
        else {
            v3 = false;
        }

        return v3;
    }

    public Object getData() {
        return this.data;
    }

    public RemoteFunction getFunction() {
        return this.function;
    }

    public void setData(Object arg1) {
        this.data = arg1;
    }

    public void setFunction(RemoteFunction arg1) {
        this.function = arg1;
    }

    public String toString() {
        return String.format("func: %s, data: %s", this.function, this.data);
    }
}

