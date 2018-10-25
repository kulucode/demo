package cn.tpson.demo.springbootdubbo.provider.service.impl;

import cn.tpson.demo.common.dto.Page;
import cn.tpson.demo.common.util.BeanCovertUtils;
import cn.tpson.demo.common.util.ReflectUtils;
import cn.tpson.demo.springbootdubbo.provider.mapper.BaseMapper;
import cn.tpson.demo.springbootdubbo.provider.service.BaseService;

import java.time.Instant;
import java.util.List;

public abstract class BaseServiceImpl<DTO, QUERY, DO> implements BaseService<DTO, QUERY> {
    private Class<DTO> dtoClass;
    private Class<DO> entityClass;

    protected abstract BaseMapper<DO, QUERY> mapper();

    public BaseServiceImpl() {
        this.dtoClass = ReflectUtils.getClassGenericType(this.getClass(), 0);
        this.entityClass = ReflectUtils.getClassGenericType(this.getClass(), 2);
    }

    @Override
    public DTO findById(Long id) {
        return BeanCovertUtils.beanCovert(dtoClass, mapper().findById(id));
    }

    @Override
    public List<DTO> findByIds(List<Long> ids) {
        return BeanCovertUtils.listCovert(dtoClass, mapper().findByIds(ids));
    }

    @Override
    public List<DTO> findAll() {
        return BeanCovertUtils.listCovert(dtoClass, mapper().findAll());
    }

    @Override
    public Long countAll() {
        return mapper().countAll();
    }

    @Override
    public List<DTO> findByExample(QUERY query) {
        return BeanCovertUtils.listCovert(dtoClass, mapper().findByExample(query));
    }

    @Override
    public Long countByExample(QUERY query) {
        return mapper().countByExample(query);
    }

    @Override
    public Page<DTO> pageByExample(QUERY query) {
        Integer pageNo = (Integer) ReflectUtils.getFieldValue(query, "pageNo");
        Integer pageSize = (Integer) ReflectUtils.getFieldValue(query, "pageSize");
        Page<DTO> page = new Page<>(pageNo, pageSize);
        List<DTO> list = BeanCovertUtils.listCovert(dtoClass, mapper().pageByExample(query));
        Long count = countByExample(query);
        page.setResultList(list);
        page.setTotalCount(count.intValue());

        return page;
    }

    @Override
    public Integer update(DTO dto) {
        DO entity = BeanCovertUtils.beanCovert(entityClass, dto);
        ReflectUtils.setFieldValue(entity, "gmtModified", Instant.now());

        return mapper().update(entity);
    }

    @Override
    public Long insert(DTO dto) {
        DO entity = BeanCovertUtils.beanCovert(entityClass, dto);
        ReflectUtils.setFieldValue(entity, "gmtCreate", Instant.now());
        ReflectUtils.setFieldValue(entity, "deleted", Boolean.FALSE);

        return mapper().insert(entity);
    }

    @Override
    public Integer deleteById(Long id) {
        return mapper().deleteById(id);
    }
}
