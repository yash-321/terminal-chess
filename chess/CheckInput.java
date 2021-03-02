package chess;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckInput {
	
	//This method requires your input
	public static boolean checkCoordinateValidity(String input){
		Pattern pattern = Pattern.compile("^[1-8][a-h]$");
		Matcher matcher = pattern.matcher(input);
		return matcher.find();
	}
}
