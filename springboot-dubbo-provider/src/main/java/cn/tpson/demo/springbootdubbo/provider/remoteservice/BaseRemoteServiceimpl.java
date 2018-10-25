package cn.tpson.demo.springbootdubbo.provider.remoteservice;

import cn.tpson.demo.common.dto.Page;
import cn.tpson.demo.common.dto.Result;
import cn.tpson.demo.springbootdubbo.api.remoteservice.BaseRemoteService;
import cn.tpson.demo.springbootdubbo.provider.mapper.BaseMapper;
import cn.tpson.demo.springbootdubbo.provider.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public abstract class BaseRemoteServiceimpl<DTO, QUERY> implements BaseRemoteService<DTO, QUERY> {
    protected static final Logger logger = LoggerFactory.getLogger(BaseRemoteServiceimpl.class);
    public static final String ERROR_MSG_SELECT_ERROR = "查找时出错";
    public static final String ERROR_MSG_UPDATE_ERROR = "更新时出错";
    public static final String ERROR_MSG_DELETE_ERROR = "删除时出错";
    public static final String ERROR_MSG_INSERT_ERROR = "保存时出错";

    protected abstract BaseService<DTO, QUERY> baseService();

    @Override
    public Result<DTO> findById(Long id) {
        try {
            DTO dto = baseService().findById(id);
            return Result.successResult(dto);
        } catch (Exception e) {
            logger.error("findById", e);
            return Result.failResult(ERROR_MSG_SELECT_ERROR);
        }
    }

    @Override
    public Result<List<DTO>> findByIds(List<Long> ids) {
        try {
            List<DTO> list = baseService().findByIds(ids);
            return Result.successResult(list);
        } catch (Exception e) {
            logger.error("findByIds", e);
            return Result.failResult(ERROR_MSG_SELECT_ERROR);
        }
    }

    @Override
    public Result<List<DTO>> findAll() {
        try {
            List<DTO> list = baseService().findAll();
            return Result.successResult(list);
        } catch (Exception e) {
            logger.error("findAll", e);
            return Result.failResult(ERROR_MSG_SELECT_ERROR);
        }
    }

    @Override
    public Result<Long> countAll() {
        try {
            Long count = baseService().countAll();
            return Result.successResult(count);
        } catch (Exception e) {
            logger.error("countAll", e);
            return Result.failResult(ERROR_MSG_SELECT_ERROR);
        }
    }

    @Override
    public Result<List<DTO>> findByExample(QUERY query) {
        try {
            List<DTO> list = baseService().findByExample(query);
            return Result.successResult(list);
        } catch (Exception e) {
            logger.error("findByExample", e);
            return Result.failResult(ERROR_MSG_SELECT_ERROR);
        }
    }

    @Override
    public Result<Long> countByExample(QUERY query) {
        try {
            Long count = baseService().countByExample(query);
            return Result.successResult(count);
        } catch (Exception e) {
            logger.error("countByExample", e);
            return Result.failResult(ERROR_MSG_SELECT_ERROR);
        }
    }

    @Override
    public Result<Page<DTO>> pageByExample(QUERY query) {
        try {
            Page<DTO> page = baseService().pageByExample(query);
            return Result.successResult(page);
        } catch (Exception e) {
            logger.error("pageByExample", e);
            return Result.failResult(ERROR_MSG_SELECT_ERROR);
        }
    }

    @Override
    public Result<Integer> update(DTO dto) {
        try {
            Integer count = baseService().update(dto);
            return Result.successResult(count);
        } catch (Exception e) {
            logger.error("update", e);
            return Result.failResult(ERROR_MSG_UPDATE_ERROR);
        }
    }

    @Override
    public Result<Long> insert(DTO dto) {
        try {
            Long id = baseService().insert(dto);
            return Result.successResult(id);
        } catch (Exception e) {
            logger.error("insert", e);
            return Result.failResult(ERROR_MSG_INSERT_ERROR);
        }
    }

    @Override
    public Result<Integer> deleteById(Long id) {
        try {
            Integer count = baseService().deleteById(id);
            return Result.successResult(count);
        } catch (Exception e) {
            logger.error("deleteById", e);
            return Result.failResult(ERROR_MSG_INSERT_ERROR);
        }
    }

    @Override
    public Result<Integer> deleteByIds(List<Long> ids) {
        try {
            Integer count = 0;
            for (Long id : ids) {
                count += baseService().deleteById(id);
            }
            return Result.successResult(count);
        } catch (Exception e) {
            logger.error("deleteByIds", e);
            return Result.failResult(ERROR_MSG_INSERT_ERROR);
        }
    }
}
