package cn.jian.product.dto;

import java.io.Serializable;
import com.google.common.base.MoreObjects;
import cn.jian.product.entity.Product;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "商品信息包")
public class ProductDto implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品主键Id")
    private Long id;
    @ApiModelProperty(value = "商品名称")
    private String name;
    @ApiModelProperty(value = "商品封面图片")
    private String coverImage;
    @ApiModelProperty(value = "商品价格(单位:分)")
    private int price;

    public ProductDto() {
    }

    public ProductDto(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.coverImage = product.getCoverImage();
        this.price = product.getPrice();
    }

    @Override
    public String toString() {
        return this.toStringHelper().toString();
    }

    protected MoreObjects.ToStringHelper toStringHelper() {
        return MoreObjects.toStringHelper(this).add("id", getId()).add("name", getName());
    }
}
