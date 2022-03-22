package model;

public class Usuario {
    private int usuario_id;
    private String usuario_login;
    private String usuario_senha;
    private String usuario_email;
    private int usuario_perfil;

    public Usuario() {
    }

    public Usuario(int usuario_id, String usuario_login, String usuario_senha, String usuario_email, int usuario_perfil) {
        this.usuario_id = usuario_id;
        this.usuario_login = usuario_login;
        this.usuario_senha = usuario_senha;
        this.usuario_email = usuario_email;
        this.usuario_perfil = usuario_perfil; //Perfil candidato
    }

    public int getUsuario_perfil() {
        return usuario_perfil;
    }

    public void setUsuario_perfil(int usuario_perfil) {
        this.usuario_perfil = usuario_perfil;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getUsuario_login() {
        return usuario_login;
    }

    public void setUsuario_login(String usuario_login) {
        this.usuario_login = usuario_login;
    }

    public String getUsuario_senha() {
        return usuario_senha;
    }

    public void setUsuario_senha(String usuario_senha) {
        this.usuario_senha = usuario_senha;
    }

    public String getUsuario_email() {
        return usuario_email;
    }

    public void setUsuario_email(String usuario_email) {
        this.usuario_email = usuario_email;
    }
}