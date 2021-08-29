package org.example.offer.mooc.service.combine;

import org.example.offer.mooc.entity.dto.MainPageInfoDTO;
import org.example.offer.mooc.entity.dto.Result;
import org.example.offer.mooc.service.solo.HeadLineService;

public interface HeadLineShopCategoryCombineService {

    Result<MainPageInfoDTO> getMainPageInfo();
}
