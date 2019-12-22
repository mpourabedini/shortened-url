package com.neueda.shortenedurl.mappedURL.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Random;

public class ShortUrlGenerator {

    public static URI generateRandomShortUrl() {
        URI uri;
        try {
            Random rand = new Random();
            int urlLen = 6;
            char[] shortURL = new char[urlLen];
            String randChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
            for (int i = 0; i < urlLen; i++)
                shortURL[i] = randChars.charAt(rand.nextInt(randChars.length()));
            StringBuilder sb = new StringBuilder("http://shortUrl.com/");
            sb.append(new String(shortURL));
            uri = new URI(sb.toString());
        } catch (URISyntaxException exception) {
            throw new RuntimeException("Url is wrong");
        }
        return uri;
    }
}
