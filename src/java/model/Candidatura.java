package model;

import java.util.Date;

public class Candidatura {
    private int idCandidatura;
    private int idVaga;
    private int idUsuario;
    private Date dataCandidatura;
    
    public Candidatura() {
    }

    public Candidatura(int idCandidatura, int idVaga, int idUsuario, Date dataCandidatura) {
        this.idCandidatura = idCandidatura;
        this.idVaga = idVaga;
        this.idUsuario = idUsuario;
        this.dataCandidatura = dataCandidatura;
    }

    public int getIdCandidatura() {
        return idCandidatura;
    }

    public void setIdCandidatura(int idCandidatura) {
        this.idCandidatura = idCandidatura;
    }

    public int getIdVaga() {
        return idVaga;
    }

    public void setIdVaga(int idVaga) {
        this.idVaga = idVaga;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Date getDataCandidatura() {
        return dataCandidatura;
    }

    public void setDataCandidatura(Date dataCandidatura) {
        this.dataCandidatura = dataCandidatura;
    }
}
