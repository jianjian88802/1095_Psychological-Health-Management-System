package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 心理咨询预约申请
 *
 * @author 
 * @email
 */
@TableName("xinlilaoshi_order")
public class XinlilaoshiOrderEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XinlilaoshiOrderEntity() {

	}

	public XinlilaoshiOrderEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 预约流水号
     */
    @TableField(value = "xinlilaoshi_order_uuid_number")

    private String xinlilaoshiOrderUuidNumber;


    /**
     * 心理老师
     */
    @TableField(value = "xinlilaoshi_id")

    private Integer xinlilaoshiId;


    /**
     * 学生
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 预约日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat
    @TableField(value = "yuyue_time")

    private Date yuyueTime;


    /**
     * 预约时间段
     */
    @TableField(value = "shijianduan_types")

    private Integer shijianduanTypes;


    /**
     * 预约状态
     */
    @TableField(value = "xinlilaoshi_order_yesno_types")

    private Integer xinlilaoshiOrderYesnoTypes;


    /**
     * 审核意见
     */
    @TableField(value = "xinlilaoshi_order_yesno_text")

    private String xinlilaoshiOrderYesnoText;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：预约流水号
	 */
    public String getXinlilaoshiOrderUuidNumber() {
        return xinlilaoshiOrderUuidNumber;
    }
    /**
	 * 获取：预约流水号
	 */

    public void setXinlilaoshiOrderUuidNumber(String xinlilaoshiOrderUuidNumber) {
        this.xinlilaoshiOrderUuidNumber = xinlilaoshiOrderUuidNumber;
    }
    /**
	 * 设置：心理老师
	 */
    public Integer getXinlilaoshiId() {
        return xinlilaoshiId;
    }
    /**
	 * 获取：心理老师
	 */

    public void setXinlilaoshiId(Integer xinlilaoshiId) {
        this.xinlilaoshiId = xinlilaoshiId;
    }
    /**
	 * 设置：学生
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 获取：学生
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：预约日期
	 */
    public Date getYuyueTime() {
        return yuyueTime;
    }
    /**
	 * 获取：预约日期
	 */

    public void setYuyueTime(Date yuyueTime) {
        this.yuyueTime = yuyueTime;
    }
    /**
	 * 设置：预约时间段
	 */
    public Integer getShijianduanTypes() {
        return shijianduanTypes;
    }
    /**
	 * 获取：预约时间段
	 */

    public void setShijianduanTypes(Integer shijianduanTypes) {
        this.shijianduanTypes = shijianduanTypes;
    }
    /**
	 * 设置：预约状态
	 */
    public Integer getXinlilaoshiOrderYesnoTypes() {
        return xinlilaoshiOrderYesnoTypes;
    }
    /**
	 * 获取：预约状态
	 */

    public void setXinlilaoshiOrderYesnoTypes(Integer xinlilaoshiOrderYesnoTypes) {
        this.xinlilaoshiOrderYesnoTypes = xinlilaoshiOrderYesnoTypes;
    }
    /**
	 * 设置：审核意见
	 */
    public String getXinlilaoshiOrderYesnoText() {
        return xinlilaoshiOrderYesnoText;
    }
    /**
	 * 获取：审核意见
	 */

    public void setXinlilaoshiOrderYesnoText(String xinlilaoshiOrderYesnoText) {
        this.xinlilaoshiOrderYesnoText = xinlilaoshiOrderYesnoText;
    }
    /**
	 * 设置：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：申请时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "XinlilaoshiOrder{" +
            "id=" + id +
            ", xinlilaoshiOrderUuidNumber=" + xinlilaoshiOrderUuidNumber +
            ", xinlilaoshiId=" + xinlilaoshiId +
            ", yonghuId=" + yonghuId +
            ", yuyueTime=" + yuyueTime +
            ", shijianduanTypes=" + shijianduanTypes +
            ", xinlilaoshiOrderYesnoTypes=" + xinlilaoshiOrderYesnoTypes +
            ", xinlilaoshiOrderYesnoText=" + xinlilaoshiOrderYesnoText +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
