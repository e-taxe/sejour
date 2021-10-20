package com.fstg.taxesejour.domaine.service.required;

import com.fstg.taxesejour.domaine.pojo.Local;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "LOCAL-SERVICE", url = "http://192.168.0.192:8060/api/local")
public interface LocalService {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    List<Local> findAll();

    @RequestMapping(method = RequestMethod.GET, value = "/ref/{ref}")
    Local findByRef(@PathVariable String ref);
}
