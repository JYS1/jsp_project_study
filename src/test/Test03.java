package test;

public class Test03 {

	public static void main(String[] args) {
//		abstract 는 객체 생성이 부가능 / why : 객체가 없기 때문에.
//		Command cmd1 = new Command();
//		cmd1.exec();
		
		Command delete = new DeleteCommand();
		Command update = new UpdateCommand();
		Command cmd1 = new Command() {		// in a press?
			@Override
			public void exec() {
				System.out.println("InsertCommanc exec ..");
			}
		};
		
		
		
		
		
		cmd1.exec();
		delete.exec();
		update.exec();
		
	}
}
abstract class Command {
	public abstract void exec() ;		
	// 추상 클레스를 가지는 abstract 클래스는 abstract 만 가진다. 
	// 상속을 전제로 만들어진 클래스
	// 강제성을 부여
}

class DeleteCommand extends Command {
	public void exec() {
		System.out.println("DeleteCommand exec ..");	//오버라이딩
	}
}

class UpdateCommand extends Command{

	@Override
	public void exec() {
		System.out.println("UpdateCommand exec ..");
	}
//	public void exec() {		// 이게 없으면 부모클레스의 exec()를 들고옴
//		System.out.println("UpdateCommand exec ..");
//	}
	
	
	
}