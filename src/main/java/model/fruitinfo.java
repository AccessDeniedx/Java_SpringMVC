package model;

import javax.persistence.criteria.CriteriaBuilder;

public class fruitinfo {
    private Integer fruitid;
    private String FNAME;
    private double Fprice;


    public Integer getFruitid() {
        return fruitid;
    }
    public void setFruitid(Integer id) {
        this.fruitid = id;
    }
    public String getFNAME() {
        return FNAME;
    }
    public void setFNAME(String FNAME) {
        this.FNAME = FNAME;
    }
    public double getFprice() {
        return Fprice;
    }
    public void setFprice(double Fprice) {
        this.Fprice = Fprice;
    }
    @Override
    public String toString() {
        System.out.println("FruitInfo [fruitid=" + fruitid +
                ", FNAME=" + FNAME + ", Fprice=" + Fprice + "]");
        return null;
    }
}
