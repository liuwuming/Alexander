package cn.work.SessionOrCookie;

public class SessionOrCookie {
//	String responseCode="";
//	String ip=request.getRemoteAddr(); //获取客户端ip
//	HttpSession session = request.getSession(); 
//	if(ip!=null){
//		Session方式
		
//		int count=0;
//		if(session.getAttribute("count")!=null){
//			count=(Integer)session.getAttribute("count");
//			count++;
//			session.setAttribute("count", count);
//		}else{
//			count++;
//			session.setAttribute("count", count);
//		}
//		if(session.getAttribute("ip")==null){
//			session.setAttribute("ip", ip);
//		}
//		String ip1=(String)session.getAttribute("ip");
//		Integer count1=(Integer) session.getAttribute("count");
		
//		if(ip1.equals(ip) && count1>3){
//			 throw new Exception("您获取验证码的次数过多，请稍后再试!");
//		}else{
//				responseCode = ms.sendMessage(sb.toString(), phone);
//		}
		
//		Cookie方式
//		int count=0;
//		String countValue="";
//		String strValue="";
//		Cookie [] ck1=request.getCookies(); //获取客户端cookies
//		Date d=new Date();
//		 Date OneT=null;
//		 Date TwoT=null;
//		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
//		String oneTime="";
//		String twoTime="";
//		Cookie ck2 = null;
//		Cookie ck3 = null;
//		if(ck1!=null){
//			for(int i=0;i<ck1.length;i++){
//				if(ck1[i].getName().equals(ip) || ck1[i].getName().equals("oneTime")){
//					if(ck1[i].getName().equals(ip)){
//						strValue=ck1[i].getValue();
//					}
//					if(ck1[i].getName().equals("oneTime")){
//						oneTime=ck1[i].getValue();
//					}
//					if(strValue!="" && oneTime!=""){
//						twoTime=format1.format(d);
//						count=new Integer(strValue.toString());
//						count++;
//						countValue=Integer.toString(count);
//						ck2=new Cookie(ip, countValue);
//						ck3=new Cookie("oneTime",twoTime);
//						ck2.setMaxAge(1*1*2*60);  //1年=365*24*60*60
//						ck3.setMaxAge(1*1*2*60);
//						response.addCookie(ck2);
//						response.addCookie(ck3);
//						if(count>3){
//							 throw new Exception("您获取验证码的次数过多，请稍后再试!");
//						}else{
//							  OneT=format1.parse(oneTime);
//							  TwoT=format1.parse(twoTime);
//							  Calendar   c   =   Calendar.getInstance(); 
//							  	c.setTime(OneT); 
//						        long   a1   =   c.getTimeInMillis()  ; 
//						        c.setTime(TwoT); 
//						        long   a2   =   c.getTimeInMillis()   ; 
//						        long a=(a2-a1)/1000;
//						        if(a>60){
//						        	  System.out.println("时间相隔为:"+a+"秒，可以发送短信了");
//						        	  responseCode = ms.sendMessage(sb.toString(), phone);
//						        }else{
//						        	System.out.println("时间相隔为:"+a+"秒，时间还没有到60秒");
//						        }    
//						}
//					}
//				}else if(ck1.length==1) {
//					 oneTime=format1.format(d);
//					 count++;
//					 countValue=Integer.toString(count);
//					 ck2=new Cookie(ip,countValue);
//					 ck3=new Cookie("oneTime",oneTime);
//					 ck2.setMaxAge(1*1*2*60);
//					 ck3.setMaxAge(1*1*2*60);
//					 response.addCookie(ck2);
//					 response.addCookie(ck3);
//					 responseCode = ms.sendMessage(sb.toString(), phone);
//				}
//			}
//		}
//	}
}
