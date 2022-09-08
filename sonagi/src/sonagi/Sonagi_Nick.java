package sonagi;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

class Sonagi_Nick extends JFrame implements ActionListener,KeyListener{
	private JTextField textField;// �г��� �Է�â
	private  JLabel lblNewLabel;  // �� 
	public  String Nick_Name; // �г��� ���� 
	public int number;	// ����� ��ȣ
	Sonagi_main main; // Main
	// �߰�
	private JPanel backPanel, radioPanel;
	private JLabel backlabel, dormitory_label;
	private JButton btnNewButton;
	ImageIcon Icon_img = new ImageIcon("HarryPotterIcon.png");
	ImageIcon back_img = new ImageIcon("NickBackground.png");
	String[] dormitories = {"Gryffindor", "Ravenclaw", "Slytherin", "Hufflepuff"};
	ImageIcon gryffindor_img = new ImageIcon("Gryffindor.png");
	ImageIcon ravenclaw_img = new ImageIcon("Ravenclaw.png");
	ImageIcon slytherin_img = new ImageIcon("Slytherin.png");
	ImageIcon hufflepuff_img = new ImageIcon("Hufflepuff.png");
	private JRadioButton griffindor, ravenclaw, slytherin, hufflepuff;
	
	public Sonagi_Nick(){
		// ȭ�鱸�� 
		setSize(500,610);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Harry Potter �꼺�� ����");
		setIconImage(Icon_img.getImage());
		
		backPanel = new JPanel();	// �г���ȭ�� ��� �г�
		backPanel.setLayout(null);
		backPanel.setBackground(Color.black);
		
		backlabel = new JLabel();	// ��濡 ���� �̹���
		backlabel.setIcon(back_img);
		backlabel.setBounds(0, 0, 485, 570);
		
	    lblNewLabel = new JLabel("       ������ ����"); // �� 
		lblNewLabel.setFont(new Font("�޸�����ü", Font.PLAIN | Font.BOLD, 30));
		lblNewLabel.setBounds(90, 32, 381, 31);

	// --------------- ����� ����(�����ڽ�, �̹���) ---------------
		radioPanel = new JPanel();
		dormitory_label = new JLabel();
		dormitory_label.setBounds(50, 100, 210, 260);
		
		griffindor = new JRadioButton("�׸��ɵ���");
		ravenclaw = new JRadioButton("����Ŭ��");
		slytherin = new JRadioButton("��������");
		hufflepuff = new JRadioButton("������Ǫ");

		griffindor.setOpaque(false);	// �����ڽ� ��ư ��� �����ϰ�
		ravenclaw.setOpaque(false);
		slytherin.setOpaque(false);
		hufflepuff.setOpaque(false);
		
		ButtonGroup dormitory = new ButtonGroup();	// �����ڽ� ��ư
		dormitory.add(griffindor);
		dormitory.add(ravenclaw);
		dormitory.add(slytherin);
		dormitory.add(hufflepuff);
		
		griffindor.setFont(new Font("�޸�����ü", Font.BOLD, 18));
		ravenclaw.setFont(new Font("�޸�����ü", Font.BOLD, 18));
		slytherin.setFont(new Font("�޸�����ü", Font.BOLD, 18));
		hufflepuff.setFont(new Font("�޸�����ü", Font.BOLD, 18));
		
		griffindor.addActionListener(this);	// ���ڽ� ��ư �̺�Ʈ (this)
		ravenclaw.addActionListener(this);
		slytherin.addActionListener(this);
		hufflepuff.addActionListener(this);
		
		radioPanel.add(griffindor);	// �����ڽ� �гο� ��ư �߰�
		radioPanel.add(ravenclaw);
		radioPanel.add(slytherin);
		radioPanel.add(hufflepuff);		
		radioPanel.setOpaque(false);	// ���� �г� ����		
		radioPanel.setBounds(310, 160, 90, 140);

		// �⺻������ �׸��ɵ���
		dormitory_label.setIcon(gryffindor_img);
		griffindor.setSelected(true);
		number = 1;
	// --------------- ����� ���� �� ---------------		
		
		textField = new JTextField(); //�г��� �Է�â 
		textField.setBorder(new LineBorder(Color.black, 2));
		textField.setFont(new Font("�޸�����ü", Font.BOLD, 24));
		textField.setBounds(180, 400, 250, 40);
		textField.setColumns(10);
		textField.setOpaque(false);
		
		btnNewButton = new JButton("Ȯ��"); //Ȯ�ι�ư 
		btnNewButton.setFont(new Font("�޸�����ü", Font.BOLD, 22));
		btnNewButton.setBounds(175, 480, 150, 40);
		btnNewButton.addActionListener(this);
		btnNewButton.setBorder(new LineBorder(Color.black, 2));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setOpaque(false);
		
		JLabel lblNewLabel_1 = new JLabel("�̸�"); // �г��� �� 
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("�޸�����ü", Font.BOLD, 25));
		lblNewLabel_1.setBounds(10, 400, 188, 40);
		
