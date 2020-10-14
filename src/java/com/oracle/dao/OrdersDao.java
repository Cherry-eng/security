package com.oracle.dao;

import com.oracle.domain.Orders;
import com.oracle.domain.Product;
import net.sf.jsqlparser.statement.select.OrderByVisitorAdapter;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersDao {
    //[1]查询订单信息——>通过订单的外键找产品信息（线路）
    @Select("select * from orders")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select = "com.oracle.dao.ProductDao.findById"))
    })
    //select * from orders limit (page-1)*size,size;
    public List<Orders> findAll(int page,int size);

    //[2]查询某个订单详细信息
    //[2.1]查询本订单信息
    //[2.2]从过本订单的产品外键，查找对应产品对象Product
    //[2.3]通过本订单的会员外键，查找对应的会员对象Member
    //[2.4]通过当前订单的主键查找对应旅客列表信息(需要使用到中间表)
    @Select("select * from orders where id=#{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "product",column = "productId",one = @One(select = "com.oracle.dao.ProductDao.findById")),
            @Result(property = "member",column = "memberId",one = @One(select = "com.oracle.dao.MemberDao.findById")),
            @Result(property = "travellers",column = "id",many = @Many(select = "com.oracle.dao.TravellerDao.findTravellersByOrdersId"))
    })
    public Orders findById(int id);

}
