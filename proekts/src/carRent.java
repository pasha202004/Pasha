import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;

public class carRent {
    private JLabel rentCarLabel;
    private JComboBox carRentComboBox1;
    private JLabel carBrandLabel;
    private JSpinner timeSpinner1;
    private JLabel timeLabel;
    private JLabel insurTypeLabel;
    private JComboBox insuranceTypeComboBox1;
    private JButton rentButton;
    private JPanel rootPanel;
    private JComboBox comboBox1;

    private void createUIComponents() {

        Car BmwCar = new Car("BMW 2 Series 2016", 3.29, 'A', "Gas");
        Car MercedesCar = new Car("MERCEDES-BENZ CLS 350", 3.75, 'A', "Petrol");
        Car AudiCar = new Car("AUDI A7", 3.75,'A', "Disel");
        Car VolvoCar = new Car("Volvo XC40", 2.41,'A', "Petrol");
        Car ToyotaCar = new Car("TOYOTA YARIS", 1.20, 'M', "Petrol");
        Car BugattiCar = new Car("Bugatti Chiron", 833.29, 'A', "Petrol");

        String[] models = {BmwCar.getModelAndPrice(),
                MercedesCar.getModelAndPrice(),
                AudiCar.getModelAndPrice(),
                VolvoCar.getModelAndPrice(),
                ToyotaCar.getModelAndPrice(),
                BugattiCar.getModelAndPrice()};
        carRentComboBox1 = new JComboBox(models);

        comboBox1 = new JComboBox(models);


        String[] insuranceTypes = {"Nekāds 0EUR","Puss apdrošināšana 200EUR","Pilna apdrošināšana 500EUR"};
        insuranceTypeComboBox1 = new JComboBox(insuranceTypes);

        SpinnerModel value = new SpinnerNumberModel(1, 1, 1000, 1);
        timeSpinner1 = new JSpinner(value);


        rentButton = new JButton();
        rentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int carType = carRentComboBox1.getSelectedIndex();
                String rent = "";
                double amount = 0;
                switch (carType) {
                    case 0:
                        rent += BmwCar.toString();
                        amount = (BmwCar.getPricePerHour()*(int)timeSpinner1.getValue());
                        break;
                    case 1:
                        rent += MercedesCar.toString();
                        amount = (MercedesCar.getPricePerHour()*(int)timeSpinner1.getValue());
                        break;
                    case 2:
                        rent += AudiCar.toString();
                        amount = (AudiCar.getPricePerHour()*(int)timeSpinner1.getValue());
                        break;
                    case 3:
                        rent += VolvoCar.toString();
                        amount = (VolvoCar.getPricePerHour()*(int)timeSpinner1.getValue());
                        break;
                    case 4:
                        rent += ToyotaCar.toString();
                        amount = (ToyotaCar.getPricePerHour()*(int)timeSpinner1.getValue());
                        break;
                    case 5:
                        rent += BugattiCar.toString();
                        amount = (BugattiCar.getPricePerHour()*(int)timeSpinner1.getValue());
                        break;
                    default:
                        break;
                }
                int insuranceType = insuranceTypeComboBox1.getSelectedIndex();
                switch (insuranceType) {
                    case 1:
                        amount += 250;
                        break;
                    case 2:
                        amount += 500;
                        break;
                }
                rent += "Uz " +timeSpinner1.getValue() + " stundiem?\n\n";
                rent += "Apdrošināšanas veids: " +insuranceTypeComboBox1.getItemAt(insuranceTypeComboBox1.getSelectedIndex()) + "\n\n";
                String summa = String.format("%.2f", amount);
                rent += "Summa: " + summa + " EUR\n";
                JFrame confirmation = new JFrame();
                int a = JOptionPane.showConfirmDialog(confirmation, "Viss pareizi?\n" + rent);
                if (a == JOptionPane.YES_OPTION) {
                    JFrame numberFrame = new JFrame();
                    JFrame nameFrame = new JFrame();
                    String name = JOptionPane.showInputDialog(nameFrame, "Ievadiet Jūsu vārdu un uzvārdu");
                    while (name.isEmpty()) {
                        JOptionPane.showMessageDialog(nameFrame, "Vards ir tukšs", "Irēšana", JOptionPane.WARNING_MESSAGE);
                        name = JOptionPane.showInputDialog(nameFrame, "Ievadiet Jūsu vārdu");
                    }
                    String number = JOptionPane.showInputDialog(nameFrame, "Ievadiet Jūsu telefona numuru");
                    while (number.isEmpty()) {
                        JOptionPane.showMessageDialog(numberFrame, "Telefona numurs ir tukšs", "Irēšana", JOptionPane.WARNING_MESSAGE);
                        number = JOptionPane.showInputDialog(numberFrame, "Ievadiet Jūsu telefona numuru");
                    }
                    try {
                        FileWriter fw = new FileWriter("rents.txt", true);
                        String file1 = "Name: " + name + " \nTelefona numurs: " + number + "\n" + rent+ "\n";
                        fw.write(file1 + "----------------\n");
                        fw.close();
                        JFrame conf = new JFrame();
                        JOptionPane.showMessageDialog(conf, "Irēšana ir izveidota");
                        System.exit(0);

                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }

            }
        });

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Irēšana");
        frame.setContentPane(new carRent().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);


    }
}

