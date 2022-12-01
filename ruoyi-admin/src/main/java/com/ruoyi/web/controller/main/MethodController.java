package com.ruoyi.web.controller.main;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.entity.Method;
import com.ruoyi.system.service.IMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/method")
public class MethodController extends BaseController {
    @Autowired
    private IMethodService methodService;

    @GetMapping("/page")
    public AjaxResult findPage() {
        return AjaxResult.success(methodService.getList());
    }

    @PostMapping("/update")
    public AjaxResult updateMethod(@RequestBody Method method) {
        methodService.update(method);
        return AjaxResult.success();
    }

    @PostMapping("/insert")
    public AjaxResult insertMethod(@RequestBody Method method) {
        methodService.insert(method);
        return AjaxResult.success();
    }

    @PostMapping("/delete/{id}")
    public AjaxResult deleteMethod(@PathVariable Integer id) {
        methodService.delete(id);
        return AjaxResult.success();
    }

    @PostMapping("/delete/batch")
    public AjaxResult deleteMethods(@RequestBody List<Integer> ids) {
        for (Integer id : ids) {
            methodService.delete(id);
        }
        return AjaxResult.success();
    }
}
