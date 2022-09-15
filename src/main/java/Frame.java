import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//프레임 생성
public class Frame extends JFrame {

	public Frame() {
		
		// 1. 탭의 갯수만큼 컨테이너가 만들어져야한다.
		JTabbedPane tab = new JTabbedPane();
		
		JPanel jp1 = new JPanel();
            jp1.setLayout(new GridLayout(3,1));
		JPanel jp2 = new JPanel();
            jp2.setLayout(new GridLayout(3,1));
		JPanel jp3 = new JPanel();
		JPanel jp4 = new JPanel();
		JPanel jp5 = new JPanel();
		JPanel jp6 = new JPanel();

        //각각의 컨테이너들을 탭에 올려준다
		tab.add("사업장", jp1); 
		tab.add("고용형태", jp2); 
		tab.add("직급", jp3);
		tab.add("직책", jp4);
		tab.add("부서", jp5);
		tab.add("사원", jp6);
        add(tab);

		// 2-1-1. 첫번째 탭에 포함된 컴포넌트
		JButton jb_placeBiz_1 = new JButton("조회");    //조회 버튼
		JLabel jl_placeBiz_1 = new JLabel("사업장명");
        JTextField jt_placeBiz_1 = new JTextField(20); //텍스트 필드

        jb_placeBiz_1.setActionCommand("plView");
        jb_placeBiz_1.addActionListener(new ButtonClickListener());

            // 2-1-2. 첫번째 탭에 올려질 컴포넌트를 컨테이너(jp1)에 올려야 한다.
            jp1.add(jb_placeBiz_1); 
            jp1.add(jl_placeBiz_1);
            jp1.add(jt_placeBiz_1); //텍스트 필드 추가
    
		// 2-2-1. 두번째 탭에 올라갈 컴포넌트
        JButton jb_empType_1 = new JButton("조회");
		JLabel jl_empType_1 = new JLabel("고용형태명");
        JTextField jt_empType_1 = new JTextField(20); //텍스트 필드
        JCheckBox jc_empType_1 = new JCheckBox();   //사용여부
		JLabel jl_empType_2 = new JLabel("고용형태 노출순서");
        JTextField jt_empType_2 = new JTextField(20); //텍스트 필드

            // 2-2-2. 두번째 탭에 올려질 컴포넌트를 컨테이너(jp2)에 올려야 한다.
            jp2.add(jb_empType_1);
            jp2.add(jl_empType_1);
            jp2.add(jt_empType_1);
            jp2.add(jc_empType_1);
            jp2.add(jl_empType_2);
            jp2.add(jt_empType_2);
	
		// 2-3-1. 세번째 탭에 올려질 컴포넌트를 만들어 보자.
		JRadioButton jrb1 = new JRadioButton("1");
		JRadioButton jrb2 = new JRadioButton("12");
		JRadioButton jrb3 = new JRadioButton("123");
		JRadioButton jrb4 = new JRadioButton("1234");
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(jrb1); bg.add(jrb2); bg.add(jrb3); bg.add(jrb4);
		
		// 2-3-2. 세번째 탭에 올려질 컴포넌트를 컨테이너(jp3)에 올려야 한다.
		jp3.add(jrb1); jp3.add(jrb2); jp3.add(jrb3); jp3.add(jrb4);
				
		// 4. 탭을 프레임에 올려준다.
		setBounds(200,200,750,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}
    //클릭시 이벤트
    private class ButtonClickListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            String command = e.getActionCommand();

            if (command.equals("View")) {
                try {
					sync.get_placebiz();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            } else {
                System.out.println("Fail");
            }
            
        }
        
    }
	
	public static void main(String[] args) {
		new Frame();

	}

}