public class Calendar1 {
    public static void main(String[] args){
        System.out.println(validDate(17,6,2025));
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
