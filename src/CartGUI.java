import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CartGUI implements ActionListener {
    JFrame frame;
    JButton back;
    JTable table;
    JLabel Total;
    JLabel FirstPurchaseDiscount;
    JLabel ThreeItemDiscount;
    JLabel FinalTotal;
    DefaultTableModel model;
    JScrollPane scrollPane;

    public CartGUI() {
        frame = new JFrame("Westminster Shopping Manager");
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        back = new JButton("Back");
        back.addActionListener(this);
        back.setBounds(50,10,200,50);
        frame.add(back);

        model = new DefaultTableModel(new String[]{"Product", "Quantity", "Price"}, 0);
        table = new JTable(model);
        this.scrollPane = new JScrollPane(table); // Add the JTable to the JScrollPane
        scrollPane.setBounds(70, 130, 700, 240);
        frame.add(scrollPane); // Add the JScrollPane to the frame

        Total = new JLabel("Total");
        Total.setBounds(50, 400, 350, 50);
        frame.add(Total);

        FirstPurchaseDiscount = new JLabel("First Purchase Discount(10%)");
        FirstPurchaseDiscount.setBounds(50, 430, 350, 50);
        frame.add(FirstPurchaseDiscount);

        ThreeItemDiscount = new JLabel("Three items in same Category Discount(20%)");
        ThreeItemDiscount.setBounds(50, 460, 350, 50);
        frame.add(ThreeItemDiscount);

        FinalTotal = new JLabel("Final Total");
        FinalTotal.setBounds(50, 490, 350, 50);
        frame.add(FinalTotal);

        frame.setSize(850, 600); // Adjusted height to fit the labels
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new CartGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back){
            frame.dispose();
            ShopGUI shop = new ShopGUI();
        }
    }
}
