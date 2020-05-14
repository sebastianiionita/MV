package com.thalesgroup.materializedview.service;

import com.thalesgroup.materializedview.dto.PurchaseOrderSummaryDto;

import java.util.List;

public interface PurchaseOrderService {
    void placeOrder(int userIndex, int productIndex);
    List<PurchaseOrderSummaryDto> getSaleSummary();
}
