package com.numberone.project.system.usermanager.service.impl;

import java.util.List;
import com.numberone.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.numberone.project.system.usermanager.mapper.UsersMapper;
import com.numberone.project.system.usermanager.domain.Users;
import com.numberone.project.system.usermanager.service.IUsersService;
import com.numberone.common.utils.text.Convert;

/**
 * 用户信息Service业务层处理
 * 
 * @author sqalong
 * @date 2020-12-29
 */
@Service
public class UsersServiceImpl implements IUsersService 
{
    @Autowired
    private UsersMapper usersMapper;

    /**
     * 查询用户信息
     * 
     * @param userId 用户信息ID
     * @return 用户信息
     */
    @Override
    public Users selectUsersById(Long userId)
    {
        return usersMapper.selectUsersById(userId);
    }

    /**
     * 查询用户信息列表
     * 
     * @param users 用户信息
     * @return 用户信息
     */
    @Override
    public List<Users> selectUsersList(Users users)
    {
        return usersMapper.selectUsersList(users);
    }

    /**
     * 新增用户信息
     * 
     * @param users 用户信息
     * @return 结果
     */
    @Override
    public int insertUsers(Users users)
    {
        users.setCreateTime(DateUtils.getNowDate());
        return usersMapper.insertUsers(users);
    }

    /**
     * 修改用户信息
     * 
     * @param users 用户信息
     * @return 结果
     */
    @Override
    public int updateUsers(Users users)
    {
        users.setUpdateTime(DateUtils.getNowDate());
        return usersMapper.updateUsers(users);
    }

    /**
     * 删除用户信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteUsersByIds(String ids)
    {
        return usersMapper.deleteUsersByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除用户信息信息
     * 
     * @param userId 用户信息ID
     * @return 结果
     */
    @Override
    public int deleteUsersById(Long userId)
    {
        return usersMapper.deleteUsersById(userId);
    }
}
