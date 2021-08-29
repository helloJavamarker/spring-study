package org.example.offer.mooc.util;

import java.util.Collection;
import java.util.Map;

public class ValidationUtil {

    //集合
    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.size() == 0;
    }

    public static boolean isEmpty(String str) {
        return str == null || "".equals(str);
    }

    //数组
    public static boolean isEmpty(Object[] objects) {
        return objects == null || objects.length == 0;
    }

    //map
    public static boolean isEmpty(Map<?,?> map) {
        return map == null || map.size() == 0;
    }
}
