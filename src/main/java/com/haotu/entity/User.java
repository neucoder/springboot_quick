package com.haotu.entity;

/**
 * User entity
 * @author ys
 * @date 2023-08-20
 */
public class User {
    /**
     * user id
     */
    private int UserId;
    /**
     * user name
     */
    private String UserName;

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }
}
