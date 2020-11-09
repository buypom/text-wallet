package com.wallet.controller;

import com.wallet.entiy.User;
import com.wallet.pojo.PayForm;
import com.wallet.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Pom
 */
@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    public PaymentService paymentService;
    @PostMapping("/pay")
    public String pay(PayForm payForm){
         paymentService.add(payForm);
        return "sucess";
    }

}
