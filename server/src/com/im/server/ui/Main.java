package com.im.server.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import com.im.server.utils.DateUtils;
import com.im.server.utils.FontUtils;
import com.im.server.utils.ImageManageUtils;
import com.im.server.utils.ScreenSizeUtils;

/** 
* CopyRright (c)2013:	InstantMessage                          
* Project:				InstantMessageServer                                          
* Module ID:			1    
* Comments:  			服务器主界面                                         
* JDK version used:		JDK 1.7                              
* NameSpace:			com.im.server.ui                         
* Author：				Ellery                 
* Create Date：			2013-04-27 14:43 
* Modified By：			                                        
* Modified Date:		                                    
* Why&What is modified:    
* Version:				0.1                       
*/ 

@SuppressWarnings("serial")
public class Main extends JFrame{

	//系统任务栏图标
	private ImageIcon taskbar_logoIcon = ImageManageUtils.getImageIcon("images/common/taskBarIcon.png");

	//窗口的宽度和窗口的高度
	private int windowWidth = 1024;
	private int windowHeight = 768;
	
	//屏幕的宽度和屏幕的高度
	private int screenWidth = 0;
	private int screenHeight = 0;

	//获取屏幕高度宽度
	private ScreenSizeUtils screenSizeUtils = null;
	//窗口主Panel
	private JPanel mainPanel = null;
	//中心界面Panel
	private JPanel centerPanel = null;
	//菜单栏
    private JMenuBar menuBar = null;
    //文件菜单
    private JMenu fileMenu = null;
    //文件菜单 - 新建
    private JMenuItem newMenuItem = null;
    //文件菜单 - 刷新
    private JMenuItem refreshMenuItem = null;
    //文件菜单 - 退出
    private JMenuItem exitMenuItem = null;
    //编辑菜单
    private JMenu editMenu = null;
    //服务器菜单
    private JMenu serverMenu = null;
    //用户菜单
    private JMenu userMenu = null;
    //消息菜单
    private JMenu messageMenu = null;
    //日志菜单
    private JMenu logMenu = null;
    //帮助菜单
    private JMenu helpMenu = null;
    //中心标签页
    private JTabbedPane centerTabbedPane = null;
	//中心标签页面板 - 首页
	private JPanel centerIndexPanel = null;
	//中心标签页面板 - 首页North
	private JPanel centerIndexNorthPanel = null;
	//中心标签页面板 - 首页Center
	private JPanel centerIndexCenterPanel = null;
	//中心标签页面板 - 首页South
	private JPanel centerIndexSouthPanel = null;
    //简介标题边框
    private TitledBorder indexIntroductionTitle = null;
    //服务器标题边框
    private TitledBorder indexServerTitle = null;
    //控制台标题边框
    private TitledBorder indexConsoleTitle = null;
    //IM简介
    private JTextArea introductionTextArea = null;
    //服务器操作按钮
    private JButton startServerButton = null;
    private JButton stopServerButton = null;
    private JButton restartServerButton = null;
    //控制台
    private JTextArea consoleTextArea = null;
    private String consoleLog = "";
    
	//字体
	private Font FONT_12_NOBOLD = new Font("微软雅黑", 0, 12);
	
	public Main(){
		//获取屏幕高度宽度
		screenSizeUtils = new ScreenSizeUtils();
		screenWidth = screenSizeUtils.getScreenWidth();
		screenHeight = screenSizeUtils.getScreenHeight();
		
		//设置字体
		FontUtils.initGlobalFont(FONT_12_NOBOLD); 
		
		//初始化主界面
		this.init();
	}
	
