package AgriRecommend.utils;

public class UserHolder {
    private static ThreadLocal<Long> userHolder = new ThreadLocal<>();

    public static void setUser(Long user){
        userHolder.set(user);
    }

    public static Long getUser(){
        return userHolder.get();
    }

    public static void removeUser(){
        userHolder.remove();
    }
}
