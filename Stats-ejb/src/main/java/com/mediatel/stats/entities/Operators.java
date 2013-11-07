/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mediatel.stats.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author gkrosnicki
 */
@Entity
@Table(name = "operators")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Operators.findAll", query = "SELECT o FROM Operators o")})
public class Operators implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "operator")
    private String operator;
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "idOperators")
    private Collection<Ips> ipsCollection;
    @OneToMany(mappedBy = "idOperators")
    private Collection<Stats> statsCollection;

    public Operators() {
    }

    public Operators(Integer id) {
        this.id = id;
    }

    public Operators(Integer id, String operator) {
        this.id = id;
        this.operator = operator;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<Ips> getIpsCollection() {
        return ipsCollection;
    }

    public void setIpsCollection(Collection<Ips> ipsCollection) {
        this.ipsCollection = ipsCollection;
    }

    @XmlTransient
    public Collection<Stats> getStatsCollection() {
        return statsCollection;
    }

    public void setStatsCollection(Collection<Stats> statsCollection) {
        this.statsCollection = statsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Operators)) {
            return false;
        }
        Operators other = (Operators) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mediatel.stats.entities.Operators[ id=" + id + " ]";
    }
    
}
