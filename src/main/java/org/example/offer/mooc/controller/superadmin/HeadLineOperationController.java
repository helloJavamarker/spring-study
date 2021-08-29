package org.example.offer.mooc.controller.superadmin;

import org.example.offer.mooc.annotation.Autowired;
import org.example.offer.mooc.annotation.Controller;
import org.example.offer.mooc.entity.bo.HeadLine;
import org.example.offer.mooc.entity.dto.Result;
import org.example.offer.mooc.service.solo.HeadLineService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class HeadLineOperationController {

    @Autowired
    private HeadLineService headLineService;

    // todo 参数校验.请求参数转化
    public Result<Boolean> addHeadLine(HttpServletRequest request, HttpServletResponse response) {
        return headLineService.addHeadLine(new HeadLine());
    }

    public Result<Boolean> removeHeadLine(HttpServletRequest request, HttpServletResponse response) {
        return headLineService.removeHeadLine(1);
    }

    public Result<Boolean> modifyHeadLine(HttpServletRequest request, HttpServletResponse response) {
        return headLineService.modifyHeadLine(new HeadLine());
    }

    public Result<HeadLine> queryHeadLineById(HttpServletRequest request, HttpServletResponse response) {
        return headLineService.queryHeadLineById(1);
    }

    public Result<List<HeadLine>> queryHeadLine(HttpServletRequest request, HttpServletResponse response) {
        return headLineService.queryHeadLine(new HeadLine(), 1, 100);
    }
}
