package com.springrest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MemberLogin {

    @SerializedName("access_token")
    @Expose
    private String accessToken;
    @SerializedName("instance_url")
    @Expose
    private String instanceUrl;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("token_type")
    @Expose
    private String tokenType;
    @SerializedName("issued_at")
    @Expose
    private String issuedAt;
    @SerializedName("signature")
    @Expose
    private String signature;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getInstanceUrl() {
        return instanceUrl;
    }

    public void setInstanceUrl(String instanceUrl) {
        this.instanceUrl = instanceUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getIssuedAt() {
        return issuedAt;
    }

    public void setIssuedAt(String issuedAt) {
        this.issuedAt = issuedAt;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        return "MemberLogin{" +
                "accessToken='" + accessToken + '\'' +
                ", instanceUrl='" + instanceUrl + '\'' +
                ", id='" + id + '\'' +
                ", tokenType='" + tokenType + '\'' +
                ", issuedAt='" + issuedAt + '\'' +
                ", signature='" + signature + '\'' +
                '}';
    }
}