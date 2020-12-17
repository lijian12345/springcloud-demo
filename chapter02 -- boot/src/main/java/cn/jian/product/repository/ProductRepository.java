package cn.jian.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cn.jian.product.entity.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {
}
