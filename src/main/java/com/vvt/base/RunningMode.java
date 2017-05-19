package com.vvt.base;

public enum RunningMode {


    NORMAL("NORMAL", 0),
    LIMITED_1("LIMITED_1", 1),
    FULL("FULL", 2);


    private String name;
    private int index;

    private RunningMode(String arg1, int arg2) {
        this.name = arg1;
        this.index = arg2;
    }
}

