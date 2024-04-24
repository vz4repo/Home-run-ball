package com.homerunball.ord.dao;

import com.homerunball.ord.domain.OrdDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OrdDaoImpl implements OrdDao {
    @Autowired
    private SqlSession session;
    private static String namespace = "com.homerunball.ord.dao.OrdMapper.";

    @Override
    public int count() throws Exception {
        return session.selectOne(namespace+"count");
    } // T selectOne(String statement)

    @Override
    public int delete(String od_id, String c_id) throws Exception {
        Map map = new HashMap();
        map.put("od_id", od_id);
        map.put("c_id", c_id);
        return session.delete(namespace+"delete", map);
    }

    @Override
    public int deleteAll() {
        return session.delete(namespace+"deleteAll");
    } // int delete(String statement)

    @Override
    public OrdDto select(String od_id) throws Exception {
        return session.selectOne(namespace + "select", od_id);
    } // T selectOne(String statement, Object parameter)

    @Override
    public List<OrdDto> selectAll() throws Exception {
        return session.selectList(namespace+"selectAll");
    } // Li

    @Override
    public int insert(OrdDto od_id) throws Exception {
        return session.insert(namespace+"insert", od_id);
    }
//        OrdDto select(String od_id, String c_id) throws Exception; // T selectOne(String statement, Object parameter)

    @Override
    public int update(OrdDto dto) throws Exception {
        return session.update(namespace+"update", dto);
    } // int update(String statement, Object parameter)


}
