package cn.jian.product.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import cn.jian.product.entity.Product;
import cn.jian.product.entity.ProductComment;
import cn.jian.product.repository.ProductCommentRepository;
import cn.jian.product.repository.ProductRepository;
import cn.jian.product.service.ProductService;


/**
 * 产品管理服务的默认实现
 *
 * @author CD826
 * @since 1.0.0
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    protected ProductRepository productRepository;
    @Autowired
    protected ProductCommentRepository productCommentRepository;

    @Override
    public Page<Product> getPage(Pageable pageable) {
        return this.productRepository.findAll(pageable);
    }

    @Override
    public Product load(Long id) {
        return this.productRepository.findById(id).get();
    }

    @Override
    public List<ProductComment> findAllByProduct(Long productId) {
        return this.productCommentRepository.findByProductIdOrderByCreated(productId);
    }
}
