package cn.jian.user.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import com.google.common.base.MoreObjects;
import lombok.Data;

@Data
@Entity
@Table(name = "tbUser")
public class User {
    @Id
    @GeneratedValue
    /** 用户数据库主键 */
    private Long id;
    /** 用户昵称 */
    private String nickname;
    /** 用户头像 */
    private String avatar;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("id", getId()).add("nickname", getNickname())
                .toString();
    }

    protected MoreObjects.ToStringHelper toStringHelper() {
        return MoreObjects.toStringHelper(this).add("id", getId()).add("nickname", getNickname());
    }
}
