/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mediatel.stats.beans;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author gkrosnicki
 */
@Stateless
@LocalBean
public class ConfigBean {
    String smbpath=null;
    String smbuser=null;
    Properties properties = new Properties();

    public String getSmbpath() {
        return smbpath;
    }

    public String getSmbuser() {
        return smbuser;
    }
    
    public ConfigBean(){
        try {
            properties.load(ConfigBean.class.getClassLoader().getResourceAsStream("init.properties"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        smbpath = properties.getProperty("smbpath");
        smbuser = properties.getProperty("smbuser");
    }
}
