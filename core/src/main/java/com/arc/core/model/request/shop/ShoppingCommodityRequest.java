package com.arc.core.model.request.shop;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 购物小票
 *
 * @author lamy
 * @since 2019-12-30 22:06:53
 */
@Getter
@Setter
public class ShoppingCommodityRequest {

	private static final long serialVersionUID = 1L;

	private Long id;// PK
	private String name;// name
	private Integer amount;// 数量
	private String amountUnit;// 数量单位
	private Integer unitPrice;// 单价
	private Integer discount;// 折扣率（备用）
	private String priceUnit;// priceUnit 价格单位
	private Integer finalPrice;// 成交价 就是该项商品实际需要支付金额
	private Object sate;// 状态
	private String remark;// 备注
	private String avatar;// 图
	private String nameEnglish;// 英文名称 （备用）
	private Date createTime;// 创建时间
	private Date updateTime;// 更新时间
}
