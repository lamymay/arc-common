package com.arc.zero.model.request.rbac;

import com.arc.zero.model.request.AuthorizationRequest;
import lombok.Data;

/**
 * Resource 相关请求参数的模型
 *
 * @author May
 * @since 2020/1/7 10:19
 */
@Data
public class ResourceRequest extends AuthorizationRequest {

    private String roleId;
    private String category;


}
