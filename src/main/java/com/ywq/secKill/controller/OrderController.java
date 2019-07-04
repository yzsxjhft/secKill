package com.ywq.secKill.controller;

import com.ywq.secKill.entry.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @RequestMapping(value = "/buy", method = RequestMethod.GET)
    public Response buy(int productId) {
        return Response.buildSuccess();
    }
}
