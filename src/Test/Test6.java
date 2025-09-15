package Test;

public class Test6 {
//    public static void main(String[] args) {
//
//
//        String s = new String();
//
//        s = "shyam";
//
//        String s1  = "shyam";
//
//        String s2 = "shyam";
//
//        System.out.println(s);
//
//
//
//
//
//    }


//    public static String reverseString(String s) {
//
////shyam
//        char[] c = s.toCharArray();
////        c  = ['s','h','y','a','m']
//
//        int i = 0 ; int j = c.length-1;
//        //i = 0 ; j = 4;
//        while(i<j){
//            char temp = c[i];
////            temp = 's'
//            c[i] = c[j];
//            c[j] = temp;
//            //[m,a,y,h,s]
//            i++;
//            j--;
//
//        }
//        return new String(c);
//
//    }
//}

//    public class Main{
//
//}

    public static class AditionOperations{


        public int add(int a, int b){
            return a+b;
        }

    }

    public static class Calculator extends AditionOperations{



        @Override
        public int add(int a, int b){
            int result = super.add(a, b);
            int subclassresult = a*b;
            System.out.println(result);
            System.out.println(subclassresult);

            return subclassresult;
        }



    }

    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        calculator.add(1, 2);

        String s = "shyam";
        String s1 = "shyam";

        String s2 = new String("shyam");
        String s3 = new String("shyam");

        System.out.println(s==s1);
        System.out.println(s1==s2);
        System.out.println(s2==s3);
    }





}
//
////        public int add(int a, int b , int c){
////            return a+b+c;
////        }













