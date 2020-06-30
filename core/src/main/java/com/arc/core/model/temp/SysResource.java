//package com.arc.core.model.domain.system;
//
//import com.arc.core.model.BaseModel;
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;
//
//import java.time.LocalDateTime;
//
///**
// * 系统资源抽象
// * state所指的状态，一般都是有限的、可列举的，status则是不可确定的
// *
// * @author may
// * @since 2020/6/2 6:41 下午
// */
//@Getter
//@Setter
//@ToString
//public class SysResource extends BaseModel {
//
//    private static final long serialVersionUID = 1L;
//
//    private Long id;// 主键
//    private String parentId;// 上级节点ID
//    private String resourceName;// 资源名
//
//    private Integer status;// 状态
//    private String note;// 备注
//    private String type;// 资源类型
//
//    private LocalDateTime createTime;// 创建时间
//    private LocalDateTime updateTime;// 更新时间
//
//}
