package model;

import java.sql.Date;

public class Vagas {
    private int idVaga;
    private String cargo;
    private String funcao;
    private String requisitos;
    private String requisitos_desejaveis;
    private String observacao;
    private Date dataIni;
    private Date dataFim;
    private int IdEmpresa;
    private String NomeEmpresa;
    public Vagas() {
    }

    public Vagas(int idVaga, String cargo, String funcao, String requisitos, String requisitosDesej, String obs, Date dataIni, Date dataFim, int IdEmpresa, String nomeEmpresa) {
        this.idVaga = idVaga;
        this.cargo = cargo;
        this.funcao = funcao;
        this.requisitos = requisitos;
        this.requisitos_desejaveis = requisitosDesej;
        this.dataFim = dataFim;
        this.dataIni = dataIni;
        this.IdEmpresa = IdEmpresa;
        this.observacao = obs;
        this.NomeEmpresa = nomeEmpresa;
    }

    public int getIdVaga() {
        return idVaga;
    }

    public void setIdVaga(int idVaga) {
        this.idVaga = idVaga;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }

    public String getRequisitos_desejaveis() {
        return requisitos_desejaveis;
    }

    public void setRequisitos_desejaveis(String requisitos_desejaveis) {
        this.requisitos_desejaveis = requisitos_desejaveis;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Date getDataIni() {
        return dataIni;
    }

    public void setDataIni(Date dataIni) {
        this.dataIni = dataIni;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public int getIdEmpresa() {
        return IdEmpresa;
    }

    public void setIdEmpresa(int IdEmpresa) {
        this.IdEmpresa = IdEmpresa;
    }

    public String getNomeEmpresa() {
        return NomeEmpresa;
    }

    public void setNomeEmpresa(String NomeEmpresa) {
        this.NomeEmpresa = NomeEmpresa;
    }
}
