package com.app1x.shark;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nikojpapa on 8/30/16.
 */
public class Request {
    String mUsername;
    Object mLocation;
    String mDeviceId;
    List<String> mNearbyDevices;
    int mPartyId;
    boolean mConfirmation;

    public Request(String username, Object location, String deviceId, List<String> nearbyDevices,
     int partyId) {
        mUsername= username;
        mLocation= location;
        mDeviceId= deviceId;
        mNearbyDevices= nearbyDevices;
        mPartyId= partyId;
    }

    //set properties
    private void setUsername(String username) {
        mUsername= username;
    }
    private void setLocation(Object location) {
        mLocation= location;
    }
    private void setDeviceId(String deviceId) {
        mDeviceId= deviceId;
    }
    private void setNearbyDevices(List<String> nearbyDevices) {
        mNearbyDevices= nearbyDevices;
    }
    private void setPartyId(int partyId) {
        mPartyId= partyId;
    }
    private void setConfirmation(boolean confirmation) {
        mConfirmation= confirmation;
    }

    //get properties
    public String getUsername() {
        return mUsername;
    }
    public Object getLocation() {
        return mLocation;
    }
    public String getDeviceId() {
        return mDeviceId;
    }
    public List<String> getNearbyDevices() {
        return mNearbyDevices;
    }
    public int getPartyId() {
        return mPartyId;
    }
    public boolean getConfirmation() {
        return mConfirmation;
    }
}
