package io.github.jonaslins.urlshortener.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.util.Assert;

@Document("request_info")
public class RequestInfo {

    @Id
    private String id;
    @Indexed
    private String shortUrlCode;
    private String ipAddress;
    private String userAgent;
    private String referrer;
    private String agentClass;
    private String agentName;
    private String agentVersion;
    private String operatingSystemClass;
    private String operatingSystemName;
    private String operatingSystemVersion;
    private String deviceClass;
    private String deviceName;
    private String deviceBrand;

    private RequestInfo(String shortUrlCode, String ipAddress, String userAgent) {
        this.shortUrlCode = shortUrlCode;
        this.ipAddress = ipAddress;
        this.userAgent = userAgent;
    }

    public static RequestInfo of(String shortUrlCode, String ipAddress, String userAgent) {
        Assert.hasText(shortUrlCode, "The shortUrlCode argument must have text; it must not be null, empty, or blank");
        Assert.hasText(ipAddress, "The ipAddress argument must have text; it must not be null, empty, or blank");
        Assert.hasText(userAgent, "The userAgent argument must have text; it must not be null, empty, or blank");
        return new RequestInfo(shortUrlCode, ipAddress, userAgent);
    }

    public String getId() {
        return id;
    }

    public String getShortUrlCode() {
        return shortUrlCode;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public String getReferrer() {
        return referrer;
    }

    public void setReferrer(String referrer) {
        this.referrer = referrer;
    }

    public String getAgentClass() {
        return agentClass;
    }

    public void setAgentClass(String agentClass) {
        this.agentClass = agentClass;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getAgentVersion() {
        return agentVersion;
    }

    public void setAgentVersion(String agentVersion) {
        this.agentVersion = agentVersion;
    }

    public String getOperatingSystemClass() {
        return operatingSystemClass;
    }

    public void setOperatingSystemClass(String operatingSystemClass) {
        this.operatingSystemClass = operatingSystemClass;
    }

    public String getOperatingSystemName() {
        return operatingSystemName;
    }

    public void setOperatingSystemName(String operatingSystemName) {
        this.operatingSystemName = operatingSystemName;
    }

    public String getOperatingSystemVersion() {
        return operatingSystemVersion;
    }

    public void setOperatingSystemVersion(String operatingSystemVersion) {
        this.operatingSystemVersion = operatingSystemVersion;
    }

    public String getDeviceClass() {
        return deviceClass;
    }

    public void setDeviceClass(String deviceClass) {
        this.deviceClass = deviceClass;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceBrand() {
        return deviceBrand;
    }

    public void setDeviceBrand(String deviceBrand) {
        this.deviceBrand = deviceBrand;
    }
}
