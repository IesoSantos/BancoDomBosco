package com.metro.bancodombosco.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class MovimentacaoFinanceira implements Parcelable{
    private long id;
    private Usuario destinatario, remetente;
    private String tipoMovimentacaoFinanceira;
    private double valorMovimentacao;
    private Date dataMovimentacaoFinanceira;

    public MovimentacaoFinanceira(long id, Usuario destinatario, Usuario remetente,
                                  String tipoMovimentacaoFinanceira, double valorMovimentacao,
                                  Date dataMovimentacaoFinanceira) {
        this.id = id;
        this.destinatario = destinatario;
        this.remetente = remetente;
        this.tipoMovimentacaoFinanceira = tipoMovimentacaoFinanceira;
        this.valorMovimentacao = valorMovimentacao;
        this.dataMovimentacaoFinanceira = dataMovimentacaoFinanceira;
    }

    private MovimentacaoFinanceira(Parcel parcel){
        this.setId(parcel.readLong());
        this.setDestinatario(parcel.readParcelable(Usuario.class.getClassLoader()));
        this.setRemetente(parcel.readParcelable(Usuario.class.getClassLoader()));
        this.setTipoMovimentacaoFinanceira(parcel.readString());
        this.setValorMovimentacao(parcel.readDouble());
        this.setDataMovimentacaoFinanceira(new Date(parcel.readLong()));
    }

    public static final Parcelable.Creator<MovimentacaoFinanceira>
            CREATOR = new Parcelable.Creator<MovimentacaoFinanceira>(){
        public MovimentacaoFinanceira createFromParcel(Parcel in) {

            return new MovimentacaoFinanceira(in);
        }

        @Override
        public MovimentacaoFinanceira[] newArray(int size) {
            return new MovimentacaoFinanceira[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Usuario getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Usuario destinatario) {
        this.destinatario = destinatario;
    }

    public Usuario getRemetente() {
        return remetente;
    }

    public void setRemetente(Usuario remetente) {
        this.remetente = remetente;
    }

    public String getTipoMovimentacaoFinanceira() {
        return tipoMovimentacaoFinanceira;
    }

    public void setTipoMovimentacaoFinanceira(String tipoMovimentacaoFinanceira) {
        this.tipoMovimentacaoFinanceira = tipoMovimentacaoFinanceira;
    }

    public double getValorMovimentacao() {
        return valorMovimentacao;
    }

    public void setValorMovimentacao(double valorMovimentacao) {
        this.valorMovimentacao = valorMovimentacao;
    }

    public Date getDataMovimentacaoFinanceira() {
        return dataMovimentacaoFinanceira;
    }

    public void setDataMovimentacaoFinanceira(Date dataMovimentacaoFinanceira) {
        this.dataMovimentacaoFinanceira = dataMovimentacaoFinanceira;
    }
}
