package com.supergo.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@ApiModel(value="com.supergo.pojo.Seller")
@Table(name = "tb_seller")
public class Seller implements Serializable {
    /**
     * 用户ID
     */
    @Id
    @Column(name = "seller_id")
    @ApiModelProperty(value="sellerId用户ID")
    private String sellerId;

    /**
     * 公司名
     */
    @ApiModelProperty(value="name公司名")
    private String name;

    /**
     * 店铺名称
     */
    @Column(name = "nick_name")
    @ApiModelProperty(value="nickName店铺名称")
    private String nickName;

    /**
     * 密码
     */
    @ApiModelProperty(value="password密码")
    private String password;

    /**
     * EMAIL
     */
    @ApiModelProperty(value="emailEMAIL")
    private String email;

    /**
     * 公司手机
     */
    @ApiModelProperty(value="mobile公司手机")
    private String mobile;

    /**
     * 公司电话
     */
    @ApiModelProperty(value="telephone公司电话")
    private String telephone;

    /**
     * 状态
     */
    @ApiModelProperty(value="status状态")
    private String status;

    /**
     * 详细地址
     */
    @Column(name = "address_detail")
    @ApiModelProperty(value="addressDetail详细地址")
    private String addressDetail;

    /**
     * 联系人姓名
     */
    @Column(name = "linkman_name")
    @ApiModelProperty(value="linkmanName联系人姓名")
    private String linkmanName;

    /**
     * 联系人QQ
     */
    @Column(name = "linkman_qq")
    @ApiModelProperty(value="linkmanQq联系人QQ")
    private String linkmanQq;

    /**
     * 联系人电话
     */
    @Column(name = "linkman_mobile")
    @ApiModelProperty(value="linkmanMobile联系人电话")
    private String linkmanMobile;

    /**
     * 联系人EMAIL
     */
    @Column(name = "linkman_email")
    @ApiModelProperty(value="linkmanEmail联系人EMAIL")
    private String linkmanEmail;

    /**
     * 营业执照号
     */
    @Column(name = "license_number")
    @ApiModelProperty(value="licenseNumber营业执照号")
    private String licenseNumber;

    /**
     * 税务登记证号
     */
    @Column(name = "tax_number")
    @ApiModelProperty(value="taxNumber税务登记证号")
    private String taxNumber;

    /**
     * 组织机构代码
     */
    @Column(name = "org_number")
    @ApiModelProperty(value="orgNumber组织机构代码")
    private String orgNumber;

    /**
     * 公司地址
     */
    @ApiModelProperty(value="address公司地址")
    private Long address;

    /**
     * 公司LOGO图
     */
    @Column(name = "logo_pic")
    @ApiModelProperty(value="logoPic公司LOGO图")
    private String logoPic;

    /**
     * 简介
     */
    @ApiModelProperty(value="brief简介")
    private String brief;

    /**
     * 创建日期
     */
    @Column(name = "create_time")
    @ApiModelProperty(value="createTime创建日期")
    private Date createTime;

    /**
     * 法定代表人
     */
    @Column(name = "legal_person")
    @ApiModelProperty(value="legalPerson法定代表人")
    private String legalPerson;

    /**
     * 法定代表人身份证
     */
    @Column(name = "legal_person_card_id")
    @ApiModelProperty(value="legalPersonCardId法定代表人身份证")
    private String legalPersonCardId;

    /**
     * 开户行账号名称
     */
    @Column(name = "bank_user")
    @ApiModelProperty(value="bankUser开户行账号名称")
    private String bankUser;

    /**
     * 开户行
     */
    @Column(name = "bank_name")
    @ApiModelProperty(value="bankName开户行")
    private String bankName;

    private static final long serialVersionUID = 1L;

