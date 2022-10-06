package com.example.servercontrol.enumeration;

public enum Status {
    server_up("SERVER_UP"),
    server_down("SERVER_DOWN");

    private final String status;

    public String getStatus() {
        return status;
    }
    Status(String status) {
        this.status = status;
    }
}
