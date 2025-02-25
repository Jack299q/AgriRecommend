package AgriRecommend.controller;

import AgriRecommend.core.AjaxResult;
import AgriRecommend.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/favorite")
public class FavoriteController {
    @Autowired
    private FavoriteService favoriteService;

}
