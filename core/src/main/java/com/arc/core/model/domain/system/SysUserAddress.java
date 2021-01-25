package com.arc.core.model.domain.system;

import com.arc.core.model.domain.BaseModel;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * 订单的地址表对应的实体
 * http://www.ip33.com/area_code.html
 *
 * @author yechao
 * @date 2021/1/25 8:30 下午
 */
public class SysUserAddress extends BaseModel {

    private static final long serialVersionUID = 1L;

    /**
     * 自增主键ID
     */
    private Long id;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 状态 如常用地址=1
     */
    private Integer state;

    private Long userId;//用户id
    private String addressTag;//标签
    private String cellphone;//电话

    private String provinceCode;//省(地区6位码)
    private String cityCode;//市(地区6位码)
    private String districtCode;//区(地区6位码)

    private String province;//省
    private String city;//市
    private String district;//区
    private String address;//具体地址


    /**
     * 扩展字段json
     */
    @Deprecated
    private Map<String, Object> extend;

}
