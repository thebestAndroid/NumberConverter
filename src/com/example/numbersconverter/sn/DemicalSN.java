package com.example.numbersconverter.sn;


public class DemicalSN extends SystemNumeration {
	{
		elements = "0123456789.";
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
		case 16:
			result = translateOfSixteen(n[0]);
			break;
		}
		return result;
	}

	 private String translateOfEight(String n) {
		SystemNumeration sn = new BinarySN();
		String number = sn.getNewNumber(n, 8);
		return translateOfBinary(number);
	}

	 private String translateOfSixteen(String n) {
			SystemNumeration sn = new BinarySN();
			String number = sn.getNewNumber(n, 16);
			return translateOfBinary(number);
		}
	private String translateOfBinary(String n){
		
		long number = 0;
		int step = 0;
		for (int i = n.length() - 1; i > -1; i--) {
			number += Integer.parseInt( n.charAt(i) + "")*Math.pow(2, step);
			++step;
		}
		
		return number + "";
	 }
}
