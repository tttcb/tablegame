package com.tablegame.system.domain;

import com.tablegame.system.domain.dto.Fund;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author tu.cb
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDetail {

    private String username;

    private String password;

    private List<Fund> fundGames ;
}
