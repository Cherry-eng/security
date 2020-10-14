package com.oracle.service.Impl;

import com.oracle.dao.SysLogDao;
import com.oracle.domain.SysLog;
import com.oracle.service.SysLogService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysLogServiceImp implements SysLogService {
    @Autowired
    public SysLogDao sysLogDao;
    @Override
    public void save(SysLog sysLog) {
        sysLogDao.save(sysLog);
    }

    @Override
    public List<SysLog> findAll() {
        return sysLogDao.findAll();
    }

    @Override
    public void deleteBatch(int[] ids) {
        sysLogDao.deleteBatch(ids);
    }
}
