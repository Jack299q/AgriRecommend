package AgriRecommend.controller;

import AgriRecommend.core.AjaxResult;
import AgriRecommend.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("category")
public class CategoryController {
    @Autowired
    ICategoryService categoryService;

    @GetMapping("listAllCategory")
    public AjaxResult listall(){
        return AjaxResult.success(categoryService.listAllCategory());
    }
}
