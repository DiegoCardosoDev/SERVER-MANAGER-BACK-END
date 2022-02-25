package com.diego.manager.server.enumeration;

/*ESSA CLASSE REPRESENTA O STATUS DO SERVIDOR*/


public enum Status {

    SERVER_UP("SERVER_UP"),
    SERVER_DOWN("SERVER_DOWN");

    private final String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus(){
        return this.status;
    }
}
