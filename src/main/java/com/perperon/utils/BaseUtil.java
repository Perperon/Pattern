package com.perperon.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author dupengcheng
 * @date 2024-03-22
 * @apiNote
 */
public class BaseUtil {
    //密码加密
    public static String getEncryption(String password){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String pwd = passwordEncoder.encode(password);
        return pwd;
    }
}
