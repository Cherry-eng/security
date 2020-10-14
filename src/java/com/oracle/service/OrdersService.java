package com.oracle.service;

import com.oracle.domain.Orders;

import java.util.List;

public interface OrdersService {
    public List<Orders> findAll(int page,int size);
    public Orders findById(int id);
}
