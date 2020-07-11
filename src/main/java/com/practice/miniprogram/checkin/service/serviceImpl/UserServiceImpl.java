package com.practice.miniprogram.checkin.service.serviceImpl;

import com.practice.miniprogram.checkin.bean.User;
import com.practice.miniprogram.checkin.dao.UserMapper;
import com.practice.miniprogram.checkin.daoExtend.UserExtendMapper;
import com.practice.miniprogram.checkin.enums.ExceptionEnum;
import com.practice.miniprogram.checkin.exception.SAException;
import com.practice.miniprogram.checkin.pojo.UserExtend;
import com.practice.miniprogram.checkin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
    @Autowired
    private UserExtendMapper userExtendMapper;

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
            throw new SAException(ExceptionEnum.USER_REGISTER_EXIST);
        }
        User user = new User();
        user.setUserId(userId);
        user.setUserName(userName);
        user.setPassword(password);
        user.setBirthday(birthday);
        user.setGender(gender);

        int n = userMapper.insert(user);
        if (n > 0) return n;
        throw new SAException(ExceptionEnum.USER_REGISTER_FAIL);
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
            throw new SAException(ExceptionEnum.USER_NOT_EXIST);
        }
        if (!password.equals(test.getPassword())) {
            throw new SAException(ExceptionEnum.USER_PSW_ERROR);
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
    public UserExtend searchById(String userId) throws Exception {
        UserExtend userExtend = userExtendMapper.searchById(userId);
        if (userExtend == null) {
            throw new SAException(ExceptionEnum.USER_NOT_EXIST);
        }
        // 根据出生日期计算年龄
        int age = getAgeByBirth(userExtend.getBirthday());
        userExtend.setAge(age);
        return userExtend;
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
            throw new SAException(ExceptionEnum.USER_NOT_EXIST);
        }
        User user = new User();
        user.setUserId(userId);
        user.setUserName(userName);
        user.setPassword(password);
        user.setBirthday(birthday);
        user.setGender(gender);

        int n = userMapper.updateByPrimaryKeySelective(user);
        if (n > 0) return n;
        throw new SAException(ExceptionEnum.USER_UPDATE_ERROR);
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
            throw new SAException(ExceptionEnum.USER_NOT_EXIST);
        }
        int n = userMapper.deleteByPrimaryKey(userId);
        if (n > 0) return n;
        throw new SAException(ExceptionEnum.USER_DELETE_ERROR);
    }

    /***
    * @Description: 根据出生日期计算年龄
    * @Param: [birthday]
    * @return: int
    * @Author: StarryHu
    * @Date: 2020/7/11
    */
    private int getAgeByBirth(String birthdayStr) {
        Date birthday = new Date();
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            // 计算得到Date对象
            birthday = sdf.parse(birthdayStr);
            // 计算年龄
            int age = 0;
            Calendar now = Calendar.getInstance();
            now.setTime(new Date());// 当前时间
            Calendar birth = Calendar.getInstance();
            birth.setTime(birthday);

            if (birth.after(now)) {//如果传入的时间，在当前时间的后面，返回0岁
                age = 0;
            } else {
                age = now.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
                if (now.get(Calendar.DAY_OF_YEAR) > birth.get(Calendar.DAY_OF_YEAR)) {
                    age += 1;
                }
            }
            return age;
        } catch (Exception e) {
            throw new SAException(ExceptionEnum.DATE_FORMAT_ERROR);
        }
    }
}
