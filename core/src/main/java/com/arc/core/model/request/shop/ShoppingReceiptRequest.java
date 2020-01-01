package com.arc.core.model.request.shop;

import com.arc.core.model.request.CommonPageQuery;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * 购物小票
 *
 * @author lamy
 * @since 2019-12-30 22:24:13
 */
@Getter
@Setter
public class ShoppingReceiptRequest extends CommonPageQuery {

    private static final long serialVersionUID = 1L;

    private LocalDateTime transactionTime;// 交易时间

    @NotNull(message = "名称不为空")
    private String name;// 名中文称

    @NotNull(message = "总价不为空")
    private int totalFinalPrice;// 成交价

    private boolean state;// 状态，暂时规划true=非0/false=0

    private String priceUnit = "元";// 价格单位
    //    private int totalDiscount;// 总折扣
//    private String remark;// 备注
//    public float getTotalFinalPrice() {
//        return (float) ((float) totalFinalPrice / 10000F);
//    }
}
