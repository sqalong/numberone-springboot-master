package com.numberone.project.system.message.service.impl;

import java.util.List;

import com.numberone.project.system.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.numberone.project.system.message.mapper.MessageMapper;
import com.numberone.project.system.message.domain.Message;
import com.numberone.project.system.message.service.IMessageService;
import com.numberone.common.utils.text.Convert;

/**
 * VIEWService业务层处理
 * 
 * @author sqalong
 * @date 2020-12-23
 */
@Service
public class MessageServiceImpl implements IMessageService 
{
    @Autowired
    private MessageMapper messageMapper;

    /**
     * 查询VIEW
     * 
     * @param id VIEWID
     * @return VIEW
     */
    @Override
    public Message selectMessageById(Long id)
    {
        return messageMapper.selectMessageById(id);
    }


    /**
     * 查询VIEW
     *
     * @param user_id VIEWID
     * @return VIEW
     */
    @Override
    public Message selectMessageByUserId(Long user_id)
    {
        return messageMapper.selectMessageByUserId(user_id);
    }

    /**
     * 查询VIEW列表
     * 
     * @param message VIEW
     * @return VIEW
     */
    @Override
    public List<Message> selectMessageList(Message message)
    {
        return messageMapper.selectMessageList(message);
    }

    /**
     * 新增VIEW
     * 
     * @param message VIEW
     * @return 结果
     */
    @Override
    public int insertMessage(Message message)
    {
        return messageMapper.insertMessage(message);
    }

    /**
     * 修改VIEW
     * 
     * @param message VIEW
     * @return 结果
     */
    @Override
    public int updateMessage(Message message)
    {
        return messageMapper.updateMessage(message);
    }



    /**
     * 删除VIEW对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */


    /**
     * 删除VIEW信息
     * 
     * @param id VIEWID
     * @return 结果
     */
    @Override
    public int deleteMessageById(Long id)
    {
        return messageMapper.deleteMessageById(id);
    }

    @Override
    public User  getNameId(String username) {
        System.out.print(username);



        return messageMapper.getNameId(username);
    }

    @Override
    public int upMessage(String ids, Long nameids) {

        System.out.print(nameids);
        System.out.print(ids);


        return messageMapper.upMessage(ids,nameids);
    }


}
