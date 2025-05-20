import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class AbbigliamentoUomoAmm extends JFrame{

    String[] abbigliamentoUomo = new String[]{"Felpe","Maglioni","T-Shirt","Jeans"};
    String[][] tutti= {
            {"Felpa nera","Felpa rossa","Felpa cappuccio"},
            {"Maglione lana","Maglione con papera"},
            {"Maglia bianca","Maglia adidas"},
            {"Jeans skinny","Jeans bianchi"},
    };
    JButton elimina=new JButton("RENDI NON DISPONIBILE");
    JButton tornaMenu=new JButton("CAMBIA CATEGORIA");
    List<String> righe = new ArrayList<>();
    JButton logOut=new JButton("LOGOUT");

    public AbbigliamentoUomoAmm() {
            try {
                righe= Files.readAllLines(Paths.get("listauomo.txt"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        JComboBox<String> abb = new JComboBox<>(abbigliamentoUomo);
        setTitle("Catalogo abbigliamento uomo");
        abb.setBounds(20, 20, 150, 25);
        add(abb);
        JList<String> listaProdotti = new JList<>();
        listaProdotti.setBounds(20, 60, 150, 100);
        add(listaProdotti);
        JTextArea dettagli = new JTextArea();
        dettagli.setBounds(200, 20, 450, 140);
        add(dettagli);
        tornaMenu.setBounds(20, 210, 200, 30);
        elimina.setBounds(270, 210, 200, 30);
        logOut.setBounds(100, 270, 200, 30);
        add(logOut);
        add(elimina);
        add(tornaMenu);

        abb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = abb.getSelectedIndex();
                listaProdotti.setListData(tutti[i]);
                dettagli.setText("");

            }
        });

        listaProdotti.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int prezzo;
                String prodotto = listaProdotti.getSelectedValue();
                if (prodotto.equals("Felpa nera")) {
                    prezzo = 50;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:" + prezzo + "\nDescrizione: felpa tinta unica con cappuccio");

                } else if (prodotto.equals("Felpa rossa")) {
                    prezzo = 45;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:" + prezzo + "\nDescrizione: felpa tinta unica con cappuccio");

                }else if (prodotto.equals("Felpa cappuccio")) {
                    prezzo = 30;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:" + prezzo + "\nDescrizione: felpa con stampa e cappuccio");


                }else if (prodotto.equals("Maglione lana")) {
                    prezzo = 55;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:" + prezzo + "\nDescrizione: Maglione lana pura");

                }else if (prodotto.equals("Maglione con papera")) {
                    prezzo = 45;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:" + prezzo + "\nDescrizione: Maglione colorato con ricamo");

                }else if (prodotto.equals("Maglia bianca")) {
                    prezzo = 30;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:" + prezzo + "\nDescrizione: maglia tinta unita");

                }else if (prodotto.equals("Maglia adidas")) {
                    prezzo = 25;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:" + prezzo + "\nDescrizione: T-shirt adidas con logo sul retro");

                }else if (prodotto.equals("Jeans skinny")) {
                    prezzo = 45;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:" + prezzo + "\nDescrizione: Jeans versione stretta");

                }else if (prodotto.equals("Jeans bianchi")) {
                    prezzo = 45;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:" + prezzo + "\nDescrizione: Jenas bianchi a palazzo");

                }
            }
        });


        elimina.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String prodotto = listaProdotti.getSelectedValue();
                if (prodotto != null && righe.contains(prodotto)) {
                    righe.remove(prodotto);
                    dettagli.setText("Prodotto non disponibile");

                    try {
                        StringBuilder sb = new StringBuilder();
                        for (String riga : righe) {
                            sb.append(riga).append("\n");
                        }
                        Files.writeString(Paths.get("listauomo.txt"), sb.toString(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Errore durante la scrittura sul file");
                        ex.printStackTrace();
                    }
                }
            }
        });


        logOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton c=(JButton)e.getSource();
                if(logOut==c)
                {
                    dispose();
                    new Login();
                }
            }
        });

        tornaMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton c=(JButton)e.getSource();
                if(tornaMenu==c)
                {

                }
            }
        });

        tornaMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Menuamm();
            }
        });


        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700,350);
        setVisible(true);
    }}
