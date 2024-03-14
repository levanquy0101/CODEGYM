//package cg.wbd.grandemonstration.config;
//
//import cg.wbd.grandemonstration.model.Customer;
//import cg.wbd.grandemonstration.service.CustomerService;
//import cg.wbd.grandemonstration.service.impl.SimpleCustomerServiceImpl;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class BeanConfig {
//    @Bean(name = "customerService")
//    @Qualifier("customerService")
//    public CustomerService getCustomerService(){
//        return new SimpleCustomerServiceImpl();
//    }
//}
