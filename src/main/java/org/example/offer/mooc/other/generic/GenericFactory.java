package org.example.offer.mooc.other.generic;

/**
 * 一般来说
 *  E:element
 *  T:type:java类
 *  K
 *  V
 *  N: number   数字类型
 * @param <T>
 * @param <N>
 */
public interface GenericFactory<T,N>{

    //普通的方法
    T demo(N n);

    //泛型方法  E和T,N没关系,可以一样,也可以不一样
    <E> T demo2(N n);
}
