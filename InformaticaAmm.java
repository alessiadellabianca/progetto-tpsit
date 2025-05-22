import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class InformaticaAmm extends JFrame {
    String[] informatica = new String[]{"Smartphone IOS","Smartphone Android","Accessori"};

    String[][] tutti= {
            {"IPhone 16","IPhone 15","IPhone 14","IPhone 13"},
            {"Samsung S25","Samsung S24","Samsung S23"},
            {"Mouse","Tastiera","Caricatore USB-C","Caricaotre Lightning","Cuffiette"}
    };

    JButton elimina=new JButton("RENDI NON DISPONIBILE");
    JButton tornaMenu=new JButton("CAMBIA CATEGORIA");
    JButton logOut=new JButton("LOGOUT");
    List<String> righe = new ArrayList<>();

    JComboBox<String> abb = new JComboBox<>(informatica);
    int prezzo=0;

    public InformaticaAmm()
    {
        try {
            righe= Files.readAllLines(Paths.get("informatica.txt"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        setTitle("Catalogo elettronica e informatica");
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
                int i= abb.getSelectedIndex();
                listaProdotti.setListData(tutti[i]);
                dettagli.setText("");

            }
        });

        listaProdotti.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {

                String prodotto = listaProdotti.getSelectedValue();
                if (prodotto.equals("IPhone 16")) {
                    if (righe.contains(prodotto)) {
                        prezzo = 1100;
                        dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: €" + prezzo + "\nDescrizione: CPU Apple A18 6 core, ROM 128/256/512 GB");
                    } else {
                        dettagli.setText("Prodotto attualmente non disponibile");
                    }
                }
                else if(prodotto.equals("IPhone 15"))
                {
                    if(righe.contains(prodotto)) {
                        prezzo=900;
                        dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:"+prezzo+"\nDescrizione: CPU Apple A16 6 core, ROM 128/256/512 GB");
                    }else {
                        dettagli.setText("Prodotto attualmente non disponibile");
                    }

                }
                else if(prodotto.equals("IPhone 14"))
                {
                    if(righe.contains(prodotto)) {
                        prezzo=700;
                        dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:"+prezzo+"\nDescrizione: CPU Apple A15 6 core, ROM 128/256/512 GB");
                    }else {
                        dettagli.setText("Prodotto attualmente non disponibile");
                    }
                }
                else if(prodotto.equals("IPhone 13"))
                {
                    if(righe.contains(prodotto))
                    {
                        prezzo=550;
                        dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:"+prezzo+"\nDescrizione: CPU Apple A15 6 core, ROM 128/256/512 GB");
                    }
                    else
                    {
                        dettagli.setText("Prodotto attualmente non disponibile");
                    }
                } else if(prodotto.equals("Samsung S25"))
                {
                    if(righe.contains(prodotto))
                    {
                        prezzo=1200;
                        dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:"+prezzo+"\nDescrizione: CPU Snapdragon 8 ELITE, ROM 128/256/512 GB");
                    }
                    else
                    {
                        dettagli.setText("Prodotto attualmente non disponibile");
                    }
                } else if(prodotto.equals("Samsung S24"))
                {
                    if(righe.contains(prodotto))
                    {
                        prezzo=900;
                        dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:"+prezzo+"\nDescrizione: CPU Snapdragon 8, ROM 128/256/512 GB");

                    }
                    else
                    {
                        dettagli.setText("Prodotto attualmente non disponibile");
                    }

                }else if(prodotto.equals("Samsung S23"))
                {
                    if(righe.contains(prodotto))
                    {
                        prezzo=650;
                        dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:"+prezzo+"\nDescrizione: CPU Snapdragon 7, ROM 128/256/512 GB");
                    }
                    else
                    {
                        dettagli.setText("Prodotto attualmente non disponibile");
                    }
                }else if(prodotto.equals("Mouse"))
                {
                    if(righe.contains(prodotto))
                    {
                        prezzo=30;
                        dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: €"+prezzo+"\nDescrizione: Mouse per pc con attacco USB");
                    }
                    else
                    {
                        dettagli.setText("Prodotto attualmente non disponibile");
                    }

                }else if(prodotto.equals("Tastiera"))
                {
                    if(righe.contains(prodotto))
                    {
                        prezzo=40;
                        dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: €"+prezzo+"\nDescrizione: Tastiera per pc con attacco USB");
                    }
                    else
                    {
                        dettagli.setText("Prodotto attualmente non disponibile");
                    }
                }else if(prodotto.equals("Caricatore USB-C"))
                {
                    if(righe.contains(prodotto))
                    {
                        prezzo=10;
                        dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: €"+prezzo+"\nDescrizione: Caricatore per smartphone USB-C");
                    }
                    else
                    {
                        dettagli.setText("Prodotto attualmente non disponibile");
                    }
                }else if(prodotto.equals("Caricatore Lightning"))
                {
                    if(righe.contains(prodotto))
                    {
                        prezzo=10;
                        dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: €"+prezzo+"\nDescrizione: Caricatore per smartphone lightning");
                    }
                    else
                    {
                        dettagli.setText("Prodotto attualmente non disponibile");
                    }
                }else if(prodotto.equals("Cuffiette"))
                {
                    if(righe.contains(prodotto))
                    {
                        prezzo=25;
                        dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: €"+prezzo+"\nDescrizione: Cuffiette auricolari semplici");
                    }
                    else
                    {
                        dettagli.setText("Prodotto attualmente non disponibile");
                    }
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

        tornaMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton c=(JButton)e.getSource();
                if(tornaMenu==c)
                {
                    dispose();
                    new Menuamm();
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

        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700,350);
        setVisible(true);

    }


}