    public Seller(String sellerId, String name, String nickName, String password, String email, String mobile, String telephone, String status, String addressDetail, String linkmanName, String linkmanQq, String linkmanMobile, String linkmanEmail, String licenseNumber, String taxNumber, String orgNumber, Long address, String logoPic, String brief, Date createTime, String legalPerson, String legalPersonCardId, String bankUser, String bankName) {
        this.sellerId = sellerId;
        this.name = name;
        this.nickName = nickName;
        this.password = password;
        this.email = email;
        this.mobile = mobile;
        this.telephone = telephone;
        this.status = status;
        this.addressDetail = addressDetail;
        this.linkmanName = linkmanName;
        this.linkmanQq = linkmanQq;
        this.linkmanMobile = linkmanMobile;
        this.linkmanEmail = linkmanEmail;
        this.licenseNumber = licenseNumber;
        this.taxNumber = taxNumber;
        this.orgNumber = orgNumber;
        this.address = address;
        this.logoPic = logoPic;
        this.brief = brief;
        this.createTime = createTime;
        this.legalPerson = legalPerson;
        this.legalPersonCardId = legalPersonCardId;
        this.bankUser = bankUser;
        this.bankName = bankName;
    }

    public Seller() {
        super();
    }

    /**
     * 获取用户ID
     *
     * @return seller_id - 用户ID
     */
    public String getSellerId() {
        return sellerId;
    }

    /**
     * 设置用户ID
     *
     * @param sellerId 用户ID
     */
    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    /**
     * 获取公司名
     *
     * @return name - 公司名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置公司名
     *
     * @param name 公司名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取店铺名称
     *
     * @return nick_name - 店铺名称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 设置店铺名称
     *
     * @param nickName 店铺名称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取EMAIL
     *
     * @return email - EMAIL
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置EMAIL
     *
     * @param email EMAIL
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取公司手机
     *
     * @return mobile - 公司手机
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置公司手机
     *
     * @param mobile 公司手机
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取公司电话
     *
     * @return telephone - 公司电话
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * 设置公司电话
     *
     * @param telephone 公司电话
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * 获取状态
     *
     * @return status - 状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态
     *
     * @param status 状态
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取详细地址
     *
     * @return address_detail - 详细地址
     */
    public String getAddressDetail() {
        return addressDetail;
    }

    /**
     * 设置详细地址
     *
     * @param addressDetail 详细地址
     */
    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    /**
     * 获取联系人姓名
     *
     * @return linkman_name - 联系人姓名
     */
    public String getLinkmanName() {
        return linkmanName;
    }

    /**
     * 设置联系人姓名
     *
     * @param linkmanName 联系人姓名
     */
    public void setLinkmanName(String linkmanName) {
        this.linkmanName = linkmanName;
    }

    /**
     * 获取联系人QQ
     *
     * @return linkman_qq - 联系人QQ
     */
    public String getLinkmanQq() {
        return linkmanQq;
    }

    /**
     * 设置联系人QQ
     *
     * @param linkmanQq 联系人QQ
     */
    public void setLinkmanQq(String linkmanQq) {
        this.linkmanQq = linkmanQq;
    }

    /**
     * 获取联系人电话
     *
     * @return linkman_mobile - 联系人电话
     */
    public String getLinkmanMobile() {
        return linkmanMobile;
    }

    /**
     * 设置联系人电话
     *
     * @param linkmanMobile 联系人电话
     */
    public void setLinkmanMobile(String linkmanMobile) {
        this.linkmanMobile = linkmanMobile;
    }

    /**
     * 获取联系人EMAIL
     *
     * @return linkman_email - 联系人EMAIL
     */
    public String getLinkmanEmail() {
        return linkmanEmail;
    }

    /**
     * 设置联系人EMAIL
     *
     * @param linkmanEmail 联系人EMAIL
     */
    public void setLinkmanEmail(String linkmanEmail) {
        this.linkmanEmail = linkmanEmail;
    }

    /**
     * 获取营业执照号
     *
     * @return license_number - 营业执照号
     */
    public String getLicenseNumber() {
        return licenseNumber;
    }

    /**
     * 设置营业执照号
     *
     * @param licenseNumber 营业执照号
     */
    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    /**
     * 获取税务登记证号
     *
     * @return tax_number - 税务登记证号
     */
    public String getTaxNumber() {
        return taxNumber;
    }

