package com.training.springcore.model;

import org.springframework.beans.factory.annotation.Value;

import java.util.Set;

public class ApplicationInfo {

    private String name;
    private Set<String> emails;
    @Value("${bigcorp.webSiteUrl}")
    private String webSiteUrl;
    private Integer version;

    public ApplicationInfo(String name, Integer version, Set<String> emails) {
        this.name = name;
        this.emails = emails;
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public Integer getVersion() {
        return version;
    }

    public Set<String> getEmails() {
        return emails;
    }

    public String getWebSiteUrl() {
        return webSiteUrl;
    }

    @Override
    public String toString() {
        return "ApplicationInfo{" +
                "name='" + name + '\'' +
                ", version=" + version +
                ", emails=" + emails +
                ", webSiteUrl='" + webSiteUrl + '\'' +
                '}';
    }
}
