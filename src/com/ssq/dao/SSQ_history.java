package com.ssq.dao;

import java.util.Date;

/**
 * @author :zh
 * @PACKAGE_NAME :com.ssq.dao
 * @NAME : SSQ_history
 * @date :2022Äê08ÔÂ25ÈÕ16:46
 */
public class SSQ_history {
    private Integer id;
    private Integer idnum;
    private Integer a;
    private Integer b;
    private Integer c;
    private Integer d;
    private Integer ee;
    private Integer f;
    private Integer g;
    private String bns;
    private Integer fpn;
    private String fpb;
    private Integer spn;
    private String spb;
    private String ttb;
    private Date lyd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdnum() {
        return idnum;
    }

    public void setIdnum(Integer idnum) {
        this.idnum = idnum;
    }

    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    public Integer getB() {
        return b;
    }

    public void setB(Integer b) {
        this.b = b;
    }

    public Integer getC() {
        return c;
    }

    public void setC(Integer c) {
        this.c = c;
    }

    public Integer getD() {
        return d;
    }

    public void setD(Integer d) {
        this.d = d;
    }

    public Integer getEe() {
        return ee;
    }

    public void setEe(Integer ee) {
        this.ee = ee;
    }

    public Integer getF() {
        return f;
    }

    public void setF(Integer f) {
        this.f = f;
    }

    public Integer getG() {
        return g;
    }

    public void setG(Integer g) {
        this.g = g;
    }

    public String getBns() {
        return bns;
    }

    public void setBns(String bns) {
        this.bns = bns;
    }

    public Integer getFpn() {
        return fpn;
    }

    public void setFpn(Integer fpn) {
        this.fpn = fpn;
    }

    public String getFpb() {
        return fpb;
    }

    public void setFpb(String fpb) {
        this.fpb = fpb;
    }

    public Integer getSpn() {
        return spn;
    }

    public void setSpn(Integer spn) {
        this.spn = spn;
    }

    public String getSpb() {
        return spb;
    }

    public void setSpb(String spb) {
        this.spb = spb;
    }

    public String getTtb() {
        return ttb;
    }

    public void setTtb(String ttb) {
        this.ttb = ttb;
    }

    public Date getLyd() {
        return lyd;
    }

    public void setLyd(Date lyd) {
        this.lyd = lyd;
    }

    @Override
    public String toString() {
        return "SSQ_history{" +
                "id=" + id +
                ", idnum=" + idnum +
                ", a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", d=" + d +
                ", ee=" + ee +
                ", f=" + f +
                ", g=" + g +
                ", bns='" + bns + '\'' +
                ", fpn=" + fpn +
                ", fpb='" + fpb + '\'' +
                ", spn=" + spn +
                ", spb='" + spb + '\'' +
                ", ttb='" + ttb + '\'' +
                ", lyd=" + lyd +
                '}';
    }
}
