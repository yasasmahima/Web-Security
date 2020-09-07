package com.example.demo.repositories;

import com.example.demo.models.cashier.CashierMemberDAO;
import org.springframework.data.repository.CrudRepository;

public interface CashierRepository extends CrudRepository<CashierMemberDAO,Long> {
    CashierMemberDAO findByUserName(String userName);
}
