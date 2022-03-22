package controller;

import dao.UsuarioDAO;
import model.Usuario;

public class UsuarioController {
    
    public int create (Usuario user){
        return new UsuarioDAO().createUsuario(user);
    }
    
    public int login (Usuario user) {
        return new UsuarioDAO().login(user);
    }
    
    public int update (Usuario user) {
        return new UsuarioDAO().update(user);
    }
}
