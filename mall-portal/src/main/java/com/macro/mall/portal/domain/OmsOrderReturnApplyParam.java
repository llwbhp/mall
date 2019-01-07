package com.macro.mall.portal.domain;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModelProperty;

/**
 * 申请退货参数 Created by macro on 2018/10/17.
 */
public class OmsOrderReturnApplyParam {
    @ApiModelProperty("订单id")
    private Long orderId;
    @ApiModelProperty("退货商品id")
    private Long productId;
    @ApiModelProperty("订单编号")
    private String orderSn;
    @ApiModelProperty("会员用户名")
    private String memberUsername;
    @ApiModelProperty("退货人姓名")
    private String returnName;
    @ApiModelProperty("退货人电话")
    private String returnPhone;
    @ApiModelProperty("商品图片")
    private String productPic;
    @ApiModelProperty("商品名称")
    private String productName;
    @ApiModelProperty("商品品牌")
    private String productBrand;
    @ApiModelProperty("商品销售属性：颜色：红色；尺码：xl;")
    private String productAttr;
    @ApiModelProperty("退货数量")
    private Integer productCount;
    @ApiModelProperty("商品单价")
    private BigDecimal productPrice;
    @ApiModelProperty("商品实际支付单价")
    private BigDecimal productRealPrice;
    @ApiModelProperty("原因")
    private String reason;
    @ApiModelProperty("描述")
    private String description;
    @ApiModelProperty("凭证图片，以逗号隔开")
    private String proofPics;

    /**
     * 
     * getter method
     * 
     * @return the orderId
     * 
     */

    public Long getOrderId() {
        return orderId;
    }

    /**
     * 
     * setter method
     * 
     * @param orderId the orderId to set
     * 
     */

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * 
     * getter method
     * 
     * @return the productId
     * 
     */

    public Long getProductId() {
        return productId;
    }

    /**
     * 
     * setter method
     * 
     * @param productId the productId to set
     * 
     */

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * 
     * getter method
     * 
     * @return the orderSn
     * 
     */

    public String getOrderSn() {
        return orderSn;
    }

    /**
     * 
     * setter method
     * 
     * @param orderSn the orderSn to set
     * 
     */

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    /**
     * 
     * getter method
     * 
     * @return the memberUsername
     * 
     */

    public String getMemberUsername() {
        return memberUsername;
    }

    /**
     * 
     * setter method
     * 
     * @param memberUsername the memberUsername to set
     * 
     */

    public void setMemberUsername(String memberUsername) {
        this.memberUsername = memberUsername;
    }

    /**
     * 
     * getter method
     * 
     * @return the returnName
     * 
     */

    public String getReturnName() {
        return returnName;
    }

    /**
     * 
     * setter method
     * 
     * @param returnName the returnName to set
     * 
     */

    public void setReturnName(String returnName) {
        this.returnName = returnName;
    }

    /**
     * 
     * getter method
     * 
     * @return the returnPhone
     * 
     */

    public String getReturnPhone() {
        return returnPhone;
    }

    /**
     * 
     * setter method
     * 
     * @param returnPhone the returnPhone to set
     * 
     */

    public void setReturnPhone(String returnPhone) {
        this.returnPhone = returnPhone;
    }

    /**
     * 
     * getter method
     * 
     * @return the productPic
     * 
     */

    public String getProductPic() {
        return productPic;
    }

    /**
     * 
     * setter method
     * 
     * @param productPic the productPic to set
     * 
     */

    public void setProductPic(String productPic) {
        this.productPic = productPic;
    }

    /**
     * 
     * getter method
     * 
     * @return the productName
     * 
     */

    public String getProductName() {
        return productName;
    }

    /**
     * 
     * setter method
     * 
     * @param productName the productName to set
     * 
     */

    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * 
     * getter method
     * 
     * @return the productBrand
     * 
     */

    public String getProductBrand() {
        return productBrand;
    }

    /**
     * 
     * setter method
     * 
     * @param productBrand the productBrand to set
     * 
     */

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    /**
     * 
     * getter method
     * 
     * @return the productAttr
     * 
     */

    public String getProductAttr() {
        return productAttr;
    }

    /**
     * 
     * setter method
     * 
     * @param productAttr the productAttr to set
     * 
     */

    public void setProductAttr(String productAttr) {
        this.productAttr = productAttr;
    }

    /**
     * 
     * getter method
     * 
     * @return the productCount
     * 
     */

    public Integer getProductCount() {
        return productCount;
    }

    /**
     * 
     * setter method
     * 
     * @param productCount the productCount to set
     * 
     */

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    /**
     * 
     * getter method
     * 
     * @return the productPrice
     * 
     */

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    /**
     * 
     * setter method
     * 
     * @param productPrice the productPrice to set
     * 
     */

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    /**
     * 
     * getter method
     * 
     * @return the productRealPrice
     * 
     */

    public BigDecimal getProductRealPrice() {
        return productRealPrice;
    }

    /**
     * 
     * setter method
     * 
     * @param productRealPrice the productRealPrice to set
     * 
     */

    public void setProductRealPrice(BigDecimal productRealPrice) {
        this.productRealPrice = productRealPrice;
    }

    /**
     * 
     * getter method
     * 
     * @return the reason
     * 
     */

    public String getReason() {
        return reason;
    }

    /**
     * 
     * setter method
     * 
     * @param reason the reason to set
     * 
     */

    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * 
     * getter method
     * 
     * @return the description
     * 
     */

    public String getDescription() {
        return description;
    }

    /**
     * 
     * setter method
     * 
     * @param description the description to set
     * 
     */

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     * getter method
     * 
     * @return the proofPics
     * 
     */

    public String getProofPics() {
        return proofPics;
    }

    /**
     * 
     * setter method
     * 
     * @param proofPics the proofPics to set
     * 
     */

    public void setProofPics(String proofPics) {
        this.proofPics = proofPics;
    }

}
