package grupouno.dao;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

import javax.swing.text.DateFormatter;

import grupouno.utils.DateConvertUtils;

public class Utilidades {

	/**
	 * Convierte de utils.Date a sql.Date
	 * 
	 * @param f1
	 * @return
	 */
	static java.sql.Date aSQL(java.util.Date f1) {
		java.sql.Date f2 = new java.sql.Date(f1.getTime());
		return f2;
	}

	/**
	 * Convierte de utils.Date a sql.Date
	 * 
	 * @param f1
	 * @return
	 */
	static String aSQL(LocalDate f1) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd");
		String str = f1.format(formatter);
		// System.out.println(str);
		return str;
	}

	/**
	 * Convierte de sql.Date a utils.Date
	 * 
	 * @param date
	 * @return
	 */
	static java.util.Date aUtil(Date date) {
		java.util.Date f2 = new java.util.Date(date.getTime());
		return f2;
	}

	static java.util.Date aUtil(String date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		java.util.Date sd = null;
		try {
			sd = dateFormat.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		java.util.Date f2 = new java.util.Date();
		return sd;
	}

	/**
	 * Convierte de DateSQL a LocalDateTime
	 * 
	 * @param f1
	 * @return
	 */
	// public static LocalDateTime aLocalDateTime(java.sql.Timestamp f1){
	//// System.out.println(" Date SQL: "+ f1);
	// java.util.Date f2 = new java.util.Date(f1.getTime());
	//// System.out.println(" Date Util: "+ f2);
	// return DateConvertUtils.asLocalDateTime(f2);
	// }

	public static String aSQL(LocalDateTime fecha_y_hora) {
		// TODO Auto-generated method stub
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		System.out.print("DESDE LA BASE AL INSERTAR: " + fecha_y_hora.format(formatter));
		return fecha_y_hora.format(formatter);
	}

	// public static LocalDateTime asLocalDateTime(Timestamp timestamp) {
	// // TODO Auto-generated method stub
	// java.util.Date d = DateConvertUtils.asUtilDate(timestamp);
	// return DateConvertUtils.asLocalDateTime(d);
	// }
	//
	public static LocalDateTime asLocalDateTime(String timestamp) {
		// TODO Auto-generated method stub

		// java.util.Date d = DateConvertUtils.asUtilDate(timestamp);
		// return DateConvertUtils.asLocalDateTime(d);
		return LocalDateTime.parse(timestamp, DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm"));
	}

}
