package cn.dao;

import cn.po.BaseDick;

import java.util.List;

public interface BaseDickDao {

    //根据类别代码查询
    public List<BaseDick> selectBaseDictByTypeCode(String typecode);
}
