package cn.tpson.demo.springbootdubbo.provider.mapper;

import java.util.List;

public interface BaseMapper<T, QUERY> {

    /**
     * 通过id查询.
     *
     * @param id
     * @return
     */
    T findById(Long id);

    /**
     * 通过id列表查询，如果查询不到，返回元素数量为0的列表.
     *
     * @param ids
     * @return
     */
    List<T> findByIds(List<Long> ids);

    /**
     * 查询所有记录.
     *
     * @return
     */
    List<T> findAll();

    /**
     * 计算总数.
     *
     * @return
     */
    Long countAll();

    /**
     * 条件查询，如果查询不到，返回元素数量为0的列表.
     *
     * @param query
     * @return
     */
    List<T> findByExample(QUERY query);

    /**
     * 多字段查询,返回记录数.
     *
     * @param query
     * @return
     */
    Long countByExample(QUERY query);

    /**
     * 分页查询，如果查询不到，返回元素数量为0的列表.
     *
     * @param query
     * @return
     */
    List<T> pageByExample(QUERY query);

    /**
     * 更新,返回被更新的记录数.
     *
     * @param entity
     * @return
     */
    Integer update(T entity);

    /**
     * 保存,返回记录id.
     *
     * @param entity
     */
    Long insert(T entity);

    /**
     * 通过id删除,返回被删除的记录数.
     *
     * @param id
     * @return
     */
    Integer deleteById(Long id);
}
