package com.brainbox.school.dto;

/**
 * Created by adityaagrawal on 31/03/16.
 */
public class HeaderDTO {
    private String id;
    private String secret;
    private String scope;


    @Override
    public String toString() {
        return "HeaderDTO{" +
                "id='" + id + '\'' +
                ", secret='" + secret + '\'' +
                ", scope='" + scope + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
