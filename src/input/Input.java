package input;

import java.util.Scanner;

/**
 * Created by tungb on 9/1/2016.
 */
public class Input {

    /*
    *   Phone start with 0 => "0"
    *   after 0 is 9->10 number => \\d{9,10}
    */
    private static final String PHONE_REGEX = "^" +
            "0" +
            "\\d{9,10}" +
            "$";

    /*
    *   A part of Name is a String like: Bui Thanh Tung, Peter Parker,...
    *   It has 1 upper character and >= 0 lower character after that => a part: ([A-Z][a-z]*)
    *   A name has >= 1 parts: "([A-Z][a-z]*)+"
    *   And has >= 0 parts, before each of these part is a space (\\s) => (\\s([A-Z][a-z]*))*
    *   => a full name: ([A-Z][a-z]*)+(\s([A-Z][a-z]*))*
    */
    private static final String NAME_REGEX = "^" +
            "([A-Z][a-z]*)+" +
            "(\\s([A-Z][a-z]*))*" +
            "$";

    /*
    *   Email has 3 part: name@domain
    *   name start with not number, can has '.'( or '-','@',...), like: a-team.co, STu.ptit, sp.us-uk, name,...
    *   name: [_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*
    *   domain start with a name (not start with _) : [A-Za-z0-9-]+
    *   and >= 0 group start with '.' like: .com, .abc.zxy, .ptit.edu => (\\.[A-Za-z0-9-]+)*
    *   end of domain is a group like: .vn, .org,... => (\\.[A-Za-z]{2,})  //{2,} because it has at least 2 character
    */
    private static final String EMAIL_REGEX = "^" +
            "[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*" +
            "@" +
            "[A-Za-z0-9-]+" +
            "(.[A-Za-z0-9-]+)*" +
            "(.[A-Za-z]{2,})" +
            "$";

    /*
    * Date has 3 part: date-month-year or date/month/year
    * here we ignore exception like 30-02-2016
    * date: from 01 to 31 => [0-3]\\d
    * month: from 01 to 12 => (0|1)\\d
    * year: YYYY => \\d{1,4}
    */
    private static final String DATE_REGEX = "^" +
            "[0-3]\\d" +
            "[-/]" +
            "(0|1)\\d" +
            "[-/]" +
            "\\d{1,4}" +
            "$";


    public static String getPhoneNumber(Scanner input){
        System.out.print("Please type your phone number: ");
        String temp = input.nextLine();
        //while input is not phone number, type again
        while (!isMatched(temp, PHONE_REGEX)){
            System.out.print("Not a phone number. Please type your phone number: ");
            temp = input.nextLine();
        }
        return temp;
    }

    public static String getName(Scanner input){
        System.out.print("Please type your full name: ");
        String temp = input.nextLine();
        //while input is not name, type again
        while (!isMatched(temp, NAME_REGEX)){
            System.out.print("Not a full name. Please type your full name: ");
            temp = input.nextLine();
        }
        return temp;
    }

    public static String getEmail(Scanner input){
        System.out.print("Please type your email address: ");
        String temp = input.nextLine();
        //while input is not name, type again
        while (!isMatched(temp, EMAIL_REGEX)){
            System.out.print("Not a email address. Please type your email address: ");
            temp = input.nextLine();
        }
        return temp;
    }

    public static String getDate(Scanner input){
        System.out.print("Please type your date of birth: ");
        String temp = input.nextLine();
        //while input is not name, type again
        while (!isMatched(temp, DATE_REGEX)){
            System.out.print("Not a date of birth. Please type your date of birth: ");
            temp = input.nextLine();
        }
        return temp;
    }


    private static boolean isMatched(String input, String regex){
        return input.matches(regex);
    }
}
