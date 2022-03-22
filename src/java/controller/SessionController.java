package controller;

import model.Usuario;

public class SessionController {
    public SessionController() {
    
    }
    
    private static Usuario current_user = null;
    
    public static Usuario getCurrent_user() {
        return current_user;
    }

    public static void setCurrent_user(Usuario current_user) {
        SessionController.current_user = current_user;
    }    
}
