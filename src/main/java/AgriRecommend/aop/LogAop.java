package AgriRecommend.aop;

import AgriRecommend.core.AjaxResult;
import AgriRecommend.core.HttpStatus;
import AgriRecommend.mapper.LogMapper;
import AgriRecommend.pojo.UserLog;
import AgriRecommend.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.weaver.loadtime.Aj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LogAop {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private LogMapper logMapper;

    @Pointcut("@annotation(AgriRecommend.aop.Log)")
    private void pt(){}

    @Around("pt()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        //获取用户信息
        String jwt = request.getHeader("token");
        if(jwt==null){
            return joinPoint.proceed();
        }
        Claims claims = JwtUtil.parseJwt(jwt);
        Long userId = Integer.toUnsignedLong((int) claims.get("userId"));

        //创建日志对象
        UserLog userLog = new UserLog();
        userLog.setUserId(userId);

        //获取方法名
        String methodName = joinPoint.getSignature().getName();
        //获取方法参数
        Object[] args = joinPoint.getArgs();
        //获取返回值
        Object result = joinPoint.proceed();
        if(result instanceof AjaxResult){
            if(((AjaxResult)result).get("code").equals(HttpStatus.ERROR)){
                return result;
            }
        }
        //判断何种操作 浏览为1,收藏为2,加入购物车为3
        if(methodName.equals("getProduct")){
            if(args[0] instanceof Long){
                userLog.setProductId((Long) args[0]);
                userLog.setOpType(1);
            }
        }else if(methodName.equals("collectProduct")){
            if(args[0] instanceof Long){
                userLog.setProductId((Long) args[0]);
                userLog.setOpType(2);
            }
        }else if(methodName.equals("addToCart")){
            if(args[0] instanceof Long){
                userLog.setProductId((Long) args[0]);
                userLog.setOpType(3);
            }
        }
        logMapper.insertLog(userLog);
        return result;
    }

}
