package AgriRecommend.service;

import AgriRecommend.pojo.User;

public interface IUserService {
    boolean checkNameExist(String name);
    boolean insertUser(User user);
    User checkUser(User user);
    void updateUser(User user);
}
