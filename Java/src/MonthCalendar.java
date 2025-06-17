import java.util.Scanner;

// printing month calendar
/* if startDay = 0 -> Sunday
                  1 -> Monday
                  2 -> Tuesday
                  3 -> Wednesday
                  4 -> Thursday
                  5 -> Friday
                  6 -> Saturday
*/
public class MonthCalendar {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter date in (yyyy/mm/dd): ");
        String date=sc.nextLine();
        String year=date.substring(0,4);
        String month=date.substring(5,7);
        String day=date.substring(8,10);
        if(!validDate(Integer.parseInt(day), Integer.parseInt(month), Integer.parseInt(year))){
            System.out.println("Invalid date");
            return ;
        }
        else printMonthCalendar(Integer.parseInt(month), Integer.parseInt(year), Integer.parseInt(day));
    }
    public static void printMonthCalendar(int month, int year, int startDay){

    }

    public static boolean validDate(int d, int m, int y){
        if(d<1||d>31||m<1||m>12||y<1) return false;
        return d<=daysInMonth(m,y);
    }
    public static boolean leap(int year){
        return (year%100==0&&year%400==0)||(year%100!=0&&year%4==0);
    }
    public static int daysInMonth(int m, int y){
        int days[]={31,28,31,30,31,31,30,31,30,31,30,31};
        if(m==2&&leap(y)) return 29;
        return days[m];
    }
}
