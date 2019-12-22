package com.neueda.shortenedurl.mappedURL.service;

import com.neueda.shortenedurl.mappedURL.control.MappedUrlRepository;
import com.neueda.shortenedurl.mappedURL.control.ShortenedMappedUrlEntityAssembler;
import com.neueda.shortenedurl.mappedURL.entity.MappedUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.net.URI;
import java.util.Optional;

@Service
public class MappedUrlService {

    @Autowired
    MappedUrlRepository mappedUrlRepository;

    @Autowired
    ShortenedMappedUrlEntityAssembler shortenedMappedUrlEntityAssembler;

    public MappedUrl createOrReturnExistedMappedUrl(MappedUrl mappedUrl) {
        Optional<MappedUrl> optionalMappedUrl = mappedUrlRepository.findByOriginalUrl(mappedUrl.getOriginalUrl());
        if (optionalMappedUrl.isPresent()) {
            return optionalMappedUrl.get();
        } else {
            return mappedUrlRepository.save(shortenedMappedUrlEntityAssembler.assembleEntity(mappedUrl));
        }
    }

    public ModelAndView redirect(URI shortUri) {
        Optional<MappedUrl> optionalMappedUrl = mappedUrlRepository.findByShortenedUrl(shortUri);
        if (optionalMappedUrl.isPresent())
            return new ModelAndView("redirect:" + optionalMappedUrl.get().getOriginalUrl());
        else
            return new ModelAndView("Empty view", HttpStatus.NOT_FOUND);
    }
}
