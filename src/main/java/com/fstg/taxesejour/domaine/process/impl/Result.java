package com.fstg.taxesejour.domaine.process.impl;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private List<String> errors;
    private List<String> warnings;
    private List<String> infos;

    public List<String> getErrors() {
        if(errors==null){
            errors= new ArrayList<>();
        }
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public List<String> getWarnings() {
        if(warnings==null){
            warnings= new ArrayList<>();
        }
        return warnings;
    }

    public void setWarnings(List<String> warnings) {
        this.warnings = warnings;
    }

    public List<String> getInfos() {
        if(infos==null){
            infos= new ArrayList<>();
        }
        return infos;
    }

    public void setInfos(List<String> infos) {
        this.infos = infos;
    }
}
