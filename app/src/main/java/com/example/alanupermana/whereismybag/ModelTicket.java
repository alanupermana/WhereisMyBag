package com.example.alanupermana.whereismybag;

public class ModelTicket {

    public Long Date;
    public String Gate_in;
    public String Aircraft;
    public String Gate_out;

    public ModelTicket(Long date, String gate_in, String aircraft, String gate_out) {
        this.Date = date;
        this.Gate_in = gate_in;
        this.Aircraft = aircraft;
        this.Gate_out = gate_out;
    }

    public ModelTicket() {
    }
}

