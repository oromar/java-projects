package br.com.qualiti.delivery.main;

import br.com.qualiti.delivery.negocio.Fachada;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.qualiti.delivery.util.Util;
import br.com.qualiti.delivery.view.Principal;
import br.com.qualiti.delivery.view.Splash;

public class Main {

    public static void main(String[] args) {
        try {
            Util.log("Inicializando aplicação", Util.LOG_TYPE_INFO);
            new Thread() {

                public void run() {
                    try {
                        Fachada.getInstancia().buscarTodosClientes();
                    } catch (Exception ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }.start();

//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            Util.log("Iniciando tela Splash", Util.LOG_TYPE_INFO);
            Splash splash = new Splash(null, true);
            Util.log("Tela Splash exibida com sucesso", Util.LOG_TYPE_INFO);
            Principal tela = new Principal();
            tela.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
