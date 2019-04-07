package javaee02_XML;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/*
 * 	Dom4j的Xpath使用
 *		Dom4j支持Xpath的写法。
 *		Xpath其实是xml的路径语言，它支持我们在解析xml的时候，能够快速定位到具体的某一个元素；	
 *		在查找指定节点的时候，根据Xpath语法规则来查找
 *		使用前需要加jar包依赖：D:\Installation Package\MyEclipse2017\jar包\dom4j\dom4j-1.6.1\lib\jaxen-1.1-beta-6.jar
 * */

public class Xpath {

	public static void main(String[] args) {
		try {
			// 1.创建sax读取对象
			SAXReader reader = new SAXReader();
			
			// 2.指定解析的xml源
			Document document = reader.read(new File("src/javaee02_XML/02_dom4j.xml"));
			
			// 3.得到元素
			Element rootElement = document.getRootElement();   //根元素root
			
			// 要想使用Xpath，还得添加jar: jaxen-1.1-beta-6.jar
			Element nameElement = (Element)rootElement.selectSingleNode("//name");		// 获取的是第一个
			System.out.println(nameElement.getText());
	
			System.out.println("-----------------");
			
			// 获取文档里面的所有name元素
			List<Element> list = rootElement.selectNodes("//name");
			for(Element element:list){
				System.out.println(element.getText());
			}
			
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

}
