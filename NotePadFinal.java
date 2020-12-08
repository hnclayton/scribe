import java.lang.Object;
import java.awt.Desktop;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JEditorPane;
import javax.swing.JToolBar;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.text.StyledEditorKit;
import javax.swing.text.html.HTMLEditorKit;
import java.net.*;
import java.io.File;
import java.io.FileWriter;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JTextArea;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.*;
import java.awt.print.PrinterException;
import javax.swing.JFileChooser;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.util.Scanner;
import java.io.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Computer Room
 *///when ready add Action Listener to Notes.
public class NotePadFinal extends JFrame implements ActionListener {
    File file;
    Scanner fileIn;
    int response;
    String response2;
      
        
private static JMenuBar menubar;
private static JMenu file1,format, todolist;
private static JTextArea textarea;
private static JMenuItem save,font,size,bold;
private  JScrollPane pane;
private static JTextField textfield;
private static JButton open;
private static JButton button1;
private static JButton button2;
private static JButton button3;
private static JButton button4;
private static JButton button5;
private static JButton save1;
private static JLabel success;
private static JLabel balance;
    JFileChooser chooser=new JFileChooser("");
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        JPanel panel=new JPanel();
       
        JFrame frame=new JFrame();
        
              
        panel.setLayout(null);
        //***************Menu Bar Items************************//
       JMenuBar menubar = new JMenuBar();// create a Menu Bar
       
       JMenu file1= new JMenu("File");// new Item on menu bar
       menubar.add(file1);
       
       JMenu todo=new JMenu("To Do List");// new Item on menu bar
       menubar.add(todo);
       
       JButton button= new JButton("Printer");// add a button to check spelling.
       button.setBounds(2, 10, 20, 20);
       button.addActionListener(new NotePadFinal());
       menubar.add(button);
       
       
       JTextField text= new JTextField("Type to search");// add a text field to type whatever the user wants to search on the web.
       text.setBounds(2,2,2, 2);
       menubar.add(text);
       
       JButton button1= new JButton("Search");// takes the information on the text field and searches the web.
       button1.setBounds(2, 10, 20, 20);
       button1.addActionListener(new NotePadFinal());
       menubar.add(button1);
       
        //****************adding the text area*************************************************************\\
     textarea =new JTextArea();
        
        panel.add(textarea);
        
        //********************start of Editor Pane********************///
       JEditorPane editorPane = new JEditorPane();
        editorPane.setContentType("Text");
        editorPane.setEditorKit(new HTMLEditorKit());
        editorPane.setText("Start Text Here!");
        
        
       
        JToolBar bar = new JToolBar();
        bar.add(new StyledEditorKit.ForegroundAction("Pink", Color.pink));        
        bar.add(new StyledEditorKit.ForegroundAction("Blue", Color.blue));
        bar.add(new StyledEditorKit.ForegroundAction("Green", Color.green));
        bar.add(new StyledEditorKit.ForegroundAction("Gray", Color.gray));
        bar.add(new StyledEditorKit.FontSizeAction("12", 12));
        bar.add(new StyledEditorKit.FontSizeAction("18", 18));
        bar.add(new StyledEditorKit.FontSizeAction("24", 24));
        bar.add(new StyledEditorKit.FontFamilyAction("Sans-Serif", "sans-serif"));
        bar.add(new StyledEditorKit.FontFamilyAction("Serif", "serif"));
        bar.add(new StyledEditorKit.FontFamilyAction("Monospace", "monospace"));
        bar.add(new StyledEditorKit.BoldAction());
        
        frame.setLocationRelativeTo(null);
        frame.add(bar, BorderLayout.NORTH);
        frame.add(editorPane, BorderLayout.CENTER);
        frame.pack();
        
        frame.setVisible(true);
        frame.setSize(700,800);//set the frame dimmensions)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
       
       //*********************Sub_Menu Items******************//
       JButton open= new JButton("Open FIle");// new Item inside of "file"
       open.addActionListener(new NotePadFinal());
       file1.add(open);
       
       JMenuItem upcoming=new JMenuItem("Upcoming Assignment");//new Item inside of "To Do List"
       file1.add(upcoming);
       
       JButton save1= new JButton("Save File");// new Item inside of "file"
       save1.addActionListener(new NotePadFinal());
      file1.add(save1);
      
       JMenuItem addit=new JMenuItem("Add Event");//new Item inside of "To Do List"
       todo.add(addit);
       
       JMenuItem calendar=new JMenuItem("Calendar");//new Item inside of "To Do List"
       todo.add(calendar);
       
       
       
       frame.setJMenuBar(menubar);
     
      
             
            
       
        //*************************adding the scroll pane************************************************\\
         JScrollPane pane = new JScrollPane(textarea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
         frame.add(pane);
        
         frame.setVisible(true);//**********setting the frame visible.
        
       
    }
     public void actionPerformed(ActionEvent e)
        
      {String cmd=e.getActionCommand();
        System.out.println(cmd);
        
        
        //*****************Open file Action*******************************//
        if(cmd=="Open FIle")
        { 
            chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        response= chooser.showOpenDialog(null);
        
        if (response==JFileChooser.APPROVE_OPTION)
         {
       File f=chooser.getSelectedFile();
       String filename=f.getAbsolutePath();
       
       try {
           FileReader reader= new FileReader(filename);
           BufferedReader br=new BufferedReader(reader);
           textarea.read(br, null);
           br.close();
           textarea.requestFocus();
           
           }
        catch(Exception p)
            
            {
            JOptionPane.showMessageDialog(null,p);
            }
         }
        }
        
        //********************start of Save File Action********************///
         if(cmd=="Save FIle")
        { 
           chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        response= chooser.showSaveDialog(null);
        }
         //********************start of Printer Action********************///
       if(cmd=="Printer")
               try
               {
               boolean complete= textarea.print();
               if(complete)
               {
               JOptionPane.showMessageDialog(null,JOptionPane.INFORMATION_MESSAGE);
               }
               else
               {JOptionPane.showMessageDialog(null, JOptionPane.ERROR_MESSAGE);
               
               }    
               }catch(PrinterException k)
                       {JOptionPane.showMessageDialog(null, k);
                         }
       //********************start of Search Action********************///
        if(cmd=="Search")
                  {try 
                  {   Desktop.getDesktop().browse(new URL("http://www.google.com").toURI());
                    } catch (Exception u) {}}
       
       
    }
        
        
}