package com.supergo.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@ApiModel(value="com.supergo.pojo.User")
@Table(name = "tb_user")
public class User implements Serializable {
    @Id
    @ApiModelProperty(value="id")
    private Long id;

    /**
     * 头像地址
     */
    @Id
    @Column(name = "head_pic")
    @ApiModelProperty(value="headPic头像地址")
    private String headPic;

    /**
     * 用户名
     */
    @ApiModelProperty(value="username用户名")
    private String username;

    /**
     * 密码，加密存储
     */
    @ApiModelProperty(value="password密码，加密存储")
    private String password;

    /**
     * 注册手机号
     */
    @ApiModelProperty(value="phone注册手机号")
    private String phone;

    /**
     * 注册邮箱
     */
    @ApiModelProperty(value="email注册邮箱")
    private String email;

    /**
     * 创建时间
     */
    @ApiModelProperty(value="created创建时间")
    private Date created;

    @ApiModelProperty(value="updated")
    private Date updated;

    /**
     * 会员来源：1:PC，2：H5，3：Android，4：IOS，5：WeChat
     */
    @Column(name = "source_type")
    @ApiModelProperty(value="sourceType会员来源：1:PC，2：H5，3：Android，4：IOS，5：WeChat")
    private String sourceType;

    /**
     * 昵称
     */
    @Column(name = "nick_name")
    @ApiModelProperty(value="nickName昵称")
    private String nickName;

    /**
     * 真实姓名
     */
    @ApiModelProperty(value="name真实姓名")
    private String name;

    /**
     * 使用状态（Y正常 N非正常）
     */
    @ApiModelProperty(value="status使用状态（Y正常 N非正常）")
    private String status;

    /**
     * QQ号码
     */
    @ApiModelProperty(value="qqQQ号码")
    private String qq;

    /**
     * 账户余额
     */
    @Column(name = "account_balance")
    @ApiModelProperty(value="accountBalance账户余额")
    private Long accountBalance;

    /**
     * 手机是否验证 （0否  1是）
     */
    @Column(name = "is_mobile_check")
    @ApiModelProperty(value="isMobileCheck手机是否验证 （0否  1是）")
    private String isMobileCheck;

    /**
     * 邮箱是否检测（0否  1是）
     */
    @Column(name = "is_email_check")
    @ApiModelProperty(value="isEmailCheck邮箱是否检测（0否  1是）")
    private String isEmailCheck;

    /**
     * 性别，1男，2女
     */
    @ApiModelProperty(value="sex性别，1男，2女")
    private String sex;

    /**
     * 会员等级
     */
    @Column(name = "user_level")
    @ApiModelProperty(value="userLevel会员等级")
    private Integer userLevel;

    /**
     * 积分
     */
    @ApiModelProperty(value="points积分")
    private Integer points;

    /**
     * 经验值
     */
    @Column(name = "experience_value")
    @ApiModelProperty(value="experienceValue经验值")
    private Integer experienceValue;

    /**
     * 生日
     */
    @ApiModelProperty(value="birthday生日")
    private Date birthday;

    /**
     * 最后登录时间
     */
    @Column(name = "last_login_time")
    @ApiModelProperty(value="lastLoginTime最后登录时间")
    private Date lastLoginTime;

    private static final long serialVersionUID = 1L;

    public User(Long id, String headPic, String username, String password, String phone, String email, Date created, Date updated, String sourceType, String nickName, String name, String status, String qq, Long accountBalance, String isMobileCheck, String isEmailCheck, String sex, Integer userLevel, Integer points, Integer experienceValue, Date birthday, Date lastLoginTime) {
        this.id = id;
        this.headPic = headPic;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.created = created;
        this.updated = updated;
        this.sourceType = sourceType;
        this.nickName = nickName;
        this.name = name;
        this.status = status;
        this.qq = qq;
        this.accountBalance = accountBalance;
        this.isMobileCheck = isMobileCheck;
        this.isEmailCheck = isEmailCheck;
        this.sex = sex;
        this.userLevel = userLevel;
        this.points = points;
        this.experienceValue = experienceValue;
        this.birthday = birthday;
        this.lastLoginTime = lastLoginTime;
    }

    public User() {
        super();
    }

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取头像地址
     *
     * @return head_pic - 头像地址
     */
    public String getHeadPic() {
        return headPic;
    }

    /**
     * 设置头像地址
     *
     * @param headPic 头像地址
     */
    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    /**
     * 获取用户名
     *
     * @return username - 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取密码，加密存储
     *
     * @return password - 密码，加密存储
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码，加密存储
     *
     * @param password 密码，加密存储
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取注册手机号
     *
     * @return phone - 注册手机号
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置注册手机号
     *
     * @param phone 注册手机号
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取注册邮箱
     *
     * @return email - 注册邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置注册邮箱
     *
     * @param email 注册邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取创建时间
     *
     * @return created - 创建时间
     */
    public Date getCreated() {
        return created;
    }

