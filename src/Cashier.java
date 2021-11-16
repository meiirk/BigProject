import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Cashier extends JFrame {
    public static void main(String[] args) throws IOException {
        JFrame cashierAPP=new JFrame("CASHIER APPLICATION");
        Socket socket = new Socket("127.0.0.1", 1989);
        ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
        Cashier cashier=new Cashier();
        cashier.ticket_functions(cashierAPP,socket,os,is);

    }
    public void main_frame(JFrame frame) {

        JLabel header_text = new JLabel();
        header_text.setText("CASHIER APPLICATION");
        header_text.setForeground(Color.white);
        header_text.setFont(new Font("Monaco", Font.BOLD, 15));

        JPanel header = new JPanel();
        header.setBackground(new Color(22, 184, 155));
        header.setOpaque(true);
        header.setBounds(0, 0, 500, 40);
        header.add(header_text);

        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.add(header);

    }

    public  void ticket_functions(JFrame functions, Socket socket, ObjectOutputStream os, ObjectInputStream is) throws IOException {
main_frame(functions);
        JButton add = new JButton();
        add.setText("ADD TICKET");
        add.setForeground(Color.white);
        add.setBounds(100, 200, 300, 30);
        add.setBackground(new Color(22, 184, 155));
        add.setFocusable(false);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                functions.setVisible(false);
                JFrame add_pages = new JFrame("CASHIER APPLICATION");
                main_frame(add_pages);
                ticket_add_page(add_pages, socket, os, is);
                add_pages.setVisible(true);

            }
        });

        JButton delete = new JButton();
        delete.setText("DELETE TICKET");
        delete.setForeground(Color.white);
        delete.setBounds(100, 250, 300, 30);
        delete.setBackground(new Color(22, 184, 155));
        delete.setFocusable(false);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                functions.setVisible(false);
                JFrame delete_page = new JFrame("CASHIER APPLICATION");
                main_frame(delete_page);
                ticket_delete(delete_page, socket, os, is);
                delete_page.setVisible(true);


            }
        });
        JButton update = new JButton();
        update.setText("UPDATE TICKET");
        update.setForeground(Color.white);
        update.setBounds(100, 300, 300, 30);
        update.setBackground(new Color(22, 184, 155));
        update.setFocusable(false);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                functions.setVisible(false);
                JFrame update_page = new JFrame("CASHIER APPLICATION");
                main_frame(update_page);
                ticket_update_page(update_page, socket, os, is);
                update_page.setVisible(true);


            }
        });
        JButton list_city = new JButton();
        list_city.setText("LIST TICKET");
        list_city.setForeground(Color.white);
        list_city.setBounds(100, 350, 300, 30);
        list_city.setBackground(new Color(22, 184, 155));
        list_city.setFocusable(false);
        list_city.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                functions.setVisible(false);
                JFrame list_page = new JFrame("CASHIER APPLICATION");
                main_frame(list_page);
                list_frame_ticket(list_page, socket, os, is);
                list_page.setVisible(true);


            }
        });

        JButton exit = new JButton();
        exit.setText("Exit ");
        exit.setForeground(Color.white);
        exit.setBounds(100, 400, 300, 35);
        exit.setBackground(new Color(153, 153, 153));
        exit.setFocusable(false);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                functions.setVisible(false);
                JFrame first_pagee = new JFrame("");



            }
        });

        functions.add(add);
        functions.add(delete);
        functions.add(list_city);
        functions.add(update);
        functions.add(exit);
        functions.setVisible(true);

    }


    public  void ticket_add_page(JFrame add_frame, Socket socket, ObjectOutputStream os, ObjectInputStream is) {
        JLabel flight_id = new JLabel("flight_id:");
        flight_id.setBounds(100, 150, 100, 20);

        JLabel name = new JLabel("name:");
        name.setBounds(100, 200, 100, 20);

        JLabel surname = new JLabel("surname:");
        surname.setBounds(100, 250, 100, 20);


        JLabel passport_number = new JLabel("passport_number:");
        passport_number.setBounds(100, 300, 100, 20);


        JLabel ticket_type = new JLabel("ticket_type:");
        ticket_type.setBounds(100, 350, 100, 20);


        JTextField flight_id_field = new JTextField();
        flight_id_field.setBounds(270, 150, 150, 35);

        JTextField name_field = new JTextField();
        name_field.setBounds(270, 200, 150, 35);

        JTextField surname_field = new JTextField();
        surname_field.setBounds(270, 250, 150, 35);

        JTextField passport_number_field = new JTextField();
        passport_number_field.setBounds(270, 300, 150, 35);

        JTextField ticket_type_field = new JTextField();
        ticket_type_field.setBounds(270, 350, 150, 35);


        JButton add_button = new JButton();
        add_button.setText("ADD");
        add_button.setForeground(Color.white);
        add_button.setBounds(100, 400, 130, 35);
        add_button.setBackground(new Color(153, 153, 153));
        add_button.setFocusable(false);
        add_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int check_function=1;


                    String name = name_field.getText();
                    String passport_number = passport_number_field.getText();
                    String ticket_type = ticket_type_field.getText();
                      String surname=surname_field.getText();
                   int flight_id=0;
                   if(!(flight_id_field.getText().isEmpty())) {
                       flight_id = Integer.parseInt(flight_id_field.getText());
                       Tickets ticket = new Tickets(null,flight_id,name,surname,passport_number,ticket_type);

                       PackageData pcd = new PackageData();
                       pcd.setOperationType("ADD_TICKET");
                       pcd.ticket = ticket;
                       os.writeObject(pcd);
                       System.out.println("New ticket sent!");
                   }
                    if (!(name.isEmpty()) && (flight_id != 0) &&! (passport_number.isEmpty()) && !(ticket_type.isEmpty()&&!(surname.isEmpty())) ) {


                                         name_field.setText("");
                                        surname_field.setText("");
                                        passport_number_field.setText("");
                                        flight_id_field.setText("");
                                        ticket_type_field.setText("");

                    } else {
                        JOptionPane.showMessageDialog(null, "Complete all fields!", "error", JOptionPane.WARNING_MESSAGE);
                    }

                } catch (Exception E) {
                    E.printStackTrace();
                }
            }

        });



        JButton back_button = new JButton();
        back_button.setText("BACK");
        back_button.setForeground(Color.white);
        back_button.setBounds(270, 400, 130, 35);
        back_button.setBackground(new Color(153, 153, 153));
        back_button.setFocusable(false);
        back_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame firstPage = new JFrame("CASHIER APPLICATION");
                add_frame.setVisible(false);
                main_frame(firstPage);
                try {
                    ticket_functions(firstPage, socket, os, is);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                firstPage.setVisible(true);
            }
        });

        add_frame.add(name);
        add_frame.add(flight_id);
        add_frame.add(flight_id_field);
        add_frame.add(name_field);
        add_frame.add(surname_field);
        add_frame.add(surname);
        add_frame.add(passport_number_field);
        add_frame.add(passport_number);
        add_frame.add(ticket_type);
        add_frame.add(back_button);
        add_frame.add(add_button);
        add_frame.add(ticket_type_field);

    }


    public void list_frame_ticket(JFrame list_frame, Socket socket, ObjectOutputStream os, ObjectInputStream is) {

        try {

            PackageData data = new PackageData();
            PackageData response_pd = null;
            data.setOperationType("LIST_TICKET");
            os.writeObject(data);
            if ((response_pd = (PackageData) is.readObject()) != null) {

                Object columName[] = {"flight_id", "name", "surname","passport_number","ticket_type"};
                Object tableData[][] = new Object[response_pd.tickets.size()][5];
                for (int i = 0; i < response_pd.tickets.size(); i++) {

                    tableData[i][0] = response_pd.tickets.get(i).getFlight_id();
                    tableData[i][1] = response_pd.tickets.get(i).getName();
                    tableData[i][2] = response_pd.tickets.get(i).getSurname();
                    tableData[i][3] = response_pd.tickets.get(i).getPassport_number();
                    tableData[i][4] = response_pd.tickets.get(i).getTicket_type();

                }

                list_frame.getContentPane().setLayout(new FlowLayout());
                JTable table_student = new JTable(tableData, columName);
                JScrollPane sp = new JScrollPane(table_student);
                table_student.setPreferredScrollableViewportSize(new Dimension(400, 300));
                list_frame.getContentPane().add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }


        JButton back_button = new JButton();
        back_button.setText("BACK");
        back_button.setForeground(Color.white);
        back_button.setBounds(400, 150, 200, 30);
        back_button.setBackground(new Color(153, 153, 153));
        back_button.setFocusable(false);
        back_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list_frame.setVisible(false);
                JFrame city_function_page = new JFrame("");
                main_frame(city_function_page);
                try {
                    ticket_functions(city_function_page, socket, os, is);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                city_function_page.setVisible(true);
            }
        });

        list_frame.add(back_button);

    }

    public void ticket_delete(JFrame delete_frame, Socket socket, ObjectOutputStream os, ObjectInputStream is) {
        //        int flight_id,String name,String surname,String passport_number,String ticket_type

        JLabel id = new JLabel("ID:");
        id.setBounds(100, 150, 50, 20);

        JTextField ID_field = new JTextField();
        ID_field.setBounds(250, 150, 150, 35);

        JButton delete_button = new JButton();
        delete_button.setText("DELETE");
        delete_button.setForeground(Color.white);
        delete_button.setBounds(100, 350, 130, 35);
        delete_button.setBackground(new Color(22, 184, 155));
        delete_button.setFocusable(false);
        delete_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {





                    PackageData data = new PackageData();
                    data.setOperationType("DELETE_TICKET");
                    int check_function=1;
                    String id_string = "0";

                    Long id = Long.parseLong(id_string);
                    if (!(ID_field.getText().isEmpty())) {
                        id = Long.parseLong(ID_field.getText());
                        Tickets ticket=new Tickets(id,0,null,null,null,null);
                        data.ticket=ticket;
                        os.writeObject(data);

                    }

                    if (id != 0) {
                        PackageData response_pd = null;
                        if ((response_pd = (PackageData) is.readObject()) != null) {
                            if (response_pd.tickets != null) {
                                for (int i = 0; i < response_pd.tickets.size(); i++) {
                                    Long ID= response_pd.tickets.get(i).getId();
                                    if (ID.equals(id)) {
                                        check_function++;
                                        ID_field.setText("");
                                    }
                                }}}if(check_function==1){
                            JOptionPane.showMessageDialog(null, "Doesn't exist ticket with current id!", "error", JOptionPane.WARNING_MESSAGE);
                        }
                    }

                    else {
                        JOptionPane.showMessageDialog(null, "You need to complete all field ", "error", JOptionPane.WARNING_MESSAGE);

                    }
                }catch (Exception E) {
                    E.printStackTrace();
                }
            }


        });


















        JButton back_button = new JButton();
        back_button.setText("BACK");
        back_button.setForeground(Color.white);
        back_button.setBounds(270, 350, 130, 35);
        back_button.setBackground(new Color(153, 153, 153));
        back_button.setFocusable(false);
        back_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame firstPage = new JFrame("CASHIER APPLICATION");
                delete_frame.setVisible(false);
                main_frame(firstPage);
                try {
                    ticket_functions(firstPage, socket, os, is);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                firstPage.setVisible(true);
            }
        });
        delete_frame.add(back_button);
        delete_frame.add(delete_button);
        delete_frame.add(ID_field);
        delete_frame.add(id);
    }



    public void ticket_update_page(JFrame update_frame, Socket socket, ObjectOutputStream os, ObjectInputStream is) {
        JLabel id = new JLabel("id:");
        id.setBounds(100, 100, 50, 20);

        JLabel flight_id = new JLabel("flight_id:");
        flight_id.setBounds(100, 150, 50, 20);

        JLabel name = new JLabel("name:");
        name.setBounds(100, 200, 100, 20);

        JLabel surname = new JLabel("surname:");
        surname.setBounds(100, 250, 100, 20);


        JLabel passport_number = new JLabel("passport_number:");
        passport_number.setBounds(100, 300, 100, 20);


        JLabel ticket_type = new JLabel("ticket_type:");
        ticket_type.setBounds(100, 350, 100, 20);

        JTextField id_field = new JTextField();
        id_field.setBounds(270, 100, 150, 35);

        JTextField flight_id_field = new JTextField();
        flight_id_field.setBounds(270, 150, 150, 35);

        JTextField name_field = new JTextField();
        name_field.setBounds(270, 200, 150, 35);

        JTextField surname_field = new JTextField();
        surname_field.setBounds(270, 250, 150, 35);

        JTextField passport_number_field = new JTextField();
        passport_number_field.setBounds(270, 300, 150, 35);

        JTextField ticket_type_field = new JTextField();
        ticket_type_field.setBounds(270, 350, 150, 35);




            JButton update_button = new JButton();
        update_button.setText("UPDATE");
        update_button.setForeground(Color.white);
        update_button.setBounds(100, 400, 130, 35);
        update_button.setBackground(new Color(153, 153, 153));
        update_button.setFocusable(false);
        update_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    int flight_id=0;
                    if(!(flight_id_field.getText().isEmpty())) {
                     flight_id=   Integer.parseInt(flight_id_field.getText());
                    }
                    String name = name_field.getText();

                    String surname = surname_field.getText();

                    String passport_number = passport_number_field.getText();

                    String ticket_type = ticket_type_field.getText();

                    PackageData data = new PackageData();

                    data.setOperationType("UPDATE_TICKET");


                    int check_function = 1;
                    String id_long = "0";
                    Long id = Long.parseLong(id_long);

                    if (!(id_field.getText().isEmpty())) {
                        id = Long.parseLong(id_field.getText());
                        Tickets ticket = new Tickets(id,flight_id,name,surname,passport_number,ticket_type);
                        data.ticket = ticket;
                        os.writeObject(data);
                    }

                    if ((id!=0)&&!(name.isEmpty()) && (flight_id != 0) &&! (passport_number.isEmpty()) && !(ticket_type.isEmpty()&&!(surname.isEmpty())) ) {

                        PackageData response_pd = null;
                        if ((response_pd = (PackageData) is.readObject()) != null) {
                            if (response_pd.tickets != null) {
                                for (int i = 0; i < response_pd.tickets.size(); i++) {
                                    Long ID = response_pd.tickets.get(i).getId();
                                    if (ID.equals(id)) {
                                        check_function++;

                                        id_field.setText("");
                                        flight_id_field.setText("");
                                        name_field.setText("");
                                        passport_number_field.setText("");
                                        surname_field.setText("");
                                        ticket_type_field.setText("");

                                    }
                                }
                            }
                        }  if (check_function == 1) {
                            JOptionPane.showMessageDialog(null, "Doesn't exist ticket with current id!", "error", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "You need to complete all field ", "error", JOptionPane.WARNING_MESSAGE);

                    }

                } catch (Exception E) {
                    E.printStackTrace();
                }

            }
        });

        JButton back_button = new JButton();
        back_button.setText("BACK");
        back_button.setForeground(Color.white);
        back_button.setBounds(270, 400, 130, 35);
        back_button.setBackground(new Color(153, 153, 153));
        back_button.setFocusable(false);
        back_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame del_frame = new JFrame("CASHIER APPLICATION");
                update_frame.setVisible(false);
                main_frame(del_frame);
                try {
                    ticket_functions(del_frame, socket, os, is);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                del_frame.setVisible(true);
            }
        });

        update_frame.add(name);
        update_frame.add(flight_id);
        update_frame.add(flight_id_field);
        update_frame.add(name_field);
        update_frame.add(surname_field);
        update_frame.add(surname);
        update_frame.add(passport_number_field);
        update_frame.add(passport_number);
        update_frame.add(ticket_type);
        update_frame.add(back_button);
        update_frame.add(update_button);
        update_frame.add(ticket_type_field);
        update_frame.add(id);
        update_frame.add(id_field);

    }


}