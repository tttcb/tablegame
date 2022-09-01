package com.tablegame.system.config;

import com.tablegame.system.common.AdminUserDetails;
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

}
