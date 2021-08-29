package org.example.offer.mooc.entity.bo;

import lombok.Data;

import java.util.Date;

@Data
public class ShopCategory {
    private Long shopCategoryId;
    private String shopCategoryName;
    private String shopCategoryDesc;
    private String shopCategoryImg;
    private Integer priority;
    private Date lastEditTime;
    private Date createTime;
    private ShopCategory parent;
}
