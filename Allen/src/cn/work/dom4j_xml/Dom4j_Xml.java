package cn.work.dom4j_xml;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Dom4j_Xml {
		public static void main(String[] args) throws DocumentException {
			dom4j_xml("<?xml version=\"1.0\" encoding=\"GBK\"?>" +
					"<service>" +
					"<evaluatedate>12345</evaluatedate>" +
					"<cognresult>1</cognresult>" +
					"<evaluateresult>1</evaluateresult>" +
					"<evaluatescore>1</evaluatescore>" +
					"<accountmonth>1</accountmonth>" +
					"<resultflag>4</resultflag>" +
					"<monthflag>10</monthflag>" +
					"</service>");
		}
		
		public static void dom4j_xml(String customeridxml) throws DocumentException{
			SAXReader reader = new SAXReader();
			Document document = null;
			document = reader.read(new StringReader(customeridxml));
			Element root = document.getRootElement();
			/**
			 * 方法1
			 */
//			Element foo; 
//			String mess = "";
			//遍历出单个属性和值
//			for (Iterator i = root.elementIterator("evaluatedate"); i.hasNext();) { 
//				foo = (Element) i.next(); 
//				mess = foo.getText();
//				System.out.println(mess);
//			} 
			/**
			 * 方法2
			 */
			String mess1 = "";
			String mess2 = "";
			List list=new ArrayList();
			Map map=new HashMap();
			Element foo1;
			//遍历出所有的属性和值  再将值存至map,
			for (Iterator iterator = root.elementIterator(); iterator.hasNext();) {
				 foo1 = (Element) iterator.next();
				 mess2=foo1.getName();
				 mess1 = foo1.getText();
				 map.put(mess2, mess1);
				 System.out.print("value=>"+mess1+",");
				 System.out.println("name=>"+mess2);
			}
			//可用map 去拼接动态的sql语句
			System.out.println(map);
//			String sql="insert into tablename (object a)values ("+mess1+")";
		}
}
