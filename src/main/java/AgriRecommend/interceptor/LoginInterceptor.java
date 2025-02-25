package AgriRecommend.interceptor;

import AgriRecommend.utils.JwtUtil;
import AgriRecommend.core.AjaxResult;
import AgriRecommend.utils.UserHolder;
import com.alibaba.fastjson.JSONObject;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;


@Component
public class LoginInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //检查是否携带token
        String jwt = request.getHeader("token");
        if(!StringUtils.hasLength(jwt))
        {
            AjaxResult error = AjaxResult.error("用户未登录");
            String notLogin = JSONObject.toJSONString(error);
            response.getWriter().write(notLogin);
            return false;
        }

        //判断token是否有效
        try{
            Claims claims = JwtUtil.parseJwt(jwt);
            if(claims != null){
                Long userId = claims.get("userId",Long.class);
                if(userId != null){
                    UserHolder.setUser(userId);
                }
            }
        }catch (Exception e){
            AjaxResult error = AjaxResult.error("用户未登录");
            String notLogin = JSONObject.toJSONString(error);
            response.getWriter().write(notLogin);
            return false;
        }

        return true;
    }
}
