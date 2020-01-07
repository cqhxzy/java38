package com.wisezone.dao.impl;

import com.wisezone.dao.HandSetDao;
import com.wisezone.dao.JdbcUtil;
import com.wisezone.entity.HandSet;

import java.util.List;

public class HandSetDaoImpl extends JdbcUtil implements HandSetDao {
    @Override
    public int insert(HandSet handSet) {
        String sql = "insert into handset (name_type,price,network_mode,network_type,facade,screen_size,feel_screen) values(?,?,?,?,?,?,?)";
        Object[] params = {handSet.getNameType(), handSet.getPrice(), handSet.getNetworkMode(), handSet.getNetworkType(), handSet.getFacade()
                , handSet.getScreenSize(), handSet.getFeelScreen()};
        return super.executeUpdate(sql,params);
    }

    @Override
    public int update(HandSet handSet) {
        return 0;
    }

    @Override
    public int deleteById(int id) {
        String sql = "delete from handset where hs_id = ?";
        return super.executeUpdate(sql,id);
    }

    @Override
    public HandSet findById(int id) {
        String sql = "select hs_id hsId, name_type nameType,price,network_mode networkMode,network_type networkType,facade,screen_size screenSize,feel_screen feelScreen from handset where hs_id=?";
        List<HandSet> handSets = super.executeQuery(HandSet.class, sql, id);

        return handSets.size() > 0 ? handSets.get(0) : null;
    }

    @Override
    public List<HandSet> queryAll() {
        String sql = "select hs_id hsId, name_type nameType,price,network_mode networkMode,network_type networkType,facade,screen_size screenSize,feel_screen feelScreen from handset";
        return super.executeQuery(HandSet.class, sql);
    }
}
