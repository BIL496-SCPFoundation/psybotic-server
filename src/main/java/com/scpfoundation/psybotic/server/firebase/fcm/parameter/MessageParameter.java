package com.scpfoundation.psybotic.server.firebase.fcm.parameter;
public enum MessageParameter {
    SOUND("default"),
    COLOR("#FFFF00");

    private String value;

    MessageParameter(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
