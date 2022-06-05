package com.metro.bancodombosco.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Usuario implements Parcelable {
    private long id;
    private String nome, sobrenome, email, senha, dataNascimento;

    public Usuario(long id,String nome, String sobrenome, String email,
                   String senha, String dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
    }

    private Usuario(Parcel p){
        this.setId(p.readLong());
        this.setNome(p.readString());
        this.setSobrenome(p.readString());
        this.setEmail(p.readString());
        this.setSenha(p.readString());
        this.setDataNascimento(p.readString());
    }

    public static final Parcelable.Creator<Usuario>
            CREATOR = new Parcelable.Creator<Usuario>(){
        public Usuario createFromParcel(Parcel in) {

            return new Usuario(in);
        }

        @Override
        public Usuario[] newArray(int size) {
            return new Usuario[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.getId());
        parcel.writeString(this.getNome());
        parcel.writeString(this.getSobrenome());
        parcel.writeString(this.getEmail());
        parcel.writeString(this.getSenha());
        parcel.writeString(this.getDataNascimento());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", dataNascimento=" + dataNascimento +
                '}';
    }
}
