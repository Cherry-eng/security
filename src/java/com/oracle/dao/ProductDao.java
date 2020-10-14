package com.oracle.dao;

import com.oracle.domain.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductDao {
    @Select("select * from product")
    public List<Product> findAll() throws Exception;
    @Insert("insert into product (productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values "+
            "(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    public void save(Product product) throws Exception;
    //[3]通过id查询产品
    @Select("select * from product where id=#{id}")
    public Product findById(int id);
    @Delete("delete from product where id=#{id}")
    public void delete(int id);
}
