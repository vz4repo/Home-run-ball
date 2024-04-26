package com.homerunball.pay.dto;

import java.time.LocalDateTime;
import java.util.Objects;

public class PayAmtDto {
    private String pay_id;
    private int pay_seqnum;
    private String od_id;
    private int c_id;
    private int disc_amt;
    private int od_pay_amt;
    private int pay_final_amt;
    private String pay_stat_cd;
    private LocalDateTime pay_dt;
    private String pay_meth_cd;
    private String pay_aprv_stat;
    private String pay_aprv_num;
    private LocalDateTime pay_aprv_dt;
    private String pay_resp_cd;
    private int pay_canc_amt;
    private LocalDateTime pay_canc_dt;
    private String c_name;
    private String trans_type;
    private String card_co;
    private int mth_instlmt;
    private String card_num;
    private String bank_name;
    private String acct_num;
    private LocalDateTime frst_reg_dt;
    private String frst_reg_id;
    private LocalDateTime last_mod_dt;
    private String last_mod_id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PayAmtDto payAmtDto = (PayAmtDto) o;
        return pay_seqnum == payAmtDto.pay_seqnum && c_id == payAmtDto.c_id && disc_amt == payAmtDto.disc_amt && od_pay_amt == payAmtDto.od_pay_amt && pay_final_amt == payAmtDto.pay_final_amt && pay_canc_amt == payAmtDto.pay_canc_amt && mth_instlmt == payAmtDto.mth_instlmt && Objects.equals(pay_id, payAmtDto.pay_id) && Objects.equals(od_id, payAmtDto.od_id) && Objects.equals(pay_stat_cd, payAmtDto.pay_stat_cd) && Objects.equals(pay_dt, payAmtDto.pay_dt) && Objects.equals(pay_meth_cd, payAmtDto.pay_meth_cd) && Objects.equals(pay_aprv_stat, payAmtDto.pay_aprv_stat) && Objects.equals(pay_aprv_num, payAmtDto.pay_aprv_num) && Objects.equals(pay_aprv_dt, payAmtDto.pay_aprv_dt) && Objects.equals(pay_resp_cd, payAmtDto.pay_resp_cd) && Objects.equals(pay_canc_dt, payAmtDto.pay_canc_dt) && Objects.equals(c_name, payAmtDto.c_name) && Objects.equals(trans_type, payAmtDto.trans_type) && Objects.equals(card_co, payAmtDto.card_co) && Objects.equals(card_num, payAmtDto.card_num) && Objects.equals(bank_name, payAmtDto.bank_name) && Objects.equals(acct_num, payAmtDto.acct_num) && Objects.equals(frst_reg_dt, payAmtDto.frst_reg_dt) && Objects.equals(frst_reg_id, payAmtDto.frst_reg_id) && Objects.equals(last_mod_dt, payAmtDto.last_mod_dt) && Objects.equals(last_mod_id, payAmtDto.last_mod_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pay_id, pay_seqnum, od_id, c_id, disc_amt, od_pay_amt, pay_final_amt, pay_stat_cd, pay_dt, pay_meth_cd, pay_aprv_stat, pay_aprv_num, pay_aprv_dt, pay_resp_cd, pay_canc_amt, pay_canc_dt, c_name, trans_type, card_co, mth_instlmt, card_num, bank_name, acct_num, frst_reg_dt, frst_reg_id, last_mod_dt, last_mod_id);
    }

    public String getPay_id() {
        return pay_id;
    }

    public void setPay_id(String pay_id) {
        this.pay_id = pay_id;
    }

    public int getPay_seqnum() {
        return pay_seqnum;
    }

    public void setPay_seqnum(int pay_seqnum) {
        this.pay_seqnum = pay_seqnum;
    }

    public String getOd_id() {
        return od_id;
    }

    public void setOd_id(String od_id) {
        this.od_id = od_id;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public int getDisc_amt() {
        return disc_amt;
    }

    public void setDisc_amt(int disc_amt) {
        this.disc_amt = disc_amt;
    }

    public int getOd_pay_amt() {
        return od_pay_amt;
    }

    public void setOd_pay_amt(int od_pay_amt) {
        this.od_pay_amt = od_pay_amt;
    }

    public int getPay_final_amt() {
        return pay_final_amt;
    }

    public void setPay_final_amt(int pay_final_amt) {
        this.pay_final_amt = pay_final_amt;
    }

    public String getPay_stat_cd() {
        return pay_stat_cd;
    }

    public void setPay_stat_cd(String pay_stat_cd) {
        this.pay_stat_cd = pay_stat_cd;
    }

    public LocalDateTime getPay_dt() {
        return pay_dt;
    }

    public void setPay_dt(LocalDateTime pay_dt) {
        this.pay_dt = pay_dt;
    }

    public String getPay_meth_cd() {
        return pay_meth_cd;
    }

    public void setPay_meth_cd(String pay_meth_cd) {
        this.pay_meth_cd = pay_meth_cd;
    }

    public String getPay_aprv_stat() {
        return pay_aprv_stat;
    }

    public void setPay_aprv_stat(String pay_aprv_stat) {
        this.pay_aprv_stat = pay_aprv_stat;
    }

    public String getPay_aprv_num() {
        return pay_aprv_num;
    }

    public void setPay_aprv_num(String pay_aprv_num) {
        this.pay_aprv_num = pay_aprv_num;
    }

    public LocalDateTime getPay_aprv_dt() {
        return pay_aprv_dt;
    }

    public void setPay_aprv_dt(LocalDateTime pay_aprv_dt) {
        this.pay_aprv_dt = pay_aprv_dt;
    }

    public String getPay_resp_cd() {
        return pay_resp_cd;
    }

    public void setPay_resp_cd(String pay_resp_cd) {
        this.pay_resp_cd = pay_resp_cd;
    }

    public int getPay_canc_amt() {
        return pay_canc_amt;
    }

    public void setPay_canc_amt(int pay_canc_amt) {
        this.pay_canc_amt = pay_canc_amt;
    }

    public LocalDateTime getPay_canc_dt() {
        return pay_canc_dt;
    }

    public void setPay_canc_dt(LocalDateTime pay_canc_dt) {
        this.pay_canc_dt = pay_canc_dt;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getTrans_type() {
        return trans_type;
    }

    public void setTrans_type(String trans_type) {
        this.trans_type = trans_type;
    }

    public String getCard_co() {
        return card_co;
    }

    public void setCard_co(String card_co) {
        this.card_co = card_co;
    }

    public int getMth_instlmt() {
        return mth_instlmt;
    }

    public void setMth_instlmt(int mth_instlmt) {
        this.mth_instlmt = mth_instlmt;
    }

    public String getCard_num() {
        return card_num;
    }

    public void setCard_num(String card_num) {
        this.card_num = card_num;
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public String getAcct_num() {
        return acct_num;
    }

    public void setAcct_num(String acct_num) {
        this.acct_num = acct_num;
    }

    public LocalDateTime getFrst_reg_dt() {
        return frst_reg_dt;
    }

    public void setFrst_reg_dt(LocalDateTime frst_reg_dt) {
        this.frst_reg_dt = frst_reg_dt;
    }

    public String getFrst_reg_id() {
        return frst_reg_id;
    }

    public void setFrst_reg_id(String frst_reg_id) {
        this.frst_reg_id = frst_reg_id;
    }

    public LocalDateTime getLast_mod_dt() {
        return last_mod_dt;
    }

    public void setLast_mod_dt(LocalDateTime last_mod_dt) {
        this.last_mod_dt = last_mod_dt;
    }

    public String getLast_mod_id() {
        return last_mod_id;
    }

    public void setLast_mod_id(String last_mod_id) {
        this.last_mod_id = last_mod_id;
    }

    @Override
    public String toString() {
        return "PayAmtDto{" +
                "pay_id='" + pay_id + '\'' +
                ", pay_seqnum=" + pay_seqnum +
                ", od_id='" + od_id + '\'' +
                ", c_id=" + c_id +
                ", disc_amt=" + disc_amt +
                ", od_pay_amt=" + od_pay_amt +
                ", pay_final_amt=" + pay_final_amt +
                ", pay_stat_cd='" + pay_stat_cd + '\'' +
                ", pay_dt=" + pay_dt +
                ", pay_meth_cd='" + pay_meth_cd + '\'' +
                ", pay_aprv_stat='" + pay_aprv_stat + '\'' +
                ", pay_aprv_num='" + pay_aprv_num + '\'' +
                ", pay_aprv_dt=" + pay_aprv_dt +
                ", pay_resp_cd='" + pay_resp_cd + '\'' +
                ", pay_canc_amt=" + pay_canc_amt +
                ", pay_canc_dt=" + pay_canc_dt +
                ", c_name='" + c_name + '\'' +
                ", trans_type='" + trans_type + '\'' +
                ", card_co='" + card_co + '\'' +
                ", mth_instlmt=" + mth_instlmt +
                ", card_num='" + card_num + '\'' +
                ", bank_name='" + bank_name + '\'' +
                ", acct_num='" + acct_num + '\'' +
                ", frst_reg_dt=" + frst_reg_dt +
                ", frst_reg_id='" + frst_reg_id + '\'' +
                ", last_mod_dt=" + last_mod_dt +
                ", last_mod_id='" + last_mod_id + '\'' +
                '}';
    }
}