package dao;

import model.fruitinfo;
import model.userinfo;

import java.util.List;

public interface FruitInfoDao {
	int addFruit(fruitinfo u);
	
	int delFruit(Integer id);
	
	int modifyFruit(fruitinfo u);
	
	List<fruitinfo> queryAllFruit();

}
