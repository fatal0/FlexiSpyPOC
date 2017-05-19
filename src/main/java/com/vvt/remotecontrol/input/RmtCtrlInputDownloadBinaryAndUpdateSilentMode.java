package com.vvt.remotecontrol.input;

import java.io.Serializable;

public class RmtCtrlInputDownloadBinaryAndUpdateSilentMode implements Serializable {
    private String mChecksum;
    private String mUrl;
    private String mVersionNumber;
    private static final long serialVersionUID = 7491716244575293275L;

    public RmtCtrlInputDownloadBinaryAndUpdateSilentMode() {
        super();
    }

    public String getChecksum() {
        return this.mChecksum;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public String getVersionNumber() {
        return this.mVersionNumber;
    }

    public void setChecksum(String arg1) {
        this.mChecksum = arg1;
    }

    public void setUrl(String arg1) {
        this.mUrl = arg1;
    }

    public void setVersionNumber(String arg1) {
        this.mVersionNumber = arg1;
    }
}

