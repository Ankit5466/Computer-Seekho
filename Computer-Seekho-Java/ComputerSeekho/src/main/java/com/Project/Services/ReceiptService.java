package com.Project.Services;

import java.util.List;
import java.util.Optional;

import com.Project.Entities.Receipt;

public interface ReceiptService {
    Optional<Receipt> getReceiptById(int receiptId);
    List<Receipt> getAllReceipts();
    Receipt addReceipt(Receipt receipt);
}
