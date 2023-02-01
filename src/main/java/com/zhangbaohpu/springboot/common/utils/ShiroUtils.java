package com.zhangbaohpu.springboot.common.utils;

import com.zhangbaohpu.springboot.module.system.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import java.security.Principal;
import java.util.List;

public class ShiroUtils {

    public static Subject getSubjct() {
        return SecurityUtils.getSubject();
    }
    public static User getUser() {
        Object object = getSubjct().getPrincipal();
        return (User)object;
    }
    public static String getUserId() {
        return getUser().getId();
    }
    public static void logout() {
        getSubjct().logout();
    }

    public static List<Principal> getPrinciples() {
        List<Principal> principals = null;
        return principals;
    }
}
