package com.wallet.entiy;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.math.BigDecimal;

/**
 * @author Pom
 */
@TableName
public class User {
    @TableId
    public int id;
    @TableField
    public String username;
     @TableField
    public BigDecimal shopjifen;
    @TableField
     public BigDecimal yue;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public BigDecimal getShopjifen() {
        return shopjifen;
    }

    public void setShopjifen(BigDecimal shopjifen) {
        this.shopjifen = shopjifen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getYue() {
        return yue;
    }

    public void setYue(BigDecimal yue) {
        this.yue = yue;
    }



}
