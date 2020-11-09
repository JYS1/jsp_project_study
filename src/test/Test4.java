package test;

import javax.swing.JOptionPane;

public class Test4 {

	public static void main(String[] args) {
//		abstract 는 객체 생성이 부가능 / why : 객체가 없기 때문에.
//		Command cmd1 = new Command();
//		cmd1.exec();
		
		
		Command_2 insert = new Command_2() {		// in a press?
			@Override
			public void exec() {
				System.out.println("InsertCommanc exec ..");
			}
		};
		
		Command_2 update = new UpdateCommand_2();
		
		Command_2 delete = () -> {		// 람다식으로 표현
			System.out.println("DeleteCommand exec ..");
		};
		
		String cmd = JOptionPane.showInputDialog("1.insert, 2.delete, 3.update, 4.quit");
		// 1.insert, 2.delete, 3.update, 4.quit
		switch (cmd) {
		case "1":
			insert.exec();
			break;
		case "2":
			delete.exec();
			break;
		case "3":
			update.exec();
			break;
		case "4":
			return;
		default:
			System.out.println("메뉴에 없는 선택지 입니다.");
			break;
		}
		
		
		
		
		
	}
}


interface Command_2 {
	public abstract void exec() ;		
	// 추상 클레스를 가지는 abstract 클래스는 abstract 만 가진다. 
	// 상속을 전제로 만들어진 클래스
	// 강제성을 부여
}

class DeleteCommand_2 implements Command_2 {
	public void exec() {
		System.out.println("DeleteCommand exec ..");
	}
}

class UpdateCommand_2 implements Command_2{

	@Override
	public void exec() {
		System.out.println("UpdateCommand exec ..");
	}
//	public void exec() {		// 이게 없으면 부모클레스의 exec()를 들고옴
//		System.out.println("UpdateCommand exec ..");
//	}
	
	
	
}