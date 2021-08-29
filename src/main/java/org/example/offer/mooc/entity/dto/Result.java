package org.example.offer.mooc.entity.dto;

import lombok.Data;

/**
 * dto下存放controller到service之间传输的对象
 * @param <T>
 */
@Data
public class Result<T> {
    // code== 200 表示成功
    private int code;

    private String msg;
    private T data;
}
