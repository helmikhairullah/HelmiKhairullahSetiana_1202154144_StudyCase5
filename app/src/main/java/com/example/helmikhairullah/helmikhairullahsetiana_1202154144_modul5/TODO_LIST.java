package com.example.helmikhairullah.helmikhairullahsetiana_1202154144_modul5;

/**
 * Created by Helmi Khairullah on 25/03/2018.
 */

public class TODO_LIST {
    private int id;
    private String namaKegiatan;
    private String kegiatan;
    private int prioritas;

    public void setId(int id) {
        this.id = id;
    }

    public void setNamaKegiatan(String namaKegiatan) {
        this.namaKegiatan = namaKegiatan;
    }

    public void setKegiatan(String kegiatan) {
        this.kegiatan = kegiatan;
    }

    public void setPrioritas(int prioritas) {
        this.prioritas = prioritas;
    }

    public TODO_LIST() {
    }

    public String getNamaKegiatan() {
        return namaKegiatan;
    }

    public String getKegiatan() {
        return kegiatan;
    }

    public int getPrioritas() {
        return prioritas;
    }
}

