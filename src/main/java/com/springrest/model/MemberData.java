package com.springrest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MemberData {

    @SerializedName("attributes")
    @Expose
    private MemberAttributes attributes;
    @SerializedName("Id")
    @Expose
    private String id;
    @SerializedName("Contact__c")
    @Expose
    private String contactC;
    @SerializedName("Role__c")
    @Expose
    private String roleC;

    public MemberAttributes getAttributes() {
        return attributes;
    }

    public void setAttributes(MemberAttributes attributes) {
        this.attributes = attributes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContactC() {
        return contactC;
    }

    public void setContactC(String contactC) {
        this.contactC = contactC;
    }

    public String getRoleC() {
        return roleC;
    }

    public void setRoleC(String roleC) {
        this.roleC = roleC;
    }

}