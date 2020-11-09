package com.wallet.service.impl;

import com.wallet.dao.LogDao;
import com.wallet.dao.PaymentDao;
import com.wallet.entiy.Log;
import com.wallet.entiy.User;
import com.wallet.pojo.PayForm;
import com.wallet.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import java.util.Date;

/**
 * @author Pom
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentDao paymentDao;

    @Autowired
    private LogDao logDao;

    @Override
    public User find(int i) {
        User user = paymentDao.find(i);
        return user;
    }

    @Override
    @Transactional
    public void add(PayForm payForm) {
        User user = new User();
        String username = payForm.getUsername();
        user.setUsername(username);
        User user1 = paymentDao.findbyname(user.getUsername());

        if (payForm.getYue() == null) {
            user.setYue(new BigDecimal(0));
            Log log = new Log();
            Log log1 = new Log();
            int type = payForm.getType();
            if (type == 1) {
                if(payForm.getCoumsername()!=null){
                    User user2 = new User();
                    String coumsername = payForm.getCoumsername();
                    user2.setUsername(coumsername);
                    User user3 = paymentDao.findbyname(user2.getUsername());
                    user2.setYue(new BigDecimal(0));
                    user2.setShopjifen(payForm.getAmount());
                    BigDecimal shopjifen = payForm.getAmount().negate();
                    user.setShopjifen(shopjifen);

                    log.setType(payForm.getType());
                    log.setUsername(payForm.getUsername());
                    log.setOrderId(payForm.getOrderId());
                    log.setCoumsername(payForm.getCoumsername());
                    log1.setType(2);
                    log1.setUsername(payForm.getCoumsername());
                    if(payForm.getOrderId()!=null){
                        log1.setOrderId(payForm.getOrderId());
                    }
                    log1.setCoumsername(payForm.getUsername());
                    log(payForm, user2, user3,log1);
                }else{
                    BigDecimal shopjifen = payForm.getAmount().negate();
                    user.setShopjifen(shopjifen);
                    log.setType(payForm.getType());
                    log.setUsername(payForm.getUsername());
                }
            } else {
                user.setShopjifen(payForm.getAmount());
                log.setType(payForm.getType());
                log.setUsername(payForm.getUsername());
            }
            int i =1/0;
            log(payForm, user, user1,log);

        } else {
            user.setShopjifen(new BigDecimal(0));
            Log log = new Log();
            Log log1 = new Log();

            int type = payForm.getType();
            if (type == 1) {
                if(payForm.getCoumsername()!=null){
                    User user2 = new User();
                    String coumsername = payForm.getCoumsername();
                    user2.setUsername(coumsername);
                    User user3 = paymentDao.findbyname(user2.getUsername());
                    user2.setShopjifen(new BigDecimal(0));
                    user2.setYue(payForm.getYue());
                    BigDecimal yue = payForm.getYue().negate();
                    user.setYue(yue);

                    log.setType(payForm.getType());
                    log.setUsername(payForm.getUsername());
                    log.setOrderId(payForm.getOrderId());
                    log.setCoumsername(payForm.getCoumsername());
                    log1.setType(2);
                    log1.setUsername(payForm.getCoumsername());
                    if(payForm.getOrderId()!=null){
                        log1.setOrderId(payForm.getOrderId());
                    }
                    log1.setCoumsername(payForm.getUsername());
                    log(payForm, user2, user3,log1);
                } else{
                    BigDecimal yue = payForm.getYue().negate();
                    user.setShopjifen(yue);
                    log.setType(payForm.getType());
                    log.setUsername(payForm.getUsername());

                }
            } else {
                user.setYue(payForm.getYue());
                log.setType(payForm.getType());
                log.setUsername(payForm.getUsername());
            }
            log(payForm, user, user1,log);
        }
    }

    private void log(PayForm payForm, User user, User user1,Log log) {

        if (user1 == null) {
            paymentDao.add(user);
        } else {
            paymentDao.update(user);
        }



        if (payForm.getYue() != null) {
            log.setYue(payForm.getYue());
            log.setAmount(new BigDecimal(0));
        } else {
            log.setAmount(payForm.getAmount());
            log.setYue(new BigDecimal(0));
        }
        Date d = new Date();
        //SimpleDateFormat sbf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        log.setCreattime(d);
        logDao.add(log);
    }


}
