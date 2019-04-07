package javaee02_XML;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Dom4j {

	public static void main(String[] args) {
		try {
			// 1.����sax��ȡ����
			SAXReader reader = new SAXReader();
			
			// 2.ָ��������xmlԴ
			Document document = reader.read(new File("src/javaee02_XML/02_dom4j.xml"));
			
			// 3.�õ�Ԫ��
			Element rootElement = document.getRootElement();   //��Ԫ��root
			System.out.println(rootElement.element("stu").element("name").getStringValue());
			System.out.println(rootElement.element("stu").element("age").getText());
			
			List<Element> elements = rootElement.elements();	//��Ԫ���µ�����Ԫ��
			for(Element element:elements){
				String name = element.element("name").getText();
				String age = element.element("age").getText();
				System.out.println("name="+name+",age="+age);
			}
			
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

}
