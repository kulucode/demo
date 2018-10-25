package cn.tpson.demo.springbootdubbo.api.remoteservice;

import cn.tpson.demo.common.dto.Page;
import cn.tpson.demo.common.dto.Result;

import java.util.List;

/**
 * Created by Zhangka in 2018/10/23
 */
public interface BaseRemoteService<DTO, QUERY> {
    /**
     * 通过id查询实体.
     *
     * @param id
     * @return
     */
    Result<DTO> findById(Long id);

    /**
     * 通过id列表查询实体列表，如果查询不到，返回元素数量为0的列表.
     *
     * @param ids
     * @return
     */
    Result<List<DTO>> findByIds(List<Long> ids);

    /**
     * 查询所有实体.
     *
     * @return
     */
    Result<List<DTO>> findAll();

    /**
     * 计算实体总数量.
     *
     * @return
     */
    Result<Long> countAll();

    /**
     * 条件查询实体列表，如果查询不到，返回元素数量为0的列表.
     *
     * @param query
     * @return
     */
    Result<List<DTO>> findByExample(QUERY query);

    /**
     * 按条件计算实体数量.
     *
     * @param query
     * @return
     */
    Result<Long> countByExample(QUERY query);

    /**
     * 分页查询实体列表，如果查询不到，返回元素数量为0的列表.
     *
     * @param query
     * @return
     */
    Result<Page<DTO>> pageByExample(QUERY query);

    /**
     * 更新实体,返回被更新记录数.
     *
     * @param dto
     * @return
     */
    Result<Integer> update(DTO dto);

    /**
     * 保存实体,返回记录id.
     *
     * @param dto
     * @return
     */
    Result<Long> insert(DTO dto);

    /**
     * 通过id删除实体,返回被删除的记录数.
     *
     * @param id
     * @return
     */
    Result<Integer> deleteById(Long id);

    /**
     * 批量删除.
     * @param ids
     * @return
     */
    Result<Integer> deleteByIds(List<Long> ids);
}
