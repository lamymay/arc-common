package com.arc.core.model.request.app;

import com.arc.core.model.domain.app.AppContact;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @author 叶超
 * @since 2020/2/28 12:47
 */
@Setter
@Getter
@NoArgsConstructor
public class AppContactRequest {

    /**
     * 发起人的身份标记
     */
    private String userFlag;

    //同步方案
    private Integer type = 0;

    @Deprecated
    private Integer state = 0;

    private List<AppContact> contacts;

}
