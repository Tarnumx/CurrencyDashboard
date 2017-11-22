import javafx.scene.control.RadioButton;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class CurrencyTable {

    public JTable curTable;

    public Object[] columns = {"Date", "Price"};
    public Object[][] data = {
            {"Date", "Price"},
            {"12.11", "60"},
            {"13.11", "61"},
            {"14.11", "61"},
            {"15.11", "62"},
            {"16.11", "60"}
    };

    public CurrencyTable() {}



    public JTable initCurrency(JRadioButton radioButton) {

        if (radioButton.getText().equals("US Dollars")) {
            this.curTable = new JTable(data, columns);


        }
        if (radioButton.getText().equals("US Dollars")) {
            this.curTable = new JTable(data, columns);

        }
        if (radioButton.getText().equals("US Dollars")) {
            this.curTable = new JTable(data, columns);

        }

        return curTable;
    }
}
