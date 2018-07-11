package org.imooc.dao;

import org.imooc.bean.Ad;
import org.imooc.dto.AdDto;

import java.util.List;

public interface AdDao {
    /**
     * 添加广告
     * @param ad
     * @return
     */
   int  insert(Ad ad);

    /**
     * 查询所有广告信息
     * @return
     */
   List<Ad> selectByPage(Ad ad);

    /**
     * 根据主键查询所需要的广告信息
     * @param id
     * @return
     */
   Ad selectById(Long id);
    /**
     * 删除广告
     * @param id
     * @return 受影响行数
     */
   int  delete(Long id);

    /**
     * 修改广告内容
     * @param ad
     * @return 返回受影响行数
     */
   int update(Ad ad);
}
