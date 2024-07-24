package com.entity.model;

import com.entity.XinlilaoshiOrderEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 心理咨询预约申请
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class XinlilaoshiOrderModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 预约流水号
     */
    private String xinlilaoshiOrderUuidNumber;


    /**
     * 心理老师
     */
    private Integer xinlilaoshiId;


    /**
     * 学生
     */
    private Integer yonghuId;


    /**
     * 预约日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date yuyueTime;


    /**
     * 预约时间段
     */
    private Integer shijianduanTypes;


    /**
     * 预约状态
     */
    private Integer xinlilaoshiOrderYesnoTypes;


    /**
     * 审核意见
     */
    private String xinlilaoshiOrderYesnoText;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show3
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：预约流水号
	 */
    public String getXinlilaoshiOrderUuidNumber() {
        return xinlilaoshiOrderUuidNumber;
    }


    /**
	 * 设置：预约流水号
	 */
    public void setXinlilaoshiOrderUuidNumber(String xinlilaoshiOrderUuidNumber) {
        this.xinlilaoshiOrderUuidNumber = xinlilaoshiOrderUuidNumber;
    }
    /**
	 * 获取：心理老师
	 */
    public Integer getXinlilaoshiId() {
        return xinlilaoshiId;
    }


    /**
	 * 设置：心理老师
	 */
    public void setXinlilaoshiId(Integer xinlilaoshiId) {
        this.xinlilaoshiId = xinlilaoshiId;
    }
    /**
	 * 获取：学生
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：学生
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：预约日期
	 */
    public Date getYuyueTime() {
        return yuyueTime;
    }


    /**
	 * 设置：预约日期
	 */
    public void setYuyueTime(Date yuyueTime) {
        this.yuyueTime = yuyueTime;
    }
    /**
	 * 获取：预约时间段
	 */
    public Integer getShijianduanTypes() {
        return shijianduanTypes;
    }


    /**
	 * 设置：预约时间段
	 */
    public void setShijianduanTypes(Integer shijianduanTypes) {
        this.shijianduanTypes = shijianduanTypes;
    }
    /**
	 * 获取：预约状态
	 */
    public Integer getXinlilaoshiOrderYesnoTypes() {
        return xinlilaoshiOrderYesnoTypes;
    }


    /**
	 * 设置：预约状态
	 */
    public void setXinlilaoshiOrderYesnoTypes(Integer xinlilaoshiOrderYesnoTypes) {
        this.xinlilaoshiOrderYesnoTypes = xinlilaoshiOrderYesnoTypes;
    }
    /**
	 * 获取：审核意见
	 */
    public String getXinlilaoshiOrderYesnoText() {
        return xinlilaoshiOrderYesnoText;
    }


    /**
	 * 设置：审核意见
	 */
    public void setXinlilaoshiOrderYesnoText(String xinlilaoshiOrderYesnoText) {
        this.xinlilaoshiOrderYesnoText = xinlilaoshiOrderYesnoText;
    }
    /**
	 * 获取：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：申请时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间 show3
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
