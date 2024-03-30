
package Assignment2;
public class LCM_calculation {
    public int gcd(int x,int y)
    {
        if (y == 0) {
           return x;
        } else {
           return gcd(y,x%y);
       }
   }
   public int lcm(int x ,int y)
   {
       return (x*y)/ gcd(x,y);
   }
   public int lcm_combo(int x, int y,int z)
   {
       int lcm_xy = lcm(x,y);
       return lcm(lcm_xy,z);
   }
}
