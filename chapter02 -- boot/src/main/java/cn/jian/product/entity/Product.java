package cn.jian.product.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import com.google.common.base.MoreObjects;
import lombok.Data;

@Data
@Entity
@Table(name = "tbProduct")
public class Product {
    @Id
    @GeneratedValue
    /** 商品数据库主键 */
    private Long id;
    /** 商品名称 */
    private String name;
    /** 商品封面图片 */
    private String coverImage;
    /** 商品价格(分) */
    private int price;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("id", getId()).add("name", getName())
                .toString();
    }
}
