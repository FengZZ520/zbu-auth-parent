package com.zbu.system.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zbu.model.system.SysRole;
import com.zbu.system.mapper.SysRoleMapper;
import com.zbu.system.service.SysRoleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

/**
 * ClassName: SysRoleMapperTest
 * Package: com.zbu
 * Description:
 *
 * @Author: 冯振卓
 * @Create: 2023/1/6 - 11:17
 * @Version: v1.0
 */
@SpringBootTest
public class SysRoleServiceTest {

    //注入service
    @Autowired
    private SysRoleService sysRoleService;

    //查询所有
    @Test
    public void findAll() {
        //service方法实现
        List<SysRole> list = sysRoleService.list();
        System.out.println(list);
    }

    //添加
    @Test
    public void add() {
        SysRole sysRole = new SysRole();
        sysRole.setRoleName("角色管理员");
        sysRole.setRoleCode("role");
        sysRole.setDescription("角色管理员");
        sysRoleService.save(sysRole);
    }

    //修改
    @Test
    public void update() {
        SysRole sysRole = sysRoleService.getById(4);
        sysRole.setDescription("测试");
        sysRoleService.updateById(sysRole);
    }

    //删除
    @Test
    public void remove() {
        sysRoleService.removeById(7);
    }

    //条件查询
    @Test
    public void select() {
        QueryWrapper<SysRole> wrapper = new QueryWrapper<>();
        wrapper.eq("role_code", "SYSTEM");
        List<SysRole> list = sysRoleService.list(wrapper);
        System.out.println(list);
    }
}
