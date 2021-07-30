package mg.meddoc.utils;

import mg.meddoc.models.Email;

public class Util {

	public static String generateCode() {
		String code = "";
		for(int i = 0; i < 6; i++) {
			code+=(int)(Math.random()*10);
		}
		return code;
	}
	
	public static boolean isNumber(String number) {
		System.out.println(number.matches("\\d+"));
		return number.matches("\\d+");
	}
	
	public static boolean isPhoneNumber(String number) {
		number = number.replace('+','0');
		return isNumber(number);
	}
	
	public static String toNormalPhoneNumber(String number) {
		if(number.matches("^\\+261[0-9]+"))
			return (number.replace("+261", "0")).toString();
		else if(number.matches("^261[0-9]+"))
			return (number.replace("261", "0")).toString();
		else if(number.matches("^3.[0-9]+"))
			return ("0"+number).toString();
		else if(number.matches("^03.[0-9]+"))
			return number.toString();
		return null;
	}
	
	public static Email sendEmailValidation(String mail, String code) {
		Email email = new Email();
		String from = "noreply@meddoc.mg";
		String to = mail;
		String subject = "Rappel de votre rendez-vous";
		String body = "Bonjour\n" + 
				"\n" + 
				"Votre code pour valider votre compte MEDDoC est le "+code+". Ce code est personnel et ne doit pas être partagé avec une autre personne.\n" + 
				"\n" + 
				"Cordialement.\n" + 
				"\n" + 
				"L’équipe MEDDoC\n" + 
				"";
		email.setFrom(from);
		email.setTo(to);
		email.setSubject(subject);
		email.setBody(body);
		return email;
	}
}
