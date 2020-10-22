package com.supergo.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@ApiModel(value="com.supergo.pojo.Seckillgoods")
@Table(name = "tb_seckill_goods")
public class Seckillgoods implements Serializable {
    /**
     * 商品秒杀产品表id
     */
    @Id
    @ApiModelProperty(value="id商品秒杀产品表id")
    private Integer id;

    /**
     * 商品id
     */
    @Column(name = "product_id")
    @ApiModelProperty(value="productId商品id")
    private Long productId;

    /**
     * 推荐图
     */
    @ApiModelProperty(value="image推荐图")
    private String image;

    /**
     * 轮播图
     */
    @ApiModelProperty(value="images轮播图")
    private String images;

    /**
     * 标签说明
     */
    @ApiModelProperty(value="mark标签说明")
    private String mark;

    /**
     * 活动标题
     */
    @ApiModelProperty(value="title活动标题")
    private String title;

    /**
     * 简介
     */
    @ApiModelProperty(value="info简介")
    private String info;

    /**
     * 秒杀价格
     */
    @ApiModelProperty(value="price秒杀价格")
    private BigDecimal price;

    /**
     * 原价
     */
    @Column(name = "cost_price")
    @ApiModelProperty(value="costPrice原价")
    private BigDecimal costPrice;

    /**
     * 成本
     */
    @Column(name = "ot_price")
    @ApiModelProperty(value="otPrice成本")
    private BigDecimal otPrice;

    /**
     * 返多少积分
     */
    @Column(name = "give_integral")
    @ApiModelProperty(value="giveIntegral返多少积分")
    private BigDecimal giveIntegral;

    /**
     * 排序
     */
    @ApiModelProperty(value="sort排序")
    private Integer sort;

    /**
     * 秒杀商品数
     */
    @ApiModelProperty(value="stock秒杀商品数")
    private Integer stock;

    /**
     * 剩余库存
     */
    @Column(name = "stock_count")
    @ApiModelProperty(value="stockCount剩余库存")
    private Integer stockCount;

    /**
     * 销量
     */
    @ApiModelProperty(value="sales销量")
    private Integer sales;

    /**
     * 单位名
     */
    @Column(name = "unit_name")
    @ApiModelProperty(value="unitName单位名")
    private String unitName;

    /**
     * 邮费
     */
    @ApiModelProperty(value="postage邮费")
    private BigDecimal postage;

    /**
     * 开始时间
     */
    @Column(name = "start_time")
    @ApiModelProperty(value="startTime开始时间")
    private Integer startTime;

    /**
     * 结束时间
     */
    @Column(name = "stop_time")
    @ApiModelProperty(value="stopTime结束时间")
    private Integer stopTime;

    /**
     * 添加时间
     */
    @Column(name = "add_time")
    @ApiModelProperty(value="addTime添加时间")
    private String addTime;

    /**
     * 产品状态
     */
    @ApiModelProperty(value="status产品状态")
    private Byte status;

    /**
     * 是否包邮
     */
    @Column(name = "is_postage")
    @ApiModelProperty(value="isPostage是否包邮")
    private Byte isPostage;

    /**
     * 热门推荐
     */
    @Column(name = "is_hot")
    @ApiModelProperty(value="isHot热门推荐")
    private Byte isHot;

    /**
     * 删除 0未删除1已删除
     */
    @Column(name = "is_del")
    @ApiModelProperty(value="isDel删除 0未删除1已删除")
    private Byte isDel;

    /**
     * 最多秒杀几个
     */
    @ApiModelProperty(value="num最多秒杀几个")
    private Integer num;

    /**
     * 显示
     */
    @Column(name = "is_show")
    @ApiModelProperty(value="isShow显示")
    private Byte isShow;

    @Column(name = "end_time_date")
    @ApiModelProperty(value="endTimeDate")
    private Date endTimeDate;

    @Column(name = "start_time_date")
    @ApiModelProperty(value="startTimeDate")
    private Date startTimeDate;

