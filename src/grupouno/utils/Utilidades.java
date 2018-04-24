package grupouno.utils;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

public class Utilidades {
	
	/**
	 * Convierte de utils.Date a sql.Date
	 * @param f1
	 * @return
	 */
    public static java.sql.Date aSQL(java.util.Date f1){
    	java.sql.Date f2 = new java.sql.Date(f1.getTime());
    	return f2;
    }
	/**
	 * Convierte de utils.Date a sql.Date
	 * @param f1
	 * @return
	 */
    public static String aSQL(LocalDate f1){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		String str = f1.format(formatter);
//		System.out.println(str);
    	return str;
    }    
	/**
	 * Convierte de sql.Date a utils.Date
	 * @param date
	 * @return
	 */    
    public static  java.util.Date aUtil(Date date){
    	java.util.Date f2 = new java.util.Date(date.getTime());
    	return f2;
    }

	/**
	 * Convierte de DateSQL a LocalDateTime
	 * @param f1
	 * @return
	 */    
    public static  LocalDateTime aLocalDateTime(java.sql.Timestamp f1){
//    	System.out.println("  Date SQL: "+ f1);
    	java.util.Date f2 = new java.util.Date(f1.getTime());
//    	System.out.println("  Date Util: "+ f2);
    	return DateConvertUtils.asLocalDateTime(f2);
    }    
    
	public static String aSQL(LocalDateTime fecha_y_hora) {
		// TODO Auto-generated method stub
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		return fecha_y_hora.format(formatter);
	}
	public static LocalDateTime asLocalDateTime(Timestamp timestamp) {
		// TODO Auto-generated method stub
		java.util.Date d = DateConvertUtils.asUtilDate(timestamp);
		return DateConvertUtils.asLocalDateTime(d);
	}
    
	public static LocalDateTime asLocalDateTime(String timestamp) {
		// TODO Auto-generated method stub
		
		
//		java.util.Date d = DateConvertUtils.asUtilDate(timestamp);
//		return DateConvertUtils.asLocalDateTime(d);
		return LocalDateTime.parse(timestamp, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
	}
    
}
