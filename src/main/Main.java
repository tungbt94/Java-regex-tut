package main;

import input.Input;

import java.util.Scanner;

/**
 * Created by tungb on 9/2/2016.
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String phoneNumber = Input.getPhoneNumber(input);
        System.out.println("Your phone number is: " + phoneNumber);
        String name = Input.getName(input);
        System.out.println("Your name: " + name);
        String email = Input.getEmail(input);
        System.out.println("email: " + email);
        String dob = Input.getDate(input);
        System.out.println("dob: " + dob);
    }
}
