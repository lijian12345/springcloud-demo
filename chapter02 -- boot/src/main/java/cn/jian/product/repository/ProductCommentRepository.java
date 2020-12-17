package cn.jian.product.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import cn.jian.product.entity.ProductComment;

public interface ProductCommentRepository extends JpaRepository<ProductComment, Long> {
    List<ProductComment> findByProductIdOrderByCreated(Long productId);
}
