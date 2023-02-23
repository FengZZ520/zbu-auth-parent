package com.zbu.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zbu.common.result.Result;
import com.zbu.model.system.SysRole;
import com.zbu.model.vo.SysRoleQueryVo;
import com.zbu.system.exception.ZBUException;
import com.zbu.system.mapper.SysRoleMapper;
import com.zbu.system.service.SysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ClassName: SysRoleController
 * Package: com.zbu.system.controller
 * Description:
 *
 * @Author: 冯振卓
 * @Create: 2023/1/6 - 16:30
 * @Version: v1.0
 */
@Api(tags = "角色管理接口")
@RestController
@RequestMapping("/admin/system/sysRole")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    //http://localhost:8800/admin/system/sysRole/findAll


    //7.批量删除
    // 多个id值 [1, 2, 3]
    // json数组格式 --- java的LIst集合
    @ApiOperation("批量删除")
    @DeleteMapping("batchRemove")
    public Result batchRemove(@RequestBody List<Long> ids) {
        sysRoleService.removeByIds(ids);
        return Result.ok();
    }


    //6.修改-最终修改
    @ApiOperation("最终修改")
    @PostMapping("update")
    public Result updateRole(@RequestBody SysRole sysRole) {
        boolean isSuccess = sysRoleService.updateById(sysRole);
        if (isSuccess) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    //5.修改-根据id查询
    @ApiOperation("根据id查询")
    @PostMapping("findRoleById/{id}")
    public Result findRoleById(@PathVariable Long id) {
        SysRole sysRole = sysRoleService.getById(id);
        return Result.ok(sysRole);
    }

    //4.添加
    // @RequestBody 不饿能使用个体提交方式
    // 传递json格式数据，把json格式数据封装到对象里面{...}
    @ApiOperation("添加角色")
    @PostMapping("save")
    public Result saveRole(@RequestBody SysRole sysRole) {
        boolean isSuccess = sysRoleService.save(sysRole);
        if (isSuccess) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    //3.条件分页查询
    //page 当前页  limit 每页记录数
    @ApiOperation("条件分页查询")
    @GetMapping("{page}/{limit}")
    public Result findPageQueryRole(@PathVariable Long page,
                                    @PathVariable Long limit,
                                    SysRoleQueryVo sysRoleQueryVo) {
        //创建page对象
        Page<SysRole> pageParam = new Page<>(page, limit);
        //调用service方法
        IPage<SysRole> pageModel = sysRoleService.selectPage(pageParam, sysRoleQueryVo);
        //返回
        return Result.ok(pageModel);
    }


    //2.逻辑删除接口
    @ApiOperation("逻辑删除接口")
    @DeleteMapping("remove/{id}")
    public Result removeRole(@PathVariable Long id) {
        //调用方法删除
        boolean isSuccess = sysRoleService.removeById(id);
        if(isSuccess) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    //1.查询所有的记录
    @ApiOperation("查询所有记录")
    @GetMapping("findAll")
    public Result<List<SysRole>> findAll() {
        //TODO 模拟异常效果   ArithmeticException
        try {
            int i = 9/0;
        } catch (Exception e) {
            throw new ZBUException(20001,"执行自定义异常处理");
        }

        //调用service
        List<SysRole> roleList = sysRoleService.list();
        return Result.ok(roleList);
    }
}
