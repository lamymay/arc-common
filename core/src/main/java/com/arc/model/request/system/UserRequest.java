package com.arc.model.request.system;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author 叶超
 * @since 2019/6/3 21:15
 */
@Setter
@Getter
@NoArgsConstructor
public class UserRequest {

    private String identifier;

    private String credential;
}
