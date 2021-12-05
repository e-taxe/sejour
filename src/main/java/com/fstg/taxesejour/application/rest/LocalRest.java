package com.fstg.taxesejour.application.rest;

import com.fstg.taxesejour.infrastructure.required.LocalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LocalRest {

    private final LocalService localService;

    @GetMapping("/ref/{ref}")
    public boolean getLocalByRef(@PathVariable String ref) {
        return localService.existByRef(ref);
    }
}
