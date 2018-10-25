package cn.tpson.demo.common.util;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Zhangka in 2018/10/25
 */
public class BeanCovertUtils {
    private static final Logger logger = LoggerFactory.getLogger(BeanCovertUtils.class);

    private BeanCovertUtils() {
        throw new AssertionError("no BeanCovertUtils instance for you!");
    }

    /**
     * bean对象之间的转换.
     *
     * @param dest 目标类型
     * @param orig 来源
     * @param <T>  目标类型
     * @return
     */
    public static <T> T beanCovert(Class<T> dest, Object orig) {
        if (orig == null) {
            return null;
        }

        T target = getInstance(dest);
        try {
            BeanUtils.copyProperties(target, orig);
        } catch (IllegalAccessException | InvocationTargetException e) {
            logger.error("t对象初始化错误 [{}]", e.getMessage(), e);
        }
        return target;
    }

    public static <T> List<T> listCovert(final Class<T> dest, final List<?> origs) {
        if (origs == null || origs.isEmpty()) {
            return Collections.emptyList();
        }

        List<T> list = new ArrayList<>();
        origs.forEach(orig -> {
            T t = beanCovert(dest, orig);
            list.add(t);
        });

        return list;
    }

    private static <T> T getInstance(Class<T> targetClass) {
        try {
            return targetClass.newInstance();
        } catch (Exception e) {
            logger.error("t对象初始化错误 [{}]", e.getMessage(), e);
        }
        return null;
    }
}
