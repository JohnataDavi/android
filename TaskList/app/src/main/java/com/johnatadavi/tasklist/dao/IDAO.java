package com.johnatadavi.tasklist.dao;


import java.io.Serializable;
import java.util.ArrayList;

public interface IDAO<T> extends Serializable {
    public boolean save(T t);

    public boolean update(T t);

    public boolean delete(T t);

    public ArrayList<T> list();
}
