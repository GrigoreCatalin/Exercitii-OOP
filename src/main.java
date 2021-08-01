public class main {

        public static String lastString (String[]values){
            if (values.length == 0) {
                return "";
            }

            String result = values[0];
            for (int i = 1; i < values.length; i++) {
                if (result.compareTo(values[i]) > 0) {// i.e. result < values[i]
                    result = values[i];
                    System.out.println(result);
                }
            }
            return result;
        }

        public static void main (String[]args){
            System.out.println("/");
        }
    }

