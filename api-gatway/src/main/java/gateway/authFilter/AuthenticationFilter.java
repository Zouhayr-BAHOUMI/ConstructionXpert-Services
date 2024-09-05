package gateway.authFilter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {

    @Autowired
    private RouteValidator routeValidator;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClientBuilder;

    public AuthenticationFilter(){
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {

            if (routeValidator.isSecured.test(exchange.getRequest())){
                if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)){
                    throw new RuntimeException("no authorisation header !");
                }

                String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
                if (authHeader!= null && authHeader.startsWith("Bearer ")){
                        authHeader = authHeader.substring(7);
                }

                return webClientBuilder.build()
                        .get()
                        .uri("http://localhost:8020/auth/validate?token=" + authHeader)
                        .retrieve()
                        .bodyToMono(String.class)
                        .map(response -> {
                            exchange.getRequest().mutate().header("X-Auth-User", response);
                            return exchange;
                        })
                        .flatMap(chain::filter)
                        .onErrorResume(error -> {
                            System.out.println("Error Occurred: " + error.getMessage());
                            return Mono.error(new RuntimeException("Auth missing"));
                        });
            }

            return chain.filter(exchange);
        });
    }

    public static class Config{

    }
}
