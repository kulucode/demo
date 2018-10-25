package cn.tpson.demo.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by Zhangka in 2018/10/25
 */
public class ReflectUtils {
    private static final Logger logger = LoggerFactory.getLogger(ReflectUtils.class);

    private ReflectUtils() {
        throw new AssertionError("no ReflectUtils instance for you!");
    }

    public static <T> Class<T> getClassGenericType(Class<? extends Object> clazz, int index) {
        Type genType = clazz.getGenericSuperclass();
        if (!(genType instanceof ParameterizedType)) {
            logger.info("{}'s superclass not ParameterizedType", clazz.getSimpleName());
            return null;
        }
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        if ((index >= params.length) || (index < 0)) {
            logger.info("Index: {}, Size of {}'s Parameterized Type: {}", index, clazz.getSimpleName(), params.length);
            return null;
        }
        if (!(params[index] instanceof Class)) {
            logger.info("{} not set the actual class on superclass generic parameter", clazz.getSimpleName());
            return null;
        }

        Class<T> ret = (Class) params[index];
        return ret;
    }

    public static Object getFieldValue(Object obj, String fieldName) {
        Field field = getAccessibleField(obj, fieldName);
        if (field == null) {
            throw new IllegalArgumentException("Could not find field [" + fieldName + "] on target [" + obj + "]");
        }
        Object result = null;
        try {
            result = field.get(obj);
        } catch (IllegalAccessException e) {
            logger.error("获取属性值出错:{}", e.getMessage());
        }
        return result;
    }

    public static void setFieldValue(Object obj, String fieldName, Object value) {
        Field field = getAccessibleField(obj, fieldName);
        if (field == null) {
            throw new IllegalArgumentException("Could not find field [" + fieldName + "] on target [" + obj + "]");
        }
        try {
            field.set(obj, value);
        } catch (IllegalAccessException e) {
            logger.error("设置属性值出错:{}", e.getMessage());
        }
    }

    public static Field getAccessibleField(Object obj, String fieldName) {
        for (Class<?> superClass = obj.getClass(); superClass != Object.class; superClass = superClass.getSuperclass()) {
            try {
                Field field = superClass.getDeclaredField(fieldName);
                field.setAccessible(true);
                return field;
            } catch (NoSuchFieldException e) {
                logger.error("获取属性字段出错:{}", e.getMessage());
            }
        }
        return null;
    }
}
