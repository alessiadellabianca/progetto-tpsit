import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Libri extends JFrame {
    String[] libri = new String[]{"Fantasy","Fantascienza","Giallo","Narrativa","Romanzo Storico"};

    String[][] tutti= {
            {"Il trono di spade","Il signore degli anelli","Le cronache di Narnia","Harry Potter","Lo Hobbit"},
            {"Frankenstein","Dune","1984","Le cronache marziane"},
            {"Pioggia per i bastardi di Pizzofalcone","Dieci piccoli indiani","Il padrino","Hannibal"},
            {"Istella mea","La prima regina","Onesto","L'Anniversario","I sette corvi"},
            {"I promessi sposi","Ivanhoe","Guerra e pace","Il gattopardo","I tre moschettieri"}
    };
    int[][] prezzi = {
            {20, 25, 45, 50, 20},
            {15, 20, 20, 30},
            {10, 15, 20, 15},
            {15, 10, 10, 15, 15},
            {25, 20, 15, 15, 15}
    };

    String[][] descrizioni = {
            {"Romanzo fantasy scritto da George R. R. Martin", "Romanzo fantasy scritto da J. R. R. Tolkien",
                    "Serie di libri fantasy per ragazzi scritti da C.S. Lewis", "Serie di libri fantasy per ragazzi scritti da J.K. Rowling",
                    "Romanzo fantasy di J.R.R. Tolkien"},

            {"Romanzo fantascientifico di Mary Shelley", "Romanzo fantascientifico di Frank Herbert",
                    "Romanzo fantascientifico di George Orwell", "Raccolta di racconti di fantascienza di Ray Bradbury"},

            {"Romanzo giallo di Maurizio de Giovanni", "Romanzo giallo di Agatha Christie", "Romanzo giallo di Mario Puzo",
                    "Romanzo giallo di Thomas Harris"},

            {"Romanzo di narrativa di Ciriaco Offeddu", "Romanzo di narrativa di Alessandra Selmi", "Romanzo di narrativa di Francesco Vidotto",
                    "Romanzo di narrativa di Andrea Bajani", "Romanzo di narrativa di Matteo Strukul"},

            {"Romanzo storico di Alessandro Manzoni", "Romanzo storico di Walter Scott", "Romanzo storico di Lev Tolstoj",
                    "Romanzo storico di Giuseppe Tomasi di Lampedusa", "Romanzo storico di Alexandre Dumas"}
    };
    JButton agg= new JButton("AGGIUNGI AL CARRELLO");
    JButton vis= new JButton("VISUALIZZA CARRELLO");
    JButton tornaMenu=new JButton("CAMBIA CATEGORIA");
    JButton logOut=new JButton("LOGOUT");
    List<String> righe = new ArrayList<>();

    JComboBox<String> lib = new JComboBox<>(libri);
    int prezzo=0;

    public Libri(ArrayList<String> carrello, ArrayList<Integer> conto)
    {
        try {
            righe= Files.readAllLines(Paths.get("libri.txt"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        setTitle("Catalogo libri");
        lib.setBounds(20, 20, 150, 25);
        add(lib);
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



        lib.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i= lib.getSelectedIndex();
                listaProdotti.setListData(tutti[i]);
                dettagli.setText("");

            }
        });

        listaProdotti.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {

                String prodotto = listaProdotti.getSelectedValue();
                if (prodotto.equals("Il trono di spade")) {
                    if (righe.contains(prodotto)) {
                        prezzo = 20;
                        dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:" + prezzo + "\nDescrizione: Romanzo fantasy scritto da George R. R. Martin");
                    }
                    else {
                        dettagli.setText("Prodotto attualmente non disponibile");
                    }

                } else if(prodotto.equals("Il signore degli anelli"))
                {
                    if (righe.contains(prodotto)) {
                        prezzo = 25;
                        dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:" + prezzo + "\nDescrizione: Romanzo fantasy scritto da J. R. R. Tolkien");
                    }
                    else {
                        dettagli.setText("Prodotto attualmente non disponibile");
                    }
                }  else if(prodotto.equals("Le cronache di Narnia"))
                {
                    if (righe.contains(prodotto)) {
                        prezzo = 45;
                        dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:+" + prezzo + "\nDescrizione: Serie di libri fantasy per ragazzi scritti da C.S. Lewis");
                    }
                    else {
                        dettagli.setText("Prodotto attualmente non disponibile");
                    }
                } else if(prodotto.equals("Harry Potter"))
                {
                    if (righe.contains(prodotto)) {
                        prezzo = 50;
                        dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:" + prezzo + "\nDescrizione: Serie di libri fantasy per ragazzi scritti da J.K. Rowling");
                    }
                    else {
                        dettagli.setText("Prodotto attualmente non disponibile");
                    }
                } else if(prodotto.equals("Lo Hobbit"))
                {if (righe.contains(prodotto)) {
                    prezzo = 20;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:" + prezzo + "\nDescrizione: Romanzo fantasy di J.R.R. Tolkien");
                }
                else {
                    dettagli.setText("Prodotto attualmente non disponibile");
                }
                } else if(prodotto.equals("Frankenstein"))
                {
                    if (righe.contains(prodotto)) {
                        prezzo = 15;
                        dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:" + prezzo + "\nDescrizione: Romanzo fantascientifico di Mary Shelley");
                    }
                    else {
                        dettagli.setText("Prodotto attualmente non disponibile");
                    }
                }else if(prodotto.equals("Dune"))
                {
                    if (righe.contains(prodotto)) {
                        prezzo = 20;
                        dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:" + prezzo + "\nDescrizione: Romanzo fantascientifico di Frank Herbert");
                    }
                    else {
                        dettagli.setText("Prodotto attualmente non disponibile");
                    }
                }else if(prodotto.equals("1984"))
                {
                    if (righe.contains(prodotto)) {
                        prezzo = 20;
                        dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: " + prezzo + "\nDescrizione: Romanzo fantascientifico di George Orwell");
                    }
                    else {
                        dettagli.setText("Prodotto attualmente non disponibile");
                    }
                }else if(prodotto.equals("Le cronache marziane"))
                {
                    if (righe.contains(prodotto)) {
                        prezzo = 30;
                        dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: " + prezzo + "\nDescrizione: Raccolta di racconti di fantascienza di Ray Bradbury");
                    }else {
                        dettagli.setText("Prodotto attualmente non disponibile");
                    }
                }else if(prodotto.equals("Pioggia per i bastardi di Pizzofalcone"))
                {
                    if (righe.contains(prodotto)) {
                        prezzo = 10;
                        dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: " + prezzo + "\nDescrizione: Romanzo giallo di Maurizio de Giovanni");
                    }else {
                        dettagli.setText("Prodotto attualmente non disponibile");
                    }
                }else if(prodotto.equals("Dieci piccoli indiani"))
                {
                    if (righe.contains(prodotto)) {
                        prezzo = 15;
                        dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: " + prezzo + "\nDescrizione: Romanzo giallo di Agatha Christie");
                    }else {
                        dettagli.setText("Prodotto attualmente non disponibile");
                    }
                }else if(prodotto.equals("Il padrino"))
                {
                    if (righe.contains(prodotto)) {
                        prezzo = 20;
                        dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: " + prezzo + "\nDescrizione: Romanzo giallo di Mario Puzo");
                    }else {
                        dettagli.setText("Prodotto attualmente non disponibile");
                    }
                }else if(prodotto.equals("Hannibal"))
                {if (righe.contains(prodotto)) {
                    prezzo = 15;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: " + prezzo + "\nDescrizione: Romanzo giallo di Thomas Harris");
                }else {
                    dettagli.setText("Prodotto attualmente non disponibile");
                }
                }else if(prodotto.equals("Istella mea"))
                {
                    if (righe.contains(prodotto)) {
                        prezzo = 15;
                        dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: " + prezzo + "\nDescrizione: Romanzo di narrativa di Ciriaco Offeddu");
                    }else {
                        dettagli.setText("Prodotto attualmente non disponibile");
                    }
                }else if(prodotto.equals("La prima regina"))
                {
                    if (righe.contains(prodotto)) {
                        prezzo = 10;
                        dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: €" + prezzo + "\nDescrizione: Romanzo di narrativa di Alessandra Selmi");
                    }else {
                        dettagli.setText("Prodotto attualmente non disponibile");
                    }
                }else if(prodotto.equals("Onesto"))
                {
                    if (righe.contains(prodotto)) {
                        prezzo = 10;
                        dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: " + prezzo + "\nDescrizione: Romanzo di narrativa di Francesco Vidotto");
                    }else {
                        dettagli.setText("Prodotto attualmente non disponibile");
                    }
                }else if(prodotto.equals("L'Anniversario"))
                {
                    if (righe.contains(prodotto)) {
                        prezzo = 15;
                        dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: " + prezzo + "\nDescrizione: Romanzo di narrativa di Andrea Bajani");
                    }else {
                        dettagli.setText("Prodotto attualmente non disponibile");
                    }
                }else if(prodotto.equals("I sette corvi")) {
                    if (righe.contains(prodotto)) {
                        prezzo = 15;
                        dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: " + prezzo + "\nDescrizione: Romanzo di narrativa di Matteo Strukul");
                    }else {
                        dettagli.setText("Prodotto attualmente non disponibile");
                    }
                }else if(prodotto.equals("I promessi sposi")) {
                    if (righe.contains(prodotto)) {
                        prezzo = 25;
                        dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: " + prezzo + "\nDescrizione: Romanzo storico di Alessandro Manzoni");
                    }else {
                        dettagli.setText("Prodotto attualmente non disponibile");
                    }
                }else if(prodotto.equals("Ivanhoe")) {
                    if (righe.contains(prodotto)) {
                        prezzo = 20;
                        dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: " + prezzo + "\nDescrizione: Romanzo storico di Walter Scott");
                    }else {
                        dettagli.setText("Prodotto attualmente non disponibile");
                    }
                }else if(prodotto.equals("Guerra e pace")) {
                    if (righe.contains(prodotto)) {
                        prezzo = 15;
                        dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: " + prezzo + "\nDescrizione: Romanzo storico di Lev Tolstoj");
                    }else {
                        dettagli.setText("Prodotto attualmente non disponibile");
                    }
                }else if(prodotto.equals("Il gattopardo")) {
                    if (righe.contains(prodotto)) {
                        prezzo = 15;
                        dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: " + prezzo + "\nDescrizione: Romanzo storico di Giuseppe Tomasi di Lampedusa");
                    }else {
                        dettagli.setText("Prodotto attualmente non disponibile");
                    }
                }else if(prodotto.equals("I tre moschettieri")) {
                    if (righe.contains(prodotto)) {
                        prezzo = 15;
                        dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: " + prezzo + "\nDescrizione: Romanzo storico di Alexandre Dumas");
                    }else {
                        dettagli.setText("Prodotto attualmente non disponibile");
                    }
                }
            }
        });

        listaProdotti.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int catIndex = lib.getSelectedIndex();
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
