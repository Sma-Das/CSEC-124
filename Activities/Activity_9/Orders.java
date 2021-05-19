import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import javax.swing.*;

public class Orders extends JFrame implements ActionListener {
  private String[] labels;
  private JTextField[] textFields;
  private String[] btnNames;
  private JButton[] buttons;

  public static void main(String[] args) {
    new Orders();
  }

  public void fillLabels() {
    labels = new String[] {"Item name", "Number of", "Cost", "Amount Owed"};
    textFields = new JTextField[labels.length];

    btnNames = new String[] {"Calculate", "Save", "Clear", "Exit"};
    buttons = new JButton[btnNames.length];
  }

  public Orders() {
    super("Sma's item order calculator");
    setLayout(new BorderLayout(5, 10));
    fillLabels();
    addButtons();
    addLabels();

    sizeFrame();
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public void sizeFrame() {
    setSize(500, 200);
    setLocationRelativeTo(null);
  }

  private JTextField addTextField(boolean enabled) {
    JTextField jtf = new JTextField();
    jtf.setEditable(!enabled);
    return jtf;
  }

  public void addLabels() {

    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(labels.length, 2, 5, 10));
    add(panel, BorderLayout.CENTER);

    for (int i = 0; i < labels.length; i++) {
      JLabel jL = new JLabel(labels[i] + " : ", SwingConstants.RIGHT);
      panel.add(jL);
      JTextField jtf = addTextField(labels[i].equalsIgnoreCase("Amount owed"));
      panel.add(jtf);
      textFields[i] = jtf;
    }
  }

  public void addButtons() {
    JPanel panel = new JPanel();
    panel.setLayout(new FlowLayout());
    add(panel, BorderLayout.SOUTH);
    for (int i = 0; i < btnNames.length; ++i) {
      JButton button = new JButton(btnNames[i]);
      buttons[i] = button;
      panel.add(button);
      button.addActionListener(this);
      button.setActionCommand(btnNames[i]);
    }
  }

  private void calculate() {
    Double amount = Double.parseDouble(textFields[1].getText());
    Double single_cost = Double.parseDouble(textFields[2].getText());
    Double cost = amount * single_cost;
    textFields[3].setText(cost.toString());
  }

  private void save() {
    try {
      FileWriter fw = new FileWriter("orders.csv", true);
      String output = "";
      for (JTextField jtf : textFields) {
        output += jtf.getText() + ", ";
      }
      fw.append(output + "\n");
      fw.flush();
      fw.close();
    } catch (Exception e) {

    }
  }

  private void clear() {
    for (JTextField jtf : textFields) {
      jtf.setText("");
    }
  }

  public void actionPerformed(ActionEvent e) {
    String action = e.getActionCommand();
    switch (action) {
      case "Calculate":
        calculate();
        break;
      case "Save":
        save();
        break;
      case "Clear":
        clear();
        break;
      case "Exit":
        System.exit(1);
        break;
      default:
        System.out.println("Error, not recognized");
    }
  }
}
