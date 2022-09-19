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
		JPanel jp2 = new JPanel();
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

		jb_empType_1.setActionCommand("empType_View");
        jb_empType_1.addActionListener(new ButtonClickListener());

            // 2-2-2. 두번째 탭에 올려질 컴포넌트를 컨테이너(jp2)에 올려야 한다.
            jp2.add(jb_empType_1);
            jp2.add(jl_empType_1);
            jp2.add(jt_empType_1);
            jp2.add(jc_empType_1);
            jp2.add(jl_empType_2);
            jp2.add(jt_empType_2);
	
		// 2-3-1. 세번째 탭에 올려질 컴포넌트를 만들어 보자.

        JButton jb_Job_1 = new JButton("조회");
		JLabel jl_Job_1 = new JLabel("직급명");
        JTextField jt_Job_1 = new JTextField(20); //텍스트 필드
        JCheckBox jc_Job_1 = new JCheckBox();   //사용여부
		JLabel jl_Job_2 = new JLabel("직급 노출순서");
        JTextField jt_Job_2 = new JTextField(20); //텍스트 필드

		jb_Job_1.setActionCommand("job_View");
        jb_Job_1.addActionListener(new ButtonClickListener());
		
			// 2-3-2. 세번째 탭에 올려질 컴포넌트를 컨테이너(jp3)에 올려야 한다.
			jp3.add(jb_Job_1); 
			jp3.add(jl_Job_1); 
			jp3.add(jt_Job_1); 
			jp3.add(jc_Job_1);
			jp3.add(jl_Job_2);
			jp3.add(jt_Job_2);

		// 2-4-1.  탭에 올려질 컴포넌트를 만들어 보자.
        JButton jb_Grade_1 = new JButton("조회");
		JLabel jl_Grade_1 = new JLabel("직급명");
        JTextField jt_Grade_1 = new JTextField(20); //텍스트 필드
        JCheckBox jc_Grade_1 = new JCheckBox();   //사용여부
		JLabel jl_Grade_2 = new JLabel("직급 노출순서");
        JTextField jt_Grade_2 = new JTextField(20); //텍스트 필드

		jb_Grade_1.setActionCommand("grade_View");
        jb_Grade_1.addActionListener(new ButtonClickListener());
		
			// 2-4-2.  탭에 올려질 컴포넌트를 컨테이너에 올려야 한다.
			jp4.add(jb_Grade_1); 
			jp4.add(jl_Grade_1); 
			jp4.add(jt_Grade_1); 
			jp4.add(jc_Grade_1);
			jp4.add(jl_Grade_2);
			jp4.add(jt_Grade_2);

		// 2-5-1.  탭에 올려질 컴포넌트를 만들어 보자.
        JButton jb_Dept_1 = new JButton("조회");
		JLabel jl_Dept_1 = new JLabel("부서명");
        JTextField jt_Dept_1 = new JTextField(20); //텍스트 필드
        JCheckBox jc_Dept_1 = new JCheckBox();   //사용여부
		JLabel jl_Dept_2 = new JLabel("부서 노출순서");
        JTextField jt_Dept_2 = new JTextField(20); //텍스트 필드

		jb_Dept_1.setActionCommand("dept_View");
        jb_Dept_1.addActionListener(new ButtonClickListener());
		
			// 2-5-2.  탭에 올려질 컴포넌트를 컨테이너에 올려야 한다.
			jp5.add(jb_Dept_1); 
			jp5.add(jl_Dept_1); 
			jp5.add(jt_Dept_1); 
			jp5.add(jc_Dept_1);
			jp5.add(jl_Dept_2);
			jp5.add(jt_Dept_2);

		// 2-6-1.  탭에 올려질 컴포넌트를 만들어 보자.
        JButton jb_emp_1 = new JButton("조회");
		JLabel jl_emp_1 = new JLabel("사원명");
        JTextField jt_emp_1 = new JTextField(20); //텍스트 필드
        JCheckBox jc_emp_1 = new JCheckBox();   //사용여부
		JLabel jl_emp_2 = new JLabel("사원 노출순서");
        JTextField jt_emp_2 = new JTextField(20); //텍스트 필드

		jb_emp_1.setActionCommand("emp_View");
        jb_emp_1.addActionListener(new ButtonClickListener());
		
			// 2-6-2.  탭에 올려질 컴포넌트를 컨테이너에 올려야 한다.
			jp6.add(jb_emp_1); 
			jp6.add(jl_emp_1); 
			jp6.add(jt_emp_1); 
			jp6.add(jc_emp_1);
			jp6.add(jl_emp_2);
			jp6.add(jt_emp_2);

				
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

			//사업장
            if (command.equals("plView")) {
                try {
					sync.get_placebiz();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            } else {
                System.out.println("Fail");
            }

			//고용형태
			if (command.equals("empType_View")) {
				try {
					sync.get_empType();
				}
				catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else {
				System.out.println( "Fail");
			}

			//직급
			if (command.equals("job_View")) {
				try {
					sync.get_job();
				}
				catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else {
				System.out.println( "Fail");
			}

			//직책
			if (command.equals("grade_View")) {
				try {
					sync.get_grade();
				}
				catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else {
				System.out.println( "Fail");
			}

			//부서
			if (command.equals("dept_View")) {
				try {
					sync.get_department();
				}
				catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else {
				System.out.println( "Fail");
			}

			//사원
			if (command.equals("emp_View")) {
				try {
					sync.get_department();
				}
				catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else {
				System.out.println( "Fail");
			}



            
        }
        
    }
	
	public static void main(String[] args) {
		new Frame();

	}

}