package com.zbu.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zbu.model.system.SysRole;
import com.zbu.model.vo.SysRoleQueryVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * ClassName: SysRoleMapper
 * Package: com.zbu.system.mapper
 * Description:
 *
 * @Author: 冯振卓
 * @Create: 2023/1/6 - 11:15
 * @Version: v1.0
 */
@Repository
public interface SysRoleMapper extends BaseMapper<SysRole> {

    //条件分页查询
    IPage<SysRole> selectPage(Page<SysRole> pageParam, @Param("vo")SysRoleQueryVo sysRoleQueryVo);
}
