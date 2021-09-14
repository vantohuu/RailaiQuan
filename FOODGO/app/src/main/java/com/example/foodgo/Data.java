package com.example.foodgo;

import java.util.ArrayList;
import java.util.List;

public class Data {
    private List<monan>  bbq, monxao, giaikhat, bia, lau, sup;

    public List<monan> getBbq() {
        bbq = new ArrayList<>();
        bbq.add(new monan(R.mipmap.bbq_bo_xien_rau_cu,"Bò xiên rau củ","",170000,0));
        bbq.add(new monan(R.mipmap.bbq_chan_ga_nuong_mat_ong,"Chân gà nướng","",90000,0));
        bbq.add(new monan(R.mipmap.bbq_da_day_nuong_ngu_vi,"Dạ dày nướng ngũ vị","",120000,0));
        bbq.add(new monan(R.mipmap.bbq_ga_nuong_sa_te,"Gà nướng sa tế","",190000,0));
        bbq.add(new monan(R.mipmap.bbq_long_heo_nuong,"Lòng heo nướng","",90000,0));
        bbq.add(new monan(R.mipmap.bbq_thit_bo_cuon_kim_cham,"Thịt bò cuộn kim châm","",180000,0));
        return bbq;
    }

    public List<monan> getMonxao() {
        monxao = new ArrayList<>();
        monxao.add(new monan(R.mipmap.monxao_longxaomuop,"Lòng xào mướp","",70000,0));
        monxao.add(new monan(R.mipmap.monxao_mang_xao_thi_bo,"Măng xào thịt bò","",90000,0));
        monxao.add(new monan(R.mipmap.monxao_muc_xao_dua,"Mực xào dưa","",70000,0));
        monxao.add(new monan(R.mipmap.monxao_raumuonxao,"Rau muống xào","",30000,0));
        monxao.add(new monan(R.mipmap.monxao_suon_xao_chua_ngot,"Sườn xào chua ngọt","",11000,0));
        return monxao;
    }

    public List<monan> getGiaikhat() {
        giaikhat = new ArrayList<>();
        giaikhat.add(new monan(R.mipmap.giaikhat_7up, "7 up", "", 15000,0));
        giaikhat.add(new monan(R.mipmap.giaikhat_coca, "Coca", "", 15000,0));
        giaikhat.add(new monan(R.mipmap.giaikhat_lavie, "Lavie", "", 10000,0));
        giaikhat.add(new monan(R.mipmap.giaikhat_pepsi, "Pepsi", "", 15000,0));
        giaikhat.add(new monan(R.mipmap.giaikhat_string, "Sting", "", 15000,0));
        return giaikhat;
    }

    public List<monan> getBia() {
        bia = new ArrayList<>();
        bia.add(new monan(R.mipmap.bia_333, "Bia 333", "", 25000,0));
        bia.add(new monan(R.mipmap.bia_corona, "Bia Corona", "", 23000,0));
        bia.add(new monan(R.mipmap.bia_heinekenpg, "Bia Heineken", "", 20000,0));
        bia.add(new monan(R.mipmap.bia_saigon, "Bia Sài gòn", "", 15000,0));
        bia.add(new monan(R.mipmap.bia_tiger, "Bia Tiger", "", 18000,0));
        return bia;
    }

    public List<monan> getLau() {
        lau = new ArrayList<>();
        lau.add(new monan(R.mipmap.lau_bo, "Lẩu bò", "", 220000,0));
        lau.add(new monan(R.mipmap.lau_chay, "Lẩu chay", "", 150000,0));
        lau.add(new monan(R.mipmap.lau_ga_la_giangjpg, "Lẩu gà lá giang", "", 200000,0));
        lau.add(new monan(R.mipmap.lau_ga_ot_hiem, "Lẩu gà ớt hiểm", "", 220000,0));
        lau.add(new monan(R.mipmap.lau_luong_chua_cayjpg, "Lẩu lương chua cay", "", 250000,0));
        lau.add(new monan(R.mipmap.lau_thai_chua_cay, "Lẩu thái chua cay", "", 200000,0));
        return lau;
    }

    public List<monan> getSup() {
        sup = new ArrayList<>();
        sup.add(new monan(R.mipmap.sup_ga_va_nam_huon, "Súp gà nấm hương", "", 60000,0));
        sup.add(new monan(R.mipmap.sup_khoai_tay_pho_mai, "Súp khoai tây phô mai", "", 50000,0));
        sup.add(new monan(R.mipmap.sup_mang_cua, "Súp măng cua", "", 60000,0));
        sup.add(new monan(R.mipmap.sup_ngo_thit_ga, "Súp ngô thịt gà", "", 50000,0));
        sup.add(new monan(R.mipmap.sup_tom_cua, "Súp tôm cua", "", 70000,0));
        return sup;
    }
}
