package com.arc.zero.model.request.rbac;

import com.arc.zero.model.request.AuthorizationRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 接收更新数据的实体bean
 *
 * @author May
 * @since 2020/1/7 10:20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleForUpdateRequest extends AuthorizationRequest {

    private String id;
    private String code;
    private String name;
    private String description;
    private String tag;


}
