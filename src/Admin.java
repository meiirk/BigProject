import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class Admin extends JFrame {
    public static void main(String[] args) throws IOException {

        JFrame adminAPP = new JFrame("ADMIN APPLICATION");
        Socket socket = new Socket("127.0.0.1", 1990);
        ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
        Admin admin = new Admin();
        admin.firstPage(adminAPP, socket, os, is);

    }


    String operationType;

    public Admin(String operationType) {
        this.operationType = operationType;
    }

    public Admin() {
        this.operationType = "";
    }

    public void main_frame(JFrame frame) {

        JLabel header_text = new JLabel();
        header_text.setText("ADMIN APPLICATION");
        header_text.setForeground(Color.white);
        header_text.setFont(new Font("Monaco", Font.BOLD, 15));

        JPanel header = new JPanel();
        header.setBackground(new Color(22, 219, 232));
        header.setOpaque(true);
        header.setBounds(0, 0, 500, 40);
        header.add(header_text);

        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.add(header);

    }

    public void firstPage(JFrame firstPage, Socket socket, ObjectOutputStream os, ObjectInputStream is) throws IOException {
        main_frame(firstPage);
        firstPage.setVisible(true);
        JButton city = new JButton();
        city.setText("City");
        city.setForeground(Color.white);
        city.setBounds(100, 200, 300, 30);
        city.setBackground(new Color(22, 219, 232));
        city.setFocusable(false);
        city.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstPage.setVisible(false);
                JFrame city_pages = new JFrame("ADMIN APPLICATION/City");
                main_frame(city_pages);
                try {
                    city_functions(city_pages, socket, os, is);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                city_pages.setVisible(true);

            }
        });

        JButton planes = new JButton();
        planes.setText("Planes");
        planes.setForeground(Color.white);
        planes.setBounds(100, 250, 300, 30);
        planes.setBackground(new Color(22, 219, 232));
        planes.setFocusable(false);
        planes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstPage.setVisible(false);
                JFrame plane_page = new JFrame("ADMIN APPLICATION/PLANE");
                main_frame(plane_page);
                try {
                    planes_functions(plane_page, socket, os, is);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                plane_page.setVisible(true);


            }
        });
        JButton flights = new JButton();
        flights.setText("Flights");
        flights.setForeground(Color.white);
        flights.setBounds(100, 300, 300, 30);
        flights.setBackground(new Color(22, 219, 232));
        flights.setFocusable(false);
        flights.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstPage.setVisible(false);
                JFrame list_page = new JFrame("ADMIN APPLICATION");
                main_frame(list_page);
                try {
                    flights_functions(list_page, socket, os, is);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                list_page.setVisible(true);


            }
        });

        JButton back = new JButton();
        back.setText("EXIT");
        back.setForeground(Color.white);
        back.setBounds(100, 350, 300, 35);
        back.setBackground(new Color(153, 153, 153));
        back.setFocusable(false);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstPage.setVisible(false);
                System.exit(0);

            }
        });

        firstPage.add(city);
        firstPage.add(flights);
        firstPage.add(city);
        firstPage.add(back);
        firstPage.add(planes);
    }


    public void city_functions(JFrame functions, Socket socket, ObjectOutputStream os, ObjectInputStream is) throws IOException {

        JButton add = new JButton();
        add.setText("ADD CITY");
        add.setForeground(Color.white);
        add.setBounds(100, 200, 300, 30);
        add.setBackground(new Color(22, 219, 232));
        add.setFocusable(false);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                functions.setVisible(false);
                JFrame add_pages = new JFrame("ADMIN APPLICATION/CITY/ADD CITY");
                main_frame(add_pages);
                city_add_page(add_pages, socket, os, is);
                add_pages.setVisible(true);

            }
        });

        JButton delete = new JButton();
        delete.setText("DELETE CITY");
        delete.setForeground(Color.white);
        delete.setBounds(100, 250, 300, 30);
        delete.setBackground(new Color(22, 219, 232));
        delete.setFocusable(false);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                functions.setVisible(false);
                JFrame delete_page = new JFrame("ADMIN APPLICATION/DELETE CITY");
                main_frame(delete_page);
                city_delete(delete_page, socket, os, is);
                delete_page.setVisible(true);


            }
        });
        JButton update = new JButton();
        update.setText("UPDATE CITY");
        update.setForeground(Color.white);
        update.setBounds(100, 300, 300, 30);
        update.setBackground(new Color(22, 219, 232));
        update.setFocusable(false);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                functions.setVisible(false);
                JFrame update_page = new JFrame("ADMIN APPLICATION/UPDATE CITY");
                main_frame(update_page);
                city_update_page(update_page, socket, os, is);
                update_page.setVisible(true);


            }
        });
        JButton list_city = new JButton();
        list_city.setText("LIST CITY");
        list_city.setForeground(Color.white);
        list_city.setBounds(100, 350, 300, 30);
        list_city.setBackground(new Color(22, 219, 232));
        list_city.setFocusable(false);
        list_city.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                functions.setVisible(false);
                JFrame list_page = new JFrame("ADMIN APPLICATION/LIST STUDENT");
                main_frame(list_page);
                list_frame_city(list_page, socket, os, is);
                list_page.setVisible(true);


            }
        });

        JButton exit = new JButton();
        exit.setText("BACK ");
        exit.setForeground(Color.white);
        exit.setBounds(100, 400, 300, 35);
        exit.setBackground(new Color(153, 153, 153));
        exit.setFocusable(false);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                functions.setVisible(false);
                JFrame first_pagee = new JFrame("");
                main_frame(first_pagee);
                try {
                    firstPage(first_pagee, socket, os, is);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                first_pagee.setVisible(true);


            }
        });

        functions.add(add);
        functions.add(delete);
        functions.add(list_city);
        functions.add(update);
        functions.add(exit);

    }


    public void city_add_page(JFrame add_frame, Socket socket, ObjectOutputStream os, ObjectInputStream is) {

        JLabel name = new JLabel("NAME:");
        name.setBounds(100, 150, 50, 20);

        JLabel country = new JLabel("COUNTRY:");
        country.setBounds(100, 200, 100, 20);

        JLabel short_name = new JLabel("SHORT NAME:");
        short_name.setBounds(100, 250, 100, 20);


        JTextField name_field = new JTextField();
        name_field.setBounds(270, 150, 150, 35);

        JTextField country_field = new JTextField();
        country_field.setBounds(270, 200, 150, 35);

        JTextField shortName_field = new JTextField();
        shortName_field.setBounds(270, 250, 150, 35);


        JButton add_button = new JButton();
        add_button.setText("ADD");
        add_button.setForeground(Color.white);
        add_button.setBounds(100, 350, 130, 35);
        add_button.setBackground(new Color(153, 153, 153));
        add_button.setFocusable(false);
        add_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String name = name_field.getText();

                    String country = country_field.getText();

                    String shortName = shortName_field.getText();

                    if (!(name.isEmpty()) && !(country.isEmpty()) && !(shortName.isEmpty())) {
                        Cities city = new Cities(null, name, country, shortName);
                        PackageData pcd = new PackageData();
                        pcd.setOperationType("ADD_CITY");
                        pcd.city = city;
                        os.writeObject(pcd);
                        System.out.println("New city sent!");
                        name_field.setText("");
                        country_field.setText("");
                        shortName_field.setText("");
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
        back_button.setBounds(270, 350, 130, 35);
        back_button.setBackground(new Color(153, 153, 153));
        back_button.setFocusable(false);
        back_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame firstPage = new JFrame("ADMIN APPLICATION/CITY");
                add_frame.setVisible(false);
                main_frame(firstPage);
                try {
                    city_functions(firstPage, socket, os, is);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                firstPage.setVisible(true);
            }
        });

        add_frame.add(name);
        add_frame.add(country);
        add_frame.add(short_name);
        add_frame.add(name_field);
        add_frame.add(country_field);
        add_frame.add(shortName_field);
        add_frame.add(add_button);
        add_frame.add(back_button);
    }


    public void list_frame_city(JFrame list_frame, Socket socket, ObjectOutputStream os, ObjectInputStream is) {

        try {

            PackageData data = new PackageData();
            PackageData response_pd = null;
            data.setOperationType("LIST_CITY");
            os.writeObject(data);
            if ((response_pd = (PackageData) is.readObject()) != null) {
                if (response_pd.cities != null) {
                    Object columName[] = {"Name", "Country", "short name"};
                    Object tableData[][] = new Object[response_pd.cities.size()][3];
                    for (int i = 0; i < response_pd.cities.size(); i++) {

                        tableData[i][0] = response_pd.cities.get(i).getName();
                        tableData[i][1] = response_pd.cities.get(i).getCountry();
                        tableData[i][2] = response_pd.cities.get(i).getShort_name();
                    }

                    list_frame.getContentPane().setLayout(new FlowLayout());
                    JTable table_student = new JTable(tableData, columName);
                    JScrollPane sp = new JScrollPane(table_student);
                    table_student.setPreferredScrollableViewportSize(new Dimension(400, 300));
                    list_frame.getContentPane().add(sp);
                } else {
                    list_frame.setVisible(false);
                    JFrame city_function_page = new JFrame("");
                    main_frame(city_function_page);
                    try {
                        city_functions(city_function_page, socket, os, is);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    city_function_page.setVisible(true);
                }

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
                    city_functions(city_function_page, socket, os, is);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                city_function_page.setVisible(true);
            }
        });

        list_frame.add(back_button);

    }


    public void city_delete(JFrame delete_frame, Socket socket, ObjectOutputStream os, ObjectInputStream is) {

        JLabel id = new JLabel("ID:");
        id.setBounds(100, 150, 50, 20);

        JTextField ID_field = new JTextField();
        ID_field.setBounds(250, 150, 150, 35);

        JButton delete_button = new JButton();
        delete_button.setText("DELETE");
        delete_button.setForeground(Color.white);
        delete_button.setBounds(100, 350, 130, 35);
        delete_button.setBackground(new Color(22, 219, 232));
        delete_button.setFocusable(false);
        delete_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    PackageData data = new PackageData();
                    data.setOperationType("DELETE_CITY");
                    int check_function = 1;
                    String id_string = "0";

                    Long id = Long.parseLong(id_string);
                    if (!(ID_field.getText().isEmpty())) {
                        id = Long.parseLong(ID_field.getText());
                        Cities cities = new Cities(id, null, null, null);
                        data.city = cities;
                        os.writeObject(data);

                    }

                    if (id != 0) {
                        PackageData response_pd = null;
                        if ((response_pd = (PackageData) is.readObject()) != null) {
                            if (response_pd.cities != null) {
                                for (int i = 0; i < response_pd.cities.size(); i++) {
                                    Long ID = response_pd.cities.get(i).getId();
                                    if (ID.equals(id)) {
                                        check_function++;
                                        ID_field.setText("");
                                    }
                                }
                            }
                        }
                        if (check_function == 1) {
                            JOptionPane.showMessageDialog(null, "Doesn't exist city with current id!", "error", JOptionPane.WARNING_MESSAGE);
                        }
                    } else {
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
        back_button.setBounds(270, 350, 130, 35);
        back_button.setBackground(new Color(153, 153, 153));
        back_button.setFocusable(false);
        back_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame firstPage = new JFrame("ADMIN APPLICATION/CITY");
                delete_frame.setVisible(false);
                main_frame(firstPage);
                try {
                    city_functions(firstPage, socket, os, is);
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


    public void city_update_page(JFrame delete_frame, Socket socket, ObjectOutputStream os, ObjectInputStream is) {
        JLabel id = new JLabel("ID:");
        id.setBounds(100, 150, 50, 20);

        JLabel name = new JLabel("NAME:");
        name.setBounds(100, 200, 50, 20);

        JLabel country = new JLabel("COUNTRY:");
        country.setBounds(100, 250, 100, 20);

        JLabel short_name = new JLabel("SHORT NAME:");
        short_name.setBounds(100, 300, 100, 20);

        JTextField id_field = new JTextField();
        id_field.setBounds(250, 150, 200, 35);

        JTextField name_field = new JTextField();
        name_field.setBounds(250, 200, 200, 35);

        JTextField country_field = new JTextField();
        country_field.setBounds(250, 250, 200, 35);

        JTextField shortName_field = new JTextField();
        shortName_field.setBounds(250, 300, 200, 35);


        JButton update_button = new JButton();
        update_button.setText("UPDATE");
        update_button.setForeground(Color.white);
        update_button.setBounds(100, 350, 130, 35);
        update_button.setBackground(new Color(153, 153, 153));
        update_button.setFocusable(false);
        update_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String name = name_field.getText();
                    String country = country_field.getText();
                    String shortName = shortName_field.getText();
                    PackageData data = new PackageData();
                    data.setOperationType("UPDATE_CITY");
                    int check_function = 1;
                    String id_long = "0";
                    Long id = Long.parseLong(id_long);

                    if (!(id_field.getText().isEmpty())) {
                        id = Long.parseLong(id_field.getText());
                        Cities cities = new Cities(id, name, country, shortName);
                        data.city = cities;
                        os.writeObject(data);
                    }

                    if (id != 0 && !(name.isEmpty()) && !(country.isEmpty()) && !(shortName.isEmpty())) {

                        PackageData response_pd = null;
                        if ((response_pd = (PackageData) is.readObject()) != null) {
                            if (response_pd.cities != null) {
                                for (int i = 0; i < response_pd.cities.size(); i++) {
                                    Long ID = response_pd.cities.get(i).getId();
                                    if (ID.equals(id)) {
                                        check_function++;
                                        id_field.setText("");
                                        id_field.setText("");
                                        name_field.setText("");
                                        country_field.setText("");
                                        shortName_field.setText("");
                                    }
                                }
                            }
                        }
                        if (check_function == 1) {
                            JOptionPane.showMessageDialog(null, "Doesn't exist city with current id!", "error", JOptionPane.WARNING_MESSAGE);
                        }
                    } else {
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
        back_button.setBounds(270, 350, 130, 35);
        back_button.setBackground(new Color(153, 153, 153));
        back_button.setFocusable(false);
        back_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame del_frame = new JFrame("ADMIN APPLICATION/CITY");
                delete_frame.setVisible(false);
                main_frame(del_frame);
                try {
                    city_functions(del_frame, socket, os, is);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                del_frame.setVisible(true);
            }
        });

        delete_frame.add(name);
        delete_frame.add(country);
        delete_frame.add(short_name);
        delete_frame.add(name_field);
        delete_frame.add(country_field);
        delete_frame.add(shortName_field);
        delete_frame.add(update_button);
        delete_frame.add(back_button);
        delete_frame.add(id);
        delete_frame.add(id_field);
    }


    public void planes_functions(JFrame functions_pl, Socket socket, ObjectOutputStream os, ObjectInputStream is) throws IOException {

        JButton add = new JButton();
        add.setText("ADD PLANS");
        add.setForeground(Color.white);
        add.setBounds(100, 200, 300, 30);
        add.setBackground(new Color(22, 219, 232));
        add.setFocusable(false);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                functions_pl.setVisible(false);
                JFrame add_page_plane = new JFrame("ADMIN APPLICATION/CITY/ADD PLANE");
                main_frame(add_page_plane);
                plane_add_page(add_page_plane, socket, os, is);
                add_page_plane.setVisible(true);

            }
        });

        JButton delete = new JButton();
        delete.setText("DELETE PLANE");
        delete.setForeground(Color.white);
        delete.setBounds(100, 250, 300, 30);
        delete.setBackground(new Color(22, 219, 232));
        delete.setFocusable(false);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                functions_pl.setVisible(false);
                JFrame delete_page = new JFrame("ADMIN APPLICATION/DELETE PLANE");
                main_frame(delete_page);
                plane_delete(delete_page, socket, os, is);
                delete_page.setVisible(true);


            }
        });
        JButton update = new JButton();
        update.setText("UPDATE PLANE");
        update.setForeground(Color.white);
        update.setBounds(100, 300, 300, 30);
        update.setBackground(new Color(22, 219, 232));
        update.setFocusable(false);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                functions_pl.setVisible(false);
                JFrame update_page = new JFrame("ADMIN APPLICATION/UPDATE PLANE");
                main_frame(update_page);
                plane_update_page(update_page, socket, os, is);
                update_page.setVisible(true);


            }
        });
        JButton list_plane = new JButton();
        list_plane.setText("LIST PLANE");
        list_plane.setForeground(Color.white);
        list_plane.setBounds(100, 350, 300, 30);
        list_plane.setBackground(new Color(22, 219, 232));
        list_plane.setFocusable(false);
        list_plane.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                functions_pl.setVisible(false);
                JFrame list_page = new JFrame("ADMIN APPLICATION/LIST PLANE");
                main_frame(list_page);
                list_frame_plane(list_page, socket, os, is);
                list_page.setVisible(true);


            }
        });

        JButton exit = new JButton();
        exit.setText("BACK ");
        exit.setForeground(Color.white);
        exit.setBounds(100, 400, 300, 35);
        exit.setBackground(new Color(153, 153, 153));
        exit.setFocusable(false);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                functions_pl.setVisible(false);
                JFrame first_pagee = new JFrame("ADMIN APPLICATION/");
                main_frame(first_pagee);
                try {
                    firstPage(first_pagee, socket, os, is);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                first_pagee.setVisible(true);


            }
        });

        functions_pl.add(add);
        functions_pl.add(delete);
        functions_pl.add(list_plane);
        functions_pl.add(update);
        functions_pl.add(exit);

    }

    public void plane_add_page(JFrame add_frame, Socket socket, ObjectOutputStream os, ObjectInputStream is) {

        JLabel name = new JLabel("NAME:");
        name.setBounds(100, 150, 50, 20);

        JLabel model = new JLabel("MODEL:");
        model.setBounds(100, 200, 100, 20);

        JLabel business_class_capacity = new JLabel("business class capacity:");
        business_class_capacity.setBounds(100, 250, 200, 20);

        JLabel econom_class_capacity = new JLabel("econom_class_capacity :");
        econom_class_capacity.setBounds(100, 300, 200, 20);


        JTextField name_field = new JTextField();
        name_field.setBounds(300, 150, 150, 35);

        JTextField model_field = new JTextField();
        model_field.setBounds(300, 200, 150, 35);

        JTextField business_class_capacity_field = new JTextField();
        business_class_capacity_field.setBounds(300, 250, 150, 35);

        JTextField econom_class_capacity_field = new JTextField();
        econom_class_capacity_field.setBounds(300, 300, 150, 35);


        JButton add_button = new JButton();
        add_button.setText("ADD");
        add_button.setForeground(Color.white);
        add_button.setBounds(100, 350, 130, 35);
        add_button.setBackground(new Color(153, 153, 153));
        add_button.setFocusable(false);
        add_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String name = name_field.getText();
                    String country = model_field.getText();
                    int business_class_capacity = 0;
                    if (!(business_class_capacity_field.getText().isEmpty())) {
                        business_class_capacity = Integer.parseInt(business_class_capacity_field.getText());
                    }

                    int econom_class_capacity = 0;
                    if (!(econom_class_capacity_field.getText().isEmpty())) {
                        econom_class_capacity = Integer.parseInt(econom_class_capacity_field.getText());
                    }
                    if (!(name.isEmpty()) && !(country.isEmpty()) && (business_class_capacity != 0) && (econom_class_capacity != 0)) {
                        model_field.setText("");
                        name_field.setText("");
                        business_class_capacity_field.setText("");
                        econom_class_capacity_field.setText("");
                        Aircrafts planes = new Aircrafts(null, name, country, business_class_capacity, econom_class_capacity);
                        PackageData pcd = new PackageData();
                        pcd.setOperationType("ADD_AIRCRAFT");
                        pcd.aircraft = planes;
                        os.writeObject(pcd);
                        System.out.println("New plane sent!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Complete all fields!", "error", JOptionPane.WARNING_MESSAGE);
                    }

                } catch (NumberFormatException | IOException E) {
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
                JFrame plane_function = new JFrame("ADMIN APPLICATION/PLANE");
                add_frame.setVisible(false);
                main_frame(plane_function);
                try {
                    planes_functions(plane_function, socket, os, is);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                plane_function.setVisible(true);
            }
        });

        add_frame.add(name);
        add_frame.add(model);
        add_frame.add(business_class_capacity);
        add_frame.add(econom_class_capacity);
        add_frame.add(name_field);
        add_frame.add(model_field);
        add_frame.add(business_class_capacity_field);
        add_frame.add(econom_class_capacity_field);
        add_frame.add(back_button);
        add_frame.add(add_button);
    }


    public void list_frame_plane(JFrame list_frame, Socket socket, ObjectOutputStream os, ObjectInputStream is) {

        try {

            PackageData data = new PackageData();
            PackageData response_pd = null;
            data.setOperationType("LIST_AIRCRAFT");
            os.writeObject(data);
            if ((response_pd = (PackageData) is.readObject()) != null) {

                Object columName[] = {"Name", "Model", "business_class_capacity", "econom_class_capacity"};
                Object tableData[][] = new Object[response_pd.aircrafts.size()][4];
                for (int i = 0; i < response_pd.aircrafts.size(); i++) {
                    tableData[i][0] = response_pd.aircrafts.get(i).getName();
                    tableData[i][1] = response_pd.aircrafts.get(i).getModel();
                    tableData[i][2] = response_pd.aircrafts.get(i).getBusiness_class_capacity();
                    tableData[i][3] = response_pd.aircrafts.get(i).getEconom_class_capacity();
                }

                list_frame.getContentPane().setLayout(new FlowLayout());
                JTable table_plane = new JTable(tableData, columName);
                JScrollPane sp = new JScrollPane(table_plane);
                table_plane.setPreferredScrollableViewportSize(new Dimension(400, 300));
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
                JFrame plane_function_page = new JFrame("");
                main_frame(plane_function_page);
                try {
                    planes_functions(plane_function_page, socket, os, is);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                plane_function_page.setVisible(true);
            }
        });

        list_frame.add(back_button);

    }


    public void plane_delete(JFrame delete_frame, Socket socket, ObjectOutputStream os, ObjectInputStream is) {

        JLabel id = new JLabel("ID:");
        id.setBounds(100, 150, 50, 20);

        JTextField ID_field = new JTextField();
        ID_field.setBounds(250, 150, 150, 35);

        JButton delete_button = new JButton();
        delete_button.setText("DELETE");
        delete_button.setForeground(Color.white);
        delete_button.setBounds(100, 350, 130, 35);
        delete_button.setBackground(new Color(22, 219, 232));
        delete_button.setFocusable(false);
        delete_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    PackageData data = new PackageData();
                    data.setOperationType("DELETE_AIRCRAFT");
                    int check_function = 1;
                    String id_string = "0";

                    Long id = Long.parseLong(id_string);
                    if (!(ID_field.getText().isEmpty())) {
                        id = Long.parseLong(ID_field.getText());
                        Aircrafts aircraft = new Aircrafts(id, null, null, 0, 0);
                        data.aircraft = aircraft;
                        os.writeObject(data);

                    }

                    if (id != 0) {
                        PackageData response_pd = null;
                        if ((response_pd = (PackageData) is.readObject()) != null) {
                            if (response_pd.aircrafts != null) {
                                for (int i = 0; i < response_pd.aircrafts.size(); i++) {
                                    Long ID = response_pd.aircrafts.get(i).getId();
                                    if (ID.equals(id)) {
                                        check_function++;
                                        ID_field.setText("");
                                    }
                                }
                            }
                        }
                        if (check_function == 1) {
                            JOptionPane.showMessageDialog(null, "Doesn't exist city with current id!", "error", JOptionPane.WARNING_MESSAGE);
                        }
                    } else {
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
        back_button.setBounds(270, 350, 130, 35);
        back_button.setBackground(new Color(153, 153, 153));
        back_button.setFocusable(false);
        back_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame plane_page = new JFrame("ADMIN APPLICATION/PLANE");
                delete_frame.setVisible(false);
                main_frame(plane_page);
                try {
                    planes_functions(plane_page, socket, os, is);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                plane_page.setVisible(true);
            }
        });
        delete_frame.add(back_button);
        delete_frame.add(delete_button);
        delete_frame.add(id);
        delete_frame.add(ID_field);
    }


    public void plane_update_page(JFrame update_frame, Socket socket, ObjectOutputStream os, ObjectInputStream is) {
        JLabel id = new JLabel("ID:");
        id.setBounds(100, 100, 50, 20);

        JLabel name = new JLabel("NAME:");
        name.setBounds(100, 150, 50, 20);

        JLabel model = new JLabel("MODEL:");
        model.setBounds(100, 200, 100, 20);

        JLabel business_class_capacity = new JLabel("business class capacity:");
        business_class_capacity.setBounds(100, 250, 200, 20);

        JLabel econom_class_capacity = new JLabel("econom_class_capacity :");
        econom_class_capacity.setBounds(100, 300, 200, 20);

        JTextField id_field = new JTextField();
        id_field.setBounds(300, 100, 150, 35);

        JTextField name_field = new JTextField();
        name_field.setBounds(300, 150, 150, 35);

        JTextField model_field = new JTextField();
        model_field.setBounds(300, 200, 150, 35);

        JTextField business_class_capacity_field = new JTextField();
        business_class_capacity_field.setBounds(300, 250, 150, 35);

        JTextField econom_class_capacity_field = new JTextField();
        econom_class_capacity_field.setBounds(300, 300, 150, 35);


        JButton update_button = new JButton();
        update_button.setText("UPDATE");
        update_button.setForeground(Color.white);
        update_button.setBounds(100, 350, 130, 35);
        update_button.setBackground(new Color(153, 153, 153));
        update_button.setFocusable(false);
        update_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    PackageData data = new PackageData();
                    data.setOperationType("UPDATE_AIRCRAFT");
                    int check_function = 1;
                    String id_long = "0";
                    Long id = Long.parseLong(id_long);

                    String name = name_field.getText();
                    String model = model_field.getText();

                    int business_class_capacity = 0;
                    if (!(business_class_capacity_field.getText().isEmpty())) {
                        business_class_capacity = Integer.parseInt(business_class_capacity_field.getText());
                    }

                    int econom_class_capacity = 0;
                    if (!(id_field.getText().isEmpty())) {
                        id = Long.parseLong(id_field.getText());
                        Aircrafts aircraft = new Aircrafts(id, name, model, business_class_capacity, econom_class_capacity);
                        data.aircraft = aircraft;
                        os.writeObject(data);
                    }
                    if (!(econom_class_capacity_field.getText().isEmpty())) {
                        econom_class_capacity = Integer.parseInt(econom_class_capacity_field.getText());
                    }
                    if (!(name.isEmpty()) && !(model.isEmpty()) && (business_class_capacity != 0) && (econom_class_capacity != 0)) {
                        PackageData response_pd = null;
                        if ((response_pd = (PackageData) is.readObject()) != null) {
                            if (response_pd.cities != null) {
                                for (int i = 0; i < response_pd.aircrafts.size(); i++) {
                                    Long ID = response_pd.aircrafts.get(i).getId();
                                    if (ID.equals(id)) {
                                        check_function++;
                                        id_field.setText("");
                                        name_field.setText("");
                                        model_field.setText("");
                                        business_class_capacity_field.setText("");
                                        econom_class_capacity_field.setText("");

                                    }
                                }
                            }
                        }
                        if (check_function == 1) {
                            JOptionPane.showMessageDialog(null, "Doesn't exist city with current id!", "error", JOptionPane.WARNING_MESSAGE);
                        }
                    } else {
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
        back_button.setBounds(270, 350, 130, 35);
        back_button.setBackground(new Color(153, 153, 153));
        back_button.setFocusable(false);
        back_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame del_frame = new JFrame("ADMIN APPLICATION/PLANE");
                update_frame.setVisible(false);
                main_frame(del_frame);
                try {
                    city_functions(del_frame, socket, os, is);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                del_frame.setVisible(true);
            }
        });
        update_frame.add(id);
        update_frame.add(id_field);
        update_frame.add(name);
        update_frame.add(model);
        update_frame.add(business_class_capacity);
        update_frame.add(econom_class_capacity);
        update_frame.add(name_field);
        update_frame.add(model_field);
        update_frame.add(econom_class_capacity_field);
        update_frame.add(business_class_capacity_field);
        update_frame.add(back_button);
        update_frame.add(update_button);

    }


    public void flights_functions(JFrame functions_pl, Socket socket, ObjectOutputStream os, ObjectInputStream is) throws IOException {

        JButton add = new JButton();
        add.setText("ADD FLIGHTS");
        add.setForeground(Color.white);
        add.setBounds(100, 200, 300, 30);
        add.setBackground(new Color(22, 219, 232));
        add.setFocusable(false);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                functions_pl.setVisible(false);
                JFrame add_page_plane = new JFrame("ADMIN APPLICATION/CITY/ADD PLANE");
                main_frame(add_page_plane);
                flight_add_page(add_page_plane, socket, os, is);
                add_page_plane.setVisible(true);

            }
        });

        JButton delete = new JButton();
        delete.setText("DELETE FLIGHTS");
        delete.setForeground(Color.white);
        delete.setBounds(100, 250, 300, 30);
        delete.setBackground(new Color(22, 219, 232));
        delete.setFocusable(false);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                functions_pl.setVisible(false);
                JFrame delete_page = new JFrame("ADMIN APPLICATION/DELETE PLANE");
                main_frame(delete_page);
                flights_delete(delete_page, socket, os, is);
                delete_page.setVisible(true);


            }
        });
        JButton update = new JButton();
        update.setText("UPDATE FLIGHTS");
        update.setForeground(Color.white);
        update.setBounds(100, 300, 300, 30);
        update.setBackground(new Color(22, 219, 232));
        update.setFocusable(false);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                functions_pl.setVisible(false);
                JFrame update_page = new JFrame("ADMIN APPLICATION/UPDATE PLANE");
                main_frame(update_page);
                flight_update_page(update_page, socket, os, is);
                update_page.setVisible(true);


            }
        });
        JButton list_plane = new JButton();
        list_plane.setText("LIST FLIGHTS");
        list_plane.setForeground(Color.white);
        list_plane.setBounds(100, 350, 300, 30);
        list_plane.setBackground(new Color(22, 219, 232));
        list_plane.setFocusable(false);
        list_plane.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                functions_pl.setVisible(false);
                JFrame list_page = new JFrame("ADMIN APPLICATION/LIST PLANE");
                main_frame(list_page);
                list_frame_flight(list_page, socket, os, is);
                list_page.setVisible(true);


            }
        });

        JButton exit = new JButton();
        exit.setText("BACK ");
        exit.setForeground(Color.white);
        exit.setBounds(100, 400, 300, 35);
        exit.setBackground(new Color(153, 153, 153));
        exit.setFocusable(false);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                functions_pl.setVisible(false);
                JFrame first_pagee = new JFrame("ADMIN APPLICATION/");
                main_frame(first_pagee);
                try {
                    firstPage(first_pagee, socket, os, is);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                first_pagee.setVisible(true);


            }
        });

        functions_pl.add(add);
        functions_pl.add(delete);
        functions_pl.add(list_plane);
        functions_pl.add(update);
        functions_pl.add(exit);

    }


    public void flight_add_page(JFrame add_frame, Socket socket, ObjectOutputStream os, ObjectInputStream is) {

        JLabel aircraft_id = new JLabel("aircraft_id:");
        aircraft_id.setBounds(100, 50, 110, 20);

        JLabel departure_city_id = new JLabel("departure_city_id:");
        departure_city_id.setBounds(100, 100, 110, 20);

        JLabel arrival_city_id = new JLabel("arrival_city_id :");
        arrival_city_id.setBounds(100, 150, 110, 20);

        JLabel departure_time = new JLabel("departure_time :");
        departure_time.setBounds(100, 200, 110, 20);

        JLabel econom_place_price = new JLabel("econom_place_price :");
        econom_place_price.setBounds(100, 250, 200, 20);

        JLabel business_place_price = new JLabel("business_place_price :");
        business_place_price.setBounds(100, 300, 200, 20);

        //Long id,int aircraft_id,int departure_city_id,int arrival_city_id,String departure_time,int econom_place_price,int business_place_price

        JTextField aircraft_id_field = new JTextField();
        aircraft_id_field.setBounds(300, 50, 150, 35);

        JTextField departure_city_id_field = new JTextField();
        departure_city_id_field.setBounds(300, 100, 150, 35);

        JTextField arrival_city_id_field = new JTextField();
        arrival_city_id_field.setBounds(300, 150, 150, 35);

        JTextField departure_time_field = new JTextField();
        departure_time_field.setBounds(300, 200, 150, 35);


        JTextField econom_place_price_field = new JTextField();
        econom_place_price_field.setBounds(300, 250, 150, 35);

        JTextField business_place_price_field = new JTextField();
        business_place_price_field.setBounds(300, 300, 150, 35);


        JButton add_button = new JButton();
        add_button.setText("ADD");
        add_button.setForeground(Color.white);
        add_button.setBounds(100, 350, 130, 35);
        add_button.setBackground(new Color(153, 153, 153));
        add_button.setFocusable(false);
        add_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int check_function = 1;

                    int arrival_city_id = 0;
                    if (!(arrival_city_id_field.getText().isEmpty())) {
                        arrival_city_id = Integer.parseInt(arrival_city_id_field.getText());
                    }
                    String departure_time = departure_time_field.getText();
                    int econom_place_price = 0;
                    if (!(econom_place_price_field.getText().isEmpty())) {
                        econom_place_price = Integer.parseInt(econom_place_price_field.getText());
                    }
                    int business_place_price = 0;
                    if (!(business_place_price_field.getText().isEmpty())) {
                        business_place_price = Integer.parseInt(business_place_price_field.getText());
                    }

                    int aircraft_id = 0;
                    if (!(aircraft_id_field.getText().isEmpty())) {
                        aircraft_id = Integer.parseInt(aircraft_id_field.getText());
                    }
                    int departure_city_id = 0;
                    if (!(departure_city_id_field.getText().isEmpty())) {
                        departure_city_id = Integer.parseInt(departure_city_id_field.getText());
                    }


                    if (!(departure_time.isEmpty()) && (aircraft_id != 0) && (departure_city_id != 0) && (business_place_price != 0) && (econom_place_price != 0) && (arrival_city_id != 0)) {
                        Flights flight = new Flights(null, aircraft_id, departure_city_id, arrival_city_id, departure_time, econom_place_price, business_place_price);
                        PackageData pfd = new PackageData();
                        pfd.setOperationType("ADD_FLIGHTS");
                        pfd.flight = flight;
                        os.writeObject(pfd);
                        System.out.println("New flight sent!");

                        PackageData response_pd = null;
                        if ((response_pd = (PackageData) is.readObject()) != null) {
                            if (response_pd.aircrafts != null) {
                                for (int i = 0; i < response_pd.aircrafts.size(); i++) {
                                    Long aircraft_ID = response_pd.aircrafts.get(i).getId();
                                    int aircraAft_ID = Integer.parseInt(String.valueOf(aircraft_ID));
                                    if (aircraAft_ID == aircraft_id) {
                                        check_function++;
                                        aircraft_id_field.setText("");
                                        departure_city_id_field.setText("");
                                        arrival_city_id_field.setText("");
                                        departure_time_field.setText("");
                                        econom_place_price_field.setText("");
                                        business_place_price_field.setText("");

                                    }
                                }
                            }
                        }
                        if (check_function == 1) {
                            JOptionPane.showMessageDialog(null, "Doesn't exist aircraft with current id!", "error", JOptionPane.WARNING_MESSAGE);
                        }
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
        back_button.setBounds(270, 350, 130, 35);
        back_button.setBackground(new Color(153, 153, 153));
        back_button.setFocusable(false);
        back_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame plane_function = new JFrame("ADMIN APPLICATION/FLIGHT");
                add_frame.setVisible(false);
                main_frame(plane_function);
                try {
                    flights_functions(plane_function, socket, os, is);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                plane_function.setVisible(true);
            }
        });
        //Long id,int aircraft_id,int departure_city_id,int arrival_city_id,String departure_time,int econom_place_price,int business_place_price

        add_frame.add(aircraft_id);
        add_frame.add(departure_city_id);
        add_frame.add(arrival_city_id);
        add_frame.add(departure_time);
        add_frame.add(econom_place_price);
        add_frame.add(business_place_price);
        add_frame.add(aircraft_id_field);
        add_frame.add(departure_city_id_field);
        add_frame.add(arrival_city_id_field);
        add_frame.add(departure_time_field);
        add_frame.add(econom_place_price_field);
        add_frame.add(business_place_price_field);
        add_frame.add(add_button);
        add_frame.add(back_button);

    }

    //Long id,int aircraft_id,int departure_city_id,int arrival_city_id,String departure_time,int econom_place_price,int business_place_price
    public void list_frame_flight(JFrame list_frame, Socket socket, ObjectOutputStream os, ObjectInputStream is) {

        try {

            PackageData data = new PackageData();
            PackageData response_pd = null;
            data.setOperationType("LIST_FLIGHTS");
            os.writeObject(data);
            if ((response_pd = (PackageData) is.readObject()) != null) {

                Object columName[] = {"aircraft_id", "departure_city_id", "arrival_city_id ", "departure_time", "econom_place_price", "business_place_price"};
                Object tableData[][] = new Object[response_pd.flights.size()][6];
                for (int i = 0; i < response_pd.flights.size(); i++) {

                    tableData[i][0] = response_pd.flights.get(i).getAircraft_id();
                    tableData[i][1] = response_pd.flights.get(i).getDeparture_city_id();
                    tableData[i][2] = response_pd.flights.get(i).getArrival_city_id();
                    tableData[i][3] = response_pd.flights.get(i).getDeparture_time();
                    tableData[i][4] = response_pd.flights.get(i).getEconom_place_price();
                    tableData[i][5] = response_pd.flights.get(i).getBusiness_place_price();


                }

                list_frame.getContentPane().setLayout(new FlowLayout());
                JTable table_flight = new JTable(tableData, columName);
                JScrollPane sp = new JScrollPane(table_flight);
                table_flight.setPreferredScrollableViewportSize(new Dimension(400, 300));
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
                JFrame plane_function_page = new JFrame("");
                main_frame(plane_function_page);
                try {
                    flights_functions(plane_function_page, socket, os, is);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                plane_function_page.setVisible(true);
            }
        });

        list_frame.add(back_button);

    }


