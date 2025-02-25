package AgriRecommend.controller;

import AgriRecommend.core.AjaxResult;
import AgriRecommend.service.FavoriteService;
import AgriRecommend.utils.UserHolder;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/favorite")
public class FavoriteController {
    @Autowired
    private FavoriteService favoriteService;

    @PostMapping("/add")
    public AjaxResult addFavorite(@RequestParam Long productId) {
        Long userId = UserHolder.getUser();
        if (userId == null) {
            return AjaxResult.error("请先登录");
        }
        boolean success =favoriteService.toggleFavorite(userId, productId);
        if (success) {
            return AjaxResult.success("收藏成功");
        }else{
            return AjaxResult.success("取消收藏成功");
        }
    }

    @GetMapping("/list")
    public AjaxResult getFavoriteList() {
        Long userId = UserHolder.getUser();
        if (userId == null) {
            return AjaxResult.error("请先登录");
        }
        return AjaxResult.success(favoriteService.getUserFavorites(userId));
    }

}
