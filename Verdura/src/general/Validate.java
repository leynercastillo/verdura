package general;

import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Leyner
 * @since 18/10/2012
 * @version 0.1 Update 19/10/12
 */
public class Validate {

	/**
	 * @param string
	 * @return <b>True</b> Si <i>string</i> no esta vacio. <br>
	 *         <b>False</b> Si <i>string</i> esta vacio.
	 */
	public boolean noEmpty(String string){
		String string2 = string.replace(" +", " ").trim();
		if(!string2.isEmpty())
			return true;
		else
			return false;
	}

	/**
	 * @param email
	 * @return <b>True</b> Si <i>email</i> es un email. <br>
	 *         <b>False</b> Si <i>email</i> no es un email.
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
	 * @return <b>True</b> Si <i>number</i> no es cero. <br>
	 *         <b>False</b> Si <i>number</i> es cero.
	 */
	public boolean noZero(Integer number){
		if (!number.equals(0) || !number.equals(null))
			return true;
		else
			return false;
	}

	/**
	 * @param string
	 * @param compare
	 * @return <b>True</b> Si <i>string</i> es igual a <i>compare</i> <br>
	 *         <b>False</b> Si <i>string</i> no es igual <i>compare</i>.
	 */
	public boolean equalString(String string, String compare){
		String string2 = string.replace(" +", " ").trim();
		if (string2.equals(compare))
			return true;
		else
			return false;
	}

	/**
	 * @param date
	 * @return <b>True</b> Si <i>date</i> tiene fecha menor al dia de hoy.<br>
	 *         <b>False</b> Si <i>date</i> no tiene fecha menor al dia de hoy.
	 */
	public boolean datePast(Calendar date){
		if (date.before(new Date()))
			return true;
		else
			return false;
	}

	/**
	 * @param date
	 * @return <b>True</b> Si <i>date</i> tiene fecha mayor al dia de hoy.<br>
	 *         <b>False</b> Si <i>date</i> no tiene fecha mayor al dia de hoy.
	 */
	public boolean dateFuture(Calendar date){
		if (date.after(new Date()))
			return true;
		else
			return false;
	}
}
