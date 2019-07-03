package com.arc.model.dto.enviroment;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 产品dto
 * 格式化价格
 */
@Setter
@Getter
@NoArgsConstructor
public class ProjectDto {


    private Long id; // 主键

    private String type; //商品类型【单商品：single（默认）、多规格商品：variant、组合捆绑：package、服务：service、辅料：accessory】


    private String spu_code; //商品代码

    private String sku_code; //货品SKU编码

    private String barcode; //条码

    private String outcode; //第三方识别码

    private String rfid_code; //RFID编号

    private String parent_code; //主商品编号


    private String name; //商品名称

    private String sub_name; //商品副标题/英文名称

    private String unit_code; //计量单位代码

    private String on_sale; //是否可销售【是：Y（默认）、否：N】

    private String on_sale_date; //2018-01-01 10:00:00 上架时间

    private String short_notes; //商品简介


    private String notes; //商品描述

    private String is_virtual; //是否虚拟商品【是：Y、否：N(默认)】

    private String active; //是否有效【是：Y（默认）、否：N】

    private String comment; //热卖商品，轻拿轻放 备注

    private String source; //来源/原访问地址

    private String json_price;

    private String json_stock;

    private String json_attrs;

    private String json_belong;

    private String json_images;

    private String other_params;


//    private List<String> accessories;
//    private List<String> tags;
}
