package com.mediatel.stats.beans;

import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbException;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileInputStream;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import javax.ejb.Stateless;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.util.Iterator;
import javax.ejb.EJB;
import javax.ejb.LocalBean;

/**
 * Created with IntelliJ IDEA.
 * User: gkrosnicki
 * Date: 05.11.13
 * Time: 14:45
 * To change this template use File | Settings | File Templates.
 */

@Stateless
@LocalBean
public class DownloadBean{
    @EJB
    ConfigBean configBean;

    public Iterator getDataFromXls() {
        SmbFileInputStream smbFileInputStream = null;
        System.out.println("Pobiera dane z xls");
        String user = configBean.getSmbuser();
        NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(user);
        String filePath=configBean.getSmbpath();
        SmbFile sFile = null;
        
        
        
        try {
            sFile = new SmbFile(filePath, auth);
        } catch (MalformedURLException ex) {

        }
        try {
            smbFileInputStream = new SmbFileInputStream(sFile);
        } catch (SmbException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (MalformedURLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (UnknownHostException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


        HSSFWorkbook workbook = null;
        try {
            workbook = new HSSFWorkbook(smbFileInputStream);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        HSSFSheet sheet = workbook.getSheetAt(0);
        Iterator iterator = sheet.iterator();
        return iterator;
    }
}
