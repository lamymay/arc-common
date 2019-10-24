package com.arc.utils.bean;

import com.arc.core.enums.system.ProjectCodeEnum;
import com.arc.core.exception.BizException;
import net.sf.cglib.beans.BeanCopier;
import net.sf.cglib.beans.BeanGenerator;
import net.sf.cglib.beans.BeanMap;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Field;
import java.util.*;

/**
 * 对象拷贝工具
 * @author Lamy
 */
public class BeanUtil {

    private BeanUtil() {
    }

    /**
     * BeanCopier缓存
     */
    public static Map<String, BeanCopier> beanCopierMap = new HashMap<>();

    private static final String UID_STR = "serialVersionUID";

    /**
     * 拷贝内容
     *
     * @param source
     * @param target
     */
    public static void copyProperties(Object source, Object target) {
        String beanKey = generateKey(source.getClass(), target.getClass());
        BeanCopier copier = null;
        if (!beanCopierMap.containsKey(beanKey)) {
            copier = BeanCopier.create(source.getClass(), target.getClass(), false);
            beanCopierMap.put(beanKey, copier);
        } else {
            copier = beanCopierMap.get(beanKey);
        }
        copier.copy(source, target, null);
    }

    /**
     * 生成key
     *
     * @param sourceClass
     * @param targetClass
     * @return
     */
    private static String generateKey(Class<?> sourceClass, Class<?> targetClass) {
        return sourceClass.toString() + targetClass.toString();
    }

    /**
     * 拷贝对象
     *
     * @param source
     * @param target
     * @param <T>
     * @return
     */
    public static <T> T copyBean(Object source, Class<T> target) {
        T instance = null;
        if (source == null || target == null) {
            return null;
        }
        try {
            instance = target.newInstance();
            copyProperties(source, instance);
        } catch (Exception e) {
            throw new BizException(e, ProjectCodeEnum.BEAN_COPY_EXCEPTION);
        }
        return instance;
    }

    /**
     * 拷贝列表
     *
     * @param source
     * @param target
     * @param <T>
     * @return
     */
    public static <T> List<T> copyList(List<?> source, Class<T> target) {
        if (CollectionUtils.isEmpty(source) || target == null) {
            return Collections.emptyList();
        }
        List<T> result = new ArrayList<T>();
        for (Object obj : source) {
            result.add(copyBean(obj, target));
        }
        return result;
    }

    /**
     * 拷贝列表(含属性名映射)
     *
     * @param source
     * @param target
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> List<T> copyList(List<?> source, Class<T> target, Map<String, String> relation) {
        if (CollectionUtils.isEmpty(source) || target == null) {
            return new ArrayList<T>();
        }
        if (relation==null||relation.isEmpty()) {
            return copyList(source, target);
        }
        List<T> result = new ArrayList<T>(source.size());
        // 生成对象参数缓存
        Map<String, Class<?>> propertyMap = new HashMap<>();
        // 对象属性赋值缓存
        Map<String, Object> valueMap = new HashMap<>();
        try {
            for (Object obj : source) {
                T instance = target.newInstance();
                Field[] fields = instance.getClass().getDeclaredFields();
                for (Field fieldIns : fields) {
                    fieldIns.setAccessible(true);
                    // 忽略UID的参数
                    if (!StringUtils.equals(fieldIns.getName(), UID_STR)) {
                        propertyMap.put(fieldIns.getName(), fieldIns.getType());
                    }
                    // 有映射关系的属性值缓存
                    if (!relation.containsValue(fieldIns.getName())) {
                        Field fieldObj = obj.getClass().getDeclaredField(fieldIns.getName());
                        fieldObj.setAccessible(true);
                        valueMap.put(fieldIns.getName(), fieldObj.get(obj));
                    }
                }
                // 生成对象并赋值
                CglibBean cglibBean = new CglibBean(propertyMap);
                for (Map.Entry entry : relation.entrySet()) {
                    Field fieldObj = obj.getClass().getDeclaredField((String) entry.getKey());
                    fieldObj.setAccessible(true);
                    valueMap.put((String) entry.getValue(), fieldObj.get(obj));
                }
                for (Map.Entry entry : valueMap.entrySet()) {
                    cglibBean.setValue((String) entry.getKey(), entry.getValue());
                }
                result.add((T) cglibBean.getObject());
            }
        } catch (Exception e) {
            throw new BizException(e, ProjectCodeEnum.BEAN_COPY_EXCEPTION);
        }
        return result;
    }

    /**
     * CglibBean 操作操作类
     */
    private static class CglibBean {
        /**
         * 实体Object
         */
        public Object object = null;

        /**
         * 属性map
         */
        public BeanMap beanMap = null;

        public CglibBean() {
            super();
        }

        @SuppressWarnings("unchecked")
        public CglibBean(Map propertyMap) {
            this.object = generateBean(propertyMap);
            this.beanMap = BeanMap.create(this.object);
        }

        /**
         * 给bean属性赋值
         * @param property 属性名
         * @param value 值
         */
        public void setValue(String property, Object value) {
            beanMap.put(property, value);
        }

        /**
         * 通过属性名得到属性值
         * @param property 属性名
         * @return 值
         */
        public Object getValue(String property) {
            return beanMap.get(property);
        }

        /**
         * 得到该实体bean对象
         * @return
         */
        public Object getObject() {
            return this.object;
        }

        @SuppressWarnings("unchecked")
        private Object generateBean(Map propertyMap) {
            BeanGenerator generator = new BeanGenerator();
            Set keySet = propertyMap.keySet();
            for (Iterator i = keySet.iterator(); i.hasNext();) {
                String key = (String) i.next();
                generator.addProperty(key, (Class) propertyMap.get(key));
            }
            return generator.create();
        }
    }
}
