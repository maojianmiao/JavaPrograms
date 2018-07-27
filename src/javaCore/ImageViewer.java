package javaCore;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.awt.EventQueue;

public class ImageViewer {

}

class ImageViewerFrame extends JFrame
{
	public ImageViewerFrame(){
		setTitle("ImageViewer");
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		
		label = new JLabel();
		add(label);
		
		chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("."));
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("File");
		
		menuBar.add(menu);
		
		JMenuItem openItem = new JMenuItem("Open");
		menu.add(openItem);
		
		openItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				int result = chooser.showOpenDialog(null);
				
				if (result == JFileChooser.APPROVE_OPTION){
					String name = chooser.getSelectedFile().getPath();
					label.setIcon(new ImageIcon(name));
				}
			}
		});
		
		JMenuItem exitItem = new JMenuItem("Exit");
		menu.add(exitItem);
		
		exitItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				System.exit(0);
			}
		});
		
	}
	private JLabel label;
	private JFileChooser chooser;
	private static final int DEFAULT_WIDTH=300;
	private static final int DEFAULT_HEIGHT= 400;
}