package com.sb.models;

import jakarta.persistence.*;

@Entity(name = "url")
@Table(name = "url")
public class UrlEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_url")
    private String fullUrl;

    @Column(name = "short_url")
    private String shortUrl;

    public UrlEntity() {}

    public UrlEntity(Long id, String fullUrl, String shortUrl) {
        this.id = id;
        this.fullUrl = fullUrl;
        this.shortUrl = shortUrl;
    }

    public UrlEntity(String fullUrl) {
        this.fullUrl = fullUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullUrl() {
        return fullUrl;
    }

    public void setFullUrl(String fullUrl) {
        this.fullUrl = fullUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    @Override
    public String toString() {
        return "Url{" +
                "id=" + id +
                ", fullUrl='" + fullUrl + '\'' +
                ", shortUrl='" + shortUrl + '\'' +
                '}';
    }
}