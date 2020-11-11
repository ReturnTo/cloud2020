package com.atguigu.springcloud.service;
import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
/**
 * @author 裴舒凯
 */
@Service
public class PaymentServiceImpl implements PaymentService{

    //还可以使用Autowired
    @Resource //java自带的,也可以进行依赖注入
    private PaymentDao paymentDao;

    public int create(Payment payment){
        return paymentDao.create(payment);
    }
    public Payment getPaymentById(Long id){
        return paymentDao.getPaymentById(id);
    }
}
