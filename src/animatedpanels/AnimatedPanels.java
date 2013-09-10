
package animatedpanels;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author marck
 */
public class AnimatedPanels implements ActionListener, KeyListener {
    static JFrame frame = new JFrame("Animated Panels");
    static JFrame alertframe = new JFrame("Error Message");
    static JPanel mainpanel = new JPanel();
    static JPanel alertpanel = new JPanel();
    static JPanel [] panels = new JPanel[5];
    static AnimatedPanels animate = new AnimatedPanels();
    static Thread animator = null;
    static JTextField txtfield = new JTextField();
    static JTextField txtfield2 = new JTextField();
    static JButton btn=new JButton();
    static JButton alertbtn=new JButton();
    static JLabel lbl=new JLabel("Selected Panel:");
    static JLabel alertlbl=new JLabel("Invalid Input!");
    static JLabel alertlbl2=new JLabel("Out Of Range Input!");
    static JButton button=new JButton();
    static JCheckBox chkbox=new JCheckBox();
    static JComboBox cmbox=new JComboBox();
    static JRadioButton rdbutton= new JRadioButton();
    static JToggleButton tgbutton=new JToggleButton();
    static int current=0;
    
    
    public static void main(String[] args) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(600, 600);
        frame.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width / 2) - (600 / 2),
            (Toolkit.getDefaultToolkit().getScreenSize().height / 2) - (600 / 2));
        frame.add(mainpanel);
        mainpanel.setLayout(null);
        mainpanel.add(btn);
        btn.setText("Create Panels");
        btn.setBounds(150, 10, 120, 30);
        btn.addActionListener(animate);
        btn.setName("button");
        btn.setFocusable(false);
        mainpanel.add(txtfield);
        txtfield.setText(null);
        txtfield.setBounds(20, 10, 120, 30);
        mainpanel.add(txtfield2);
        txtfield2.setBounds(150, 50, 40, 30);
        txtfield2.setEditable(false);
        mainpanel.add(lbl);
        lbl.setBounds(40, 50, 120, 30);
        lbl.addKeyListener(animate);
        txtfield2.addKeyListener(animate);
        button.setText("ok");
        button.setFocusable(false);
        chkbox.setFocusable(false);
        cmbox.setFocusable(false);
        rdbutton.setFocusable(false);
        tgbutton.setFocusable(false);
        tgbutton.setText("Marck");
        alertframe.add(alertpanel);
        alertpanel.setLayout(null);
        alertframe.setLocation(520, 200);
        alertframe.setSize(250, 100);
        alertframe.setResizable(false);
        alertpanel.add(alertbtn);
        alertpanel.add(alertlbl);
        alertpanel.add(alertlbl2);
        alertlbl.setBounds(85, 10, 90,40);
        alertlbl2.setBounds(68, 30, 150,40);
        alertlbl.setVisible(false);
        alertlbl2.setVisible(false);
        frame.setVisible(true); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if(btn.getName().equals("button"))
        {
            String txtInput=txtfield.getText();
            if(wordCheck(txtInput))
            {
                alertlbl.setVisible(true);
                alertlbl2.setVisible(false);
                alertframe.setVisible(true);
            }
            else
            {
            int input=Integer.parseInt(txtInput);
            if(input > 5)
            {
                alertlbl.setVisible(true);
                alertlbl2.setVisible(true);
                alertframe.setVisible(true);
            }
            else
            {
            System.out.println("Button Pressed");
            txtfield.setVisible(false);
            btn.setVisible(false);
            createPanel(input);
            }
            }
        } 
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        if (ke.getKeyChar() == KeyEvent.VK_SPACE)
            {
                String txtInput=txtfield.getText();
                int input=Integer.parseInt(txtInput);
                if(current>=input)
                {
                    current=0;
                }
                clearPanels(input);
                JPanel pane = panels[current++];
                pane.setBackground(Color.RED);
                pane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                txtfield2.setText(" "+current);
            }
        else if (ke.getKeyChar() == 'w')
            {
                animator = null;
                final int curr=current-1;
                if (animator == null)
                    {
                        animator = new Thread()
                        {
                            public void run()
                            {
                                JPanel pane = panels[curr];
                                for (int i = 0; i < 200; i++)
                                {
                                    pane.setBounds(pane.getX(), pane.getY() - 1, pane.getWidth(), pane.getHeight());
                                    try {
                                        Thread.sleep(10);
                                        } catch (Exception ex) {}
                                }
                            }
                        };
                    animator.start();
                    }
            }
        else if (ke.getKeyChar() == 's')
            {
                animator = null;
                final int curr=current-1;
                if (animator == null)
                    {
                        animator = new Thread()
                        {
                            public void run()
                            {
                                JPanel pane = panels[curr];
                                for (int i = 0; i < 200; i++)
                                {
                                    pane.setBounds(pane.getX(), pane.getY() + 1, pane.getWidth(), pane.getHeight());
                                    try {
                                        Thread.sleep(10);
                                        } catch (Exception ex) {}
                                }
                            }
                        };
                    animator.start();
                    }
            }
        else if (ke.getKeyChar() == 'd')
            {
                animator = null;
                final int curr=current-1;
                if (animator == null)
                    {
                        animator = new Thread()
                        {
                            public void run()
                            {
                                JPanel pane = panels[curr];
                                for (int i = 0; i < 200; i++)
                                {
                                    pane.setBounds(pane.getX()+1, pane.getY() , pane.getWidth() , pane.getHeight());
                                    try {
                                        Thread.sleep(10);
                                        } catch (Exception ex) {}
                                }
                            }
                        };
                    animator.start();
                    }
            }
        else if (ke.getKeyChar() == 'a')
            {
                animator = null;
                final int curr=current-1;
                if (animator == null)
                    {
                        animator = new Thread()
                        {
                            public void run()
                            {
                                JPanel pane = panels[curr];
                                for (int i = 0; i < 200; i++)
                                {
                                    pane.setBounds(pane.getX()-1, pane.getY() , pane.getWidth(), pane.getHeight());
                                    try {
                                        Thread.sleep(10);
                                        } catch (Exception ex) {}
                                }
                            }
                        };
                    animator.start();
                    }
            }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void createPanel(int input) 
    {
        int i;
        for (i = 0; i < input; i++) 
        {
            panels[i] = new JPanel();
            panels[i].setBounds(i * 90, 150, 80, 40);
            panels[i].setBackground(Color.WHITE);
            panels[i].setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            mainpanel.add(panels[i]);
            panels[i].addKeyListener(animate); 
        }
        if(input==1)
        {
        for (i = 0; i < 1; i++) 
        {
            panels[i].add(button);
        }
        }
        else if(input==2)
            {
                for (i = 0; i < 1; i++) 
                {
                    panels[i].add(button);
                }
                for (i = 0; i < 2; i++) 
                {
                    panels[i].add(chkbox);
                }
            }
        else if(input==3)
        {
            for (i = 0; i < 1; i++) 
                {
                    panels[i].add(button);
                }
            for (i = 0; i < 2; i++) 
                {
                    panels[i].add(chkbox);
                }
            for (i = 0; i < 3; i++) 
                {
                    panels[i].add(cmbox);
                }
        }
        else if(input==4)
        {
            for (i = 0; i < 1; i++) 
                {
                    panels[i].add(button);
                }
            for (i = 0; i < 2; i++) 
                {
                    panels[i].add(chkbox);
                }
            for (i = 0; i < 3; i++) 
                {
                    panels[i].add(cmbox);
                } 
            for (i = 0; i < 4; i++) 
                {
                    panels[i].add(rdbutton);
                } 
        }
        else if(input==5)
        {
            for (i = 0; i < 1; i++) 
                {
                    panels[i].add(button);
                }
            for (i = 0; i < 2; i++) 
                {
                    panels[i].add(chkbox);
                }
            for (i = 0; i < 3; i++) 
                {
                    panels[i].add(cmbox);
                } 
            for (i = 0; i < 4; i++) 
                {
                    panels[i].add(rdbutton);
                } 
            for (i = 0; i < 5; i++) 
                {
                    panels[i].add(tgbutton);
                }
        }
        System.out.println("Make Panels : Done");
        System.out.print("Number Of Panels: "+ input);
        mainpanel.updateUI();
    }
    public static void clearPanels(int erase) 
    {
        for (int i = 0; i < erase; i++)
        {
            panels[i].setBackground(Color.WHITE);
            panels[i].setBorder(BorderFactory.createLineBorder(Color.RED, 2));
        }
    }
    public static boolean wordCheck(String input)
    {
        boolean in=false;
        int loop;
        char inputar[]=input.toCharArray();
        for(loop=0;loop<input.length();loop++)
        {
            if(!(inputar[loop]>=(int)'0' && inputar[loop]<=(int)'9'))
            {
                in=true;
            }
            
        }
        return(in);
    }
}
