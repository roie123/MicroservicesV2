package com.roie.department_service.config;


import com.roie.department_service.client.EmployeeClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
@RequiredArgsConstructor
public class WebClientConfig {

    @Autowired
    private LoadBalancedExchangeFilterFunction lbFunction;

    @Bean
    public WebClient employeeWebClient() {
        return WebClient.builder()
                .baseUrl("http://employee-service")
                .filter(lbFunction)
                .build();
    }


    @Bean
    public EmployeeClient employeeClient() {
        WebClientAdapter webClientAda = WebClientAdapter.create(employeeWebClient());

        HttpServiceProxyFactory httpServiceProxyFactory
                = HttpServiceProxyFactory.builderFor(webClientAda).build();

        return httpServiceProxyFactory.createClient(EmployeeClient.class);
    }


}
