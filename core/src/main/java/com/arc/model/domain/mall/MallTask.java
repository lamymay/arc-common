package com.arc.model.domain.mall;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 *
 */
@Getter
@Setter
public class MallTask {

    private static final long serialVersionUID = 1L;

    private Long id;// 主键ID
    private Long mallId;//mall的id，做关联


    //    新加字段
    private Long workId;// 工单id
    private String taskArea;//任务所在区域 AC

    private Date beginDate;// 用户开始时间
    private Date taskFinishDate;// 任务结束时间


    private String title;// 任务标题
    private String code;// 代码(注意导入的数据是name+code，入库时候分离了)
    private String name;// 任务名称
    private String lotNumber;// 批次号
    private Long stepId;// 分步模板ID
    private Long seriesId;// 系列任务模板ID
    private Long workerId;// 完成人ID
    private String taskType;// 任务类型
    private String description;// 任务详细描述
    private String taskPicture;// 任务图片
    private String finishPicture;// 任务完成图片
    private Integer gpsCheck;// 是否完成GPS校验
    private String longitudeBegin;// 开始经度 Longitude 简写Lng
    private String latitudeBegin;// 开始纬度 Latitude 简写Lat
    private String longitudeEnd;// 结束经度 Longitude 简写Lng
    private String latitudeEnd;// 结束纬度 Latitude 简写Lat

    private Integer salary;// 报酬
    private Integer salaryTotal;// 报酬解算金额
    private Integer salaryIncrease;// 调价幅度
    private Integer integral;// 积分
    private Integer effectiveDistance;// 有效距离
    private Integer outsideRangeTime;// 出签到范围次数
    private Integer reSignTime;// 再次签到次数
    private Integer limitTime;// 限时（任务完成时限，单位：min）
    private Integer costTime;// 耗时（做单时长，单位：min）
    private Integer reviewTime;// 审核实际（审单时间）单位：min
    private String admin;// 管理员V
    private Integer needWorkerNumbewr;// 需要人数
    private String customerNumber;// 客户编号 AK
    private Integer canPriority;// 是否金牌用户优先
    private Integer canTaskRepeatExecution;// 任务能否重复执行
    private Integer canWorkerRepeatExecution;// 执行人能否重复执行
    private Integer canTopping;// 是否置顶
    private Integer canPropaganda;// 是否为宣称任务
    private Integer canRepeatReceive;// 是否允许多次接单
    private Integer canDisplayInHall;// 是否在大厅显示
    private String note;// 备注
    private Integer state;// 状态


    private Date onlineDate;// 任务上线时间
    private Date offlineDate;// 任务下线时间


    //
    private Date endDate;// 用户结束时间

    private Date createDate;// 创建时间（任务浏览开始时间）
    private Date updateDate;// 更新时间（管理员更新时间）
}
