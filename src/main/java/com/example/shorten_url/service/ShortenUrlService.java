package com.example.shorten_url.service;

import com.example.shorten_url.domain.model.entity.ShortenUrlData;
import com.example.shorten_url.repository.ShortenUrlDataRepository;
import com.example.shorten_url.repository.ShortenUrlSeqRepository;
import com.example.shorten_url.util.Base62Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ShortenUrlService {
	@Autowired
    ShortenUrlSeqRepository seqRepository;
    @Autowired
    ShortenUrlDataRepository dataRepository;
    @Autowired
    Base62Util base62Util;
    
    public String CreateShortenUrl(String targetUrl) {
        // Check Already Created URL
        if(dataRepository.existsByTargetUrl(targetUrl)) {
            log.info("Already exists URL : " + targetUrl);
            ShortenUrlData findData = dataRepository.findByTargetUrl(targetUrl);
            String shortenUrl = findData.getShortenUrl();
            return shortenUrl;
        }

        // 신규 URL 생성
        Long id = seqRepository.nextId();
        String encodedId = base62Util.Encode(id);

        log.info(id + "=>" + encodedId);
        
        // TODO baseURL을 config로
        ShortenUrlData data = new ShortenUrlData();
        String shortenUrl = "http://localhost:8080/shortenURL/" + encodedId;
        data.setBase62Id(encodedId);
        data.setTargetUrl(targetUrl);
        data.setShortenUrl(shortenUrl);
        data = dataRepository.save(data);

        return shortenUrl;
    }

    public Iterable<ShortenUrlData> findAllShortenUrl() {
        Iterable<ShortenUrlData> dataList = dataRepository.findAll();
        return dataList;
    }

    public String findTargetUrl(String id) {
        ShortenUrlData data = dataRepository.findByBase62Id(id);
        return data.getTargetUrl();
    }
}