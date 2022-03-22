package model;

import java.sql.Date;

public class UsuarioDetalhes {
    private int idUsuarioDetalhes;
    private int idUsuario;
    private String email;
    private String nome;
    private String sexo;
    private Date dataNascimento;
    private String curriculoResumido;
    private byte[] foto;
    private String formatoFoto;
    public UsuarioDetalhes() {
    }

    public UsuarioDetalhes(int idUsuarioDetalhes, int idUsuario, String email, String nome, String sexo, Date dataNascimento, String curriculoResumido, byte[] foto, String formatoFoto) {
        this.idUsuarioDetalhes = idUsuarioDetalhes;
        this.idUsuario = idUsuario;
        this.email = email;
        this.nome = nome;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.curriculoResumido = curriculoResumido;
        this.foto = foto;
        this.formatoFoto = formatoFoto;
    }

    public int getIdUsuarioDetalhes() {
        return idUsuarioDetalhes;
    }

    public void setIdUsuarioDetalhes(int idUsuarioDetalhes) {
        this.idUsuarioDetalhes = idUsuarioDetalhes;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCurriculoResumido() {
        return curriculoResumido;
    }

    public void setCurriculoResumido(String curriculoResumido) {
        this.curriculoResumido = curriculoResumido;
    }
    
    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getFormatoFoto() {
        return formatoFoto;
    }

    public void setFormatoFoto(String formatoFoto) {
        this.formatoFoto = formatoFoto;
    } 
}