		// ������, �г� add
		backPanel.add(radioPanel);
		backPanel.add(btnNewButton);
		backPanel.add(lblNewLabel_1);
		backPanel.add(textField);
		backPanel.add(dormitory_label);
		backPanel.add(lblNewLabel);
		backPanel.add(backlabel);
		add(backPanel);
		
		setLocationRelativeTo(null);	// ������ ȭ�� �߾ӿ� ��ġ
		setResizable(false);	// ������ ũ�� ����
		setVisible(true);
		
		// �г��� �Է�â Ű �̺�Ʈ (this)
		textField.addKeyListener(this);
		
	}
	// ��ư  �̺�Ʈ 
	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == griffindor) {	// �׸��ɵ��� ����
			dormitory_label.setIcon(gryffindor_img);
			number = 1;	// ����� ��ȣ1
		}
		if(e.getSource() == ravenclaw) {	// ����Ŭ�� ����
			dormitory_label.setIcon(ravenclaw_img);
			number = 2;	// ����� ��ȣ2
		}
		if(e.getSource() == slytherin) {	// �������� ����
			dormitory_label.setIcon(slytherin_img);
			number = 3;	// ����� ��ȣ3
		}
		if(e.getSource() == hufflepuff) {	// ������Ǫ ����
			dormitory_label.setIcon(hufflepuff_img);
			number = 4;	// ����� ��ȣ4
		}
		  
		if(e.getSource() ==  btnNewButton) {	// Ȯ�� ��ư
			if(!textField.getText().equals("")){			
				// �ؽ�Ʈ �̷�â�� ���� �ִٸ� �г��� ������ ���� �� ����ȭ�� ���� 
				Nick_Name = textField.getText().toString();
				main.showGameView(this, Nick_Name, number);
			}else {
				// �ؽ�Ʈ �Է�â�� ���� ���ٸ� ���ؽ�Ʈ ���� 
				lblNewLabel.setText("�ùٸ��� ���� �����Դϴ�.");
			}
		}
	}

	//Main ��� 
	public void setSonagi_main(Sonagi_main main) {
	
		this.main =main;
		
	}
	//����Ű �̺�Ʈ 
	@Override
	public void keyPressed(KeyEvent e) {
		//����Ű �̺�Ʈ 
		if (e.getKeyCode() == KeyEvent.VK_ENTER){
			// �ؽ�Ʈ �̷�â�� ���� �ִٸ� �г��� ������ ���� �� ����ȭ�� ���� 
			if(!textField.getText().equals("")){	
				Nick_Name = textField.getText().toString();
				System.out.println(Nick_Name);
				main.showGameView(this, Nick_Name, number);
			}
			else {
				// �ؽ�Ʈ �Է�â�� ���� ���ٸ� ���ؽ�Ʈ ���� 
				lblNewLabel.setText("�ùٸ��� ���� �����Դϴ�.");
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub	
	}
}