    /**
     * 时间段id
     */
    @Column(name = "time_id")
    @ApiModelProperty(value="timeId时间段id")
    private Integer timeId;

    /**
     * 时间段id
     */
    @ApiModelProperty(value="version时间段id")
    private Integer version;

    /**
     * 内容
     */
    @ApiModelProperty(value="description内容")
    private String description;

    private static final long serialVersionUID = 1L;

    public Seckillgoods(Integer id, Long productId, String image, String images, String mark, String title, String info, BigDecimal price, BigDecimal costPrice, BigDecimal otPrice, BigDecimal giveIntegral, Integer sort, Integer stock, Integer stockCount, Integer sales, String unitName, BigDecimal postage, Integer startTime, Integer stopTime, String addTime, Byte status, Byte isPostage, Byte isHot, Byte isDel, Integer num, Byte isShow, Date endTimeDate, Date startTimeDate, Integer timeId, Integer version) {
        this.id = id;
        this.productId = productId;
        this.image = image;
        this.images = images;
        this.mark = mark;
        this.title = title;
        this.info = info;
        this.price = price;
        this.costPrice = costPrice;
        this.otPrice = otPrice;
        this.giveIntegral = giveIntegral;
        this.sort = sort;
        this.stock = stock;
        this.stockCount = stockCount;
        this.sales = sales;
        this.unitName = unitName;
        this.postage = postage;
        this.startTime = startTime;
        this.stopTime = stopTime;
        this.addTime = addTime;
        this.status = status;
        this.isPostage = isPostage;
        this.isHot = isHot;
        this.isDel = isDel;
        this.num = num;
        this.isShow = isShow;
        this.endTimeDate = endTimeDate;
        this.startTimeDate = startTimeDate;
        this.timeId = timeId;
        this.version = version;
    }

    public Seckillgoods(Integer id, Long productId, String image, String images, String mark, String title, String info, BigDecimal price, BigDecimal costPrice, BigDecimal otPrice, BigDecimal giveIntegral, Integer sort, Integer stock, Integer stockCount, Integer sales, String unitName, BigDecimal postage, Integer startTime, Integer stopTime, String addTime, Byte status, Byte isPostage, Byte isHot, Byte isDel, Integer num, Byte isShow, Date endTimeDate, Date startTimeDate, Integer timeId, Integer version, String description) {
        this.id = id;
        this.productId = productId;
        this.image = image;
        this.images = images;
        this.mark = mark;
        this.title = title;
        this.info = info;
        this.price = price;
        this.costPrice = costPrice;
        this.otPrice = otPrice;
        this.giveIntegral = giveIntegral;
        this.sort = sort;
        this.stock = stock;
        this.stockCount = stockCount;
        this.sales = sales;
        this.unitName = unitName;
        this.postage = postage;
        this.startTime = startTime;
        this.stopTime = stopTime;
        this.addTime = addTime;
        this.status = status;
        this.isPostage = isPostage;
        this.isHot = isHot;
        this.isDel = isDel;
        this.num = num;
        this.isShow = isShow;
        this.endTimeDate = endTimeDate;
        this.startTimeDate = startTimeDate;
        this.timeId = timeId;
        this.version = version;
        this.description = description;
    }

    public Seckillgoods() {
        super();
    }

    /**
     * 获取商品秒杀产品表id
     *
     * @return id - 商品秒杀产品表id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置商品秒杀产品表id
     *
     * @param id 商品秒杀产品表id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取商品id
     *
     * @return product_id - 商品id
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * 设置商品id
     *
     * @param productId 商品id
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * 获取推荐图
     *
     * @return image - 推荐图
     */
    public String getImage() {
        return image;
    }

    /**
     * 设置推荐图
     *
     * @param image 推荐图
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * 获取轮播图
     *
     * @return images - 轮播图
     */
    public String getImages() {
        return images;
    }

    /**
     * 设置轮播图
     *
     * @param images 轮播图
     */
    public void setImages(String images) {
        this.images = images;
    }

