package cn.work.dom4j_xml;

import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

public class Jdom2_Xml {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		   System.out.println(Jdom2_Xml.obtainValue("pSize"));

	}
	
	 /**
     * @方法名: obtainValue 
     * @参数名：@param name：属性名
     * @参数名：@return           ：返回与属性名一致的属性值
     * @描述语: 解析XML数据,返回与属性名一致的属性值,查找不到匹配属性名则返回null
     */
    public static String obtainValue(String name){
    	 try {
         //创建一个SAXBuilder对象
           SAXBuilder saxBuilder = new SAXBuilder();                       
           //读取prop.xml资源         
           Document doc = saxBuilder.build("src/cn/work/dom4j_xml/test.xml");
         //获取根元素(prop)
         Element root = doc.getRootElement();
         //获取根元素下面的所有子元素(mess)
         List<Element> messList = root.getChildren("mess");
         //子根元素(mess)
         Element childrenRoot = null;
         //property元素集合
           List<Element> propertyList = null;
         //遍历根元素的子元素集合(即遍历mess元素)
         for(int i = 0; i < messList.size(); i++){
              //将根元素prop下的mess子元素作为一个新的子根元素
                childrenRoot = messList.get(i);
             //获取子根元素mess下的所有property子元素
                propertyList = childrenRoot.getChildren("property");
             //遍历子根元素的子元素集合(即遍历property元素)
             for(int j = 0; j < propertyList.size(); j++){
                 //获取property元素
                    Element element = propertyList.get(j);
                 //element.getAttributeValue("name")：获取property中name属性的值
                    if(element.getAttributeValue("name").equals(name)){        //如果name的值一致
                       return element.getAttributeValue("value");            //取得name对应的value属性值
                    }
             }
         }
         //遍历完没有查找到结果返回null
         return null;
         } catch (Exception e) {e.printStackTrace();} 
         return null;
     }

}
