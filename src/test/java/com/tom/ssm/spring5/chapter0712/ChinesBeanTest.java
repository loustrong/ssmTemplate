package com.tom.ssm.spring5.chapter0712;



import com.tom.ssm.spring5.chapter0712.domain.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @descriptions: ChineseBeanTest
 * @author: Tom
 * @date: 2021/2/5 上午 10:22
 * @version: 1.0
 */
public class ChinesBeanTest {
    @Test
    public void testChinese070501(){
        // 创建一个ExpressionParser对象，用于解析表达式
        ExpressionParser parser = new SpelExpressionParser();
        // 最简单的字符串表达式
        Expression exp = parser.parseExpression("'HelloWorld'");
        System.out.println("'HelloWorld'的结果： " + exp.getValue());
        // 调用方法的表达式
        exp = parser.parseExpression("'HelloWorld'.concat('!')");
        System.out.println("'HelloWorld'.concat('!')的结果： "
                + exp.getValue());
        // 调用对象的getter方法
        exp = parser.parseExpression("'HelloWorld'.bytes");
        System.out.println("'HelloWorld'.bytes的结果： "
                + exp.getValue());
        // 访问对象的属性(d相当于HelloWorld.getBytes().length)
        exp = parser.parseExpression("'HelloWorld'.bytes.length");
        System.out.println("'HelloWorld'.bytes.length的结果："
                + exp.getValue());
        // 使用构造器来创建对象
        exp = parser.parseExpression("new String('helloworld')"
                + ".toUpperCase()");
        System.out.println("new String('helloworld')"
                + ".toUpperCase()的结果是： "
                + exp.getValue(String.class));
        Person person = new Person(1 , "孙悟空", new Date());
        exp = parser.parseExpression("name");
        // 以指定对象作为root来计算表达式的值
        // 相当于调用person.name表达式的值
        System.out.println("以persn为root，name表达式的值是： "
                + exp.getValue(person , String.class));
        exp = parser.parseExpression("name=='孙悟空'");
        StandardEvaluationContext ctx = new StandardEvaluationContext();
        // 将person设为Context的root对象
        ctx.setRootObject(person);
        // 以指定Context来计算表达式的值
        System.out.println(exp.getValue(ctx , Boolean.class));
        List<Boolean> list = new ArrayList<Boolean>();
        list.add(true);
        EvaluationContext ctx2 = new StandardEvaluationContext();
        // 将list设置成EvaluationContext的一个变量
        ctx2.setVariable("list" , list);
        // 修改list变量的第一个元素的值
        parser.parseExpression("#list[0]").setValue(ctx2 , "false");
        // list集合的第一个元素被改变
        System.out.println("list集合的第一个元素为："
                + parser.parseExpression("#list[0]").getValue(ctx2));
    }

    @Test
    public void testChinese071202(){
        ApplicationContext ctx = new
                ClassPathXmlApplicationContext("config/spring-0712.xml");
        com.tom.ssm.spring5.chapter0712.service.Person author = ctx.getBean("author" , com.tom.ssm.spring5.chapter0712.service.Person.class);
        System.out.println(author.getBooks());
        author.useAxe();
    }


