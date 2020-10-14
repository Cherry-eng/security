package com.oracle.service;

import com.oracle.domain.SysLog;

import java.util.List;

public interface SysLogService {
    public void save(SysLog sysLog);
    public List<SysLog> findAll();
    public void deleteBatch(int[] ids);
}
