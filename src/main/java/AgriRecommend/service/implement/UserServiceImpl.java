package AgriRecommend.Service.implement;

import AgriRecommend.Service.IUserService;
import AgriRecommend.mapper.UserMapper;
import AgriRecommend.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {


    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean checkNameExist(String account) {
        Integer isExist = userMapper.getUserByAccount(account);
        if (isExist == null || isExist!=1) return false;
        return true;
    }

    @Override
    public boolean insertUser(User user) {
        try {
            userMapper.insertUser(user);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    @Override
    public User checkUser(User user) {
        return userMapper.getUser(user);
    }

    @Override
    public void updateUser(User user) {
        userMapper.UpdateUser(user);
    }
}
