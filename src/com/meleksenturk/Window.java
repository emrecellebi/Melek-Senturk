package com.meleksenturk;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class Window extends JFrame implements ActionListener
{
	private List<Integer> data = null;
	private Date date;
	private JButton btnStart;
	private JButton btnRestart;
	private JTextArea log;
	private JScrollPane logScroll;
	
	public Window()
	{
		if(data == null) data = new ArrayList<Integer>();
		for(int i = 1; i <= 5; i++) data.add(0);
		
		date = new Date();
		btnStart = new JButton();
		btnRestart = new JButton();
		log = new JTextArea();
		logScroll = new JScrollPane(log);
		
		JButtonInit();
		JTextAreaInit();
		JFrameInit();
	}
	
	private void JButtonInit()
	{
		/************** btnStart **************/
		btnStart.setBounds(10, 550, 200, 50);
		btnStart.setText("Start");
		btnStart.setFont(new Font("Arial", Font.BOLD, 17));
		btnStart.addActionListener(this);
		add(btnStart);
		
		/************** btnRestart **************/
		btnRestart.setBounds(800, 550, 200, 50);
		btnRestart.setText("Restart");
		btnRestart.setFont(new Font("Arial", Font.BOLD, 17));
		btnRestart.addActionListener(this);
		add(btnRestart);
	}
	
	private void JTextAreaInit()
	{
		/************ log ************/
		logScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		logScroll.setBounds(10, 10, 990, 500);
		log.setFont(new Font("Arial", Font.PLAIN, 20));
		log.setEditable(false);
		add(logScroll);
	}
	
	private void JFrameInit()
	{
		setTitle("Melek Senturk");
		setSize(1024, 720);
		setResizable(false);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new Window();
	}
	
	/*** Events ***/
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == btnStart)
		{
			threads();
		}
		
		if(e.getSource() == btnRestart)
		{
			log.setText("");
			log.setCaretPosition(log.getDocument().getLength());
			log.update(log.getGraphics());
			data = new ArrayList<Integer>();
			for(int i = 1; i <= 5; i++) data.add(0);
		}
	}
	
	private void threads()
	{
		Thread t1 = new Thread("Reader-1"){
			@Override
			public void run()
			{
				for(int i = 1; i <= 5; i++)
				{
					reader(Thread.currentThread().getName());
					try{Thread.sleep(50);}catch(Exception e){};
				}
			}
		};
		t1.start();
		
		Thread t2 = new Thread("Reader-2"){
			@Override
			public void run()
			{
				for(int i = 1; i <= 5; i++)
				{
					reader(Thread.currentThread().getName());
					try{Thread.sleep(50);}catch(Exception e){};
				}
			}
		};
		t2.start();
		
		/************************************************/
		Thread t3 = new Thread("Writer-1"){
			@Override
			public void run()
			{
				for(int a = 1; a <= 5; a++)
				{
					writer(Thread.currentThread().getName(), a);
					try{Thread.sleep(50);}catch(Exception e){};
				}
			}
		};
		t3.start();
		
		Thread t4 = new Thread("Writer-2"){
			@Override
			public void run()
			{
				for(int i = 1; i <= 5; i++)
				{
					writer(Thread.currentThread().getName(), i);
					try{Thread.sleep(50);}catch(Exception e){};
				}
			}
		};
		t4.start();
	}
	
	private void writer(String name, int seat)
	{
		for(int i = 0; i < data.size(); i++)
		{
			if(seat == (i + 1))
			{
				if(data.get(i) == 1)
				{
					String time = "Time: " + date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds() + "\n";
					log.insert(time + name + " Could not booked seat number " + (i + 1) + " since it has been already booked\n\n", 0);
					log.insert("-------------------------------------------------------------------------------\n\n", 0);
					log.setCaretPosition(log.getDocument().getLength());
					break;
				}
				else
				{
					String time = "Time: " + date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds() + "\n";
					log.insert(time + name + " Tries to book the seat " + seat + " successfully\n", 0);
					log.insert("-------------------------------------------------------------------------------\n\n", 0);
					log.setCaretPosition(log.getDocument().getLength());
					data.set(i, 1);
					break;
				}
			}
		}
	}
	
	private void writerSync(String name, int seat)
	{
		for(int i = 0; i < data.size(); i++)
		{
			if(seat == (i + 1))
			{
				if(data.get(i) == 1)
				{
					String time = "Time: " + date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds() + "\n";
					log.insert(time + name + " Could not booked seat number " + (i + 1) + " since it has been already booked\n\n", 0);
					log.insert("-------------------------------------------------------------------------------\n\n", 0);
					log.setCaretPosition(log.getDocument().getLength());
					break;
				}
				else
				{
					synchronized(Window.class)
					{
						String time = "Time: " + date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds() + "\n";
						log.insert(time + name + " Tries to book the seat " + seat + " successfully\n", 0);
						log.insert("-------------------------------------------------------------------------------\n\n", 0);
						log.setCaretPosition(log.getDocument().getLength());
						data.set(i, 1);
						break;
					}
				}
			}
		}
	}
	
	private void reader(String name)
	{
		String time = "Time: " + date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds() + "\n";
		log.insert(time + name + " Seat No 1: " + data.get(0) + " Seat No 2: " + data.get(1) + " Seat No 3: " + data.get(2) + " Seat No 4: " + data.get(3) + " Seat No 5: " + data.get(4) + "\n", 0);
		log.insert("-------------------------------------------------------------------------------\n", 0);
		log.setCaretPosition(log.getDocument().getLength());
	}
}