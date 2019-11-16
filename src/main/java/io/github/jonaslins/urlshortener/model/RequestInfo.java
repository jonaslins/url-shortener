package io.github.jonaslins.urlshortener.model;

public class RequestInfo {

    private String IPAddress;
    private String referrer;
    private String originalUserAgent;
    private String agentClass;
    private String agentName;
    private String agentVersion;
    private String operatingSystemClass;
    private String operatingSystemName;
    private String operatingSystemVersion;
    private String deviceClass;
    private String deviceName;
    private String deviceBrand;

    public RequestInfo() {
    }

    public String getIPAddress() {
        return IPAddress;
    }

    public void setIPAddress(String IPAddress) {
        this.IPAddress = IPAddress;
    }

    public String getReferrer() {
        return referrer;
    }

    public void setReferrer(String referrer) {
        this.referrer = referrer;
    }

    public String getOriginalUserAgent() {
        return originalUserAgent;
    }

    public void setOriginalUserAgent(String originalUserAgent) {
        this.originalUserAgent = originalUserAgent;
    }

    public void setAgentClass(String agentClass) {
        this.agentClass = agentClass;
    }

    public String getAgentClass() {
        return agentClass;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentVersion(String agentVersion) {
        this.agentVersion = agentVersion;
    }

    public String getAgentVersion() {
        return agentVersion;
    }

    public void setOperatingSystemClass(String operatingSystemClass) {
        this.operatingSystemClass = operatingSystemClass;
    }

    public String getOperatingSystemClass() {
        return operatingSystemClass;
    }

    public void setOperatingSystemName(String operatingSystemName) {
        this.operatingSystemName = operatingSystemName;
    }

    public String getOperatingSystemName() {
        return operatingSystemName;
    }

    public void setOperatingSystemVersion(String operatingSystemVersion) {
        this.operatingSystemVersion = operatingSystemVersion;
    }

    public String getOperatingSystemVersion() {
        return operatingSystemVersion;
    }

    public String getDeviceClass() {
        return deviceClass;
    }

    public void setDeviceClass(String deviceClass) {
        this.deviceClass = deviceClass;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceBrand(String deviceBrand) {
        this.deviceBrand = deviceBrand;
    }

    public String getDeviceBrand() {
        return deviceBrand;
    }
}
