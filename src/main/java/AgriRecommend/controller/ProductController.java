package AgriRecommend.controller;

import AgriRecommend.core.AjaxResult;
import AgriRecommend.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @GetMapping("/listAllProduct")
    public AjaxResult listall(){
        return  AjaxResult.success(iProductService.listAllProduct());
    }
}
