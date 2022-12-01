package com.ruoyi.web.controller.main;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.service.IDetectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/detect")
public class DetectController {

    @Autowired
    private IDetectService detectService;

    @GetMapping("/page")
    public AjaxResult findPage() {
        return AjaxResult.success(detectService.getList());
    }
}
