package cn.service.Impl;

import cn.dao.BaseDickDao;
import cn.po.BaseDick;
import cn.service.BaseDickService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("baseDickService")
public class BaseDickServiceImpl implements BaseDickService {

    @Autowired
    private BaseDickDao baseDickDao;
    @Override
    public List<BaseDick> findBaseDictByTypeCode(String typecode) {
        return baseDickDao.selectBaseDictByTypeCode(typecode);
    }
}
