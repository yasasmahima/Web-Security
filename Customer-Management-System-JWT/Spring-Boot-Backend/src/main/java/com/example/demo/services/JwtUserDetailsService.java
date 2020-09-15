package com.example.demo.services;

import com.example.demo.models.cashier.CashierMemberDAO;
import com.example.demo.models.cashier.CashierMemberDTO;
import com.example.demo.repositories.CashierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private CashierRepository userDao;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CashierMemberDAO cashierMember = userDao.findByUserName(username);
        if (cashierMember == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(cashierMember.getUserName(), cashierMember.getPassword(),
                new ArrayList<>());
    }

    public CashierMemberDAO save(CashierMemberDTO cashierMember) {
        CashierMemberDAO newCashierMember = new CashierMemberDAO();
        newCashierMember.setCashierName(cashierMember.getCashierName());
        newCashierMember.setCashierContactNo(cashierMember.getCashierContactNo());
        newCashierMember.setUserName(cashierMember.getUserName());
        newCashierMember.setPassword(bcryptEncoder.encode(cashierMember.getPassword()));
        return userDao.save(newCashierMember);
    }
}