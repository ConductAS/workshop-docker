package no.conduct.domain;

import javax.validation.constraints.NotNull;

public class News {

    @NotNull
    private String ingress;

    @NotNull
    private String body;

    public News(String ingress, String body) {
        this.ingress = ingress;
        this.body = body;
    }

    public String getIngress() {
        return ingress;
    }

    public void setIngress(String ingress) {
        this.ingress = ingress;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}
