import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class AbbigliamentoDonna extends JFrame {
    String[] abbigliamentoDonna = new String[]{"Felpe","Maglioni","T-Shirt","Jeans","Pantaloncini","Slip","Sport"};

    String[][] tutti= {
            {"Felpa nera","Felpa Bianca","Felpa con zip"},
            {"Maglione lana","Maglione con orso","Maglione lavorato"},
            {"Maglia bianca","Maglia nike","Maglia con stampa","Berretta"},
            {"Jeans skinny","Jeans a palazzo"},
            {"Shorts in Jeans","Shorts in lino"},
            {"Slip bianco","Slip nero"},
            {"Scarpe running"},
    };
    JButton agg= new JButton("AGGIUNGI AL CARRELLO");
    JButton vis= new JButton("VISUALIZZA CARRELLO");
    JButton tornaMenu=new JButton("CAMBIA CATEGORIA");
    List<String> righe = new ArrayList<>();

    JComboBox<String> abb = new JComboBox<>(abbigliamentoDonna);
    int prezzo=0;

    public AbbigliamentoDonna(ArrayList<String> carrello,ArrayList<Integer> conto)
    {
        try {
            righe= Files.readAllLines(Paths.get("listadonna.txt"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (String[] categoria : tutti) {
            for (String prodotto : categoria) {
                righe.add(prodotto);
            }
        }

        setTitle("Catalogo abbigliamento donna");
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
        tornaMenu.setBounds(100, 270, 200, 30);
        add(agg);
        add(vis);
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
                if (prodotto.equals("Felpa nera")) {
                    prezzo=50;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:" +prezzo+"\nDescrizione: felpa tinta unica con cappuccio");
                    agg.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JButton premuto=(JButton)e.getSource();
                            if(premuto==agg)
                            {
                                carrello.add(prodotto);
                                conto.add(prezzo);
                            }
                        }
                    });
                } else if(prodotto.equals("Felpa Bianca"))
                {
                    prezzo=45;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:"+prezzo+"\nDescrizione: felpa tinta unica con cappuccio");
                    agg.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JButton premuto=(JButton)e.getSource();
                            if(premuto==agg)
                            {
                                carrello.add(prodotto);
                                conto.add(prezzo);
                            }
                        }
                    });

                }  else if(prodotto.equals("Felpa con zip"))
                {

                    prezzo=30;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:+"+prezzo+"\nDescrizione: felpa tinta unica con zip, disponibile in altri colori");
                    agg.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JButton premuto=(JButton)e.getSource();
                            if(premuto==agg)
                            {
                                carrello.add(prodotto);
                                conto.add(prezzo);
                            }
                        }
                    });
                } else if(prodotto.equals("Maglione lana"))
                {

                    prezzo=65;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:"+prezzo+"\nDescrizione: maglione 100% in lana, caldo e confortevole");
                    agg.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JButton premuto=(JButton)e.getSource();
                            if(premuto==agg)
                            {
                                carrello.add(prodotto);
                                conto.add(prezzo);
                            }
                        }
                    });
                } else if(prodotto.equals("Maglione con orso"))
                {

                    prezzo=55;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:"+prezzo+"\nDescrizione: maglione con orso ricamato, colorato e lavorato a mano");
                    agg.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JButton premuto=(JButton)e.getSource();
                            if(premuto==agg)
                            {
                                carrello.add(prodotto);
                                conto.add(prezzo);
                            }
                        }
                    });
                } else if(prodotto.equals("Maglione lavorato"))
                {

                    prezzo=90;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:"+prezzo+"\nDescrizione: lavorato a mano da ditta tedesca");
                    agg.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JButton premuto=(JButton)e.getSource();
                            if(premuto==agg)
                            {
                                carrello.add(prodotto);
                                conto.add(prezzo);
                            }
                        }
                    });
                }else if(prodotto.equals("Maglia bianca"))
                {

                    prezzo=10;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:"+prezzo+"\nDescrizione: semplice maglia bianca in cotone morbido");
                    agg.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JButton premuto=(JButton)e.getSource();
                            if(premuto==agg)
                            {
                                carrello.add(prodotto);
                                conto.add(prezzo);
                            }
                        }
                    });
                }else if(prodotto.equals("Maglia nike"))
                {

                    prezzo=30;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: €30.00\nDescrizione: maglia marca 'nike' con stampa sul retro");
                    agg.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JButton premuto=(JButton)e.getSource();
                            if(premuto==agg)
                            {
                                carrello.add(prodotto);
                                conto.add(prezzo);
                            }
                        }
                    });
                }else if(prodotto.equals("Maglia con stampa"))
                {

                    prezzo=40;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: €40.00\nDescrizione: maglietta con stampa tramonto sul retro");
                    agg.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JButton premuto=(JButton)e.getSource();
                            if(premuto==agg)
                            {
                                carrello.add(prodotto);
                                conto.add(prezzo);
                            }
                        }
                    });
                }else if(prodotto.equals("Berretta"))
                {
                    prezzo=10;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: €10.00\nDescrizione: adatta per i senza capelli");
                    agg.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JButton premuto=(JButton)e.getSource();
                            if(premuto==agg)
                            {
                                carrello.add(prodotto);
                                conto.add(prezzo);
                            }
                        }
                    });
                }else if(prodotto.equals("Jeans skinny"))
                {

                    prezzo=50;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: €50.00\nDescrizione: jeans versione stretta su cosce e polpacci");
                    agg.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JButton premuto=(JButton)e.getSource();
                            if(premuto==agg)
                            {
                                carrello.add(prodotto);
                                conto.add(prezzo);
                            }
                        }
                    });
                }else if(prodotto.equals("Jeans a palazzo"))
                {

                    prezzo=75;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: €75.00\nDescrizione: semplice jeans largo sulle gambe");
                    agg.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JButton premuto=(JButton)e.getSource();
                            if(premuto==agg)
                            {
                                carrello.add(prodotto);
                                conto.add(prezzo);
                            }
                        }
                    });
                }else if(prodotto.equals("Shorts in jeans"))
                {

                    prezzo=25;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: €25.00\nDescrizione: jeans elastici a metà coscia");
                    agg.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JButton premuto=(JButton)e.getSource();
                            if(premuto==agg)
                            {
                                carrello.add(prodotto);
                                conto.add(prezzo);
                            }
                        }
                    });
                }else if(prodotto.equals("Shorts in lino"))
                {

                    prezzo=15;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: €15.00\nDescrizione: in lino puro morbido e fresco");
                    agg.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JButton premuto=(JButton)e.getSource();
                            if(premuto==agg)
                            {
                                carrello.add(prodotto);
                                conto.add(prezzo);
                            }
                        }
                    });
                }else if(prodotto.equals("Slip bianco"))
                {

                    prezzo=5;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: €5\nDescrizione: slip tinta unita");
                    agg.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JButton premuto=(JButton)e.getSource();
                            if(premuto==agg)
                            {
                                carrello.add(prodotto);
                                conto.add(prezzo);
                            }
                        }
                    });
                }else if(prodotto.equals("Slip nero"))
                {

                    prezzo=5;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: €5\nDescrizione: slip tinta unita");
                    agg.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JButton premuto=(JButton)e.getSource();
                            if(premuto==agg)
                            {
                                carrello.add(prodotto);
                                conto.add(prezzo);
                            }
                        }
                    });
                }else if(prodotto.equals("Scarpe running"))
                {

                    prezzo=110;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: €110.00\nDescrizione: scarpe adatte per la corsa");
                    agg.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JButton premuto=(JButton)e.getSource();
                            if(premuto==agg)
                            {
                                carrello.add(prodotto);
                                conto.add(prezzo);
                            }
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
                    JTextArea car = new JTextArea();
                    StringBuilder contenuto = new StringBuilder("PRODOTTI NEL CARRELLO:\n\n");
                    contenuto.append("- ").append(carrello).append("\n");
                    for(Integer c:conto)
                    {
                        tot=tot+c;
                    }
                    contenuto.append("\nTOTALE: €").append(tot);



                    car.setText(contenuto.toString());
                    finestraCarrello.add(new JScrollPane(car), BorderLayout.CENTER);
                    finestraCarrello.setVisible(true);

                }
            }
        });

        tornaMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton c=(JButton)e.getSource();
                if(tornaMenu==c)
                {
                    new Menu();
                }
            }
        });

        try {
            StringBuilder sb = new StringBuilder();
            for (String riga : righe) {
                sb.append(riga).append("\n");
            }

            Files.writeString(Paths.get("listadonna.txt"), sb.toString(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            dispose();
            new Login();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Errore durante la scrittura sul file");
            ex.printStackTrace();
        }
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700,350);
        setVisible(true);

    }


}
