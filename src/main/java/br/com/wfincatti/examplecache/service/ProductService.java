package br.com.wfincatti.examplecache.service;

import br.com.wfincatti.examplecache.entity.Product;
import br.com.wfincatti.examplecache.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@CacheConfig(cacheNames = "product")
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Cacheable(key = "#root.method.name")
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @CacheEvict(allEntries = true)
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @CachePut(key = "#product.getId()")
    public Product updateProduct(Product product) {
        boolean present = productRepository
                .findById(product.getId())
                .isPresent();
        if (!present) {
            throw new EntityNotFoundException("not found product");
        }
        return productRepository.save(product);
    }

    @Cacheable(key = "#id", unless = "#result.name == 'xbox'")
    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("not found product"));
    }

    @CacheEvict(allEntries = true)
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
