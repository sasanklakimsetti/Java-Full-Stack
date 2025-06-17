import java.sql.Date;
import java.time.LocalDate;

public class DateFunctions {
    public static void main(String[] args){
        java.sql.Date date= java.sql.Date.valueOf(LocalDate.now());
        java.sql.Date date2=java.sql.Date.valueOf("2025-06-15");
        System.out.println(date);
        System.out.println(date2);

        // Convert java.util.Date to java.sql.Date
        java.util.Date utilDate= new java.util.Date();
        java.sql.Date sqlDate=new java.sql.Date(utilDate.getTime());
        System.out.println("UtilDate: "+utilDate);
        System.out.println("SQL Date: "+sqlDate);
        // LocalDate to java.sql.Date
        LocalDate localDate=LocalDate.now();
        java.sql.Date sqlDate2=java.sql.Date.valueOf(localDate);
        System.out.println("LocalDate: "+localDate);
        System.out.println("SQLDate: "+sqlDate2);
        // java.sql.Date to LocalDate using factory methods or Constructors
        java.sql.Date sqlDate3=java.sql.Date.valueOf("2025-06-17");
        LocalDate localDate2=sqlDate3.toLocalDate();
        System.out.println("SQL Date: " +sqlDate3);
        System.out.println("LocalDate: "+localDate2);
    }
}
