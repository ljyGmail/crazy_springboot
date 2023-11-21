package com.crazyit.firstboot.ch03.service;

import com.crazyit.firstboot.ch03.domain.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    // 定义一个List模拟系统中所有User对象
    private static List<User> userList = Collections.synchronizedList(new ArrayList<>());

    static {
        userList.add(new User(1, "sun", "32145"));
        userList.add(new User(2, "zhu", "83433"));
        userList.add(new User(3, "crazyit.org", "ljy"));
    }

    @Override
    public Integer userLogin(User user) {
        // 如果能找到目标User对象，则返回该User的id
        for (User u : userList) {
            if (u.equals(user)) {
                return u.getId();
            }
        }

        return -1;
    }
}
