package me.wangfeng.annotation;

import android.os.Bundle;
import android.os.Parcelable;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by wangfeng on 17/2/15.
 */

public class BundleMaker {

    public static Bundle make(Object instance) {
        try {
            Bundle bundle = new Bundle();
            Field[] fields = instance.getClass().getDeclaredFields();
            if (fields == null || fields.length == 0) {
                return bundle;
            }
            for (Field field : fields) {
                if (!field.isAnnotationPresent(BundleField.class)) {
                    // 该成员变量未被BundleField注解，不需要放入bundle中
                    continue;
                }
                BundleField bundleField = field.getAnnotation(BundleField.class);
                field.setAccessible(true);
                Class<?> fieldType = field.getType();
                if (fieldType.getCanonicalName().equals(Boolean.TYPE.getCanonicalName())) {
                    // boolean类型
                    boolean value = field.getBoolean(instance);
                    bundle.putBoolean(bundleField.key(), value);

                } else if (fieldType.getCanonicalName().equals(Integer.TYPE.getCanonicalName())) {
                    // int类型
                    int value = field.getInt(instance);
                    bundle.putInt(bundleField.key(), value);
                } else if (fieldType.getCanonicalName().equals(Long.TYPE.getCanonicalName())) {
                    // long类型
                    long value = field.getLong(instance);
                    bundle.putLong(bundleField.key(), value);
                } else if (fieldType.getCanonicalName().equals(Double.TYPE.getCanonicalName())) {
                    // double类型
                    double value = field.getDouble(instance);
                    bundle.putDouble(bundleField.key(), value);
                } else if (fieldType.getCanonicalName().equals(Byte.TYPE.getCanonicalName())) {
                    // byte类型
                    byte value = field.getByte(instance);
                    bundle.putByte(bundleField.key(), value);
                } else if (fieldType.getCanonicalName().equals(Character.TYPE.getCanonicalName())) {
                    // char类型
                    char value = field.getChar(instance);
                    bundle.putChar(bundleField.key(), value);
                } else if (fieldType.getCanonicalName().equals(Short.TYPE.getCanonicalName())) {
                    // short类型
                    short value = field.getShort(instance);
                    bundle.putShort(bundleField.key(), value);
                } else if (fieldType.getCanonicalName().equals(Float.TYPE.getCanonicalName())) {
                    // float类型
                    float value = field.getFloat(instance);
                    bundle.putFloat(bundleField.key(), value);
                } else if (fieldType.getCanonicalName().equals(String.class.getCanonicalName())) {
                    // String类型
                    String value = (String) field.get(instance);
                    bundle.putString(bundleField.key(), value);
                } else if (fieldType.getCanonicalName().equals(Parcelable.class.getCanonicalName())) {
                    // Parcelable类型
                    Parcelable value = (Parcelable) field.get(instance);
                    bundle.putParcelable(bundleField.key(), value);
                } else {
                    throw new RuntimeException("不支持的成员变量类型");
                }
            }
            return bundle;
        } catch (Exception e) {
            return null;
        }
    }

    public static void annotationTest(Object object) {
        Class<?> clazz = object.getClass();
        Annotation[] annotations = clazz.getAnnotations();
        if (clazz.isAnnotationPresent(BundleField.class)) {
            BundleField bundleField = clazz.getAnnotation(BundleField.class);
        }
    }
}
