package com.ywq.secKill.controller;

import com.ywq.secKill.common.Response;
import com.ywq.secKill.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    ProductService productService;

    @GetMapping("/buy")
    public Response buy(Integer productId) {
        if(productId == null) return Response.buildFail("操作错误");
        int buyRes = productService.buyOne(productId);
        if (buyRes > 0)
            return Response.buildSuccess();
        else return Response.buildFail("秒杀失败");
    }
}
