package com.arc.core.model.domain.bet;

import com.arc.core.model.BaseModel;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * 购物小票
 *
 * @author yechao
 * @date 2021/01/03 21:39 下午
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@TableName("bet_award")
public class Award extends BaseModel {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;// 自增id
    private Long activityId;// 活动id 冗余

    private String name;// 名中文称 奖励物名称：XX手机/XX立减1元
    private String nameEnglish;// 英文名称 （备用）
    private String avatar;// 图片

    private String awardType;//奖品类型
    private String awardCostType;//资源消耗类型
    private Integer amount;//奖品总数量

    private Integer everyBetNeedPay;//每注资源数 (就等效现价)
    private String priceUnit = "元";// 价格单位 例：元/币/金币/点数
    private Integer prizePool;// 奖池 开奖奖池所需资源数
    private Integer price;// 展示價格

    private Integer channel;//渠道类型
    private Date userConfirmTime;//用户确认时间
    private Integer state;// 状态，暂时规划true=非0/false=0
    private String remark;// 备注


    private String creator;//?{json}
    private Long creatorId;//id
    private LocalDateTime createTime;// 创建时间
    private LocalDateTime updateTime;// 更新时间

    private String extend;//扩展JsonString

    public float getTotalFinalPrice() {
        return (float) ((float) price / 10000F);
    }

    // 订单相关
    @Deprecated
    private List<Long> orderIds;//用户参与记录中的某一个ids

    // user 相关
    private String userNickname;//用户名称
    private String userAvatar;//用户的图标
    private String address;//地址
    private String tag;//标签
    private String cellphone;//电话
    private int status;//活动实例记录的状态


}
