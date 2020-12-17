package cn.jian.product.dto;

import java.io.Serializable;
import java.util.Date;
import com.google.common.base.MoreObjects;
import cn.jian.product.entity.ProductComment;
import cn.jian.user.dto.UserDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "商品评论信息包")
public class ProductCommentDto implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "评论主键Id")
    private Long id;
    @ApiModelProperty(value = "所属商品")
    private ProductDto product;
    @ApiModelProperty(value = "评论作者")
    private UserDto author;
    @ApiModelProperty(value = "评论内容")
    private String content;
    @ApiModelProperty(value = "创建时间")
    private Date created;

    public ProductCommentDto() {
    }

    public ProductCommentDto(ProductComment productComment) {
        this.id = productComment.getId();
        this.content = productComment.getContent();
        this.created = productComment.getCreated();
    }

    @Override
    public String toString() {
        return this.toStringHelper().toString();
    }

    protected MoreObjects.ToStringHelper toStringHelper() {
        return MoreObjects.toStringHelper(this).add("id", getId()).add("productId", getProduct());
    }
}
