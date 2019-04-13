/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *
 * @author thoma
 */
public class Message {
    private String msg;
    private String origin;

    public Message() {
        msg = null;
        origin = null;
    }

    public Message(String msg) {
        this.msg = msg;
        origin = null;
    }

    public Message(String msg, String origin) {
        this.msg = msg;
        this.origin = origin;
    }
    
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getOrigin() {
        return origin;
    }

    @Override
    public String toString() {
        return "Message{" + "msg=" + msg + ", origin=" + origin + '}';
    }
}
