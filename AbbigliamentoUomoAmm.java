import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Files;
import java.nio.file.Paths;
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
    public AbbigliamentoUomoAmm() {
            try {
                righe= Files.readAllLines(Paths.get("testo.txt"));
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
                    elimina.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JButton premuto=(JButton)e.getSource();
                            if(premuto==elimina)
                            {
                                dettagli.setText("prodotto non dispobile");
                                for(int i=0;i< righe.size();i++)
                                {
                                    if(righe.get(i).equals(prodotto))
                                    {
                                        righe.remove(i);
                                    }

                                }
                            }
                        }
                    });
                } else if (prodotto.equals("Felpa rossa")) {
                    prezzo = 45;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:" + prezzo + "\nDescrizione: felpa tinta unica con cappuccio");
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
                }else if (prodotto.equals("Felpa cappuccio")) {
                    prezzo = 30;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:" + prezzo + "\nDescrizione: felpa con stampa e cappuccio");
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
                }else if (prodotto.equals("Maglione lana")) {
                    prezzo = 55;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:" + prezzo + "\nDescrizione: Maglione lana pura");
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
                }else if (prodotto.equals("Maglione con papera")) {
                    prezzo = 45;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:" + prezzo + "\nDescrizione: Maglione colorato con ricamo");
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
                }else if (prodotto.equals("Maglia bianca")) {
                    prezzo = 30;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:" + prezzo + "\nDescrizione: maglia tinta unita");
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
                }else if (prodotto.equals("Maglia adidas")) {
                    prezzo = 25;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:" + prezzo + "\nDescrizione: T-shirt adidas con logo sul retro");
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
                }else if (prodotto.equals("Jeans skinny")) {
                    prezzo = 45;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:" + prezzo + "\nDescrizione: Jeans versione stretta");
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
                }else if (prodotto.equals("Jeans bianchi")) {
                    prezzo = 45;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:" + prezzo + "\nDescrizione: Jenas bianchi a palazzo");
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

                }
            }
        });


        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700,350);
        setVisible(true);
    }}
