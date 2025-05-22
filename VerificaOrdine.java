import javax.swing.*;
import java.awt.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class VerificaOrdine extends JFrame {
    JTextArea lista = new JTextArea();

    List<String> righe = new ArrayList<>();
    List<String> ordini = new ArrayList<>();
    int flag=0;


    VerificaOrdine()
    {
        try {
            righe= Files.readAllLines(Paths.get("nomeaccesso.txt"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
        ordini= Files.readAllLines(Paths.get("nomeaccesso.txt"));
    } catch (Exception e) {
        e.printStackTrace();
    }

        setTitle("Lista Ordini Utente");
        this.setLayout(new GridBagLayout());
        GridBagConstraints b = new GridBagConstraints();
        if(ordini.contains(righe.get(0)))
        {
            for(int i=0;i<ordini.size();i++)
            {
                if(ordini.equals(righe.get(0)))
                {
                    lista.append("Ordine trovato: \nNumero traccimento: "+ordini.get(i-1)+"\nNome utente: "+ordini.get(i)+"\nIndrizzo di spedizione: :"+ordini.get(i+1)+"\nComune di spedizione: :"+ordini.get(i+2)+"\nTotale ordine: :"+ordini.get(i+3)+"\nStato ordine: CONFERMATO");

                    i=100;
                    flag=1;
                }
            }

            if(flag==0)
            {
                lista.append("Nessun ordine effettuato da questo account");
            }

            b.gridx=0;
            b.gridy=0;
            add(lista,b);

            setSize(300,500);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            pack();
            setVisible(true);

        }

    }
}
