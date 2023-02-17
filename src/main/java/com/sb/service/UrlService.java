package com.sb.service;

import com.sb.common.ShortUtil;
import com.sb.dto.FullUrl;
import com.sb.dto.ShortUrl;
import com.sb.models.UrlEntity;
import com.sb.repo.UrlRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UrlService {

    private final UrlRepo urlRepository;

    @Autowired
    public UrlService(UrlRepo urlRepository) {
        this.urlRepository = urlRepository;
    }

    private UrlEntity get(Long id) {
        UrlEntity urlEntity = urlRepository.findById(id).get();
        return urlEntity;
    }

    public FullUrl getFullUrl(String shortenString) {
        Long id = ShortUtil.strToId(shortenString);
        return new FullUrl(this.get(id).getFullUrl());
    }

    private UrlEntity save(FullUrl fullUrl) {
        return urlRepository.save(new UrlEntity(fullUrl.getFullUrl()));
    }

    public ShortUrl getShortUrl(FullUrl fullUrl) {
        List<UrlEntity> savedUrls = null;
        savedUrls = checkFullUrlAlreadyExists(fullUrl);

        UrlEntity savedUrl = null;

        if (savedUrls.isEmpty()) {
            savedUrl = this.save(fullUrl);
        }
        else {
            savedUrl = savedUrls.get(0);
        }

        String shortUrlText = ShortUtil.idToStr(savedUrl.getId());
        return new ShortUrl(shortUrlText);
    }

    private List<UrlEntity> checkFullUrlAlreadyExists(FullUrl fullUrl) {
        return urlRepository.findUrlByFullUrl(fullUrl.getFullUrl());
    }
}