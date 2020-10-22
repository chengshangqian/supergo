package com.supergo.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@ApiModel(value="com.supergo.pojo.Paylog")
@Table(name = "tb_pay_log")
public class Paylog implements Serializable {
    /**
     * 支付订单号
     */
    @Id
    @Column(name = "out_trade_no")
    @ApiModelProperty(value="outTradeNo支付订单号")
    private String outTradeNo;

    /**
     * 创建日期
     */
    @Column(name = "create_time")
    @ApiModelProperty(value="createTime创建日期")
    private Date createTime;

    /**
     * 支付完成时间
     */
    @Column(name = "pay_time")
    @ApiModelProperty(value="payTime支付完成时间")
    private Date payTime;

    /**
     * 支付金额（分）
     */
    @Column(name = "total_fee")
    @ApiModelProperty(value="totalFee支付金额（分）")
    private Long totalFee;

    /**
     * 用户ID
     */
    @Column(name = "user_id")
    @ApiModelProperty(value="userId用户ID")
    private String userId;

    /**
     * 交易号码
     */
    @Column(name = "transaction_id")
    @ApiModelProperty(value="transactionId交易号码")
    private String transactionId;

    /**
     * 交易状态
     */
    @Column(name = "trade_state")
    @ApiModelProperty(value="tradeState交易状态")
    private String tradeState;

    /**
     * 订单编号列表
     */
    @Column(name = "order_list")
    @ApiModelProperty(value="orderList订单编号列表")
    private String orderList;

    /**
     * 支付类型
     */
    @Column(name = "pay_type")
    @ApiModelProperty(value="payType支付类型")
    private String payType;

    private static final long serialVersionUID = 1L;

    public Paylog(String outTradeNo, Date createTime, Date payTime, Long totalFee, String userId, String transactionId, String tradeState, String orderList, String payType) {
        this.outTradeNo = outTradeNo;
        this.createTime = createTime;
        this.payTime = payTime;
        this.totalFee = totalFee;
        this.userId = userId;
        this.transactionId = transactionId;
        this.tradeState = tradeState;
        this.orderList = orderList;
        this.payType = payType;
    }

    public Paylog() {
        super();
    }

    /**
     * 获取支付订单号
     *
     * @return out_trade_no - 支付订单号
     */
    public String getOutTradeNo() {
        return outTradeNo;
    }

    /**
     * 设置支付订单号
     *
     * @param outTradeNo 支付订单号
     */
    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
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
     * 获取支付完成时间
     *
     * @return pay_time - 支付完成时间
     */
    public Date getPayTime() {
        return payTime;
    }

    /**
     * 设置支付完成时间
     *
     * @param payTime 支付完成时间
     */
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    /**
     * 获取支付金额（分）
     *
     * @return total_fee - 支付金额（分）
     */
    public Long getTotalFee() {
        return totalFee;
    }

    /**
     * 设置支付金额（分）
     *
     * @param totalFee 支付金额（分）
     */
    public void setTotalFee(Long totalFee) {
        this.totalFee = totalFee;
    }

    /**
     * 获取用户ID
     *
     * @return user_id - 用户ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户ID
     *
     * @param userId 用户ID
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取交易号码
     *
     * @return transaction_id - 交易号码
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * 设置交易号码
     *
     * @param transactionId 交易号码
     */
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    /**
     * 获取交易状态
     *
     * @return trade_state - 交易状态
     */
    public String getTradeState() {
        return tradeState;
    }

    /**
     * 设置交易状态
     *
     * @param tradeState 交易状态
     */
    public void setTradeState(String tradeState) {
        this.tradeState = tradeState;
    }

    /**
     * 获取订单编号列表
     *
     * @return order_list - 订单编号列表
     */
    public String getOrderList() {
        return orderList;
    }

    /**
     * 设置订单编号列表
     *
     * @param orderList 订单编号列表
     */
    public void setOrderList(String orderList) {
        this.orderList = orderList;
    }

    /**
     * 获取支付类型
     *
     * @return pay_type - 支付类型
     */
    public String getPayType() {
        return payType;
    }

    /**
     * 设置支付类型
     *
     * @param payType 支付类型
     */
    public void setPayType(String payType) {
        this.payType = payType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", outTradeNo=").append(outTradeNo);
        sb.append(", createTime=").append(createTime);
        sb.append(", payTime=").append(payTime);
        sb.append(", totalFee=").append(totalFee);
        sb.append(", userId=").append(userId);
        sb.append(", transactionId=").append(transactionId);
        sb.append(", tradeState=").append(tradeState);
        sb.append(", orderList=").append(orderList);
        sb.append(", payType=").append(payType);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}