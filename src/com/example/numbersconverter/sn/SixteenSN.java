package com.example.numbersconverter.sn;

import java.util.ArrayList;

public class SixteenSN extends SystemNumeration {
	{
		elements = "0123456789ABCDEF.";
	}
	@Override
	public String getNewNumber(String number, int scc) {
		if(scc == elements.length() - 1) return number;
		String n[] = getTwoPartNumber(number);
		String result = "";
		switch (scc) {
		case 2:
			result = translateOfBinary(n[0]);
			break;
		case 8:
			result = translateOfEight(n[0]);
			break;
		case 10:
			result = translateOfDemical(n[0]);
			break;
		}
		return result;
	}
	private String translateOfBinary(String n) {
		String number = "";
		ArrayList<String> al = new ArrayList<String>();
		int cursor = n.length() - 1;
		int count = 0;
		String h = "";
		while (true) {

			h += n.charAt(cursor);

			if (count++ == 3) {
				count = 0;
				h = new StringBuffer(h).reverse().toString();
				al.add(h);
				h = "";
			}
			if (cursor-- == 0) {
				h = new StringBuffer(h).reverse().toString();
				al.add(h);
				break;
			}
		}
		 h= "";
		switch (al.get(al.size() - 1).length()) {
		case 1:
            h = "000" + al.get(al.size() - 1);
			break;
		case 2:
			h = "00" + al.get(al.size() - 1);
			break;
		case 3:
			h = "0" + al.get(al.size() - 1);
			break;
		default:
			break;
		}
		al.remove(al.size() - 1);
		al.add(h);
		for (int i = al.size() - 1; i > -1; i--) {
			if(al.get(i).equals("0000")) number += 0 + "";
			else if(al.get(i).equals("0001")) number += 1 + "";
			else if(al.get(i).equals("0010")) number += 2 + "";
			else if(al.get(i).equals("0011")) number += 3 + "";
			else if(al.get(i).equals("0100")) number += 4 + "";
			else if(al.get(i).equals("0101")) number += 5 + "";
			else if(al.get(i).equals("0110")) number += 6 + "";
			else if(al.get(i).equals("0111")) number += 7 + "";
			else if(al.get(i).equals("1000")) number += 8 + "";
			else if(al.get(i).equals("1001")) number += 9 + "";
			else if(al.get(i).equals("1010")) number +=  "A";
			else if(al.get(i).equals("1011")) number +=  "B";
			else if(al.get(i).equals("1100")) number +=  "C";
			else if(al.get(i).equals("1101")) number +=  "D";
			else if(al.get(i).equals("1110")) number +=  "E";
			else if(al.get(i).equals("1111")) number +=  "F";
			
		}
		return number;
	}

   private String translateOfEight(String n){
	    String number = new BinarySN().getNewNumber(n, 8);
	   return translateOfBinary(number);
   }
   
   private String translateOfDemical(String n){
	   
	  String number = new BinarySN().getNewNumber(n, 10);
	   return translateOfBinary(number);
   }
}
