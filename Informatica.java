import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class Informatica extends JFrame {
    String[] informatica = new String[]{"Smartphone IOS","Smartphone Android","Accessori"};

    String[][] tutti= {
            {"IPhone 16","IPhone 15","IPhone 14","IPhone 13"},
            {"Samsung S25","Samsung S24","Samsung S23"},
            {"Mouse","Tastiera","Caricatore USB-C","Caricaotre Lightning","Cuffiette"}
    };

    int[][] prezzi = {
            {1100, 900, 700, 550},
            {1200, 900, 650},
            {30, 40, 10, 10, 25}
    };

    String[][] descrizioni = {
            {"CPU Apple A18 6 core, ROM 128/256/512 GB", "CPU Apple A16 6 core, ROM 128/256/512 GB", "CPU Apple A15 6 core, ROM 128/256/512 GB", "CPU Apple A15 6 core, ROM 128/256/512 GB"},
            {"CPU Snapdragon 8 ELITE, ROM 128/256/512 GB", "CPU Snapdragon 8, ROM 128/256/512 GB", "CPU Snapdragon 7, ROM 128/256/512 GB"},
            {"Mouse per pc con attacco USB", "Tastiera per pc con attacco USB", "Caricatore per smartphone USB-C", "Caricatore per smartphone lightning", "Cuffiette auricolari semplici"}
    };

    JButton agg= new JButton("AGGIUNGI AL CARRELLO");
    JButton vis= new JButton("VISUALIZZA CARRELLO");
    JButton tornaMenu=new JButton("CAMBIA CATEGORIA");
    JButton logOut=new JButton("LOGOUT");
    List<String> righe = new ArrayList<>();

    JComboBox<String> abb = new JComboBox<>(informatica);
    int prezzo=0;

    public Informatica(ArrayList<String> carrello,ArrayList<Integer> conto)
    {
        try {
            righe= Files.readAllLines(Paths.get("listadonna.txt"));
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
        agg.setBounds(20, 210, 200, 30);
        vis.setBounds(270, 210, 200, 30);
        tornaMenu.setBounds(20, 270, 200, 30);
        logOut.setBounds(270, 270, 200, 30);
        add(agg);
        add(vis);
        add(tornaMenu);
        add(logOut);



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

        listaProdotti.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int catIndex = abb.getSelectedIndex();
                int prodIndex = listaProdotti.getSelectedIndex();

                if (catIndex >= 0 && prodIndex >= 0) {
                    String nome = tutti[catIndex][prodIndex];
                    int prezzo = prezzi[catIndex][prodIndex];
                    String descrizione = descrizioni[catIndex][prodIndex];

                    dettagli.setText("Prodotto: " + nome + "\nPrezzo: €" + prezzo + "\nDescrizione: " + descrizione);

                    for (ActionListener al : agg.getActionListeners()) {
                        agg.removeActionListener(al);
                    }

                    agg.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            carrello.add(nome);
                            conto.add(prezzo);
                            JOptionPane.showMessageDialog(null, nome + " aggiunto al carrello!");
                        }
                    });
                }
            }
        });


        vis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton premuto=(JButton)e.getSource();
                if(premuto==vis)
                {
                    int tot=0;
                    JFrame finestraCarrello = new JFrame("Carrello");
                    finestraCarrello.setSize(400, 300);
                    finestraCarrello.setLayout(new BorderLayout());
                    JButton t=new JButton("Torna alla zona acquisti");
                    JButton termina=new JButton("CONCLUDI ORDINE");
                    JTextArea car = new JTextArea();
                    StringBuilder contenuto = new StringBuilder("PRODOTTI NEL CARRELLO:\n\n");
                    contenuto.append("- ").append(carrello).append("\n");
                    for(Integer c:conto)
                    {
                        tot=tot+c;
                    }
                    contenuto.append("\nTOTALE: €").append(tot);



                    car.setText(contenuto.toString());
                    finestraCarrello.add(termina,BorderLayout.NORTH);
                    finestraCarrello.add(new JScrollPane(car), BorderLayout.CENTER);
                    finestraCarrello.setVisible(true);

                    termina.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JButton prem= (JButton)e.getSource();
                            if(prem==termina)
                            {
                                dispose();
                                new GestioneOrdine(carrello,conto);
                            }
                        }
                    });

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
                    new Menu();
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
