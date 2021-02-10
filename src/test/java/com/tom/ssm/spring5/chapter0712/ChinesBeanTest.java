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
 * @date: 2021/2/5 ���� 10:22
 * @version: 1.0
 */
public class ChinesBeanTest {
    @Test
    public void testChinese070501(){
        // ����һ��ExpressionParser�������ڽ������ʽ
        ExpressionParser parser = new SpelExpressionParser();
        // ��򵥵��ַ������ʽ
        Expression exp = parser.parseExpression("'HelloWorld'");
        System.out.println("'HelloWorld'�Ľ���� " + exp.getValue());
        // ���÷����ı��ʽ
        exp = parser.parseExpression("'HelloWorld'.concat('!')");
        System.out.println("'HelloWorld'.concat('!')�Ľ���� "
                + exp.getValue());
        // ���ö����getter����
        exp = parser.parseExpression("'HelloWorld'.bytes");
        System.out.println("'HelloWorld'.bytes�Ľ���� "
                + exp.getValue());
        // ���ʶ��������(d�൱��HelloWorld.getBytes().length)
        exp = parser.parseExpression("'HelloWorld'.bytes.length");
        System.out.println("'HelloWorld'.bytes.length�Ľ����"
                + exp.getValue());
        // ʹ�ù���������������
        exp = parser.parseExpression("new String('helloworld')"
                + ".toUpperCase()");
        System.out.println("new String('helloworld')"
                + ".toUpperCase()�Ľ���ǣ� "
                + exp.getValue(String.class));
        Person person = new Person(1 , "�����", new Date());
        exp = parser.parseExpression("name");
        // ��ָ��������Ϊroot��������ʽ��ֵ
        // �൱�ڵ���person.name���ʽ��ֵ
        System.out.println("��persnΪroot��name���ʽ��ֵ�ǣ� "
                + exp.getValue(person , String.class));
        exp = parser.parseExpression("name=='�����'");
        StandardEvaluationContext ctx = new StandardEvaluationContext();
        // ��person��ΪContext��root����
        ctx.setRootObject(person);
        // ��ָ��Context��������ʽ��ֵ
        System.out.println(exp.getValue(ctx , Boolean.class));
        List<Boolean> list = new ArrayList<Boolean>();
        list.add(true);
        EvaluationContext ctx2 = new StandardEvaluationContext();
        // ��list���ó�EvaluationContext��һ������
        ctx2.setVariable("list" , list);
        // �޸�list�����ĵ�һ��Ԫ�ص�ֵ
        parser.parseExpression("#list[0]").setValue(ctx2 , "false");
        // list���ϵĵ�һ��Ԫ�ر��ı�
        System.out.println("list���ϵĵ�һ��Ԫ��Ϊ��"
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
        // ����һ��ExpressionParser�������ڽ������ʽ
        ExpressionParser parser = new SpelExpressionParser();

        // ʹ��ֱ�������ʽ
//		Expression exp = parser.parseExpression("'Hello World'");
//		System.out.println(exp.getValue(String.class));
//		exp = parser.parseExpression("0.23");
//		System.out.println(exp.getValue(Double.class));

        //------------ʹ��SpEL��������-----------
//		// ����һ������
//		Expression exp = parser.parseExpression(
//			"new String[]{'java' , 'Struts' , 'Spring'}");
//		System.out.println(exp.getValue());
//		// ������ά����
//		exp = parser.parseExpression(
//			"new int[2][4]");
//		System.out.println(exp.getValue());


        //------------ʹ��SpEL����List����-----------
//		Expression exp = parser.parseExpression(
//			"{'java' , 'Struts' , 'Spring'}");
//		System.out.println(exp.getValue());
//		// ��������ά��List����
//		exp = parser.parseExpression(
//			"{{'���Java����' , '���Android����'}, {'��' , 'ս����'}}");
//		System.out.println(exp.getValue());

        //------------ʹ��SpEL����List���ϡ�Map���ϵ�Ԫ��-----------
//		List<String> list = new ArrayList<String>();
//		list.add("Java");
//		list.add("Spring");
//		Map<String, Double> map =
//			new HashMap<String, Double>();
//		map.put("Java" , 80.0);
//		map.put("Spring" , 89.0);
//		// ����һ��EvaluationContext������ΪSpEL����������������
//		EvaluationContext ctx = new StandardEvaluationContext();
//		// ������������
//		ctx.setVariable("mylist" , list);
//		ctx.setVariable("mymap" , map);
//		// ����List���ϵĵڶ���Ԫ��
//		System.out.println(parser
//			.parseExpression("#mylist[1]").getValue(ctx));
//		// ����Map���ϵ�ָ��Ԫ��
//		System.out.println(parser
//			.parseExpression("#mymap['Java']").getValue(ctx));

        //------------ʹ��SpEL���÷���-----------
//		// ����String�����substring()����
//		System.out.println(parser
//			.parseExpression("'HelloWorld'.substring(2, 5)")
//			.getValue());
//		List<String> list = new ArrayList<String>();
//		list.add("java");
//		list.add("struts");
//		list.add("spring");
//		list.add("hibernate");
//		// ����һ��EvaluationContext������ΪSpEL����������������
//		EvaluationContext ctx = new StandardEvaluationContext();
//		// ����һ������
//		ctx.setVariable("mylist" , list);
//		// ����ָ������������Ķ����subList()����
//		System.out.println(parser
//			.parseExpression("#mylist.subList(1, 3)").getValue(ctx));

        //------------��SpEL��ʹ�������-----------
//		List<String> list = new ArrayList<String>();
//		list.add("java");
//		list.add("struts");
//		list.add("spring");
//		list.add("hibernate");
//		// ����һ��EvaluationContext������ΪSpEL����������������
//		EvaluationContext ctx = new StandardEvaluationContext();
//		// ����һ������
//		ctx.setVariable("mylist" , list);
//		// �Լ��ϵĵ�һ��Ԫ�ؽ��и�ֵ
//		parser.parseExpression("#mylist[0]='���Java����'")
//			.getValue(ctx);
//		// ���潫��� ���Java����
//		System.out.println(list.get(0));
//		// ʹ����Ŀ�����
//		System.out.println(parser.parseExpression("#mylist.size()>3?"
//			+ "'myList���ȴ���3':'myList���Ȳ�����3'")
//			.getValue(ctx));

        //------------��SpEL��ʹ�����������-----------
//		//����Math�ľ�̬����
//		System.out.println(parser.parseExpression(
//			"T(java.lang.Math).random()").getValue());
//		//����Math�ľ�̬����
//		System.out.println(parser.parseExpression(
//			"T(System).getProperty('os.name')").getValue());

        //------------��SpEL�е��ù�����-----------
//		// ��������
//		System.out.println(parser.parseExpression(
//			"new String('HelloWorld').substring(2, 4)")
//			.getValue());
//		// ��������
//		System.out.println(parser.parseExpression(
//			"new javax.swing.JFrame('����')"
//			+ ".setVisible('true')").getValue());

        //------------��SpEL��ʹ�ð�ȫ��������-----------
//		// ʹ�ð�ȫ�����������null
//		System.out.println("----" + parser.parseExpression(
//			"#foo?.bar").getValue());
//		// ��ʹ�ð�ȫ������������NullPointerException
//		System.out.println(parser.parseExpression(
//			"#foo.bar").getValue());

//		//------------��SpEL�жԼ��Ͻ���ѡ��-----------
//		List<String> list = new ArrayList<String>();
//		list.add("���Java����");
//		list.add("���Ajax����");
//		list.add("���iOS����");
//		list.add("����Java EE��ҵӦ��ʵս");
//		// ����һ��EvaluationContext������ΪSpEL����������������
//		EvaluationContext ctx = new StandardEvaluationContext();
//		ctx.setVariable("mylist" , list);
//		// �жϼ���Ԫ��length()�����ĳ��ȴ���7�������iOS���塱���޳�
//		Expression expr = parser.parseExpression
//			("#mylist.?[length()>7]");
//		System.out.println(expr.getValue(ctx));
//		Map<String, Double> map = new HashMap<String ,Double>();
//		map.put("Java" , 89.0);
//		map.put("Spring" , 82.0);
//		map.put("Ӣ��" , 75.0);
//		ctx.setVariable("mymap" , map);
//		// �ж�Map���ϵ�valueֵ����80��ֻ����ǰ��2��Entry
//		expr = parser.parseExpression
//			("#mymap.?[value>80]");
//		System.out.println(expr.getValue(ctx));

        //------------��SpEL�жԼ��Ͻ���ͶӰ-----------
        List<String> list = new ArrayList<String>();
        list.add("���Java����");
        list.add("���Ajax����");
        list.add("���iOS����");
        list.add("����Java EE��ҵӦ��ʵս");
        // ����һ��EvaluationContext������ΪSpEL����������������
        EvaluationContext ctx = new StandardEvaluationContext();
        ctx.setVariable("mylist" , list);
        // �õ����¼��ϵ�Ԫ����ԭ���ϵ�ÿ��Ԫ��length()��������ֵ
        Expression expr = parser.parseExpression
                ("#mylist.![length()]");
        System.out.println(expr.getValue(ctx));
        List<com.tom.ssm.spring5.chapter0712.grammer.Person> list2 = new ArrayList<>();
        list2.add(new com.tom.ssm.spring5.chapter0712.grammer.Person(1, "�����" , 162));
        list2.add(new com.tom.ssm.spring5.chapter0712.grammer.Person(2, "��˽�" , 182));
        list2.add(new com.tom.ssm.spring5.chapter0712.grammer.Person(3, "ţħ��" , 195));
        ctx.setVariable("mylist2" , list2);
        // �õ����¼��ϵ�Ԫ����ԭ���ϵ�ÿ��Ԫ��name����ֵ
        expr = parser.parseExpression
                ("#mylist2.![name]");
        System.out.println(expr.getValue(ctx));

        //------------��SpEL��ʹ�ñ��ʽģ��-----------
//		Person p1 = new Person(1, "�����" , 162);
//		Person p2 = new Person(2, "��˽�" , 182);
//		Expression expr = parser.parseExpression(
//			"�ҵ�������#{name},�����#{height}"
//			, new TemplateParserContext());
//		// ��ʹ��p1����name��height���������ʽģ���е�#{}
//		System.out.println(expr.getValue(p1));
//		// ��ʹ��p2����name��height���������ʽģ���е�#{}
//		System.out.println(expr.getValue(p2));
    }

}
