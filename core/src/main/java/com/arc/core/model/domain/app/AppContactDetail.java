package com.arc.core.model.domain.app;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author 叶超
 * @since 2020/2/27 10:46
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AppContactDetail {

    private static final long serialVersionUID = 1L;

    //本系统中的id是主键
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    //contact表的id
    private Long contactId;

    //类型
    private String type;

    //值=phone/email
    private String value;

    //别名
    private String alias;

    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public AppContactDetail(Long contactId, String type, String phoneOrEmail  , String alias) {
        this.contactId = contactId;
        this.type = type;
        this.value = phoneOrEmail;
        this.alias = alias;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AppContactDetail)) return false;
        AppContactDetail that = (AppContactDetail) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(contactId, that.contactId) &&
                Objects.equals(type, that.type) &&
                Objects.equals(value, that.value) &&
                Objects.equals(alias, that.alias) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(updateTime, that.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, contactId, type, value, alias, createTime, updateTime);
    }
}
