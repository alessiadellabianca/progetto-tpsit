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

    String[][] descrizioni = {
            {"felpa tinta unica con cappuccio", "felpa tinta unica con cappuccio", "felpa tinta unica con zip, disponibile in altri colori"},
            {"maglione 100% in lana, caldo e confortevole", "maglione con orso ricamato, colorato e lavorato a mano", "lavorato a mano da ditta tedesca"},
            {"semplice maglia bianca in cotone morbido", "maglia marca 'nike' con stampa sul retro", "maglietta con stampa tramonto sul retro", "adatta per i senza capelli"},
            {"jeans versione stretta su cosce e polpacci", "semplice jeans largo sulle gambe"},
            {"jeans elastici a metà coscia", "in lino puro morbido e fresco"},
            {"slip tinta unita", "slip tinta unita"},
            {"scarpe adatte per la corsa"}
    };

    int[][] prezzi = {
            {50, 45, 30},
            {65, 55, 90},
            {10, 30, 40, 10},
            {50, 75},
            {25, 15},
            {5, 5},
            {110}
    };
    JButton agg= new JButton("AGGIUNGI AL CARRELLO");
    JButton vis= new JButton("VISUALIZZA CARRELLO");
    JButton tornaMenu=new JButton("CAMBIA CATEGORIA");
    JButton logOut=new JButton("LOGOUT");
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
                if (prodotto.equals("Felpa nera")) {
                    if (righe.contains(prodotto)) {
                        prezzo = 50;
                        dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: €" + prezzo + "\nDescrizione: felpa tinta unica con cappuccio");
                    } else {
                        dettagli.setText("Prodotto attualmente non disponibile");
                    }


                } else if(prodotto.equals("Felpa Bianca"))
                {
                    if(righe.contains(prodotto))
                {
                    prezzo=45;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:"+prezzo+"\nDescrizione: felpa tinta unica con cappuccio");
                }else
                    {
                        dettagli.setText("Prodotto attualmente non disponibile");
                    }

                }  else if(prodotto.equals("Felpa con zip"))
                {

                    prezzo=30;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:+"+prezzo+"\nDescrizione: felpa tinta unica con zip, disponibile in altri colori");
                } else if(prodotto.equals("Maglione lana"))
                {
                    if(righe.contains(prodotto))
                    {
                        prezzo=65;
                        dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:"+prezzo+"\nDescrizione: maglione 100% in lana, caldo e confortevole");

                    }
                    else
                    {
                        dettagli.setText("Prodotto attualmente non disponibile");
                    }
                } else if(prodotto.equals("Maglione con orso"))
                {
                    if(righe.contains(prodotto))
                    {
                        prezzo=55;
                        dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:"+prezzo+"\nDescrizione: maglione con orso ricamato, colorato e lavorato a mano");

                    }
                  else
                    {
                        dettagli.setText("Prodotto attualmente non disponibile");
                    }
                } else if(prodotto.equals("Maglione lavorato"))
                {
                    if(righe.contains(prodotto))
                    {
                        prezzo=90;
                        dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:"+prezzo+"\nDescrizione: lavorato a mano da ditta tedesca");

                    }
                    else
                    {
                        dettagli.setText("Prodotto attualmente non disponibile");
                    }

               }else if(prodotto.equals("Maglia bianca"))
                {
                    if(righe.contains(prodotto))
                    {
                        prezzo=10;
                        dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:"+prezzo+"\nDescrizione: semplice maglia bianca in cotone morbido");
                    }
                        else
                    {
                        dettagli.setText("Prodotto attualmente non disponibile");
                    }
                }else if(prodotto.equals("Maglia nike"))
                {
                    if(righe.contains(prodotto))
                    {
                        prezzo=30;
                        dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: €30.00\nDescrizione: maglia marca 'nike' con stampa sul retro");
                    }
                    else
                    {
                        dettagli.setText("Prodotto attualmente non disponibile");
                    }

                }else if(prodotto.equals("Maglia con stampa"))
                {
                    if(righe.contains(prodotto))
                    {
                        prezzo=40;
                        dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: €40.00\nDescrizione: maglietta con stampa tramonto sul retro");
                    }
                    else
                    {
                        dettagli.setText("Prodotto attualmente non disponibile");
                    }
                }else if(prodotto.equals("Berretta"))
                {
                    if(righe.contains(prodotto))
                    {
                        prezzo=10;
                        dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: €10.00\nDescrizione: adatta per i senza capelli");
                    }
                    else
                    {
                        dettagli.setText("Prodotto attualmente non disponibile");
                    }
                }else if(prodotto.equals("Jeans skinny"))
                {
                    if(righe.contains(prodotto))
                    {
                        prezzo=50;
                        dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: €50.00\nDescrizione: jeans versione stretta su cosce e polpacci");
                    }
                    else
                    {
                        dettagli.setText("Prodotto attualmente non disponibile");
                    }
                    }else if(prodotto.equals("Jeans a palazzo"))
                {
                    if(righe.contains(prodotto))
                    {
                        prezzo=75;
                        dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: €75.00\nDescrizione: semplice jeans largo sulle gambe");
                    }
                    else
                    {
                        dettagli.setText("Prodotto attualmente non disponibile");
                    }
                       }else if(prodotto.equals("Shorts in jeans"))
                {
                    if(righe.contains(prodotto))
                    {
                        prezzo=25;
                        dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: €25.00\nDescrizione: jeans elastici a metà coscia");
                    }
                    else
                    {
                        dettagli.setText("Prodotto attualmente non disponibile");
                    }
                }else if(prodotto.equals("Shorts in lino"))
                {
                    if(righe.contains(prodotto))
                    {
                        prezzo=15;
                        dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: €15.00\nDescrizione: in lino puro morbido e fresco");
                    }
                    else
                    {
                        dettagli.setText("Prodotto attualmente non disponibile");
                    }
                  }else if(prodotto.equals("Slip bianco"))
                {
                    if(righe.contains(prodotto))
                    {
                        prezzo=5;
                        dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: €5\nDescrizione: slip tinta unita");
                    }
                    else
                    {
                        dettagli.setText("Prodotto attualmente non disponibile");
                    }

                }else if(prodotto.equals("Slip nero"))
                {
                    if(righe.contains(prodotto))
                    {
                        prezzo=5;
                        dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: €5\nDescrizione: slip tinta unita");
                    }
                    else
                    {
                        dettagli.setText("Prodotto attualmente non disponibile");
                    }
                      }else if(prodotto.equals("Scarpe running"))
                {

                    if(righe.contains(prodotto))
                    {
                        prezzo=110;
                        dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: €110.00\nDescrizione: scarpe adatte per la corsa");
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
