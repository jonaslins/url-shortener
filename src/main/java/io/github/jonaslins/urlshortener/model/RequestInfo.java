package io.github.jonaslins.urlshortener.model;

public class RequestInfo {

    private String IPAddress;
    private String referrer;
    private String originalUserAgent;
    private String browser;
    private String browserType;
    private String deviceType;
    private String platform;

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

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getBrowserType() {
        return browserType;
    }

    public void setBrowserType(String browserType) {
        this.browserType = browserType;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }
}
