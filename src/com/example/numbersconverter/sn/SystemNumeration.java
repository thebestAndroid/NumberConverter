package com.example.numbersconverter.sn;
public abstract  class SystemNumeration {
	protected String elements;
    
	
	public final boolean rule(String number) {
		boolean m = true;
		for (char x : number.toCharArray()) {
			for (int i = 0; i < elements.length(); i++) {
				if(x == elements.charAt(i)) break;
				if(i == elements.length() - 1) m = false;
			}
		}
		return m ;
	}
    
	public final String[] getTwoPartNumber(String number) {
		int i = -1;
		boolean m = false;
		while (++i < number.length() - 1) {
			if (number.charAt(i) == '.'){
				m = true;
                break;
			}
		}
		
       String twoPart[] = new String[2]; 
       if(m){
       twoPart[0] = number.substring(0, i);
       twoPart[1] = number.substring(i+1 , number.length());
       }
       else{
    	   twoPart[0] = number;
           twoPart[1] = new String();
       }
       return twoPart;
       
	}
    // метод переводить число в нову СЧ 
    public abstract String getNewNumber(String number, int scc);
}