    /**
     * 获取标签说明
     *
     * @return mark - 标签说明
     */
    public String getMark() {
        return mark;
    }

    /**
     * 设置标签说明
     *
     * @param mark 标签说明
     */
    public void setMark(String mark) {
        this.mark = mark;
    }

    /**
     * 获取活动标题
     *
     * @return title - 活动标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置活动标题
     *
     * @param title 活动标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取简介
     *
     * @return info - 简介
     */
    public String getInfo() {
        return info;
    }

    /**
     * 设置简介
     *
     * @param info 简介
     */
    public void setInfo(String info) {
        this.info = info;
    }

    /**
     * 获取秒杀价格
     *
     * @return price - 秒杀价格
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 设置秒杀价格
     *
     * @param price 秒杀价格
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 获取原价
     *
     * @return cost_price - 原价
     */
    public BigDecimal getCostPrice() {
        return costPrice;
    }

    /**
     * 设置原价
     *
     * @param costPrice 原价
     */
    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    /**
     * 获取成本
     *
     * @return ot_price - 成本
     */
    public BigDecimal getOtPrice() {
        return otPrice;
    }

    /**
     * 设置成本
     *
     * @param otPrice 成本
     */
    public void setOtPrice(BigDecimal otPrice) {
        this.otPrice = otPrice;
    }

    /**
     * 获取返多少积分
     *
     * @return give_integral - 返多少积分
     */
    public BigDecimal getGiveIntegral() {
        return giveIntegral;
    }

    /**
     * 设置返多少积分
     *
     * @param giveIntegral 返多少积分
     */
    public void setGiveIntegral(BigDecimal giveIntegral) {
        this.giveIntegral = giveIntegral;
    }

    /**
     * 获取排序
     *
     * @return sort - 排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序
     *
     * @param sort 排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取秒杀商品数
     *
     * @return stock - 秒杀商品数
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * 设置秒杀商品数
     *
     * @param stock 秒杀商品数
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /**
     * 获取剩余库存
     *
     * @return stock_count - 剩余库存
     */
    public Integer getStockCount() {
        return stockCount;
    }

    /**
     * 设置剩余库存
     *
     * @param stockCount 剩余库存
     */
    public void setStockCount(Integer stockCount) {
        this.stockCount = stockCount;
    }

    /**
     * 获取销量
     *
     * @return sales - 销量
     */
    public Integer getSales() {
        return sales;
    }

    /**
     * 设置销量
     *
     * @param sales 销量
     */
    public void setSales(Integer sales) {
        this.sales = sales;
    }

    /**
     * 获取单位名
     *
     * @return unit_name - 单位名
     */
    public String getUnitName() {
        return unitName;
    }

    /**
     * 设置单位名
     *
     * @param unitName 单位名
     */
    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    /**
     * 获取邮费
     *
     * @return postage - 邮费
     */
    public BigDecimal getPostage() {
        return postage;
    }

    /**
     * 设置邮费
     *
     * @param postage 邮费
     */
    public void setPostage(BigDecimal postage) {
        this.postage = postage;
    }

    /**
     * 获取开始时间
     *
     * @return start_time - 开始时间
     */
    public Integer getStartTime() {
        return startTime;
    }

    /**
     * 设置开始时间
     *
     * @param startTime 开始时间
     */
    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    /**
     * 获取结束时间
     *
     * @return stop_time - 结束时间
     */
    public Integer getStopTime() {
        return stopTime;
    }

    /**
     * 设置结束时间
     *
     * @param stopTime 结束时间
     */
    public void setStopTime(Integer stopTime) {
        this.stopTime = stopTime;
    }

    /**
     * 获取添加时间
     *
     * @return add_time - 添加时间
     */
    public String getAddTime() {
        return addTime;
    }

    /**
     * 设置添加时间
     *
     * @param addTime 添加时间
     */
    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    /**
     * 获取产品状态
     *
     * @return status - 产品状态
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置产品状态
     *
     * @param status 产品状态
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * 获取是否包邮
     *
     * @return is_postage - 是否包邮
     */
    public Byte getIsPostage() {
        return isPostage;
    }

