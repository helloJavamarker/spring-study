package org.example.offer.mooc.service.solo.impl;

import org.example.offer.mooc.annotation.Service;
import org.example.offer.mooc.entity.bo.HeadLine;
import org.example.offer.mooc.entity.dto.Result;
import org.example.offer.mooc.service.solo.HeadLineService;

import java.util.List;

@Service
public class HeadLineServiceImpl implements HeadLineService {
    @Override
    public Result<Boolean> addHeadLine(HeadLine headLine) {
        return null;
    }

    @Override
    public Result<Boolean> removeHeadLine(int headLineId) {
        return null;
    }

    @Override
    public Result<Boolean> modifyHeadLine(HeadLine headLine) {
        return null;
    }

    @Override
    public Result<HeadLine> queryHeadLineById(int headLineId) {
        return null;
    }

    @Override
    public Result<List<HeadLine>> queryHeadLine(HeadLine headLineCondition, int pageIndex, int limit) {
        return null;
    }
}
