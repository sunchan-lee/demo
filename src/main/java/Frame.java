import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//프레임 생성
public class Frame extends JFrame {
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;
    private JTabbedPane pane;

    public Frame(){
        prepareGUI();
    }

    public static void main(String[] args) {
        Frame Frame = new Frame(); 
        Frame.createdTabbedPane();
    }

    private void prepareGUI(){
        mainFrame = new JFrame("Workplace 조직연동"); //타이틀 이름
        mainFrame.setSize(1000,800);    //창 사이즈
        mainFrame.setLayout(new GridLayout(4, 1));  //레이아웃 셋팅

        // 닫기 버튼 눌렀을때 종료
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
               System.exit(0);
            }        
         });  
         mainFrame.setVisible(true);  

    }

    //Tab 추가 항목
    void createdTabbedPane(){
        JTabbedPane tab = new JTabbedPane();
        add(tab);

        JLabel placeBizLabel = new JLabel("사업장", SwingConstants.CENTER);
        JPanel placeBizPanel = new JPanel();
        placeBizPanel.add(placeBizLabel);
        tab.addTab("1", placeBizPanel);
        
        JLabel empTypeLabel = new JLabel("고용형태", SwingConstants.CENTER);
        JPanel empTypePanel = new JPanel();
        empTypePanel.add(empTypeLabel);
        tab.addTab("2", empTypePanel);

        JLabel gradeLabel = new JLabel("직급", SwingConstants.CENTER);
        JPanel gradePanel = new JPanel();
        gradePanel.add(gradeLabel);
        tab.addTab("3", gradePanel);

        JLabel jobLabel = new JLabel("직책", SwingConstants.CENTER);
        JPanel jobPanel = new JPanel();
        jobLabel.add(jobPanel);
        tab.addTab("4", jobPanel);

        JLabel departmentLabel = new JLabel("부서", SwingConstants.CENTER);
        JPanel departmentPanel = new JPanel();
        departmentLabel.add(departmentPanel);
        tab.addTab("5", departmentPanel);

        JLabel employeeLabel = new JLabel("사원", SwingConstants.CENTER);
        JPanel employeePanel = new JPanel();
        employeeLabel.add(employeePanel);
        tab.addTab("6", employeePanel);

        tab.setVisible(true);



    }
















}