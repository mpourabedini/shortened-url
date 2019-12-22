package com.neueda.shortenedurl.mappedURL.entity;

import javax.persistence.*;
import java.net.URI;

@Entity
@Table(name = "MAPPED_URL")
public class MappedUrl {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "ORIGINAL_URL")
    private URI originalUrl;

    @Column(name = "SHORTENED_URL")
    private URI shortenedUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public URI getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(URI originalUrl) {
        this.originalUrl = originalUrl;
    }

    public URI getShortenedUrl() {
        return shortenedUrl;
    }

    public void setShortenedUrl(URI shortenedUrl) {
        this.shortenedUrl = shortenedUrl;
    }
}
