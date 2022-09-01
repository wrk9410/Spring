import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import mybeans.MyBean;
import mybeans.MyLogic;
import mybeans.MyStatefulObj;

public class IOC_Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("myconfig.xml");
		
		MyStatefulObj fourth = context.getBean(MyStatefulObj.class);
		System.out.println(fourth.toString());
		
		
//		MyStatefulObj third = context.getBean(MyStatefulObj.class);
//		System.out.println(third.toString());
//		third.setName("new-name");
//		third.setNumber(200);
//		
//		MyStatefulObj oneMoretime = context.getBean(MyStatefulObj.class);
//		System.out.println(oneMoretime.toString());
//		System.out.println(third == oneMoretime);
		/* 같은 참조이기에 third가 바뀌어도 oneMoretime에는 바뀐 값이 적용됨
		  어트리뷰트에 scope="prototype"을 할 경우 호출할 때마다 새로운 참조로 호출됨 */
		
		
//		MyLogic logic = context.getBean(MyLogic.class);
//		logic.someMethod();

//		
//		  MyBean b = context.getBean(MyBean.class); b.hello();
//		  
//		  MyBean b2 = (MyBean) context.getBean("first"); // 다운 캐스팅 해도 되고 MyBean b3 =
//		  context.getBean("first", MyBean.class); // 인자? 로 넘겨도 됨 b2.hello();
//		  b3.hello();
//		  
//		  System.out.println(b == b2);
		
		// 참조가 같은지 확인, true이기에 인스턴스는 1개(똑같은 값을 다시 가져오는 것)
	}
}
