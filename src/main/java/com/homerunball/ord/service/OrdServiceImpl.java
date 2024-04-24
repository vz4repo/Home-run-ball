package com.homerunball.ord.service;

import com.homerunball.ord.dao.OrdDao;
import com.homerunball.ord.domain.OrdDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrdServiceImpl implements OrdService {
   @Autowired
    OrdDao ordDao;


   @Override
   public int getcount() throws Exception{
       return ordDao.count();
   }

   @Override
   public int remove(String od_id, String c_id) throws Exception{
       return ordDao.delete(od_id,c_id);
   }

    @Override
    public OrdDto read(String od_id) throws Exception {
        return  ordDao.select(od_id);
    }

    @Override
    public int writer(OrdDto ord)throws Exception{
        return  ordDao.insert(ord);
    }

    @Override
    public List<OrdDto> getList() throws Exception{
        return ordDao.selectAll();
    }

    @Override
    public int modify(OrdDto ord) throws Exception{
        return ordDao.update(ord);
    }

  /*  @Override
    public List<OrdDto> getPage(Map map) throws Exception {
        return ordDao.selectPage(map);
    }*/
}
