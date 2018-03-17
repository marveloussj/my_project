package grosstest;

public class MyUnitTest {
	@MyBefore
	public void init(){
		System.out.println("---init---");
	}
	@MyAfter
	public void destroy(){
		System.out.println("---destroy---");
	}
	@MyTest
	public void save(){
		System.out.println("MyUnitTest.save()");
	}
	@MyTest
	public void updata(){
		System.out.println("MyUnitTest.updata()");
	}
}