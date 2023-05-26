package com.nowcoder.community.dao;

import com.nowcoder.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {
    // 首页查询 这两个函数就够了
    //status == 2 拉黑
    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);
    //一共有多少数据
    //@Param:用于给参数取别名
    //如果只有一个参数，并且在<if>里使用，则必须加别名
    int selectDiscussPostRows(@Param("userId") int userId);//别名的注释
}
