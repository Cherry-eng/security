package com.oracle.dao;

import com.oracle.domain.Member;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MemberDao {
    //[1]通过会员id查找会员对象
    @Select("select * from member where id=#{id}")
    public Member findById(int id);
}
