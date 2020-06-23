package br.com.wfincatti.examplecache.configuration;

import br.com.wfincatti.examplecache.entity.ItemProduct;
import br.com.wfincatti.examplecache.entity.Product;
import br.com.wfincatti.examplecache.repository.ItemProductRepository;
import br.com.wfincatti.examplecache.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;

@Component
public class InitDb {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ItemProductRepository itemProductRepository;

    @PostConstruct
    public void createProducts() {
        ItemProduct itemProduct = new ItemProduct();
        Product product = new Product();
        itemProduct.setName("chassi");
        itemProduct.setAmount(1);
        itemProduct.setProduct(product);

        HashSet<ItemProduct> itemProducts = new HashSet<>();
        itemProducts.add(itemProduct);

        product.setItems(itemProducts);
        product.setPrice(300F);
        product.setName("xbox");
        product.setAmount(27);

        itemProductRepository.save(itemProduct);
        productRepository.save(product);
    }

}
