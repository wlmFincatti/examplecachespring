package br.com.wfincatti.examplecache.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static java.util.Objects.requireNonNull;

@Configuration("cache")
@EnableCaching
public class CacheConfig {

    @Autowired
    private CacheManager cacheManager;

    @Bean
    public void clearCache() {
        cacheManager.getCacheNames()
                .parallelStream()
                .forEach(n -> requireNonNull(cacheManager.getCache(n)).clear());
    }

}
