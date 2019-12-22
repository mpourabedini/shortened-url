package com.neueda.shortenedurl.mappedURL.control;

import com.neueda.shortenedurl.mappedURL.entity.MappedUrl;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.net.URI;
import java.util.Optional;

public interface MappedUrlRepository extends CrudRepository<MappedUrl, Long> {

    @Query("SELECT m FROM MappedUrl m WHERE m.originalUrl = ':shortUri'")
    Optional<MappedUrl> findByOriginalUrl(@Param("originalUri") URI originalUri);

    @Query("SELECT m FROM MappedUrl m WHERE m.shortenedUrl = ':shortUri'")
    Optional<MappedUrl> findByShortenedUrl(@Param("shortUri") URI shortUri);
}
