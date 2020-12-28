package com.numberone.project.system.message.mapper;

import java.util.List;
import com.numberone.project.system.message.domain.Message;
import com.numberone.project.system.user.domain.User;

/**
 * VIEWMapper接口
 * 
 * @author sqalong
 * @date 2020-12-23
 */
public interface MessageMapper 
{
    /**
     * 查询VIEW
     * 
     * @param id VIEWID
     * @return VIEW
     */
    public Message selectMessageById(Long id);


    /**
     * 查询VIEW
     *
     * @param user_id VIEWID
     * @return VIEW
     */
    public Message selectMessageByUserId(Long user_id);
    /**
     * 查询VIEW列表
     * 
     * @param message VIEW
     * @return VIEW集合
     */
    public List<Message> selectMessageList(Message message);

    /**
     * 新增VIEW
     * 
     * @param message VIEW
     * @return 结果
     */
    public int insertMessage(Message message);

    /**
     * 修改VIEW
     * 
     * @param message VIEW
     * @return 结果
     */
    public int updateMessage(Message message);

    /**
     * 删除VIEW
     * 
     * @param id VIEWID
     * @return 结果
     */
    public int deleteMessageById(Long id);

    /**
     * 批量删除VIEW
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMessageByIds(String[] ids);

    User getNameId(String username);

    int upMessage(String ids, Long nameids);
}
