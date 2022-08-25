package com.tablegame.system.service;

import com.tablegame.system.domain.UserDetail;

/**
 * @author tu.cb
 */
public interface AccountService {

    /**
     * 查询账号
     * @return
     */
    UserDetail query();
}
