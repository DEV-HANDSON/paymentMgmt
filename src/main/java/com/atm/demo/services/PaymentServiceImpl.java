    package com.atm.demo.services;

    import com.atm.demo.entity.Payment;
    import com.atm.demo.repository.PaymentRepository;
    import com.atm.demo.request.CreatePaymentRequest;
    import com.atm.demo.response.PaymentResponse;
    import com.atm.demo.util.DozzerMapper;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.beans.factory.annotation.Value;
    import org.springframework.stereotype.Service;

    import java.util.List;

    @Service
    public class PaymentServiceImpl implements PaymentService {

        @Value("${paymentMessage}")
        private String paymentMsg;

        @Autowired
         private  PaymentRepository paymentRepository;

        @Override
        public PaymentResponse createpayment(CreatePaymentRequest createPaymentRequest) {

            PaymentResponse res = new PaymentResponse();

            Payment pay = DozzerMapper.map(createPaymentRequest, Payment.class);
            pay = paymentRepository.save(pay);
            if (pay.getId() != null) {
                res.setResponseMessage(paymentMsg);
                res.setPayment(pay);
            } else {
                res.setResponseMessage("Unsuccessful !!!!");
            }
            return res;
        }

        @Override
        public List<Payment> getAllpayment() {
            List<Payment> pay = paymentRepository.findAll();
            return pay;
        }

    }
