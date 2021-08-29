package org.example.offer.mooc.entity.dto;

import lombok.Data;
import org.example.offer.mooc.entity.bo.HeadLine;
import org.example.offer.mooc.entity.bo.ShopCategory;

import java.util.List;

@Data
public class MainPageInfoDTO {
    private List<HeadLine> headLineList;
    private List<ShopCategory> shopCategoryList;
}
