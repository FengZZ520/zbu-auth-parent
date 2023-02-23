package com.zbu.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zbu.model.system.SysRole;
import com.zbu.model.vo.SysRoleQueryVo;

/**
 * ClassName: SysRoleService
 * Package: com.zbu.system.service
 * Description:
 *
 * @Author: 冯振卓
 * @Create: 2023/1/6 - 13:51
 * @Version: v1.0
 */
public interface SysRoleService extends IService<SysRole> {
    IPage<SysRole> selectPage(Page<SysRole> pageParam, SysRoleQueryVo roleQueryVo);
}
