package com.example.numbersconverter.sn;
import java.util.ArrayList;

public class BinarySN extends SystemNumeration {
	{
		elements = "01.";
	}

	@Override
	public String getNewNumber(String number, int scc) {
		if(scc == elements.length() - 1) return number;
		String n[] = getTwoPartNumber(number);
		String result = "";
		switch (scc) {
		case 10:
			result = translateOfDecimal(n[0]);
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

	private String translateOfDecimal(String n) {
		long number;
		try {
			number = Long.parseLong(n);
		} catch (Exception e) {
			return " ";
		}
		ArrayList<Long> ostatok = new ArrayList<Long>();
		long s;
		long ost;
		while (true) {
			s = number / 2;
			ost = number % 2;
			if (number < 2)
				break;
			ostatok.add(ost);
			number = s;
		}
		ostatok.add(number);
		String result = "";
		for (int i = ostatok.size() - 1; i > -1; i--) {
			result += ostatok.get(i);
		}
		return result;
	}

	private String translateOfEight(String n) {
		char[] mass = n.toCharArray();
		String number = "";

		for (char x : mass) {
			switch (x) {
			case '0':
				number += "000";
				break;
			case '1':
				number += "001";
				break;
			case '2':
				number += "010";
				break;
			case '3':
				number += "011";
				break;
			case '4':
				number += "100";
				break;
			case '5':
				number += "101";
				break;
			case '6':
				number += "110";
				break;
			case '7':
				number += "111";
				break;

			}
		}

		return number;
	}

	private String translateOfSixteen(String n) {
		char[] mass = n.toCharArray();
		String number = "";

		for (char x : mass) {
			switch (x) {
			case '0':
				number += "0000";
				break;
			case '1':
				number += "0001";
				break;
			case '2':
				number += "0010";
				break;
			case '3':
				number += "0011";
				break;
			case '4':
				number += "0100";
				break;
			case '5':
				number += "0101";
				break;
			case '6':
				number += "0110";
				break;
			case '7':
				number += "0111";
				break;
			case '8':
				number += "1000";
				break;
			case '9':
				number += "1001";
				break;
			case 'A':
				number += "1010";
				break;
			case 'B':
				number += "1011";
				break;
			case 'C':
				number += "1100";
				break;
			case 'D':
				number += "1101";
				break;
			case 'E':
				number += "1110";
				break;
			case 'F':
				number += "1111";
				break;

			}
		}
		return number;
	}
}
