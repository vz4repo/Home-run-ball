package com.homerunball.payment.service;

import com.homerunball.payment.domain.PaymentDto;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;

public interface PaymentService {
  List<PaymentDto> selectPaymentHistoryWithDateRange(int c_id, LocalDate fromDate, LocalDate toDate);
}