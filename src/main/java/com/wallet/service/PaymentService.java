package com.wallet.service;

import com.wallet.entiy.User;
import com.wallet.pojo.PayForm;

/**
 * @author Pom
 */
public interface PaymentService {
    User find(int i);

    void add(PayForm payForm);



}
