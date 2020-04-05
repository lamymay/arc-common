package com.arc.core.model.request.system.dictionary;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author 叶超
 * @since 2019/9/29 23:28
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
public class SysDataDictionaryRequest {
    private Long id;//主键
    private String name;//名称
}
