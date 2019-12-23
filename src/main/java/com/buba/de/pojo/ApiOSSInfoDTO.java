package com.buba.de.pojo;

import java.io.Serializable;

public class ApiOSSInfoDTO implements Serializable {
    private String securityToken;
    private String accessKeyId;
    private String accessKeySecret;
    private String expiration;
    private String callbackHost;
    private String callbackUrl;
    private String postPolicy;
    private String bucketName;
    private String dir;
    private String endopint;

    @Override
    public String toString() {
        return "ApiOSSInfoDTO{" +
                "securityToken='" + securityToken + '\'' +
                ", accessKeyId='" + accessKeyId + '\'' +
                ", accessKeySecret='" + accessKeySecret + '\'' +
                ", expiration='" + expiration + '\'' +
                ", callbackHost='" + callbackHost + '\'' +
                ", callbackUrl='" + callbackUrl + '\'' +
                ", postPolicy='" + postPolicy + '\'' +
                ", bucketName='" + bucketName + '\'' +
                ", dir='" + dir + '\'' +
                ", endopint='" + endopint + '\'' +
                '}';
    }

    public String getSecurityToken() {
        return securityToken;
    }

    public void setSecurityToken(String securityToken) {
        this.securityToken = securityToken;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public String getCallbackHost() {
        return callbackHost;
    }

    public void setCallbackHost(String callbackHost) {
        this.callbackHost = callbackHost;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public String getPostPolicy() {
        return postPolicy;
    }

    public void setPostPolicy(String postPolicy) {
        this.postPolicy = postPolicy;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getEndopint() {
        return endopint;
    }

    public void setEndopint(String endopint) {
        this.endopint = endopint;
    }
}
