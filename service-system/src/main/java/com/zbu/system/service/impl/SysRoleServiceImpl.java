package com.zbu.system.service.impl;

import com.baomidou.mybatisplus.core.injector.methods.SelectPage;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zbu.model.system.SysRole;
import com.zbu.model.vo.SysRoleQueryVo;
import com.zbu.system.mapper.SysRoleMapper;
import com.zbu.system.service.SysRoleService;
import org.springframework.stereotype.Service;

/**
 * ClassName: SysRoleServiceImpl
 * Package: com.zbu.system.service.impl
 * Description:
 *
 * @Author: 冯振卓
 * @Create: 2023/1/6 - 13:53
 * @Version: v1.0
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    //条件分页查询
    @Override
    public IPage<SysRole> selectPage(Page<SysRole> pageParam, SysRoleQueryVo sysRoleQueryVo) {
        IPage<SysRole> pageModel = baseMapper.selectPage(pageParam, sysRoleQueryVo);
        return pageModel;
    }
}


