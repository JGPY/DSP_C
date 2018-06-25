package vip.iotworld.main;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.Charset;


public class Test {
	public static final String IP="192.168.31.100";//服务器地址
//	public static final String IP="127.0.0.1";
	public static final int PORT=4601;//服务器端口
//	public static final int PORT=9999;//服务器端口
	static Charset charset=Charset.forName("iso8859-1");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		handler();

	}
	private static void handler(){
		try{
			Socket client=new Socket(IP,PORT);
			System.out.println("THIS IS A CLIENT");
			//开启两个线程，一个负责读，一个负责写
			//new Thread(new WriteHandlerThread(client)).start();
//			new Thread(new ReadHandlerThread(client)).start();
		    new Thread(new WriteHandlerThread4(client)).start();
	}catch (Exception e) {    
        e.printStackTrace();    
		}    
	}
	
	public static byte[] hexToBytes(String hexString) {   
        if (hexString == null || hexString.equals("")) {   
            return null;   
        }   

        int length = hexString.length() / 2;   
        char[] hexChars = hexString.toCharArray();   
        byte[] bytes = new byte[length];   
        String hexDigits = "0123456789abcdef";
        for (int i = 0; i < length; i++) {   
            int pos = i * 2; // 两个字符对应一个byte
            int h = hexDigits.indexOf(hexChars[pos]) << 4; // 注1
            int l = hexDigits.indexOf(hexChars[pos + 1]); // 注2
            if(h == -1 || l == -1) { // 非16进制字符
                return null;
            }
            bytes[i] = (byte) (h | l);   
        }   
        return bytes;   
    }
}

/*
 *处理写操作的线程 
 */
class WriteHandlerThread4 implements Runnable{
	private Socket client;
	public WriteHandlerThread4(Socket client){
		this.client=client;
	}
	@Override
	public void run() {
		DataOutputStream dataOutputStream=null;
		DataInputStream dataInputStream=null;
		try {
			/*out=new PrintWriter(client.getOutputStream());*/
			  dataOutputStream = new DataOutputStream(client.getOutputStream());
			  dataInputStream = new DataInputStream(client.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//从控制台获取输入内容
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		try{
//			char ch = \x0b;
			String str="MSH|^~\\&|||||||QRY^R02|1203|P|2.3.1\r" + 
					"QRF|MON||||0&0^1^1^1^204\r\r";
//			byte[] bytes = str.getBytes();
//			byte[] bytes1 = {11,};
//			bytes1[1]="M".getBytes();
			
			System.out.println("str: "+str.getBytes());
	
			while(true){ 
				dataOutputStream.write(str.getBytes()); 
				dataOutputStream.flush();
				String readLine = dataInputStream.readLine();
				System.out.println(readLine);
//				dataOutputStream.write(str.getBytes());
		}
		}catch(IOException e) {    
            e.printStackTrace();       
        }  

	}
}
