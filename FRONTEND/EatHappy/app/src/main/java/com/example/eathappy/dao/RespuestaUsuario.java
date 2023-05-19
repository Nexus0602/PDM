package com.example.eathappy.dao;

import java.util.List;

public interface RespuestaUsuario {

    List<Usuario> getResult();

    void setResult(List<Usuario> result);

    String getCode();

    void setCode(String code);

    String getMessage();

    void setMessage(String message);
}

