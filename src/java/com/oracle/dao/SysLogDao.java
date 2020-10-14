package com.oracle.dao;

import com.oracle.domain.SysLog;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SysLogDao {
    @Insert("insert into syslog (visitTime,username,ip,url,executionTime,method) values (#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    public void save(SysLog sysLog);
    @Select("select * from syslog")
    public List<SysLog> findAll();

    @Delete({"<script>",
            "delete from syslog where id in ",
            "<foreach collection='array' item='ids' open='(' separator=',' close=')'> ",
            "#{ids}",
            "</foreach>",
            "</script>"})
    public void deleteBatch(int[] ids);//delete from syslog where id in (1,3,6,9)
}