	public void init(){

		//基础设置
		this.setTitle("IM2013");
		this.setLayout(null);
		this.setBounds((screenWidth - windowWidth)/2, 
				(screenHeight - windowHeight)/2, windowWidth, windowHeight);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置任务栏图标
		this.setIconImage(taskbar_logoIcon.getImage());
		
		//主面板
		mainPanel = new JPanel(new BorderLayout());
		//中心界面面板
		centerPanel = new JPanel(new BorderLayout());
		//中心标签页面板 - 首页
		centerIndexPanel = new JPanel(new BorderLayout());
		//中心标签页面板 - 首页North
		centerIndexNorthPanel = new JPanel(new BorderLayout());
		//中心标签页面板 - 首页Center
		centerIndexCenterPanel = new JPanel(new FlowLayout());
		//中心标签页面板 - 首页South
		centerIndexSouthPanel = new JPanel(new BorderLayout());
		
		//菜单栏
	    menuBar = new JMenuBar(); 
	    
	    //菜单
	    fileMenu = new JMenu("文件");  
	    fileMenu.setMnemonic(KeyEvent.VK_F);  
	    editMenu = new JMenu("编辑");  
	    editMenu.setMnemonic(KeyEvent.VK_E);  
	    serverMenu = new JMenu("服务器选项");  
	    serverMenu.setMnemonic(KeyEvent.VK_S);  
	    userMenu = new JMenu("用户选项");  
	    userMenu.setMnemonic(KeyEvent.VK_U);
	    messageMenu = new JMenu("消息");  
	    messageMenu.setMnemonic(KeyEvent.VK_M);    
	    logMenu = new JMenu("日志");  
	    logMenu.setMnemonic(KeyEvent.VK_L);  
	    helpMenu = new JMenu("帮助");  
	    helpMenu.setMnemonic(KeyEvent.VK_H);  
	    
	    //文件菜单 - 组件
	    newMenuItem = new JMenuItem("新建", KeyEvent.VK_N);  
	    refreshMenuItem = new JMenuItem("刷新", KeyEvent.VK_R);  
	    exitMenuItem = new JMenuItem("退出", KeyEvent.VK_C);  
	    //文件菜单添加组件
	    fileMenu.add(newMenuItem);
	    fileMenu.add(refreshMenuItem);
	    fileMenu.add(exitMenuItem);
	    
	    //其他菜单组件
	    //...
	    
	    //菜单栏添加组件
	    menuBar.add(fileMenu); 
	    menuBar.add(editMenu); 
	    menuBar.add(serverMenu); 
	    menuBar.add(userMenu); 
	    menuBar.add(messageMenu); 
	    menuBar.add(logMenu); 
	    menuBar.add(helpMenu); 
	    
	    //中心标签页面板 - 首页
	    //标题边框
	    indexIntroductionTitle = new TitledBorder("欢迎来到IM服务器！"); 
	    centerIndexNorthPanel.setBorder(indexIntroductionTitle);
	    indexServerTitle = new TitledBorder("服务器管理"); 
	    centerIndexCenterPanel.setBorder(indexServerTitle);
	    indexConsoleTitle = new TitledBorder("Console"); 
	    centerIndexSouthPanel.setBorder(indexConsoleTitle);
	    //IM简介
	    introductionTextArea = new JTextArea();
	    String introductionTexts = "        Instant messaging (IM) is a form of communication " +
	    		"over the Internet that offers quick transmission of text-based messages " +
	    		"from sender to receiver. In push mode between two or more people using " +
	    		"personal computers or other devices, along with shared clients, instant " +
	    		"messaging basically offers real-time direct written language-based online " +
	    		"chat. The user's text is conveyed over a network, such as the Internet. " +
	    		"It may address point-to-point communications as well as multicast communications " +
	    		"from one sender to many receivers. More advanced instant messaging allows enhanced " +
	    		"modes of communication, such as live voice or video calling, video chat and inclusion " +
	    		"of hyperlinks to media.";
	    introductionTextArea.setText(introductionTexts);
	    introductionTextArea.setEditable(false);
	    introductionTextArea.setLineWrap(true);
	    introductionTextArea.setWrapStyleWord(true);
	    introductionTextArea.setMargin(new Insets(10, 10, 10, 5));
	    introductionTextArea.setOpaque(false);
	    
	    //中心标签页面板 - centerIndexNorthPanel面板添加组件
	    centerIndexNorthPanel.add(introductionTextArea);
	    
	    //服务器操作按钮
	    startServerButton = new JButton("启动服务器");
	    startServerButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				consoleLog = "["+ DateUtils.getCuttentTime() +"] 服务器启动成功～！\r\n";
			    consoleTextArea.append(consoleLog);
			    //启动服务器启动线程
			    /*ServerStartThread serverStartThread = new ServerStartThread();
			    serverStartThread.start();*/
			    startServerButton.setEnabled(false);
			    restartServerButton.setEnabled(true);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
			}
		});
	    stopServerButton = new JButton("停止服务器");
	    stopServerButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				consoleLog = "["+ DateUtils.getCuttentTime() +"] 服务器已关闭～！\r\n";
			    consoleTextArea.append(consoleLog);
			    /*//停止服务器
			    IMServerConnectClient i = new IMServerConnectClient();
			    i.closeServer();*/
			    startServerButton.setEnabled(true);
			    restartServerButton.setEnabled(false);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
			}
		});
	    restartServerButton = new JButton("重启服务器");
	    restartServerButton.setEnabled(false);

	    //中心标签页面板 - 首页Center面板添加组件
	    centerIndexCenterPanel.add(startServerButton);
	    centerIndexCenterPanel.add(stopServerButton);
	    centerIndexCenterPanel.add(restartServerButton);
	    
	    //控制台
	    consoleTextArea = new JTextArea();
	    consoleTextArea.setRows(21);
	    consoleTextArea.setText(introductionTexts);
	    consoleTextArea.setEditable(false);
	    consoleTextArea.setLineWrap(true);
	    consoleTextArea.setWrapStyleWord(true);
	    consoleTextArea.setMargin(new Insets(10, 10, 10, 5));
	    consoleLog = "["+ DateUtils.getCuttentTime() +"] 服务等待启动...\r\n";
	    consoleTextArea.setText(consoleLog);
	    
	    //中心标签页面板 - 首页South面板添加组件
	    centerIndexSouthPanel.add(consoleTextArea);
	    
	    //中心标签页面板 - 首页面板添加组件
	    centerIndexPanel.add(BorderLayout.NORTH, centerIndexNorthPanel);
	    centerIndexPanel.add(BorderLayout.CENTER, centerIndexCenterPanel);
	    centerIndexPanel.add(BorderLayout.SOUTH, centerIndexSouthPanel);
	    
	    //中心标签页
	    centerTabbedPane = new JTabbedPane();
	    centerTabbedPane.addTab("首页", null, centerIndexPanel, "首页");
	    centerTabbedPane.addTab("服务器管理", null, new JLabel("Tab 2 Content"), "服务器管理");
	    centerTabbedPane.addTab("用户管理", null, new JLabel("Tab 3 Content"), "用户管理");
	    centerTabbedPane.addTab("群组管理", null, new JLabel("Tab 1 Content"), "群组管理");
	    centerTabbedPane.addTab("消息管理", null, new JLabel("Tab 1 Content"), "消息管理");
	    centerTabbedPane.addTab("日志管理", null, new JLabel("Tab 1 Content"), "日志管理");

	    //中心面板添加组件
	    centerPanel.add(BorderLayout.CENTER, centerTabbedPane);
		
	    //添加组件
		this.setContentPane(mainPanel);
		mainPanel.add(BorderLayout.NORTH, menuBar);
		mainPanel.add(BorderLayout.CENTER, centerPanel);
	}

	public static void main(String[] args) {
		
		//设置LookAndFeel
		try{
	        BeautyEyeLNFHelper.launchBeautyEyeLNF();
	    }
	    catch(Exception e){
	    	e.printStackTrace();
	    }
		
		//运行主界面
		new Main().setVisible(true);
	}

}
