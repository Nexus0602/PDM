package com.example.eathappy.dao;

import java.util.List;

public class RespuestaCategoriaImpl implements RespuestaCategoria {

    private String code;
    private String message;
    private List<Categoria> result;


    @Override
    public List<Categoria> getResult() {
        return result;
    }


    @Override
    public void setResult(List<Categoria> result) {
        this.result = result;
    }


    @Override
    public String getCode() {
        return code;
    }


    @Override
    public void setCode(String code) {
        this.code = code;
    }


    @Override
    public String getMessage() {
        return message;
    }


    @Override
    public void setMessage(String message) {
        this.message = message;
    }
}


