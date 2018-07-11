package org.imooc.dao;

import org.imooc.bean.Business;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface BusinessDao {

    /**
     * 按分页查询商户列表
     * @return 商户集合
     */
    List<Business> selectByPage(Business business);

    /**
     * 插入商户信息
     * @param business
     * @return 受影响行数s
     */
    int insert(Business business);

    /**
     * 根据ID查询商户
     * @param id
     * @return 商户
     */
    Business selectById(Long id);


    /**
     *  根据查询条件分页查询商户列表 :
     *  标题、副标题、描述三个过滤条件为模糊查询
     *  并且这三个过滤条件之间为或者的关系，用 OR 连接
     *  这三个过滤条件与其他过滤条件依然是并且关系，用 AND 连接
     * @param
     * @return 商户列表
     */
    int updateStar(Map<String,Date> map);

    /**
     *  根据查询条件分页查询商户列表 :
     *  标题、副标题、描述三个过滤条件为模糊查询
     *  并且这三个过滤条件之间为或者的关系，用 OR 连接
     *  这三个过滤条件与其他过滤条件依然是并且关系，用 AND 连接
     * @param business 查询条件
     * @return 商户列表
     */
    List<Business> selectLikeByPage(Business business);
}
