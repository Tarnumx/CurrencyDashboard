import org.swixml.SwingEngine;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class CurrencyController {

    JPanel preview;
    JTable curTable;

    CurrencyTable ct = new CurrencyTable();

    public JLabel currency;

    public JRadioButton usd;
    public JRadioButton eur;
    public JRadioButton gbp;

    public Action view = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {

            preview.remove(curTable);

            if (usd.isSelected()) {

                curTable = ct.initCurrency(usd);
                preview.add(curTable);
                preview.updateUI();

            }
            if (eur.isSelected()) {

                currency.setText("EURO = 70.11");
            }
            if (gbp.isSelected()) {

                currency.setText("GBP = 100.11");
            }
        }
    };

    private CurrencyController() throws Exception {

        new SwingEngine(this).render("currency_main_page.xml").setVisible(true);

    }

    public static void main(String[] args) throws Exception {
        new CurrencyController();

    }


}
