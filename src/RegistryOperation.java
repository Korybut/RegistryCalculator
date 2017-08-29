/**
 * Created by Korybut on 03.07.2017.
 * All operation hexadecimal values:
 * - add
 * - sub
 * - checking overload (up/down)
 */
class RegistryOperation {

    RegistryOperation(){
    }

    // values parameters always be in String type - because return value must be cutting to 16 bytes.

    // sum last four rightmost numbers
    String hexAddw(String a, String b){
        // string parameters to Integer, next summary to HexString
        String result = Integer.toHexString(Integer.parseInt(a, 16) + Integer.parseInt(b, 16));
        result = result.toUpperCase();
        // cut to last 4 characters
        if(result.length()>4) result = result.substring(result.length()-4);
        while(result.length()<4){
            result = "0" + result;
        }
        return result;
    }

    // sum last four rightmost numbers - unsigned
    String hexAddusw(String a, String b){
        // string parameters to Integer, next summary to HexString
        String result = Integer.toHexString(Integer.parseInt(a, 16) + Integer.parseInt(b, 16));
        result = result.toUpperCase();
        if(Integer.parseInt(result,16)>65535) return "FFFF";
        // cut to last 4 characters
        if(result.length()>4) result = result.substring(result.length()-4);
        while(result.length()<4){
            result = "0" + result;
        }
        return result;
    }

    // sum last four rightmost numbers with sign
    String hexAddsw(String a, String b){
        // string parameters to Integer, next summary to HexString
        String result = Integer.toHexString(Integer.parseInt(a, 16) + Integer.parseInt(b, 16));
        result = result.toUpperCase();
        // cut to last 4 characters
        if(result.length()>4) result = result.substring(result.length()-4);
        while(result.length()<4){
            result = "0" + result;
        }

        int aa = Integer.parseInt(a,16);
        int bb = Integer.parseInt(b,16);
        int rs = Integer.parseInt(result,16);

        if((aa<32768 & bb<32768) & rs>32767) return "7FFF";
        else if((aa>32767 & bb>32767) & rs<32768) return "8000";
        else if((aa>32767 & bb>32767) & (rs<aa & rs<bb)) return "8000";
        else return result;
    }

    // substract last four rightmost numbers
    String hexSubw(String a, String b){
        String result = Integer.toHexString(Integer.parseInt(a,16) - Integer.parseInt(b,16));
        result = result.toUpperCase();
        if(result.length()>4) result = result.substring(result.length()-4);
        while(result.length()<4){
            result = "0" + result;
        }
        return result;
    }

    // substract last four rightmost numbers - unsigned
    String hexSubusw(String a, String b){
        String result = Integer.toHexString(Integer.parseInt(a,16) - Integer.parseInt(b,16));
        result = result.toUpperCase();
        if(Integer.parseInt(a,16)<=Integer.parseInt(b,16)) return "0000";
        if(result.length()>4) result = result.substring(result.length()-4);
        while(result.length()<4){
            result = "0" + result;
        }
        return result;
    }

    // substract last four rightmost numbers with sign
    String hexSubsw(String a, String b){
        String result = Integer.toHexString(Integer.parseInt(a,16) - Integer.parseInt(b,16));
        result = result.toUpperCase();
        if(result.length()>4) result = result.substring(result.length()-4);
        while(result.length()<4){
            result = "0" + result;
        }

        int aa = Integer.parseInt(a,16);
        int bb = Integer.parseInt(b,16);
        int rs = Integer.parseInt(result,16);

        if((aa>32768 & bb<32768) & rs<32767) return "8000";
        else if((aa<32767 & bb>32767) & rs>32768) return "7FFF";
        else return result;
    }
}
