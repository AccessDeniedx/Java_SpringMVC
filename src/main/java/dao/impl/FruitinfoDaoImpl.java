package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.FruitInfoDao;
import model.*;

public class FruitinfoDaoImpl extends BaseDao implements FruitInfoDao {
    @Override
    public int addFruit(fruitinfo u) {
        String sql  = "insert into fruits (fruitid,FNAME,Fprice) " +
                "values("+u.getFruitid()+",'"+u.getFNAME()+"','"
                +u.getFprice()+"')";
        int i = executeIUD(sql);
        return i;
    }

    @Override
    public int delFruit(Integer id) {
        String sql  = "delete from fruits where fruitid="+id+";";
        int i = executeIUD(sql);
        return i;
    }

    @Override
    public int modifyFruit(fruitinfo u) {
        String sql  = "update fruits set " +
                "FNAME='"+u.getFNAME()+" ', Fprice='"+
                u.getFprice()+"' where fruitid="+u.getFruitid()+";";

        int i = executeIUD(sql);
        return i;
    }

    @Override
    public List<fruitinfo> queryAllFruit() {
        List<fruitinfo> list = new ArrayList<fruitinfo>();
        try {
            String sql="select * from fruits;";
            ResultSet rs = executeSelect(sql);

            while(rs.next()){
                fruitinfo temp = new fruitinfo();
                temp.setFruitid(rs.getInt(1));
                temp.setFNAME(rs.getString(2));
                temp.setFprice(rs.getDouble(3));

                list.add(temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            //closeAll(BaseDao.con, BaseDao.pstat, rst);
        }

        return list;
    }
}
