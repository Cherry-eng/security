package com.oracle.service.Impl;

import com.github.pagehelper.PageHelper;
import com.oracle.dao.OrdersDao;
import com.oracle.domain.Orders;
import com.oracle.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersDao ordersDao;
    @Override
    public List<Orders> findAll(int page,int size) {

        PageHelper.startPage(page,size);
        return ordersDao.findAll(page,size);
    }

    @Override
    public Orders findById(int id) {
        Orders orders=ordersDao.findById(id);
        return orders;
    }
}
