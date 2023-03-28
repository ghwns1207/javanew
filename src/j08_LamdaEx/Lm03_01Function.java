package j08_LamdaEx;
import java.util.function.Function;

// ** FunctionalInterface 1
// => Function <T, R> 

class Lm03_01Function {
    public static void main(String[] args) {
    	
    	// ** String 의 길이를 return
    	// int apply(String s) { return s.length();  }
        Function<String, Integer> f = s -> s.length();
        // 스트링을 입력 받아 인트로 리턴 
        
        System.out.println(f.apply("Robot"));
        System.out.println(f.apply("System"));
        
        // ** Double 입력받아 Double return
        // double apply(double d) { return d * 0.393701;  }
        Function<Double, Double> cti = d -> d * 0.393701;
        Function<Double, Double> itc = d -> d * 2.54;
        // 더블 받고 더블 리턴 
        System.out.println("1cm = " + cti.apply(1.0) + "inch");
        System.out.println("1inch = " + itc.apply(1.0) + "cm");
        
    } // main
} // class