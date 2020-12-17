package cn.jian.product.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import cn.jian.product.entity.Product;
import cn.jian.product.entity.ProductComment;


/**
 * 产品管理服务
 *
 * @author CD826
 * @since 1.0.0
 */
public interface ProductService {
    /**
     * 获取商品配置的分页数据
     * @param pageable 分页参数
     * @return 分页数据
     */
    Page<Product> getPage(Pageable pageable);

    /**
     * 加载指定的商品配置
     * @param id 商品配置ID
     * @return
     */
    Product load(Long id);

    /**
     * 加载指定商品的评论列表
     * @param productId
     * @return
     */
    List<ProductComment> findAllByProduct(Long productId);
}
