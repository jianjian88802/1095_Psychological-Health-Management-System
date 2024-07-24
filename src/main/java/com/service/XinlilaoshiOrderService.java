package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XinlilaoshiOrderEntity;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 * 心理咨询预约申请 服务类
 */
public interface XinlilaoshiOrderService extends IService<XinlilaoshiOrderEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}