    /**
     * 设置税务登记证号
     *
     * @param taxNumber 税务登记证号
     */
    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    /**
     * 获取组织机构代码
     *
     * @return org_number - 组织机构代码
     */
    public String getOrgNumber() {
        return orgNumber;
    }

    /**
     * 设置组织机构代码
     *
     * @param orgNumber 组织机构代码
     */
    public void setOrgNumber(String orgNumber) {
        this.orgNumber = orgNumber;
    }

    /**
     * 获取公司地址
     *
     * @return address - 公司地址
     */
    public Long getAddress() {
        return address;
    }

    /**
     * 设置公司地址
     *
     * @param address 公司地址
     */
    public void setAddress(Long address) {
        this.address = address;
    }

    /**
     * 获取公司LOGO图
     *
     * @return logo_pic - 公司LOGO图
     */
    public String getLogoPic() {
        return logoPic;
    }

    /**
     * 设置公司LOGO图
     *
     * @param logoPic 公司LOGO图
     */
    public void setLogoPic(String logoPic) {
        this.logoPic = logoPic;
    }

    /**
     * 获取简介
     *
     * @return brief - 简介
     */
    public String getBrief() {
        return brief;
    }

    /**
     * 设置简介
     *
     * @param brief 简介
     */
    public void setBrief(String brief) {
        this.brief = brief;
    }

    /**
     * 获取创建日期
     *
     * @return create_time - 创建日期
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建日期
     *
     * @param createTime 创建日期
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取法定代表人
     *
     * @return legal_person - 法定代表人
     */
    public String getLegalPerson() {
        return legalPerson;
    }

    /**
     * 设置法定代表人
     *
     * @param legalPerson 法定代表人
     */
    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    /**
     * 获取法定代表人身份证
     *
     * @return legal_person_card_id - 法定代表人身份证
     */
    public String getLegalPersonCardId() {
        return legalPersonCardId;
    }

    /**
     * 设置法定代表人身份证
     *
     * @param legalPersonCardId 法定代表人身份证
     */
    public void setLegalPersonCardId(String legalPersonCardId) {
        this.legalPersonCardId = legalPersonCardId;
    }

    /**
     * 获取开户行账号名称
     *
     * @return bank_user - 开户行账号名称
     */
    public String getBankUser() {
        return bankUser;
    }

    /**
     * 设置开户行账号名称
     *
     * @param bankUser 开户行账号名称
     */
    public void setBankUser(String bankUser) {
        this.bankUser = bankUser;
    }

    /**
     * 获取开户行
     *
     * @return bank_name - 开户行
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * 设置开户行
     *
     * @param bankName 开户行
     */
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sellerId=").append(sellerId);
        sb.append(", name=").append(name);
        sb.append(", nickName=").append(nickName);
        sb.append(", password=").append(password);
        sb.append(", email=").append(email);
        sb.append(", mobile=").append(mobile);
        sb.append(", telephone=").append(telephone);
        sb.append(", status=").append(status);
        sb.append(", addressDetail=").append(addressDetail);
        sb.append(", linkmanName=").append(linkmanName);
        sb.append(", linkmanQq=").append(linkmanQq);
        sb.append(", linkmanMobile=").append(linkmanMobile);
        sb.append(", linkmanEmail=").append(linkmanEmail);
        sb.append(", licenseNumber=").append(licenseNumber);
        sb.append(", taxNumber=").append(taxNumber);
        sb.append(", orgNumber=").append(orgNumber);
        sb.append(", address=").append(address);
        sb.append(", logoPic=").append(logoPic);
        sb.append(", brief=").append(brief);
        sb.append(", createTime=").append(createTime);
        sb.append(", legalPerson=").append(legalPerson);
        sb.append(", legalPersonCardId=").append(legalPersonCardId);
        sb.append(", bankUser=").append(bankUser);
        sb.append(", bankName=").append(bankName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}