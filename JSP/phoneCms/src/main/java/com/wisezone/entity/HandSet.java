package com.wisezone.entity;

import java.io.Serializable;
import java.util.Objects;

public class HandSet implements Serializable {
    private int hsId;
    private String nameType;
    private double price;
    private String networkMode;
    private String networkType;
    private String facade;
    private String screenSize;
    private String feelScreen;

    public HandSet(int hsId, String nameType, double price, String networkMode, String networkType, String facade, String screenSize, String feelScreen) {
        this.hsId = hsId;
        this.nameType = nameType;
        this.price = price;
        this.networkMode = networkMode;
        this.networkType = networkType;
        this.facade = facade;
        this.screenSize = screenSize;
        this.feelScreen = feelScreen;
    }

    public HandSet() {
    }

    @Override
    public String toString() {
        return "HandSet{" +
                "hsId=" + hsId +
                ", nameType='" + nameType + '\'' +
                ", price=" + price +
                ", networkMode='" + networkMode + '\'' +
                ", networkType='" + networkType + '\'' +
                ", facade='" + facade + '\'' +
                ", screenSize='" + screenSize + '\'' +
                ", feelScreen='" + feelScreen + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HandSet handSet = (HandSet) o;
        return hsId == handSet.hsId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hsId);
    }

    public int getHsId() {
        return hsId;
    }

    public void setHsId(int hsId) {
        this.hsId = hsId;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getNetworkMode() {
        return networkMode;
    }

    public void setNetworkMode(String networkMode) {
        this.networkMode = networkMode;
    }

    public String getNetworkType() {
        return networkType;
    }

    public void setNetworkType(String networkType) {
        this.networkType = networkType;
    }

    public String getFacade() {
        return facade;
    }

    public void setFacade(String facade) {
        this.facade = facade;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    public String getFeelScreen() {
        return feelScreen;
    }

    public void setFeelScreen(String feelScreen) {
        this.feelScreen = feelScreen;
    }
}
