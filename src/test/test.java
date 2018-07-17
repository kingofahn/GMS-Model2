package test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import dao.TestDAO;

public class test {
	public static void main(String[] args) {
		List<String> lst = TestDAO.getIntance().list();
		int stf = Integer.valueOf(new SimpleDateFormat("yyyy").format(new Date()))+1-1900;
		for(int i=0; i< lst.size(); i++ ) {
			lst.set(i, String.valueOf(
					stf - 
					Integer.parseInt(lst.get(i)))+
					String.format("%02d",(int)((Math.random()*12)+1))+
					String.format("%02d",((int) (Math.random()*31)+1)));
		}
		System.out.println(lst);
	}
}
