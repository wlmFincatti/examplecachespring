package br.com.wfincatti.examplecache.repository;

import br.com.wfincatti.examplecache.entity.ItemProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("itemProductRepository")
public interface ItemProductRepository extends JpaRepository<ItemProduct, Long> {
}
