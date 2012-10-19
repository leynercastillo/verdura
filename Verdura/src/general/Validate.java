package general;

import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Leyner
 *
 */
public class Validate {

	/**
	 * @param string
	 * @return
	 */
	public boolean noEmpty(String string){
		String string2 = string.replace(" +", " ").trim();
		if(string2.isEmpty())
			return true;
		else
			return false;
	}

	/**
	 * @param email
	 * @return
	 */
	public boolean isEmail(String email){
		Pattern pattern = null;
		Matcher matcher = null;
		pattern = Pattern.compile(".+@.+\\.[a-z]+");
		matcher = pattern.matcher(email);
		if (matcher.find())
			return true;
		else
			return false;
	}

	/**
	 * @param number
	 * @return
	 */
	public boolean noZero(Integer number){
		if (!number.equals(0) || !number.equals(null))
			return true;
		else
			return false;
	}

	/**
	 * @param string
	 * @return
	 */
	public boolean noSeleccione(String string){
		String string2 = string.replace(" +", " ").trim();
		if (string2.equals("--Seleccione--"))
			return true;
		else
			return false;
	}
	
	/**
	 * @param string
	 * @return
	 */
	public boolean noGuion(String string){
		String string2 = string.replace(" +", " ").trim();
		if (string2.equals("--"))
			return true;
		else
			return false;
	}

	/**
	 * @param date
	 * @return
	 */
	public boolean noPast(Calendar date){
		if (!date.before(new Date()))
			return true;
		else
			return false;
	}

	/**
	 * @param date
	 * @return
	 */
	public boolean noFuture(Calendar date){
		if (!date.after(new Date()))
			return true;
		else
			return false;
	}
}
