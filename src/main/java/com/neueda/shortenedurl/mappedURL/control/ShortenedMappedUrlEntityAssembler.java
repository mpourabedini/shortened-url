package com.neueda.shortenedurl.mappedURL.control;

import com.neueda.shortenedurl.mappedURL.entity.MappedUrl;
import org.springframework.stereotype.Component;

@Component
public class ShortenedMappedUrlEntityAssembler {

    public MappedUrl assembleEntity(MappedUrl mappedUrl) {
        mappedUrl.setShortenedUrl(ShortUrlGenerator.generateRandomShortUrl());
        return mappedUrl;
    }
}
