package com.fstg.taxesejour.infrastructure.required;

import com.fstg.taxesejour.domaine.pojo.Local;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
@FeignClient(name = "LOCAL-SERVICE", url = "http://localhost:8061/api/local")
@Component
public interface LocalService {

    @GetMapping("/exist/ref/{ref}")
    boolean existByRef(@PathVariable String ref);

    @PutMapping("/ref/{ref}")
    boolean existByRef(@PathVariable String ref, @RequestBody Local local);
}
