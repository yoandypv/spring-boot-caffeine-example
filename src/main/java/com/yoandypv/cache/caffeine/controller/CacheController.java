package com.yoandypv.cache.caffeine.controller;

import com.github.benmanes.caffeine.cache.Cache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RequestMapping("/caches")
@RestController
@Slf4j
public class CacheController {

    private final CacheManager cacheManager;

    public CacheController(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    @GetMapping("/{cache-name}")
    public Map<Object, Object> getCacheValues(@PathVariable(value = "cache-name") String cacheName) {
        log.info("Calling get keys/values for cache name={}", cacheName);
        com.github.benmanes.caffeine.cache.Cache<Object, Object> nativeCache = (Cache<Object, Object>) cacheManager.getCache(cacheName).getNativeCache();
        //nativeCache.asMap().forEach((key, value) -> log.info("Key is {} and value {}", key, value));
        return nativeCache.asMap();
    }

    @DeleteMapping("/{cache-name}/clear")
    public void cleanCache(@PathVariable(value = "cache-name") String cacheName) {
        log.info("Calling clean cache name={}", cacheName);
        Optional.ofNullable(cacheName).flatMap(name -> Optional.ofNullable(this.cacheManager.getCache(name)))
                .ifPresent(org.springframework.cache.Cache::clear);
    }

}
