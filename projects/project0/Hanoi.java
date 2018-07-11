import java.lang.*;


class Hanoi{
    public static void main(String[] args){
        // do sth...
        
        int n = Integer.parseInt(args[0]);
        
        Hanoi("a","b","c",n);
       
        
    }
    
    private static void Hanoi(String start, String mid, String end, int n){
        
        if( n == 0 ){
            return;
        }
        
        Hanoi(start, end, mid , n-1);
        
        System.out.println("move " + n + " from " + start + " to " + end );

        Hanoi(mid,start,end,n-1);
        
    }
    
    
}

