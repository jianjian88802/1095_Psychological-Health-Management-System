package com.entity.view;

import com.entity.XinlilaoshiOrderEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 心理咨询预约申请
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("xinlilaoshi_order")
public class XinlilaoshiOrderView extends XinlilaoshiOrderEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 预约时间段的值
		*/
		private String shijianduanValue;
		/**
		* 预约状态的值
		*/
		private String xinlilaoshiOrderYesnoValue;



		//级联表 yonghu
			/**
			* 学生姓名
			*/
			private String yonghuName;
			/**
			* 学生手机号
			*/
			private String yonghuPhone;
			/**
			* 学生身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 学生头像
			*/
			private String yonghuPhoto;
			/**
			* 电子邮箱
			*/
			private String yonghuEmail;

		//级联表 xinlilaoshi
			/**
			* 心理老师姓名
			*/
			private String xinlilaoshiName;
			/**
			* 心理老师手机号
			*/
			private String xinlilaoshiPhone;
			/**
			* 心理老师头像
			*/
			private String xinlilaoshiPhoto;
			/**
			* 电子邮箱
			*/
			private String xinlilaoshiEmail;
			/**
			* 擅长
			*/
			private String xinlilaoshiShanchang;
			/**
			* 履历
			*/
			private String xinlilaoshiLvli;
			/**
			* 心理老师详细介绍
			*/
			private String xinlilaoshiContent;

	public XinlilaoshiOrderView() {

	}

	public XinlilaoshiOrderView(XinlilaoshiOrderEntity xinlilaoshiOrderEntity) {
		try {
			BeanUtils.copyProperties(this, xinlilaoshiOrderEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 预约时间段的值
			*/
			public String getShijianduanValue() {
				return shijianduanValue;
			}
			/**
			* 设置： 预约时间段的值
			*/
			public void setShijianduanValue(String shijianduanValue) {
				this.shijianduanValue = shijianduanValue;
			}
			/**
			* 获取： 预约状态的值
			*/
			public String getXinlilaoshiOrderYesnoValue() {
				return xinlilaoshiOrderYesnoValue;
			}
			/**
			* 设置： 预约状态的值
			*/
			public void setXinlilaoshiOrderYesnoValue(String xinlilaoshiOrderYesnoValue) {
				this.xinlilaoshiOrderYesnoValue = xinlilaoshiOrderYesnoValue;
			}






































				//级联表的get和set yonghu

					/**
					* 获取： 学生姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 学生姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}

					/**
					* 获取： 学生手机号
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 学生手机号
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}

					/**
					* 获取： 学生身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 学生身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}

					/**
					* 获取： 学生头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 学生头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}

					/**
					* 获取： 电子邮箱
					*/
					public String getYonghuEmail() {
						return yonghuEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setYonghuEmail(String yonghuEmail) {
						this.yonghuEmail = yonghuEmail;
					}


				//级联表的get和set xinlilaoshi

					/**
					* 获取： 心理老师姓名
					*/
					public String getXinlilaoshiName() {
						return xinlilaoshiName;
					}
					/**
					* 设置： 心理老师姓名
					*/
					public void setXinlilaoshiName(String xinlilaoshiName) {
						this.xinlilaoshiName = xinlilaoshiName;
					}

					/**
					* 获取： 心理老师手机号
					*/
					public String getXinlilaoshiPhone() {
						return xinlilaoshiPhone;
					}
					/**
					* 设置： 心理老师手机号
					*/
					public void setXinlilaoshiPhone(String xinlilaoshiPhone) {
						this.xinlilaoshiPhone = xinlilaoshiPhone;
					}

					/**
					* 获取： 心理老师头像
					*/
					public String getXinlilaoshiPhoto() {
						return xinlilaoshiPhoto;
					}
					/**
					* 设置： 心理老师头像
					*/
					public void setXinlilaoshiPhoto(String xinlilaoshiPhoto) {
						this.xinlilaoshiPhoto = xinlilaoshiPhoto;
					}

					/**
					* 获取： 电子邮箱
					*/
					public String getXinlilaoshiEmail() {
						return xinlilaoshiEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setXinlilaoshiEmail(String xinlilaoshiEmail) {
						this.xinlilaoshiEmail = xinlilaoshiEmail;
					}

					/**
					* 获取： 擅长
					*/
					public String getXinlilaoshiShanchang() {
						return xinlilaoshiShanchang;
					}
					/**
					* 设置： 擅长
					*/
					public void setXinlilaoshiShanchang(String xinlilaoshiShanchang) {
						this.xinlilaoshiShanchang = xinlilaoshiShanchang;
					}

					/**
					* 获取： 履历
					*/
					public String getXinlilaoshiLvli() {
						return xinlilaoshiLvli;
					}
					/**
					* 设置： 履历
					*/
					public void setXinlilaoshiLvli(String xinlilaoshiLvli) {
						this.xinlilaoshiLvli = xinlilaoshiLvli;
					}

					/**
					* 获取： 心理老师详细介绍
					*/
					public String getXinlilaoshiContent() {
						return xinlilaoshiContent;
					}
					/**
					* 设置： 心理老师详细介绍
					*/
					public void setXinlilaoshiContent(String xinlilaoshiContent) {
						this.xinlilaoshiContent = xinlilaoshiContent;
					}




}
