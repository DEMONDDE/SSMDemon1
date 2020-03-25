package cn.service;

import cn.po.BaseDick;

import java.util.List;

public interface BaseDickService {
    //根据类别查询字典
    public List<BaseDick> findBaseDictByTypeCode(String typecode);
}