    @Test
    public void testChinese071203(){
        // 创建一个ExpressionParser对象，用于解析表达式
        ExpressionParser parser = new SpelExpressionParser();

        // 使用直接量表达式
//		Expression exp = parser.parseExpression("'Hello World'");
//		System.out.println(exp.getValue(String.class));
//		exp = parser.parseExpression("0.23");
//		System.out.println(exp.getValue(Double.class));

        //------------使用SpEL创建数组-----------
//		// 创建一个数组
//		Expression exp = parser.parseExpression(
//			"new String[]{'java' , 'Struts' , 'Spring'}");
//		System.out.println(exp.getValue());
//		// 创建二维数组
//		exp = parser.parseExpression(
//			"new int[2][4]");
//		System.out.println(exp.getValue());


        //------------使用SpEL创建List集合-----------
//		Expression exp = parser.parseExpression(
//			"{'java' , 'Struts' , 'Spring'}");
//		System.out.println(exp.getValue());
//		// 创建“二维”List集合
//		exp = parser.parseExpression(
//			"{{'疯狂Java讲义' , '疯狂Android讲义'}, {'左传' , '战国策'}}");
//		System.out.println(exp.getValue());

        //------------使用SpEL访问List集合、Map集合的元素-----------
//		List<String> list = new ArrayList<String>();
//		list.add("Java");
//		list.add("Spring");
//		Map<String, Double> map =
//			new HashMap<String, Double>();
//		map.put("Java" , 80.0);
//		map.put("Spring" , 89.0);
//		// 创建一个EvaluationContext对象，作为SpEL解析变量的上下文
//		EvaluationContext ctx = new StandardEvaluationContext();
//		// 设置两个变量
//		ctx.setVariable("mylist" , list);
//		ctx.setVariable("mymap" , map);
//		// 访问List集合的第二个元素
//		System.out.println(parser
//			.parseExpression("#mylist[1]").getValue(ctx));
//		// 访问Map集合的指定元素
//		System.out.println(parser
//			.parseExpression("#mymap['Java']").getValue(ctx));

        //------------使用SpEL调用方法-----------
//		// 调用String对象的substring()方法
//		System.out.println(parser
//			.parseExpression("'HelloWorld'.substring(2, 5)")
//			.getValue());
//		List<String> list = new ArrayList<String>();
//		list.add("java");
//		list.add("struts");
//		list.add("spring");
//		list.add("hibernate");
//		// 创建一个EvaluationContext对象，作为SpEL解析变量的上下文
//		EvaluationContext ctx = new StandardEvaluationContext();
//		// 设置一个变量
//		ctx.setVariable("mylist" , list);
//		// 调用指定变量所代表的对象的subList()方法
//		System.out.println(parser
//			.parseExpression("#mylist.subList(1, 3)").getValue(ctx));

        //------------在SpEL中使用运算符-----------
//		List<String> list = new ArrayList<String>();
//		list.add("java");
//		list.add("struts");
//		list.add("spring");
//		list.add("hibernate");
//		// 创建一个EvaluationContext对象，作为SpEL解析变量的上下文
//		EvaluationContext ctx = new StandardEvaluationContext();
//		// 设置一个变量
//		ctx.setVariable("mylist" , list);
//		// 对集合的第一个元素进行赋值
//		parser.parseExpression("#mylist[0]='疯狂Java讲义'")
//			.getValue(ctx);
//		// 下面将输出 疯狂Java讲义
//		System.out.println(list.get(0));
//		// 使用三目运算符
//		System.out.println(parser.parseExpression("#mylist.size()>3?"
//			+ "'myList长度大于3':'myList长度不大于3'")
//			.getValue(ctx));

        //------------在SpEL中使用类型运算符-----------
//		//调用Math的静态方法
//		System.out.println(parser.parseExpression(
//			"T(java.lang.Math).random()").getValue());
//		//调用Math的静态方法
//		System.out.println(parser.parseExpression(
//			"T(System).getProperty('os.name')").getValue());

        //------------在SpEL中调用构造器-----------
//		// 创建对象
//		System.out.println(parser.parseExpression(
//			"new String('HelloWorld').substring(2, 4)")
//			.getValue());
//		// 创建对象
//		System.out.println(parser.parseExpression(
//			"new javax.swing.JFrame('测试')"
//			+ ".setVisible('true')").getValue());

        //------------在SpEL中使用安全导航操作-----------
//		// 使用安全操作，将输出null
//		System.out.println("----" + parser.parseExpression(
//			"#foo?.bar").getValue());
//		// 不使用安全操作，将引发NullPointerException
//		System.out.println(parser.parseExpression(
//			"#foo.bar").getValue());

//		//------------在SpEL中对集合进行选择-----------
//		List<String> list = new ArrayList<String>();
//		list.add("疯狂Java讲义");
//		list.add("疯狂Ajax讲义");
//		list.add("疯狂iOS讲义");
//		list.add("经典Java EE企业应用实战");
//		// 创建一个EvaluationContext对象，作为SpEL解析变量的上下文
//		EvaluationContext ctx = new StandardEvaluationContext();
//		ctx.setVariable("mylist" , list);
//		// 判断集合元素length()方法的长度大于7，“疯狂iOS讲义”被剔除
//		Expression expr = parser.parseExpression
//			("#mylist.?[length()>7]");
//		System.out.println(expr.getValue(ctx));
//		Map<String, Double> map = new HashMap<String ,Double>();
//		map.put("Java" , 89.0);
//		map.put("Spring" , 82.0);
//		map.put("英语" , 75.0);
//		ctx.setVariable("mymap" , map);
//		// 判断Map集合的value值大于80，只保留前面2个Entry
//		expr = parser.parseExpression
//			("#mymap.?[value>80]");
//		System.out.println(expr.getValue(ctx));

        //------------在SpEL中对集合进行投影-----------
        List<String> list = new ArrayList<String>();
        list.add("疯狂Java讲义");
        list.add("疯狂Ajax讲义");
        list.add("疯狂iOS讲义");
        list.add("经典Java EE企业应用实战");
        // 创建一个EvaluationContext对象，作为SpEL解析变量的上下文
        EvaluationContext ctx = new StandardEvaluationContext();
        ctx.setVariable("mylist" , list);
        // 得到的新集合的元素是原集合的每个元素length()方法返回值
        Expression expr = parser.parseExpression
                ("#mylist.![length()]");
        System.out.println(expr.getValue(ctx));
        List<com.tom.ssm.spring5.chapter0712.grammer.Person> list2 = new ArrayList<>();
        list2.add(new com.tom.ssm.spring5.chapter0712.grammer.Person(1, "孙悟空" , 162));
        list2.add(new com.tom.ssm.spring5.chapter0712.grammer.Person(2, "猪八戒" , 182));
        list2.add(new com.tom.ssm.spring5.chapter0712.grammer.Person(3, "牛魔王" , 195));
        ctx.setVariable("mylist2" , list2);
        // 得到的新集合的元素是原集合的每个元素name属性值
        expr = parser.parseExpression
                ("#mylist2.![name]");
        System.out.println(expr.getValue(ctx));

        //------------在SpEL中使用表达式模板-----------
//		Person p1 = new Person(1, "孙悟空" , 162);
//		Person p2 = new Person(2, "猪八戒" , 182);
//		Expression expr = parser.parseExpression(
//			"我的名字是#{name},身高是#{height}"
//			, new TemplateParserContext());
//		// 将使用p1对象name、height填充上面表达式模板中的#{}
//		System.out.println(expr.getValue(p1));
//		// 将使用p2对象name、height填充上面表达式模板中的#{}
//		System.out.println(expr.getValue(p2));
    }

}
