package javaee02_XML;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/*
 * 	Dom4j��Xpathʹ��
 *		Dom4j֧��Xpath��д����
 *		Xpath��ʵ��xml��·�����ԣ���֧�������ڽ���xml��ʱ���ܹ����ٶ�λ�������ĳһ��Ԫ�أ�	
 *		�ڲ���ָ���ڵ��ʱ�򣬸���Xpath�﷨����������
 *		ʹ��ǰ��Ҫ��jar��������D:\Installation Package\MyEclipse2017\jar��\dom4j\dom4j-1.6.1\lib\jaxen-1.1-beta-6.jar
 * */

public class Xpath {

	public static void main(String[] args) {
		try {
			// 1.����sax��ȡ����
			SAXReader reader = new SAXReader();
			
			// 2.ָ��������xmlԴ
			Document document = reader.read(new File("src/javaee02_XML/02_dom4j.xml"));
			
			// 3.�õ�Ԫ��
			Element rootElement = document.getRootElement();   //��Ԫ��root
			
			// Ҫ��ʹ��Xpath���������jar: jaxen-1.1-beta-6.jar
			Element nameElement = (Element)rootElement.selectSingleNode("//name");		// ��ȡ���ǵ�һ��
			System.out.println(nameElement.getText());
	
			System.out.println("-----------------");
			
			// ��ȡ�ĵ����������nameԪ��
			List<Element> list = rootElement.selectNodes("//name");
			for(Element element:list){
				System.out.println(element.getText());
			}
			
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

}
