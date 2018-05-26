package com.test;

public enum WhoIsRIR {
    ARIN("whois.arin.net"),
    RIPE("whois.ripe.net"),
    APNIC("whois.apnic.net"),
    AFRINIC("whois.afrinic.net"),
    LACNIC("whois.lacnic.net");
 
    private String url;

    WhoIsRIR(String url) {
        this.url = url;
    }

    public String url() {
        return url;
    }
}
