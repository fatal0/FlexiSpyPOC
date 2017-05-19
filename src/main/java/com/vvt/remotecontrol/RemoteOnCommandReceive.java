package com.vvt.remotecontrol;

import com.fx.socket.TcpSocketCmd;

public class RemoteOnCommandReceive extends TcpSocketCmd {
    private static final String TAG = "RemoteOnCommandReceive";
    private static final long serialVersionUID = 169130551510599370L;

    public RemoteOnCommandReceive(ControlCommand arg2) {
        super(arg2, Object.class);
    }

    protected int getPort() {
        return 12512;
    }

    protected String getServerName() {
        return "com.vvt.rmtctrl.server";
    }

    protected String getTag() {
        return "RemoteOnCommandReceive";
    }
}

