package XMJ_JSON;

public class PESEL {

    public static boolean isValidPesel(String pesel){
        int[] intPesel = peselArray(pesel);
        if (intPesel.length==11){
            //9×a + 7×b + 3×c + 1×d + 9×e + 7×f + 3×g + 1×h + 9×i + 7×j
            int result = 9*intPesel[0]
                        +7*intPesel[1]
                        +3*intPesel[2]
                        +1*intPesel[3]
                        +9*intPesel[4]
                        +7*intPesel[5]
                        +3*intPesel[6]
                        +1*intPesel[7]
                        +9*intPesel[8]
                        +7*intPesel[9];
            if (result%10==intPesel[10]&&intPesel[4]<=3&&intPesel[5]<=9){
                return true;
            }
        }
        return false;
    }
    public static Gender getGenderByPesel(String pesel){
        int[] intPesel = peselArray(pesel);
        if (intPesel[9]%2!=0){
            return Gender.MALE;
        }
        return Gender.FEMALE;
    }

    public static String getDateOfBirth(String pesel){
        int[] intPesel = peselArray(pesel);
        int year = intPesel[0]*10 + intPesel[1];
        int month = 0;
        switch (intPesel[2]){
            case 8:
            case 9:
                month = (intPesel[2]-8)*10+intPesel[3];
                year+=1800;
                break;

            case 0:
            case 1:
                month = (intPesel[2])*10+intPesel[3];
                year+=1900;
                break;

            case 2:
            case 3:
                month = (intPesel[2]-2)*10+intPesel[3];
                year+=2000;
                break;

            case 4:
            case 5:
                month = (intPesel[2]-4)*10+intPesel[3];
                year+=2100;
                break;

            case 6:
            case 7:
                month = (intPesel[2]-6)*10+intPesel[3];
                year+=2200;
                break;
        }
        int day = intPesel[4]*10+intPesel[5];
        String result =year+"."+month+"."+day;
        return result;
    }


    private static int[] peselArray(String pesel){
        String[] arrPesel = pesel.split("");
        int[] intPesel = new int[arrPesel.length];
        for (int i = 0; i <intPesel.length ; i++) {
            intPesel[i]=Integer.parseInt(arrPesel[i]);
        }
        return intPesel;
    }
}
