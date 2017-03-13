package sms.backup.tech.soft.applock.model;

import android.graphics.drawable.Drawable;

/**
 * Created by dee on 11/03/2017.
 */

public class AppRunning {
    private int uId;
    private String name;
    private String packetName;
    private Drawable ico;
    private float perApp;
    private long cuTime;
    private long csTime;
    private long startTime;

    public AppRunning() {
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPacketName() {
        return packetName;
    }

    public void setPacketName(String packetName) {
        this.packetName = packetName;
    }

    public Drawable getIco() {
        return ico;
    }

    public void setIco(Drawable ico) {
        this.ico = ico;
    }

    public float getPerApp() {
        return perApp;
    }

    public void setPerApp(float perApp) {
        this.perApp = perApp;
    }

    public long getCuTime() {
        return cuTime;
    }

    public void setCuTime(long cuTime) {
        this.cuTime = cuTime;
    }

    public long getCsTime() {
        return csTime;
    }

    public void setCsTime(long csTime) {
        this.csTime = csTime;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public AppRunning(int uId, String name, String packetName, Drawable ico, float perApp, long cuTime, long csTime, long startTime) {

        this.uId = uId;
        this.name = name;
        this.packetName = packetName;
        this.ico = ico;
        this.perApp = perApp;
        this.cuTime = cuTime;
        this.csTime = csTime;
        this.startTime = startTime;
    }
}