    /**
     * 设置创建时间
     *
     * @param created 创建时间
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * @return updated
     */
    public Date getUpdated() {
        return updated;
    }

    /**
     * @param updated
     */
    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    /**
     * 获取会员来源：1:PC，2：H5，3：Android，4：IOS，5：WeChat
     *
     * @return source_type - 会员来源：1:PC，2：H5，3：Android，4：IOS，5：WeChat
     */
    public String getSourceType() {
        return sourceType;
    }

    /**
     * 设置会员来源：1:PC，2：H5，3：Android，4：IOS，5：WeChat
     *
     * @param sourceType 会员来源：1:PC，2：H5，3：Android，4：IOS，5：WeChat
     */
    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    /**
     * 获取昵称
     *
     * @return nick_name - 昵称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 设置昵称
     *
     * @param nickName 昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * 获取真实姓名
     *
     * @return name - 真实姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置真实姓名
     *
     * @param name 真实姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取使用状态（Y正常 N非正常）
     *
     * @return status - 使用状态（Y正常 N非正常）
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置使用状态（Y正常 N非正常）
     *
     * @param status 使用状态（Y正常 N非正常）
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取QQ号码
     *
     * @return qq - QQ号码
     */
    public String getQq() {
        return qq;
    }

    /**
     * 设置QQ号码
     *
     * @param qq QQ号码
     */
    public void setQq(String qq) {
        this.qq = qq;
    }

    /**
     * 获取账户余额
     *
     * @return account_balance - 账户余额
     */
    public Long getAccountBalance() {
        return accountBalance;
    }

    /**
     * 设置账户余额
     *
     * @param accountBalance 账户余额
     */
    public void setAccountBalance(Long accountBalance) {
        this.accountBalance = accountBalance;
    }

    /**
     * 获取手机是否验证 （0否  1是）
     *
     * @return is_mobile_check - 手机是否验证 （0否  1是）
     */
    public String getIsMobileCheck() {
        return isMobileCheck;
    }

    /**
     * 设置手机是否验证 （0否  1是）
     *
     * @param isMobileCheck 手机是否验证 （0否  1是）
     */
    public void setIsMobileCheck(String isMobileCheck) {
        this.isMobileCheck = isMobileCheck;
    }

    /**
     * 获取邮箱是否检测（0否  1是）
     *
     * @return is_email_check - 邮箱是否检测（0否  1是）
     */
    public String getIsEmailCheck() {
        return isEmailCheck;
    }

    /**
     * 设置邮箱是否检测（0否  1是）
     *
     * @param isEmailCheck 邮箱是否检测（0否  1是）
     */
    public void setIsEmailCheck(String isEmailCheck) {
        this.isEmailCheck = isEmailCheck;
    }

    /**
     * 获取性别，1男，2女
     *
     * @return sex - 性别，1男，2女
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置性别，1男，2女
     *
     * @param sex 性别，1男，2女
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 获取会员等级
     *
     * @return user_level - 会员等级
     */
    public Integer getUserLevel() {
        return userLevel;
    }

    /**
     * 设置会员等级
     *
     * @param userLevel 会员等级
     */
    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }

    /**
     * 获取积分
     *
     * @return points - 积分
     */
    public Integer getPoints() {
        return points;
    }

    /**
     * 设置积分
     *
     * @param points 积分
     */
    public void setPoints(Integer points) {
        this.points = points;
    }

    /**
     * 获取经验值
     *
     * @return experience_value - 经验值
     */
    public Integer getExperienceValue() {
        return experienceValue;
    }

    /**
     * 设置经验值
     *
     * @param experienceValue 经验值
     */
    public void setExperienceValue(Integer experienceValue) {
        this.experienceValue = experienceValue;
    }

    /**
     * 获取生日
     *
     * @return birthday - 生日
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 设置生日
     *
     * @param birthday 生日
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取最后登录时间
     *
     * @return last_login_time - 最后登录时间
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * 设置最后登录时间
     *
     * @param lastLoginTime 最后登录时间
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", headPic=").append(headPic);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", phone=").append(phone);
        sb.append(", email=").append(email);
        sb.append(", created=").append(created);
        sb.append(", updated=").append(updated);
        sb.append(", sourceType=").append(sourceType);
        sb.append(", nickName=").append(nickName);
        sb.append(", name=").append(name);
        sb.append(", status=").append(status);
        sb.append(", qq=").append(qq);
        sb.append(", accountBalance=").append(accountBalance);
        sb.append(", isMobileCheck=").append(isMobileCheck);
        sb.append(", isEmailCheck=").append(isEmailCheck);
        sb.append(", sex=").append(sex);
        sb.append(", userLevel=").append(userLevel);
        sb.append(", points=").append(points);
        sb.append(", experienceValue=").append(experienceValue);
        sb.append(", birthday=").append(birthday);
        sb.append(", lastLoginTime=").append(lastLoginTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}