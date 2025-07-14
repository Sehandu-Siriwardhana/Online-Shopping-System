import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShopGUI implements ActionListener {
    JFrame frame;
    JTable table;
    JLabel label;
    JButton shoppingCart;
    JButton addToCart;
    JComboBox<String> productType;
    DefaultTableModel model;
    DefaultListModel<String> productInfo = new DefaultListModel<>();
    JScrollPane scrollPane;

    public ShopGUI() {
        frame = new JFrame("Westminster Shopping Manager");
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        shoppingCart = new JButton("Shopping Cart");
        shoppingCart.addActionListener(this);
        shoppingCart.setBounds(450, 5, 200, 50);
        frame.add(shoppingCart);

        label = new JLabel("Select Product Category");
        label.setBounds(50, 70, 250, 50);
        frame.add(label);

        productType = new JComboBox<>(new String[]{"All", "Electronic", "Clothing"});
        productType.setBounds(250, 70, 200, 50);
        productType.addActionListener(this);
        frame.add(productType);

        model = new DefaultTableModel(new String[]{"Product_id", "Name", "Type", "Price", "Info"}, 0);
        table = new JTable(model);

        // Add ListSelectionListener to the table
        ListSelectionModel selectionModel = table.getSelectionModel();
        selectionModel.addListSelectionListener(new TableSelectionListener());

        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(70, 130, 700, 240);
        frame.add(scrollPane);

        JList<String> list = new JList<>(productInfo);

        list.setBounds(70, 380, 700, 252);
        frame.add(list);

        addToCart = new JButton("Add to cart");
        addToCart.setBounds(250, 640, 150, 50);
        addToCart.addActionListener(this);
        frame.add(addToCart);

        frame.setSize(800, 850);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    private void filterTableData(String selectedType) {
        model.setRowCount(0);

        for (Product product : WestminsterShoppingManager.productList) {
            if (selectedType.equalsIgnoreCase("All") || selectedType.equalsIgnoreCase(product.productCatergory())) {
                model.addRow(new Object[]{
                        product.getProductId(),
                        product.getProductName(),
                        product.productCatergory(),
                        product.getPrice(),
                        product.toString()
                });
            }
        }
    }

    public void updateTableData() {
        model.setRowCount(0);
        for (Product product : WestminsterShoppingManager.productList) {
            model.addRow(new Object[]{
                    product.getProductId(),
                    product.getProductName(),
                    product.productCatergory(),
                    product.getPrice(),
                    product.toString()
            });
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == shoppingCart) {
            frame.dispose();
        }
        if (e.getSource() == productType) {
            String selectedType = (String) productType.getSelectedItem();
            filterTableData(selectedType);
        }
        if (e.getSource() == addToCart) {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {

            } else {
                JOptionPane.showMessageDialog(frame, "Please select a row from the table.");
            }
        }
    }

    // Inner class to handle table row selection
    private class TableSelectionListener implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {

                    productInfo.clear(); // Clear existing content

                    // Display default information
                    productInfo.addElement("Product Details");

                    // Get the data from the selected row
                    String productId = table.getValueAt(selectedRow, 0).toString();
                    String productName = table.getValueAt(selectedRow, 1).toString();
                    String productType = table.getValueAt(selectedRow, 2).toString();
                    String price = table.getValueAt(selectedRow, 3).toString();
                    String productInfoText = table.getValueAt(selectedRow, 4).toString();

                    productInfo.addElement("Product ID :      " + productId);
                    productInfo.addElement("Product Category: " + productType);
                    productInfo.addElement("Name:             " + productName);
                    productInfo.addElement("Price:            " + price);
                    productInfo.addElement("Info:             " + productInfoText);
                }
            }
        }
    }
}