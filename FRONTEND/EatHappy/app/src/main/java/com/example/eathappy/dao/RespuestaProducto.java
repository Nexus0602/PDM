package com.example.eathappy.dao;

import java.util.List;

public interface RespuestaProducto {
    List<Producto> getResult();

    void setResult(List<Producto> result);

    String getCode();

    void setCode(String code);

    String getMessage();

    void setMessage(String message);
}
