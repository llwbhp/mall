package com.macro.mall.model;

import java.io.Serializable;
import java.util.Date;

public class MemberBrandAttention implements Serializable {
    private Long id;

    private Long memberId;

    private String memberNickname;

    private String memberIcon;

    private Long brandId;

    private String brandName;

    private String brandLogo;

    private String brandCity;

    private Integer brandAttentionCount;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getMemberNickname() {
        return memberNickname;
    }

    public void setMemberNickname(String memberNickname) {
        this.memberNickname = memberNickname;
    }

    public String getMemberIcon() {
        return memberIcon;
    }

    public void setMemberIcon(String memberIcon) {
        this.memberIcon = memberIcon;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandLogo() {
        return brandLogo;
    }

    public void setBrandLogo(String brandLogo) {
        this.brandLogo = brandLogo;
    }

    public String getBrandCity() {
        return brandCity;
    }

    public void setBrandCity(String brandCity) {
        this.brandCity = brandCity;
    }

    public Integer getBrandAttentionCount() {
        return brandAttentionCount;
    }

    public void setBrandAttentionCount(Integer brandAttentionCount) {
        this.brandAttentionCount = brandAttentionCount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", memberId=").append(memberId);
        sb.append(", memberNickname=").append(memberNickname);
        sb.append(", memberIcon=").append(memberIcon);
        sb.append(", brandId=").append(brandId);
        sb.append(", brandName=").append(brandName);
        sb.append(", brandLogo=").append(brandLogo);
        sb.append(", brandCity=").append(brandCity);
        sb.append(", brandAttentionCount=").append(brandAttentionCount);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}