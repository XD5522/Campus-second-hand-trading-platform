package com.example.campus_second_hand_trading_platform.utils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <p>
 *     Beanutils拓展，增加copyList方法
 * </p>
 *
 * @author cc
 * @since 2023-4-22
 */


public class BeanUtils extends org.springframework.beans.BeanUtils {

    /**
     *
     * @param sourceList
     * @param targetClass
     *
     *
     * @param <S>
     * @param <T>
     *
     */
    public static <S, T> List<T> copyPropertiesList(List<S> sourceList, Class<T> targetClass) {
        return sourceList.stream()
                .map(source -> {
                    T target = null;
                    try {
                        target = targetClass.newInstance();
                        BeanUtils.copyProperties(source, target);
                    } catch (InstantiationException | IllegalAccessException e) {
                        // handle exception here
                    }
                    return target;
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
