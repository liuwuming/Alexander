package cn.work.FileOrIO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class FileTest {
	public static void main(String[] args) throws Exception {
		FileTest ft=new FileTest();
		
		ft.Filetest("E:/File/ggg.asp");
		
//		String str=ft.getInputMessage();
//		System.out.println(str);
		
//		ft.copyFile("E:/File/test.txt","E:/File/555.txt");
		
//		ft.PrintStreamDemo();
		
//		ft.StringBufferDemo();
		
//		ft.renameFile("E:/File","bbb.txt","CCC.txt");
		
//		ft.changeDirectory("555.txt", "E:/File", "F:/File", true);
		
//		String str=ft.FileInputStreamDemo("E:/File/test.txt");
//		System.out.println(str);
		
//		String str1=ft.BufferedReaderDemo("E:/File/test.txt");
//		System.out.println(str1);
		
//		Document d =ft.readXml("E:/File/hh.xml");
//		String str3="";
//		Element root=d.getRootElement();
//		Element foo; 
//		for (Iterator i = root.elementIterator("hand"); i.hasNext();) { 
//			foo = (Element) i.next(); 
//			str3 = foo.getText();
//		} 
//		System.out.println(str3);
		
		
//		ft.delDir("E:/File1/");
	}
	/**
	 * 一.获得控制台用户输入的信息
	 * @return
	 * @throws IOException
	 */
	public String getInputMessage() throws IOException{
        System.out.println("请输入您的命令∶");
        byte buffer[]=new byte[1024];
        int count=System.in.read(buffer);
        char[] ch=new char[count-2];//最后两位为结束符，删去不要
        for(int i=0;i<count-2;i++)
            ch[i]=(char)buffer[i];
        String str=new String(ch);
        return str;
    }
	/**二.复制文件
	 * 以文件流的方式复制文件
	 * 该方法经过测试，支持中文处理，并且可以复制多种类型，比如txt，xml，jpg，doc等多种格式
	 * @param file1
	 * @param file2
	 * @throws IOException
	 */
	public void copyFile(String fiel1,String file2) throws IOException{
        FileInputStream in=new FileInputStream(fiel1);
        File file=new File(file2);
        if(!file.exists())
            file.createNewFile();
        FileOutputStream out=new FileOutputStream(file);
        int c;
        byte buffer[]=new byte[1024];
        while((c=in.read(buffer))!=-1){
            for(int i=0;i<c;i++)
                out.write(buffer[i]);        
        }
        in.close();
        out.close();
    }
	
	 /**
	  * 2.利用StringBuffer写文件
	  * 该方法可以设定使用何种编码，有效解决中文问题。
	  * @throws IOException
	  */
	 public void StringBufferDemo() throws IOException{
	          File file=new File("E:/File/File.sql");
	          if(!file.exists())
	              file.createNewFile();
	          
	          FileOutputStream out=new FileOutputStream(file,true);        
	          for(int i=0;i<500;i++){
	              StringBuffer sb=new StringBuffer();
	              sb.append("这是第"+i+"行:前面介绍的各种方法都不关用,为什么总是奇怪的问题 ");
	              out.write(sb.toString().getBytes("utf-8"));
	          }        
	          out.close();
	      }

	/**
	 * 三.写文件
     *  1.利用PrintStream写文件
	 */
	public void PrintStreamDemo(){
        try {
            FileOutputStream out=new FileOutputStream("E:/File/bbb.txt");
            PrintStream p=new PrintStream(out);
            for(int i=0;i<10;i++)
                p.println("This is "+i+" line");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
	/**
	 * 四.文件重命名
	 * @param path
	 * @param oldname
	 * @param newname
	 */
	public void renameFile(String path,String oldname,String newname){
        if(!oldname.equals(newname)){//新的文件名和以前文件名不同时,才有必要进行重命名
            File oldfile=new File(path+"/"+oldname);
            File newfile=new File(path+"/"+newname);
            if(newfile.exists())//若在该目录下已经有一个文件和新文件名相同，则不允许重命名
                System.out.println(newname+"已经存在！");
            else{
                oldfile.renameTo(newfile);
            }
        }         
    }
	/**
	 *   五.转移文件目录
     转移文件目录不等同于复制文件，复制文件是复制后两个目录都存在该文件，而转移文件目录则是转移后，只有新目录中存在该文件。
	 * @param filename
	 * @param oldpath
	 * @param newpath
	 * @param cover
	 */
	public void changeDirectory(String filename,String oldpath,String newpath,boolean cover){
        if(!oldpath.equals(newpath)){
            File oldfile=new File(oldpath+"/"+filename);
            File newfile=new File(newpath+"/"+filename);
            if(newfile.exists()){//若在待转移目录下，已经存在待转移文件
                if(cover)//覆盖
                    oldfile.renameTo(newfile);
                else
                    System.out.println("在新目录下已经存在："+filename);
            }
            else{
                oldfile.renameTo(newfile);
            }
        }       
    }
	/**
	 * 六.读文件
     1.利用FileInputStream读取文件
	 * @param path
	 * @return
	 * @throws IOException
	 */
	 public String FileInputStreamDemo(String path) throws IOException{
         File file=new File(path);
         if(!file.exists()||file.isDirectory())
             throw new FileNotFoundException();
         FileInputStream fis=new FileInputStream(file);
         byte[] buf = new byte[1024];
         StringBuffer sb=new StringBuffer();
         while((fis.read(buf))!=-1){
             sb.append(new String(buf));    
             buf=new byte[1024];//重新生成，避免和上次读取的数据重复
         }
         return sb.toString();
     }
	 /**
	  * 2.利用BufferedReader读取
     	在IO操作，利用BufferedReader和BufferedWriter效率会更高一点
	  */
     public String BufferedReaderDemo(String path) throws IOException{
         File file=new File(path);
         if(!file.exists()||file.isDirectory())
             throw new FileNotFoundException();
         BufferedReader br=new BufferedReader(new FileReader(file));
         String temp=null;
         StringBuffer sb=new StringBuffer();
         temp=br.readLine();
         while(temp!=null){
             sb.append(temp+" ");
             temp=br.readLine();
         }
         return sb.toString();
     }
     /**
      *   3.利用dom4j读取xml文件
      * @param path
      * @return
      * @throws DocumentException
      * @throws IOException
      */
     public Document readXml(String path) throws DocumentException, IOException{
         File file=new File(path);
         BufferedReader bufferedreader = new BufferedReader(new FileReader(file));
         SAXReader saxreader = new SAXReader();
         Document document = (Document)saxreader.read(bufferedreader);
         bufferedreader.close();
         return document;
     }

     /***
      * 七.创建文件(文件夹)
		1.创建文件夹  
      * @param path
      */
     public void createDir(String path){
         File dir=new File(path);
         if(!dir.exists())
             dir.mkdir();
     }

     /**
      * 2.创建新文件
      * @param path
      * @param filename
      * @throws IOException
      */
     public void createFile(String path,String filename) throws IOException{
         File file=new File(path+"/"+filename);
         if(!file.exists())
             file.createNewFile();
     }
	/**
	 *      八.删除文件(目录)
	 *      1.删除文件    
	 */
      
      public void delFile(String path,String filename){
          File file=new File(path+"/"+filename);
          if(file.exists()&&file.isFile())
              file.delete();
      }
    
      /**
       * 2.删除目录
	   *要利用File类的delete()方法删除目录时，必须保证该目录下没有文件或者子目录，
	   *否则删除失败，因此在实际应用中，我们要删除目录，
	   *必须利用递归删除该目录下的所有子目录和文件，然后再删除该目录。  
       * @param path
       */
      public void delDir(String path){
          File dir=new File(path);
          if(dir.exists()){
              File[] tmp=dir.listFiles();
              for(int i=0;i<tmp.length;i++){
                  if(tmp[i].isDirectory()){
                      delDir(path+"/"+tmp[i].getName());
                  }
                  else{
                      tmp[i].delete();
                  }
              }
              dir.delete();
          }
      }


     
	/**
	 * 创建删除文件
	 */
	public void Filetest(String path){
		try {
			path.getBytes("utf-8");
//			String path="E:/File/ppp.pdf";
			File f=new File(path);
			if(!f.getParentFile().exists()){   //如果该目录不存在则创建该目录
				f.mkdir();
			}
//			File f=new File(path+"/test.txt");
			f.createNewFile();  //创建文件
			
//			System.out.println(f.getParent());//父目录
//			System.out.println(f.getPath()); // 路径
//			System.out.println(f.getParentFile());
			
//			String [] str=f.list();
//			for (int i = 0; i < str.length; i++) {
//				System.out.println(str[i]);//输出E:/File下的文件名称
//			}
			/**
			 * 写入文件
			 */
			FileWriter fw=new FileWriter(f);
			PrintWriter pw=new PrintWriter(fw);
			pw.print("哈哈哈");
			fw.close();
//			
//			FileWriter fws=new FileWriter(f);
//			fws.write("wwwww");
//			fws.close();
			
			/**
			 * 在E:/File/test.txt文件中追加fuck内容
			 */
//			RandomAccessFile randomFile = new RandomAccessFile("E:/File/test.txt", "rw"); 
//			// 文件长度，字节数 
//			long fileLength = randomFile.length(); 
//			randomFile.seek(fileLength); 
//			randomFile.writeBytes("fuck"); 
//			randomFile.close(); 

			/**
			 * 将文件名称修改成第二个文件名
			 */
//			File dir1=new File("E:/File/aaa.txt");
//			File dir2=new File("E:/File/bbb.txt");
//			dir1.renameTo(dir2); //将dir1的文件名称 改为dir2的文件名称
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
