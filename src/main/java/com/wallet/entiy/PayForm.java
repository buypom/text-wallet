package com.wallet.pojo;

import com.wallet.entiy.User;

import java.math.BigDecimal;

/**
 * @author Pom
 */
public class PayForm {
    public String username;
    public  int type;
    public BigDecimal amount;
    public String orderId;
    public String transactionId;
    public  String coumsername;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getCoumsername() {
        return coumsername;
    }

    public void setCoumsername(String coumsername) {
        this.coumsername = coumsername;
    }

    public BigDecimal getYue() {
        return yue;
    }

    public void setYue(BigDecimal yue) {
        this.yue = yue;
    }

    public BigDecimal yue;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
