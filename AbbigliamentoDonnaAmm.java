import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AbbigliamentoDonnaAmm extends JFrame {

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
        JButton elimina=new JButton("RENDI NON DISPONIBILE");
        JButton tornaMenu=new JButton("CAMBIA CATEGORIA");

        JComboBox<String> abb = new JComboBox<>(abbigliamentoDonna);
        int prezzo=0;

        public AbbigliamentoDonnaAmm()
        {
            setTitle("Catalogo abbigliamento donna");
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
                    if (prodotto.equals("Felpa nera")) {
                        prezzo=50;
                        dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:" +prezzo+"\nDescrizione: felpa tinta unica con cappuccio");
                        elimina.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JButton premuto=(JButton)e.getSource();
                                if(premuto==elimina)
                                {
                                   dettagli.setText("prodotto non dispobile");
                                }
                            }
                        });
                    } else if(prodotto.equals("Felpa Bianca"))
                    {
                        prezzo=45;
                        dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:"+prezzo+"\nDescrizione: felpa tinta unica con cappuccio");
                        elimina.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JButton premuto=(JButton)e.getSource();
                                if(premuto==elimina)
                                {
                                    dettagli.setText("prodotto non dispobile");
                                }
                            }
                        });

                    }  else if(prodotto.equals("Felpa con zip"))
                    {
                        prezzo=30;
                        dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:+"+prezzo+"\nDescrizione: felpa tinta unica con zip, disponibile in altri colori");
                        elimina.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JButton premuto=(JButton)e.getSource();
                                if(premuto==elimina)
                                {
                                    dettagli.setText("prodotto non dispobile");
                                }
                            }
                        });

                    } else if(prodotto.equals("Maglione lana"))
                    {
                        prezzo=65;
                        dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:"+prezzo+"\nDescrizione: maglione 100% in lana, caldo e confortevole");
                        elimina.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JButton premuto=(JButton)e.getSource();
                                if(premuto==elimina)
                                {
                                    dettagli.setText("prodotto non dispobile");
                                }
                            }
                        });
                    } else if(prodotto.equals("Maglione con orso"))
                    {
                        prezzo=55;
                        dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:"+prezzo+"\nDescrizione: maglione con orso ricamato, colorato e lavorato a mano");
                        elimina.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JButton premuto=(JButton)e.getSource();
                                if(premuto==elimina)
                                {
                                    dettagli.setText("prodotto non dispobile");
                                }
                            }
                        });

                    } else if(prodotto.equals("Maglione lavorato"))
                    {
                        prezzo=90;
                        dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:"+prezzo+"\nDescrizione: lavorato a mano da ditta tedesca");
                        elimina.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JButton premuto=(JButton)e.getSource();
                                if(premuto==elimina)
                                {
                                    dettagli.setText("prodotto non dispobile");
                                }
                            }
                        });
                    }else if(prodotto.equals("Maglia bianca"))
                    {
                        prezzo=10;
                        dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:"+prezzo+"\nDescrizione: semplice maglia bianca in cotone morbido");
                        elimina.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JButton premuto=(JButton)e.getSource();
                                if(premuto==elimina)
                                {
                                    dettagli.setText("prodotto non dispobile");
                                }
                            }
                        });
                    }else if(prodotto.equals("Maglia nike"))
                    {
                        prezzo=30;
                        dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: €30.00\nDescrizione: maglia marca 'nike' con stampa sul retro");
                        elimina.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JButton premuto=(JButton)e.getSource();
                                if(premuto==elimina)
                                {
                                    dettagli.setText("prodotto non dispobile");
                                }
                            }
                        });

                    }else if(prodotto.equals("Maglia con stampa"))
                    {
                        prezzo=40;
                        dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: €40.00\nDescrizione: maglietta con stampa tramonto sul retro");
                        elimina.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JButton premuto=(JButton)e.getSource();
                                if(premuto==elimina)
                                {
                                    dettagli.setText("prodotto non dispobile");
                                }
                            }
                        });

                    }else if(prodotto.equals("Berretta"))
                    {
                        prezzo=10;
                        dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: €10.00\nDescrizione: adatta per i senza capelli");
                        elimina.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JButton premuto=(JButton)e.getSource();
                                if(premuto==elimina)
                                {
                                    dettagli.setText("prodotto non dispobile");
                                }
                            }
                        });

                    }else if(prodotto.equals("Jeans skinny"))
                    {
                        prezzo=50;
                        dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: €50.00\nDescrizione: jeans versione stretta su cosce e polpacci");
                        elimina.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JButton premuto=(JButton)e.getSource();
                                if(premuto==elimina)
                                {
                                    dettagli.setText("prodotto non dispobile");
                                }
                            }
                        });

                    }else if(prodotto.equals("Jeans a palazzo"))
                    {
                        prezzo=75;
                        dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: €75.00\nDescrizione: semplice jeans largo sulle gambe");
                        elimina.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JButton premuto=(JButton)e.getSource();
                                if(premuto==elimina)
                                {
                                    dettagli.setText("prodotto non dispobile");
                                }
                            }
                        });

                    }else if(prodotto.equals("Shorts in jeans"))
                    {
                        prezzo=25;
                        dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: €25.00\nDescrizione: jeans elastici a metà coscia");
                        elimina.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JButton premuto=(JButton)e.getSource();
                                if(premuto==elimina)
                                {
                                    dettagli.setText("prodotto non dispobile");

                                }
                            }
                        });

                    }else if(prodotto.equals("Shorts in lino"))
                    {
                        prezzo=15;
                        dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: €15.00\nDescrizione: in lino puro morbido e fresco");
                        elimina.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JButton premuto=(JButton)e.getSource();
                                if(premuto==elimina)
                                {
                                    dettagli.setText("prodotto non dispobile");
                                }
                            }
                        });

                    }else if(prodotto.equals("Slip bianco"))
                    {
                        prezzo=5;
                        dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: €5\nDescrizione: slip tinta unita");
                        elimina.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JButton premuto=(JButton)e.getSource();
                                if(premuto==elimina)
                                {
                                    dettagli.setText("prodotto non dispobile");
                                }
                            }
                        });

                    }else if(prodotto.equals("Slip nero"))
                    {
                        prezzo=5;
                        dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: €5\nDescrizione: slip tinta unita");
                        elimina.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JButton premuto=(JButton)e.getSource();
                                if(premuto==elimina)
                                {
                                    dettagli.setText("prodotto non dispobile");
                                }
                            }
                        });

                    }else if(prodotto.equals("Scarpe running"))
                    {
                        prezzo=110;
                        dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: €110.00\nDescrizione: scarpe adatte per la corsa");
                        elimina.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JButton premuto=(JButton)e.getSource();
                                if(premuto==elimina)
                                {
                                    dettagli.setText("prodotto non dispobile");
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
                       new AbbigliamentoUomoAmm();
                    }
                }
            });





            this.setLayout(new BorderLayout());
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            setSize(700,350);
            setVisible(true);

        }


    }

