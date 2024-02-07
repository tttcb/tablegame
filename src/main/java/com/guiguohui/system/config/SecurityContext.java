package com.guiguohui.system.config;

import com.guiguohui.system.common.AdminUserDetails;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author tu.cb
 */
public class SecurityContext {

    public static String getUsername() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    public static Integer getUserId() {
        return ((AdminUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId();
    }

    public static String getPassword() {
        return ((AdminUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getPassword();
    }
    public static String getRole() {
        return ((AdminUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getRole();
    }
}
