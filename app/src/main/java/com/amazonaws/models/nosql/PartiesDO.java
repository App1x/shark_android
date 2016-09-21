package com.amazonaws.models.nosql;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBIndexHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBIndexRangeKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBRangeKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;

import java.util.List;
import java.util.Map;
import java.util.Set;

@DynamoDBTable(tableName = "shark-mobilehub-626415116-Parties")

public class PartiesDO {
    private String _userId;
    private String _partyId;
    private String _currentDJ;
    private Double _currentDJIndex;
    private List<String> _currentUsers;
    private Map<String, String> _location;

    @DynamoDBHashKey(attributeName = "userId")
    @DynamoDBAttribute(attributeName = "userId")
    public String getUserId() {
        return _userId;
    }

    public void setUserId(final String _userId) {
        this._userId = _userId;
    }
    @DynamoDBRangeKey(attributeName = "partyId")
    @DynamoDBAttribute(attributeName = "partyId")
    public String getPartyId() {
        return _partyId;
    }

    public void setPartyId(final String _partyId) {
        this._partyId = _partyId;
    }
    @DynamoDBAttribute(attributeName = "currentDJ")
    public String getCurrentDJ() {
        return _currentDJ;
    }

    public void setCurrentDJ(final String _currentDJ) {
        this._currentDJ = _currentDJ;
    }
    @DynamoDBAttribute(attributeName = "currentDJ_index")
    public Double getCurrentDJIndex() {
        return _currentDJIndex;
    }

    public void setCurrentDJIndex(final Double _currentDJIndex) {
        this._currentDJIndex = _currentDJIndex;
    }
    @DynamoDBAttribute(attributeName = "currentUsers")
    public List<String> getCurrentUsers() {
        return _currentUsers;
    }

    public void setCurrentUsers(final List<String> _currentUsers) {
        this._currentUsers = _currentUsers;
    }
    @DynamoDBAttribute(attributeName = "location")
    public Map<String, String> getLocation() {
        return _location;
    }

    public void setLocation(final Map<String, String> _location) {
        this._location = _location;
    }

}
