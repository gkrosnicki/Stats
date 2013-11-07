package com.mediatel.stats.beans;

import com.mediatel.stats.entities.Operators;
import com.mediatel.stats.entities.Stats;
import org.apache.poi.hssf.usermodel.HSSFRow;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: gkrosnicki
 * Date: 31.10.13
 * Time: 22:39
 * To change this template use File | Settings | File Templates.
 */
@Stateless
public class PersistBean {
    //@PersistenceContext(unitName="persistanceUnit")
    @PersistenceContext(unitName="NewPersistenceUnit")
    public EntityManager em;

    //@EJB
    DownloadBean downloadBean = new DownloadBean();

    public void getStats(){
        Query query = em.createQuery("select s from StatsEntity s");
        System.out.println(query.toString());
        List<Stats> statsList = query.getResultList();
        for (Stats stats:statsList){
            System.out.println(stats.getMinutes());
        }
    }

    public void updateBase(){
        Iterator iterator=downloadBean.getDataFromXls();
        while (iterator.hasNext()) {
            HSSFRow row = (HSSFRow) iterator.next();
            if (row != null) {
                if (row.getCell(1) != null) {
                    System.out.println(row.getCell(1));
                    System.out.println(row.getCell(1).getCellStyle().getFillBackgroundColor());
                }
            }
        }

    }

    public void getOperators(){
        Query query = em.createQuery("select o from OperatorsEntity o");
        List<Operators> operators =  query.getResultList();
    }
}
