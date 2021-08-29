package org.example.offer.mooc.service.solo;

import org.example.offer.mooc.entity.bo.HeadLine;
import org.example.offer.mooc.entity.bo.ShopCategory;
import org.example.offer.mooc.entity.dto.Result;

import java.util.List;

public interface ShopCategoryService {
    Result<Boolean> addCategory(ShopCategory shopCategory);
    Result<Boolean> removeCategory(int shopCategoryId);
    Result<Boolean> modifyCategory(ShopCategory shopCategory);
    Result<ShopCategory> queryCategoryById(int shopCategoryId);
    Result<List<ShopCategory>> queryCategory(ShopCategory ShopCategory, int pageIndex, int limit);
}
