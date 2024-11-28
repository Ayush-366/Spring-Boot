package com.cg.repository;
 
import java.util.List;
 
import org.springframework.data.jpa.repository.JpaRepository;
 
import com.cg.entity.Order;
 
public interface OrderRepository extends JpaRepository<Order, Integer>{
	public Order getAllByorderId(int orderId);
}
 