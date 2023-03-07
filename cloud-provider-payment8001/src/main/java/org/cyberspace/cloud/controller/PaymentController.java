package org.cyberspace.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.cyberspace.cloud.entity.CommonResult;
import org.cyberspace.cloud.entity.Payment;
import org.cyberspace.cloud.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    /**
     * 添加serial
     *
     * @param payment
     * @return
     */
    @PostMapping("/insert")
    public CommonResult insert(@RequestBody Payment payment) {
        int i = paymentService.insert(payment);
        if (i > 0) {
            return new CommonResult(200, "添加数据库成功", i);
        } else {
            return new CommonResult(444, "添加数据库失败");
        }
    }

    @GetMapping("/getSerialById/{id}")
    public CommonResult getSerialById(@PathVariable("id") Long id) {
        Payment payment = paymentService.queryById(id);
        if (payment != null) {
            return new CommonResult(200, "查询成功", payment);
        }
        return new CommonResult(444, "查询失败", null);
    }
}
