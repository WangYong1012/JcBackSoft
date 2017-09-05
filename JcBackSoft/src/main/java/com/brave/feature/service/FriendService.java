package com.brave.feature.service;

import com.brave.feature.mapper.homepage.FriendMapper;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

@Service
public class FriendService
{
    private FriendMapper writeMapper;
    private FriendMapper readMapper;

    @Resource(name="sqlSessionMaster")
    public void setWriteMapper(SqlSession sqlSession)
    {
        this.writeMapper = ((FriendMapper)sqlSession.getMapper(FriendMapper.class));
    }

    @Resource(name="sqlSessionSlave")
    public void setReadMapper(SqlSession sqlSession)
    {
        this.readMapper = ((FriendMapper)sqlSession.getMapper(FriendMapper.class));
    }

    public int deleteFriend(Map<String, Object> friendMap)
    {
        return this.writeMapper.deleteFriend(friendMap);
    }

    public List<Map<String, Object>> selectFriendState(Map<String, Object> friendMap)
    {
        return this.readMapper.selectFriendState(friendMap);
    }

    public List<Map<String, Object>> selectFriendByUsername(String username)
    {
        return this.readMapper.selectFriendByUsername(username);
    }

    public int insertFriend(Map<String, Object> friendMap)
    {
        return this.writeMapper.insertFriend(friendMap);
    }

    public int updateFriend(Map<String, Object> friendMap)
    {
        return this.writeMapper.updateFriend(friendMap);
    }
}
