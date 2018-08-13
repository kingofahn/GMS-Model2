package pool;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileDemo {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		/*FileName fn = new FileName(PATH);*/
		final String PATH = "C:\\Users\\hb1001\\Documents\\sample.txt";
		try {
			File file = new File(PATH);
			FileWriter fw = new FileWriter(file, true);
			FileReader fr = new FileReader(file);
			BufferedWriter writer = new  BufferedWriter(fw);
			BufferedReader reader = new BufferedReader(fr);
			while(true) {
				System.out.println("[메뉴] 1.전송, 2.읽기 0.종료");
				switch(s.next()) {
				case "1" :
					System.out.println("메시지 입력");
					writer.write(s.next());
					writer.newLine();
					writer.flush();  // 한번에 센딩
					break;
				case "2" :
					System.out.println("메시지 보기");
					String msg ="";
					while((msg = reader.readLine())!=null) {
						System.out.println(msg);
					}
					reader.close();
					break;
				case "0" :
					System.out.println("메시지 입력");
					return;
				default :
					break;
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}	
class FileName {
	private String path,sep,ext,filename;
	public FileName(String path) {
		this.path = path;
		System.out.println("path : " + path);
		this.sep = File.separator;
		this.ext = path.substring(path.lastIndexOf(".")+1);
		this.filename = path.substring((path.lastIndexOf(sep)+1),path.lastIndexOf("."));
	}
	public String getPath() {
		return path;
	}
	public String getSep() {
		return sep;
	}
	public String getExt() {
		return ext;
	}
	public String getFilename() {
		return filename;
	}

}