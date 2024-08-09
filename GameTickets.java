/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Alex
 */
public class GameTickets extends JFrame
{
    private JPanel mainPanel;
    private JPanel headingPanel;
    private JPanel namePanel;
    private JPanel surnamePanel;
    private JPanel nameAnemUsernamePnel;
    private JPanel customerDetailsPanel;
    private JPanel homeTeamPanel;
    private JPanel awyaTeamPnel;
    private JPanel costPricePanel;
    private JPanel numOfTicketsPanel;
    private JPanel totalPricePanel;
    private JPanel tickesDetailsPanel;
    private JPanel buttonPanel;
    
    private JLabel headingLabel;
    private JLabel nameLabel;
    private JLabel surnameLabel;
    private JLabel homeTeamLabel;
    private JLabel awayTeamLabel;
    private JLabel costPriceLabel;
    private JLabel numOfTicketsLabel;
    private JLabel totalPriceLabel;
    
    private JTextField nameFiled;
    private JTextField surnameFiled;
    private JTextField hometeamFiled;
    private JTextField awayTeamFiled;
    private JTextField costPriceFiled;
    private JTextField totalPriceFiled;
    
    private JSlider numberOfTicksSlider;
    
    private JButton buyBtns;
    private JButton clearBtns;
    private JButton exitBtns;
    
    public GameTickets()
    {
     //creating fram
        setSize(500, 600);
        setLayout(new FlowLayout());
        setTitle("Tickets sales");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
     headingPanel = new JPanel( new FlowLayout());   
     mainPanel = new JPanel(new GridLayout(2,1));
     namePanel  = new JPanel(new FlowLayout(FlowLayout.LEFT) );
     surnamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
     nameAnemUsernamePnel = new JPanel( new FlowLayout());
     customerDetailsPanel = new JPanel( new GridLayout(2,1,1,1));
     customerDetailsPanel.setBorder(new TitledBorder(new LineBorder(Color.BLUE,2),"Customer details"));
     
     homeTeamPanel = new JPanel( new FlowLayout(FlowLayout.LEFT));
     awyaTeamPnel = new JPanel( new FlowLayout(FlowLayout.LEFT));
     costPricePanel = new JPanel( new FlowLayout(FlowLayout.LEFT));
     numOfTicketsPanel = new JPanel( new FlowLayout(FlowLayout.LEFT));
     totalPricePanel = new JPanel( new FlowLayout(FlowLayout.LEFT));
     tickesDetailsPanel = new JPanel( new GridLayout(5,1,1,1));
     tickesDetailsPanel.setBorder(new TitledBorder(new LineBorder(Color.BLUE,2),"Customer details"));
     buttonPanel = new JPanel(new FlowLayout());
     
     headingLabel = new JLabel("Soccer Match Tickets");
     headingLabel.setFont(new Font(Font.SERIF,Font.ITALIC+Font.BOLD,50));
     headingLabel.setForeground(Color.CYAN);
     nameLabel = new JLabel("Name:       ");
     surnameLabel = new JLabel("Surname: ");
     homeTeamLabel = new JLabel("Home team:     ");
     awayTeamLabel = new JLabel("Away team:      ");
     costPriceLabel = new JLabel("Cost price:    R");
     numOfTicketsLabel = new JLabel("Number of tickets required");
     totalPriceLabel = new JLabel("Total amount due: R");
//fields
     nameFiled = new JTextField(10);
     surnameFiled = new JTextField(10);
     hometeamFiled = new JTextField(10);
     awayTeamFiled = new JTextField(10);
     costPriceFiled = new JTextField(10);
     totalPriceFiled = new JTextField(20);
     totalPriceFiled.setText("To be calculated later. ");
     totalPriceFiled.setForeground(Color.gray);
     totalPriceFiled.setBackground(Color.LIGHT_GRAY);
//slider
       numberOfTicksSlider = new JSlider(1,20,10);
     numberOfTicksSlider.setMinorTickSpacing(1);
     numberOfTicksSlider.setPaintTicks(true);
     numberOfTicksSlider.setPaintLabels(true);
//buttons 
     buyBtns = new JButton("Buy");
     clearBtns = new JButton("Clear");
     exitBtns = new JButton("Exit");
     buyBtns.addActionListener(new ButtonAction());
     clearBtns.addActionListener(new ButtonAction());
     exitBtns.addActionListener(new ButtonAction());
     
//panel
    headingPanel.add(headingLabel);
    namePanel.add(nameLabel);
    namePanel.add(nameFiled);
    surnamePanel.add(surnameLabel);
    surnamePanel.add(surnameFiled);
    customerDetailsPanel.add(namePanel);
    customerDetailsPanel.add(surnamePanel);
    
    homeTeamPanel.add(homeTeamLabel);
    homeTeamPanel.add(hometeamFiled);
    awyaTeamPnel.add(awayTeamLabel);
    awyaTeamPnel.add(awayTeamFiled);
    costPricePanel.add(costPriceLabel);
    costPricePanel.add(costPriceFiled);
    numOfTicketsPanel.add(numOfTicketsLabel);
    numOfTicketsPanel.add(numberOfTicksSlider);
    totalPricePanel.add(totalPriceLabel);
    totalPricePanel.add(totalPriceFiled);
    
    tickesDetailsPanel.add(homeTeamPanel);
    tickesDetailsPanel.add(awyaTeamPnel);
    tickesDetailsPanel.add(costPricePanel);
    tickesDetailsPanel.add(numOfTicketsPanel);
    tickesDetailsPanel.add(totalPricePanel);
    
    buttonPanel.add(buyBtns);
    buttonPanel.add(clearBtns);
    buttonPanel.add(exitBtns);
     
     add(headingPanel, BorderLayout.NORTH);
     mainPanel.add(customerDetailsPanel,BorderLayout.CENTER);
     mainPanel.add(tickesDetailsPanel,BorderLayout.SOUTH);
     add(mainPanel);
     add(buttonPanel);
    setVisible(true);
        
    }
   private class ButtonAction implements ActionListener
   {

        @Override
        public void actionPerformed(ActionEvent e)
        {
         if(e.getSource() == buyBtns)
         {
             int number = numberOfTicksSlider.getValue();
            String name = nameFiled.getText();
            String surname = surnameFiled.getText();
            String homeTame = hometeamFiled.getText();
            String awayTeam = awayTeamFiled.getText();
            String cost = costPriceFiled.getText();
            double price = Double.parseDouble(cost);
            
            double totalPrice = number*price;
            String message = "\bINVOICE\b\nName: "+name+"\nSurname: "+surname+"\n"
                    + "Home team:"+ homeTame+"\nAway team: "+awayTeam+"\n"
                    + "Number of tickets: "+number+"\nCost per Ticket:R "+cost+"\n"
                    + "Total amount to pay: R"+totalPrice;
            
            JOptionPane.showMessageDialog(GameTickets.this, message);
            
         }
         else if(e.getSource() == clearBtns)
         {
             nameFiled.setText("");
             surnameFiled.setText("");
             hometeamFiled.setText("");
             awayTeamFiled.setText("");
             costPriceFiled.setText("");
             totalPriceFiled.setText("");

         }
         else if(e.getSource() == exitBtns)
         {
             System.exit(0);
         }
        }
       
   }
    
}
