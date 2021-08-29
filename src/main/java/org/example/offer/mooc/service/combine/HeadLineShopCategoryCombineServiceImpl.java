package org.example.offer.mooc.service.combine;

import org.example.offer.mooc.annotation.Autowired;
import org.example.offer.mooc.annotation.Controller;
import org.example.offer.mooc.annotation.Service;
import org.example.offer.mooc.entity.bo.HeadLine;
import org.example.offer.mooc.entity.bo.ShopCategory;
import org.example.offer.mooc.entity.dto.MainPageInfoDTO;
import org.example.offer.mooc.entity.dto.Result;
import org.example.offer.mooc.service.solo.HeadLineService;
import org.example.offer.mooc.service.solo.ShopCategoryService;

import java.util.List;

@Service
public class HeadLineShopCategoryCombineServiceImpl implements HeadLineShopCategoryCombineService {

    @Autowired
    private HeadLineService headLineService;
    @Autowired
    private ShopCategoryService shopCategoryService;
    @Override
    public Result<MainPageInfoDTO> getMainPageInfo() {
        HeadLine headLine = new HeadLine();
        headLine.setEnableStatus(1);
        Result<List<HeadLine>> headLineResult = headLineService.queryHeadLine(headLine, 1, 10);
        ShopCategory shopCategory = new ShopCategory();
        Result<List<ShopCategory>> shopCategoryResult = shopCategoryService.queryCategory(shopCategory, 1, 100);
        Result<MainPageInfoDTO> result = mergeMainPageInfoResult(headLineResult, shopCategoryResult);
        return result;
    }

    private Result<MainPageInfoDTO> mergeMainPageInfoResult(Result<List<HeadLine>> headLineResult, Result<List<ShopCategory>> shopCategoryResult) {
        return null;
    }
}
