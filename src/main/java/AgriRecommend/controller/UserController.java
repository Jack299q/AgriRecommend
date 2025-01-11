package AgriRecommend.Controller;

import AgriRecommend.Service.IUserService;
import AgriRecommend.Utils.JwtUtil;
import AgriRecommend.core.AjaxResult;
import AgriRecommend.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private IUserService userService;

    @PostMapping("/register")
    @CrossOrigin
    @Transactional(rollbackFor = Exception.class)
    public AjaxResult register(@RequestBody User user) {
        boolean isExist = userService.checkNameExist(user.getAccount());
        if(isExist) return AjaxResult.error("账户已存在!");
        boolean result = userService.insertUser(user);
        String jwt = this.generateJwt(user);
        if (result) return AjaxResult.success("注册成功!",jwt);
        return AjaxResult.error("系统异常,请联系管理员");
    }

    @PostMapping("/login")
    @CrossOrigin
    public AjaxResult login(@RequestBody User user) {
        User u = userService.checkUser(user);
        if (u == null) return AjaxResult.error("用户名或密码错误!");
        String jwt = this.generateJwt(u);
        return AjaxResult.success("登录成功!",jwt);
    }


    private String generateJwt(User user) {
        userService.updateUser(user);
        Map<String, Object> claims = new HashMap<>();
        claims.put("account", user.getAccount());
        //生成jwt令牌
        return JwtUtil.generateJwt(claims);
    }
}
