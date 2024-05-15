package com.demo.wordchecker.cache;

import com.demo.wordchecker.model.Palindrome;
import com.demo.wordchecker.repository.PalindromeRepositoryImp;
import jakarta.annotation.PostConstruct;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@Profile("!test")
public class CacheLoad {

    @Autowired
    private CacheManager cacheManager;
    
    @Autowired
    private PalindromeRepositoryImp palidroneRepository;

    @Value("${cache.palindrome}")
    private String cacheName;
    
    @PostConstruct
    public void init(){
        load();
    }
    
    public void load(){
        List<Palindrome> initialLoad = palidroneRepository.findAll();
        initialLoad.forEach( p -> cacheManager.getCache(cacheName).put(p.getText(), p));
    }

}
