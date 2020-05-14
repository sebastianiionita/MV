package com.thalesgroup.materializedview.repository;

import com.thalesgroup.materializedview.entity.PurchaseOrderSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseOrderSummaryRepository extends JpaRepository<PurchaseOrderSummary, String> {
}
