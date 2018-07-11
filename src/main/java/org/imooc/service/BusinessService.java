package org.imooc.service;

import org.imooc.bean.Business;
import org.imooc.dto.BusinessDto;
import org.imooc.dto.BusinessListDto;

import java.util.List;

public interface BusinessService {

    /**
     * 按分页查询商户信息
     * @param businessDto
     * @return
     */
    List<BusinessDto> searchByPage(BusinessDto businessDto);

    /**
     * 插入新的商户信息
     * @param businessDto
     * @return 返回true或false：true：插入成功；false：插入失败
     */
    boolean insertBusiness(BusinessDto businessDto);

    /**
     * 根据ID查询商户信息
     * @param id
     * @return
     */
    BusinessDto selectById(Long id);

    /**
     * 分页搜索商户列表(接口专用)
     * @param businessDto 查询条件(包含分页对象)
     * @return 商户列表Dto对象
     */
    BusinessListDto searchByPageForApi(BusinessDto businessDto);
}