//

    public void flights_delete(JFrame delete_frame, Socket socket, ObjectOutputStream os, ObjectInputStream is) {

        JLabel id = new JLabel("ID:");
        id.setBounds(100, 150, 50, 20);

        JTextField ID_field = new JTextField();
        ID_field.setBounds(250, 150, 150, 35);

        JButton delete_button = new JButton();
        delete_button.setText("DELETE");
        delete_button.setForeground(Color.white);
        delete_button.setBounds(100, 350, 130, 35);
        delete_button.setBackground(new Color(22, 219, 232));
        delete_button.setFocusable(false);
        delete_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {


                    PackageData data = new PackageData();
                    data.setOperationType("DELETE_FLIGHTS");
                    int check_function = 1;
                    String id_string = "0";

                    Long id = Long.parseLong(id_string);
                    if (!(ID_field.getText().isEmpty())) {
                        id = Long.parseLong(ID_field.getText());
                        Flights flights = new Flights(id, 0, 0, 0, null, 0, 0);
                        data.flight = flights;
                        os.writeObject(data);


                    }

                    if (id != 0) {
                        PackageData response_pd = null;
                        if ((response_pd = (PackageData) is.readObject()) != null) {
                            if (response_pd.flights != null) {
                                for (int i = 0; i < response_pd.flights.size(); i++) {
                                    Long ID = response_pd.flights.get(i).getId();
                                    if (ID.equals(id)) {
                                        check_function++;
                                        ID_field.setText("");
                                    }
                                }
                            }
                        }
                        if (check_function == 1) {
                            JOptionPane.showMessageDialog(null, "Doesn't exist flight with current id!", "error", JOptionPane.WARNING_MESSAGE);
                        }
                    } else {
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
        back_button.setBounds(270, 350, 130, 35);
        back_button.setBackground(new Color(153, 153, 153));
        back_button.setFocusable(false);
        back_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame plane_page = new JFrame("ADMIN APPLICATION/PLANE");
                delete_frame.setVisible(false);
                main_frame(plane_page);
                try {
                    flights_functions(plane_page, socket, os, is);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                plane_page.setVisible(true);
            }
        });
        delete_frame.add(back_button);
        delete_frame.add(delete_button);
        delete_frame.add(id);
        delete_frame.add(ID_field);
    }


    public void flight_update_page(JFrame update_frame, Socket socket, ObjectOutputStream os, ObjectInputStream is) {
        JLabel id = new JLabel("id:");
        id.setBounds(100, 50, 100, 20);

        JLabel aircraft_id = new JLabel("aircraft_id:");
        aircraft_id.setBounds(100, 100, 100, 20);

        JLabel departure_city_id = new JLabel("departure_city_id:");
        departure_city_id.setBounds(100, 150, 150, 20);

        JLabel arrival_city_id = new JLabel("arrival_city_id :");
        arrival_city_id.setBounds(100, 200, 100, 20);

        JLabel departure_time = new JLabel("departure_time :");
        departure_time.setBounds(100, 250, 100, 20);

        JLabel econom_place_price = new JLabel("econom_place_price :");
        econom_place_price.setBounds(100, 300, 200, 20);

        JLabel business_place_price = new JLabel("business_place_price :");
        business_place_price.setBounds(100, 350, 200, 20);

        //Long id,int aircraft_id,int departure_city_id,int arrival_city_id,String departure_time,int econom_place_price,int business_place_price
        JTextField id_field = new JTextField();
        id_field.setBounds(300, 50, 150, 35);

        JTextField aircraft_id_field = new JTextField();
        aircraft_id_field.setBounds(300, 100, 150, 35);

        JTextField departure_city_id_field = new JTextField();
        departure_city_id_field.setBounds(300, 150, 150, 35);

        JTextField arrival_city_id_field = new JTextField();
        arrival_city_id_field.setBounds(300, 200, 150, 35);

        JTextField departure_time_field = new JTextField();
        departure_time_field.setBounds(300, 250, 150, 35);


        JTextField econom_place_price_field = new JTextField();
        econom_place_price_field.setBounds(300, 300, 150, 35);

        JTextField business_place_price_field = new JTextField();
        business_place_price_field.setBounds(300, 350, 150, 35);


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


                    int check_function = 1;
                    String id_long = "0";
                    Long id = Long.parseLong(id_long);

                    int arrival_city_id = 0;
                    if (!(arrival_city_id_field.getText().isEmpty())) {
                        arrival_city_id = Integer.parseInt(arrival_city_id_field.getText());
                    }
                    String departure_time = departure_time_field.getText();
                    int econom_place_price = 0;
                    if (!(econom_place_price_field.getText().isEmpty())) {
                        econom_place_price = Integer.parseInt(econom_place_price_field.getText());
                    }
                    int business_place_price = 0;
                    if (!(business_place_price_field.getText().isEmpty())) {
                        business_place_price = Integer.parseInt(business_place_price_field.getText());
                    }

                    int aircraft_id = 0;
                    if (!(aircraft_id_field.getText().isEmpty())) {
                        aircraft_id = Integer.parseInt(aircraft_id_field.getText());
                    }
                    int departure_city_id = 0;
                    if (!(departure_city_id_field.getText().isEmpty())) {
                        departure_city_id = Integer.parseInt(departure_city_id_field.getText());
                    }   
                    if (!(id_field.getText().isEmpty())) {
                        id = Long.parseLong(id_field.getText());
                        Flights flight = new Flights(id, aircraft_id, departure_city_id, arrival_city_id, departure_time, econom_place_price, business_place_price);
                        PackageData pfd = new PackageData();
                        pfd.setOperationType("UPDATE_FLIGHTS");
                        pfd.flight = flight;
                        os.writeObject(pfd);


                    }

                    if ((id != 0) && !(departure_time.isEmpty()) && (aircraft_id != 0) && (departure_city_id != 0) && (business_place_price != 0) && (econom_place_price != 0) && (arrival_city_id != 0)) {

                        PackageData response_pd = null;
                        if ((response_pd = (PackageData) is.readObject()) != null) {
                            if (response_pd.flights != null) {
                                for (int i = 0; i < response_pd.flights.size(); i++) {
                                    Long ID = response_pd.flights.get(i).getId();

                                    if (ID.equals(id)) {
                                        check_function++;
                                        id_field.setText("");
                                        aircraft_id_field.setText("");
                                        departure_city_id_field.setText("");
                                        arrival_city_id_field.setText("");
                                        departure_time_field.setText("");
                                        econom_place_price_field.setText("");
                                        business_place_price_field.setText("");

                                    }
                                }
                            }
                        }
                        if (check_function == 1) {
                            JOptionPane.showMessageDialog(null, "Doesn't exist aircraft with current id!", "error", JOptionPane.WARNING_MESSAGE);
                        }
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
                JFrame update_frame = new JFrame("ADMIN APPLICATION/FLIGHT");
                update_frame.setVisible(false);
                main_frame(update_frame);
                try {
                    flights_functions(update_frame, socket, os, is);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                update_frame.setVisible(true);
            }
        });
        update_frame.add(id);
        update_frame.add(id_field);
        update_frame.add(aircraft_id);
        update_frame.add(departure_city_id);
        update_frame.add(arrival_city_id);
        update_frame.add(departure_time);
        update_frame.add(econom_place_price);
        update_frame.add(business_place_price);
        update_frame.add(aircraft_id_field);
        update_frame.add(departure_city_id_field);
        update_frame.add(arrival_city_id_field);
        update_frame.add(departure_time_field);
        update_frame.add(econom_place_price_field);
        update_frame.add(business_place_price_field);
        update_frame.add(update_button);
        update_frame.add(back_button);
    }
}