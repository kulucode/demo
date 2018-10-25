package cn.tpson.demo.springbootdubbo.provider.service;

import cn.tpson.demo.common.dto.Page;

import java.util.List;

/**
 * Created by Zhangka in 2018/10/24
 */
public interface BaseService<DTO, QUERY> {
    /**
     * 通过id查询记录.
     *
     * @param id
     * @return
     */
    DTO findById(Long id);

    /**
     * 通过id列表查询记录，如果查询不到，返回元素数量为0的列表.
     *
     * @param ids
     * @return
     */
    List<DTO> findByIds(List<Long> ids);

    /**
     * 查询所有记录.
     *
     * @return
     */
    List<DTO> findAll();

    /**
     * 计算记录总数量.
     *
     * @return
     */
    Long countAll();

    /**
     * 条件查询记录列表，如果查询不到，返回元素数量为0的列表.
     *
     * @param query
     * @return
     */
    List<DTO> findByExample(QUERY query);

    /**
     * 多字段查询,返回记录数.
     *
     * @param query
     * @return
     */
    Long countByExample(QUERY query);

    /**
     * 分页查询记录列表，如果查询不到，返回元素数量为0的列表.
     *
     * @param query
     * @return
     */
    Page<DTO> pageByExample(QUERY query);

    /**
     * 更新记录,返回被更新的记录数.
     *
     * @param dto
     * @return
     */
    Integer update(DTO dto);

    /**
     * 保存记录,返回记录id.
     *
     * @param dto
     */
    Long insert(DTO dto);

    /**
     * 通过id删除记录.
     *
     * @param id
     * @return
     */
    Integer deleteById(Long id);
}