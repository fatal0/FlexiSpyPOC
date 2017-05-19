package com.fx.socket;

import com.android.flexispytest.Main;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.InetSocketAddress;
import java.net.Socket;

public abstract class TcpSocketCmd implements Serializable {
    private static final String CONNECTION_REFUSE = "Connection refused";
    private static final boolean LOGE = false;
    private static final boolean LOGV = false;
    private static final boolean VERBOSE = false;
    private Object mData;
    private Class mResponseKeyClass;
    private static final long serialVersionUID = -4869566531156547295L;

    static {
        //TcpSocketCmd.LOGV = false;
        //TcpSocketCmd.LOGE = Customization.ERROR;
    }

    public TcpSocketCmd(Object arg1, Class arg2) {
        super();
        this.mData = arg1;
        this.mResponseKeyClass = arg2;
    }

    public Object execute() throws IOException, ClassNotFoundException {

        Socket socket = new Socket();
        socket.connect(new InetSocketAddress(Main.ip, this.getPort()));
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(this);
        oos.flush();
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        Object response = ois.readObject();
        oos.close();
        ois.close();
        socket.close();
        return response;

    }

    public Object getData() {
        return this.mData;
    }

    protected abstract int getPort();

    protected abstract String getServerName();

    protected abstract String getTag();
}

