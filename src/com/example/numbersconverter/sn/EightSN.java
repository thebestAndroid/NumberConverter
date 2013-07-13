package com.example.numbersconverter.sn;


import java.util.ArrayList;

public class EightSN extends SystemNumeration {
	{
		elements = "01234567.";
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
		case 10:
			result = translateOfDemical(n[0]);
			break;
		case 16:
			result = translateOfSixteen(n[0]);
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

			if (count++ == 2) {
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
            h = "00" + al.get(al.size() - 1);
			break;
		case 2:
			h = "0" + al.get(al.size() - 1);
			break;

		default:
			break;
		}
		al.remove(al.size() - 1);
		al.add(h);
		for (int i = al.size() - 1; i > -1; i--) {
			if(al.get(i).equals("000")) number += 0 + "";
			else if(al.get(i).equals("001")) number += 1 + "";
			else if(al.get(i).equals("010")) number += 2 + "";
			else if(al.get(i).equals("011")) number += 3 + "";
			else if(al.get(i).equals("100")) number += 4 + "";
			else if(al.get(i).equals("101")) number += 5 + "";
			else if(al.get(i).equals("110")) number += 6 + "";
			else if(al.get(i).equals("111")) number += 7 + "";
			
		}
		return number;
	}
    private String translateOfDemical(String n){
    	String number = "";
    	number = new BinarySN().getNewNumber(n, 10);
    	return translateOfBinary(number);
    }
    private String translateOfSixteen(String n){
    	String number = "";
    	number = new BinarySN().getNewNumber(n, 16);
    	return translateOfBinary(number);
    }
}
