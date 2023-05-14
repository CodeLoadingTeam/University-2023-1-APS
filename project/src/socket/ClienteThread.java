package socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClienteThread extends Thread {

    private Socket socket;
    private Tela tela;

    public ClienteThread(Tela tela) {

        this.tela   = tela;
        this.socket = tela.socket;
    }

    @Override
    public void run() {

        try {
            InputStreamReader inputReader = new InputStreamReader(socket.getInputStream());
            BufferedReader reader = new BufferedReader(inputReader);
            String novaMensagemServidor;
            String mensagemAntiga;

            while ((novaMensagemServidor = reader.readLine()) != null) {
                
                mensagemAntiga = tela.chat.getText();
                tela.chat.setText(
                    mensagemAntiga + '\n' + novaMensagemServidor
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}