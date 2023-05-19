package com.example.eathappy.dao;

import java.util.List;

public class RespuestaProductoImpl implements RespuestaProducto{

    private String code;
    private String message;
    private List<Producto> result;


    @Override
    public List<Producto> getResult() {
        return result;
    }


    @Override
    public void setResult(List<Producto> result) {
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


