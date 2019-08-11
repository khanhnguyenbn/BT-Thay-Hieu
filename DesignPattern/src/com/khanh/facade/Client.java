package com.khanh.facade;

public class Client {
	
	public static void main(String[] args) {
		// get acount with this email to buy product freeship
        ShopFacade.getInstance().buyProductByCashWithFreeShipping("contact@gpcoder.com");
        
        
        // get acount with this email and send sms to this phone number
        ShopFacade.getInstance().buyProductByPaypalWithStandardShipping("gpcodervn@gmail.com", "0988.999.999");
    }

}
