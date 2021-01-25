package com.arc.core.model.domain.bet;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 投注用奖品
 *
 * @author lamy
 * @since
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@TableName("bet_award")
@Deprecated
public class Award implements Serializable {


    private static final long serialVersionUID = 1L;


    @TableId(value = "id", type = IdType.AUTO)
    private Long id;// 自增id

    private Long activityId;// 活动id 冗余
    private Long creatorId;//id
    private String creator;//?{json}

    private String awardName;// 名中文称 奖励物名称：XX手机/XX立减1元
    private String awardAvatar;// 图片

    private Integer price;//每注资源数 (就等效现价)
    private Integer markingPrice;// 展示划线價格
    private String priceUnit = "元";// 价格单位 例：元/币/金币/点数

    private Integer  amount;//奖品总数量
    private Integer prizePool;// 奖池 开奖奖池所需资源数

    private String awardType;//奖品类型
    private Integer awardCostType;//资源消耗类型


    //private Date userConfirmTime;//用户确认时间

    private Integer state;// 状态，暂时规划true=非0/false=0

    private LocalDateTime awardTime;
    private LocalDateTime createTime;// 创建时间
    private LocalDateTime updateTime;// 更新时间

    private Integer totalAmountOfParticipants;//总参与净人数 (同一个人多次成功的捐赠计数只加一)
    private Integer totalTimeOfParticipants;//总参与人次 (计多少人次捐赠,捐赠成功一次计数加一)

    @Deprecated
    private Integer from;//渠道来源

    // 订单相关
    @Deprecated
    private List<Long> orderIds;//用户参与记录中的某一个ids



    //******************捐赠物***********************
    /**
     * 下一个全网捐公益项目的id(当第一个捐满后会维护此字段)
     */
    private Long nextWelfareId;

    /**
     * 公益类型(1=全网捐(无限数量)/2=实物)
     */
    private Integer welfareType;

    /**
     * 周期,从1开始,0/null表示还没有开始的期数
     */
    private Integer period;

    /**
     * 公益名称
     */
    private String welfareName;

    /**
     * 公益主图片
     */
    private String welfareAvatar;

    /**
     * 公益总数
     */
    private Integer welfareTotal;

    /**
     * 公益定义总目标数(超过总目标数,本公益捐满,激活下一个公益目标)
     */
    private Long target;

    /**
     * 捐满时刻的时间
     */
    private Date finishTime;


    /**
     * 公益提供者相关信息{description/}
     */
    private JSONObject welfareSupportDetailJson;

    /**
     * 公益详情页{description/}
     */
    private JSONObject welfareDetailJson;


    private Map<String, Object> extend;//扩展字段json

    public float getTotalFinalPrice() {
        return (float) ((float) price / 10000F);
    }

}
