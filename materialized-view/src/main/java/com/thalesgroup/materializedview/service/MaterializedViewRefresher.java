package com.thalesgroup.materializedview.service;

import com.thalesgroup.materializedview.repository.PurchaseOrderRepository;
import com.thalesgroup.materializedview.repository.PurchaseOrderSummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Component
public class MaterializedViewRefresher {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    @Scheduled(fixedRate = 60000L)
    public void refresh(){
        System.out.println("OK");
        this.entityManager.createNativeQuery("call refresh_mat_view();").executeUpdate();

    }
}

