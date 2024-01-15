package com.guiguohui.system.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tu.cb
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDetails {

    private String username;

    private String password;

}
