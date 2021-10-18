package com.fstg.taxesejour.domaine.service.required;

import com.fstg.taxesejour.domaine.pojo.Local;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "local-service", url = "http://localhost:8060/")
public interface LocalService {

    @RequestMapping(method = RequestMethod.GET, value = "/locals")
    List<Local> getAllLocal();
}
