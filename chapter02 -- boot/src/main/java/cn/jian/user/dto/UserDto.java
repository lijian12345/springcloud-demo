package cn.jian.user.dto;

import java.io.Serializable;
import com.google.common.base.MoreObjects;
import cn.jian.user.entity.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "用户信息包")
public class UserDto implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键Id")
    private Long id;
    @ApiModelProperty(value = "用户昵称")
    private String nickname;
    @ApiModelProperty(value = "用户头像")
    private String avatar;

    public UserDto() {
    }

    public UserDto(User user) {
        this.id = user.getId();
        this.nickname = user.getNickname();
        this.avatar = user.getAvatar();
    }

    @Override
    public String toString() {
        return this.toStringHelper().toString();
    }

    protected MoreObjects.ToStringHelper toStringHelper() {
        return MoreObjects.toStringHelper(this).add("id", getId()).add("nickname", getNickname());
    }
}
