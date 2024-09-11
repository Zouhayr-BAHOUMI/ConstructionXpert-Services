package gateway.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "user-management", url = "http://localhost:8020")
public interface AuthenticationClient {

    @GetMapping("/auth/validate")
    String validateToken(@RequestParam("token") String token);
}
