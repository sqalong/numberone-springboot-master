package com.numberone.project.system.usermanager.mapper;

import java.util.List;
import com.numberone.project.system.usermanager.domain.Users;

/**
 * 用户信息Mapper接口
 * 
 * @author sqalong
 * @date 2020-12-29
 */
public interface UsersMapper 
{
    /**
     * 查询用户信息
     * 
     * @param userId 用户信息ID
     * @return 用户信息
     */
    public Users selectUsersById(Long userId);

    /**
     * 查询用户信息列表
     * 
     * @param users 用户信息
     * @return 用户信息集合
     */
    public List<Users> selectUsersList(Users users);

    /**
     * 新增用户信息
     * 
     * @param users 用户信息
     * @return 结果
     */
    public int insertUsers(Users users);

    /**
     * 修改用户信息
     * 
     * @param users 用户信息
     * @return 结果
     */
    public int updateUsers(Users users);

    /**
     * 删除用户信息
     * 
     * @param userId 用户信息ID
     * @return 结果
     */
    public int deleteUsersById(Long userId);

    /**
     * 批量删除用户信息
     * 
     * @param userIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteUsersByIds(String[] userIds);
}
