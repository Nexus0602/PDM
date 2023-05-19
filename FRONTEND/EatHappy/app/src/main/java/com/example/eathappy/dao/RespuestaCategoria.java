package com.example.eathappy.dao;

import java.util.List;

public interface RespuestaCategoria {
    List<Categoria> getResult();

    void setResult(List<Categoria> result);

    String getCode();

    void setCode(String code);

    String getMessage();

    void setMessage(String message);
}
