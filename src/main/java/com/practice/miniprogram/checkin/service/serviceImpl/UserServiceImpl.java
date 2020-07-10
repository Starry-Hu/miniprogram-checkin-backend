package com.practice.miniprogram.checkin.service.serviceImpl;

import com.practice.miniprogram.checkin.bean.User;
import com.practice.miniprogram.checkin.dao.UserMapper;
import com.practice.miniprogram.checkin.enums.ExceptionEnum;
import com.practice.miniprogram.checkin.exception.SAException;
import com.practice.miniprogram.checkin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @Project checkin
 * @ClassName UserServiceImpl
 * @Author StarryHu
 * @Description 用户的业务逻辑层的实现
 * @Date 2020/7/10 17:27
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    /***
     * @Description: 注册用户
     * @Param: [userId, userName, userPassword, userBirthday, userGender]
     * @return: com.practice.miniprogram.checkin.bean.User
     * @Author: StarryHu
     * @Date: 2020/7/10
     */
    public int register(String userId, String userName, String password, String birthday, int gender) throws Exception {
        // 查看该ID是否已存在
        User test = userMapper.selectByPrimaryKey(userId);
        if (test != null) {
            throw new SAException(ExceptionEnum.CUSTOMER_REGISTER_EXIST);
        }
        User user = new User();
        user.setUserId(userId);
        user.setUserName(userName);
        user.setPassword(password);
        user.setBirthday(birthday);
        user.setGender(gender);

        int n = userMapper.insert(user);
        if (n > 0) return n;
        throw new SAException(ExceptionEnum.CUSTOMER_REGISTER_FAIL);
    }

    /***
     * @Description: 用户登录
     * @Param: [userId, userPassword]
     * @return: int
     * @Author: StarryHu
     * @Date: 2020/7/10
     */
    public User login(String userId, String password) throws Exception {
        // 查看该ID对应的用户是否存在
        User test = userMapper.selectByPrimaryKey(userId);
        if (test == null) {
            throw new SAException(ExceptionEnum.CUSTOMER_NOT_EXIST);
        }
        // 检查密码和数据库中是否相等
        if (!password.equals(test.getPassword())) {
            throw new SAException(ExceptionEnum.CUSTOMER_PSW_ERROR);
        }
        return test;
    }

    /***
     * @Description: 根据用户账号查找
     * @Param: [userId]
     * @return: com.practice.miniprogram.checkin.bean.User
     * @Author: StarryHu
     * @Date: 2020/7/10
     */
    public User searchById(String userId) throws Exception {
        User user = userMapper.selectByPrimaryKey(userId);
        // 检查用户是否存在
        if (user == null) {
            throw new SAException(ExceptionEnum.CUSTOMER_NOT_EXIST);
        }
        return user;
    }

    /***
     * @Description: 更新账户信息
     * @Param: [userId, userName, userPassword, userBirthday, userGender]
     * @return: int
     * @Author: StarryHu
     * @Date: 2020/7/10
     */
    public int update(String userId, String userName, String password, String birthday, int gender) throws Exception {
        // 查看该账户是否存在
        User test = userMapper.selectByPrimaryKey(userId);
        if (test == null) {
            throw new SAException(ExceptionEnum.CUSTOMER_NOT_EXIST);
        }
        User user = new User();
        user.setUserId(userId);
        user.setUserName(userName);
        user.setPassword(password);
        user.setBirthday(birthday);
        user.setGender(gender);

        int n = userMapper.updateByPrimaryKeySelective(user);
        if (n > 0) return n;
        throw new SAException(ExceptionEnum.CUSTOMER_UPDATE_ERROR);
    }

    /***
     * @Description: 删除账户
     * @Param: [userId]
     * @return: int
     * @Author: StarryHu
     * @Date: 2020/7/10
     */
    public int delete(String userId) throws Exception {
        // 查看该账户是否存在
        User test = userMapper.selectByPrimaryKey(userId);
        if (test == null) {
            throw new SAException(ExceptionEnum.CUSTOMER_NOT_EXIST);
        }
        int n = userMapper.deleteByPrimaryKey(userId);
        if (n > 0) return n;
        throw new SAException(ExceptionEnum.CUSTOMER_DELETE_ERROR);
    }
}
