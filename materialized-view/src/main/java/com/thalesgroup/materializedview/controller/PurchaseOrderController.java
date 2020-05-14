package com.thalesgroup.materializedview.controller;

import com.thalesgroup.materializedview.dto.PurchaseOrderSummaryDto;
import com.thalesgroup.materializedview.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("po")
public class PurchaseOrderController {

    @Autowired
    private PurchaseOrderService purchaseOrderService;


    @GetMapping("/sale/{userIndex}/{prodIndex}")
    public void placeOrder(@PathVariable final int userIndex,
                           @PathVariable final int prodIndex){
        this.purchaseOrderService.placeOrder(userIndex, prodIndex);
    }

    @GetMapping("/summary")
    public List<PurchaseOrderSummaryDto> getSummary(){

        return this.purchaseOrderService.getSaleSummary();
    }


    @GetMapping("/test")
    public void Test(){
        long startT = System.nanoTime();
        for(int i = 0; i<100000;i++){
            this.purchaseOrderService.getSaleSummary();
        }

        long endT = System.nanoTime();
        long elapsedTime  = endT- startT;
        double elapsedTimeInSecond = (double) elapsedTime / 1_000_000_000;

        System.out.println(elapsedTimeInSecond + " seconds");

    }

}