    /**
     * 设置是否包邮
     *
     * @param isPostage 是否包邮
     */
    public void setIsPostage(Byte isPostage) {
        this.isPostage = isPostage;
    }

    /**
     * 获取热门推荐
     *
     * @return is_hot - 热门推荐
     */
    public Byte getIsHot() {
        return isHot;
    }

    /**
     * 设置热门推荐
     *
     * @param isHot 热门推荐
     */
    public void setIsHot(Byte isHot) {
        this.isHot = isHot;
    }

    /**
     * 获取删除 0未删除1已删除
     *
     * @return is_del - 删除 0未删除1已删除
     */
    public Byte getIsDel() {
        return isDel;
    }

    /**
     * 设置删除 0未删除1已删除
     *
     * @param isDel 删除 0未删除1已删除
     */
    public void setIsDel(Byte isDel) {
        this.isDel = isDel;
    }

    /**
     * 获取最多秒杀几个
     *
     * @return num - 最多秒杀几个
     */
    public Integer getNum() {
        return num;
    }

    /**
     * 设置最多秒杀几个
     *
     * @param num 最多秒杀几个
     */
    public void setNum(Integer num) {
        this.num = num;
    }

    /**
     * 获取显示
     *
     * @return is_show - 显示
     */
    public Byte getIsShow() {
        return isShow;
    }

    /**
     * 设置显示
     *
     * @param isShow 显示
     */
    public void setIsShow(Byte isShow) {
        this.isShow = isShow;
    }

    /**
     * @return end_time_date
     */
    public Date getEndTimeDate() {
        return endTimeDate;
    }

    /**
     * @param endTimeDate
     */
    public void setEndTimeDate(Date endTimeDate) {
        this.endTimeDate = endTimeDate;
    }

    /**
     * @return start_time_date
     */
    public Date getStartTimeDate() {
        return startTimeDate;
    }

    /**
     * @param startTimeDate
     */
    public void setStartTimeDate(Date startTimeDate) {
        this.startTimeDate = startTimeDate;
    }

    /**
     * 获取时间段id
     *
     * @return time_id - 时间段id
     */
    public Integer getTimeId() {
        return timeId;
    }

    /**
     * 设置时间段id
     *
     * @param timeId 时间段id
     */
    public void setTimeId(Integer timeId) {
        this.timeId = timeId;
    }

    /**
     * 获取时间段id
     *
     * @return version - 时间段id
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * 设置时间段id
     *
     * @param version 时间段id
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * 获取内容
     *
     * @return description - 内容
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置内容
     *
     * @param description 内容
     */
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", productId=").append(productId);
        sb.append(", image=").append(image);
        sb.append(", images=").append(images);
        sb.append(", mark=").append(mark);
        sb.append(", title=").append(title);
        sb.append(", info=").append(info);
        sb.append(", price=").append(price);
        sb.append(", costPrice=").append(costPrice);
        sb.append(", otPrice=").append(otPrice);
        sb.append(", giveIntegral=").append(giveIntegral);
        sb.append(", sort=").append(sort);
        sb.append(", stock=").append(stock);
        sb.append(", stockCount=").append(stockCount);
        sb.append(", sales=").append(sales);
        sb.append(", unitName=").append(unitName);
        sb.append(", postage=").append(postage);
        sb.append(", startTime=").append(startTime);
        sb.append(", stopTime=").append(stopTime);
        sb.append(", addTime=").append(addTime);
        sb.append(", status=").append(status);
        sb.append(", isPostage=").append(isPostage);
        sb.append(", isHot=").append(isHot);
        sb.append(", isDel=").append(isDel);
        sb.append(", num=").append(num);
        sb.append(", isShow=").append(isShow);
        sb.append(", endTimeDate=").append(endTimeDate);
        sb.append(", startTimeDate=").append(startTimeDate);
        sb.append(", timeId=").append(timeId);
        sb.append(", version=").append(version);
        sb.append(", description=").append(description);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}