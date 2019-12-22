package com.neueda.shortenedurl.mappedURL.boundary;

import com.neueda.shortenedurl.mappedURL.entity.MappedUrl;
import com.neueda.shortenedurl.mappedURL.service.MappedUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.net.URI;

@RestController
public class MappedUrlController {

    @Autowired
    private MappedUrlService mappedUrlService;

    @PostMapping("mapped-urls")
    public ResponseEntity<MappedUrl> makeShortUrl(@RequestBody MappedUrl mappedUrlRequest) {
        if (mappedUrlRequest.getOriginalUrl() == null)
            ResponseEntity.status(HttpStatus.BAD_REQUEST);
        MappedUrl existedOrCreatedMappedUrl = mappedUrlService.createOrReturnExistedMappedUrl(mappedUrlRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(existedOrCreatedMappedUrl);
    }

    @GetMapping("mapped-urls")
    public ModelAndView retrieveShortenedUrl(@RequestParam("shortUri") URI shortUri) {
        if (shortUri == null)
            ResponseEntity.status(HttpStatus.BAD_REQUEST);
        return mappedUrlService.redirect(shortUri);
    }
}
