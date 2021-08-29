package org.example.offer.mooc.controller.frontend;

import org.example.offer.mooc.annotation.Autowired;
import org.example.offer.mooc.annotation.Controller;
import org.example.offer.mooc.entity.dto.MainPageInfoDTO;
import org.example.offer.mooc.entity.dto.Result;
import org.example.offer.mooc.service.combine.HeadLineShopCategoryCombineService;

@Controller
public class MainPageController {

    @Autowired
    private HeadLineShopCategoryCombineService headLineShopCategoryCombineService;

    public Result<MainPageInfoDTO> getMainPageInfo() {
        return headLineShopCategoryCombineService.getMainPageInfo();
    }
}
