package model;

public class Empresa {
    private int idEmpresa;
    private String nome;
    private String razao;
    private String cnpj;
    private String email;
    private String cidade;
    private String uf;
    
    public Empresa() {
    }

    public Empresa(int idEmpresa, String nome, String razao, String cnpj, String email, String cidade, String uf) {
        this.idEmpresa = idEmpresa;
        this.nome = nome;
        this.razao = razao;
        this.cnpj = cnpj;
        this.email = email;
        this.cidade = cidade;
        this.uf = uf;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRazao() {
        return razao;
    }

    public void setRazao(String razao) {
        this.razao = razao;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }    
    
    @Override
    public String toString() {
        return this.idEmpresa + " - " + this.getNome();
    } 
}
