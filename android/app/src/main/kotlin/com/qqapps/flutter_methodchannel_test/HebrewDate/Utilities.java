package com.qqapps.flutter_methodchannel_test.HebrewDate;import java.util.TimeZone;import java.text.DateFormat;import java.text.SimpleDateFormat;import java.util.Calendar;import java.util.Date;class Utilities{	private String jodesh;	private int yom;	private int shana;	private Boolean isLeapYear;	/** Gets a degree in decimal form. */	public static double getDecimalDegree(int degree, int minute, int second)	{		double total= (double) second / 60;		total= (total + minute) / 60;		total += degree;		return total;	}	/** Gets a String of the form degree&deg; minute' second" from a degree in	* decimal form. Always returns the absolute value. */	public static String getDegreeString(double degree)	{		degree= Math.abs(degree);		int d= (int) degree;		degree -= d;		degree *= 60;		int minute= (int) degree;		degree -= minute;		degree *= 60;		int second= (int) degree;		return Integer.toString(d) + "&deg; " + minute + "' " + second + "\"";	}    public static String[] getTimeZoneList()    {        String[] list= TimeZone.getAvailableIDs();        TimeZone zone;        for (int i=0; i < list.length; i++)        {            zone = TimeZone.getTimeZone(list[i]);            int offset= zone.getRawOffset();            offset= offset/3600000;            list[i]= list [i] + " (" + offset + ")";        }        return list;    }	/*public static void main(String[] args)	{		//double degree= Utilities.getDecimalDegree(48, 25, 0);		//System.out.println("Decimal degree: "+ degree);		//String s= Utilities.getDegreeString(degree);		//System.out.println("Degree: "+ s);        String[] list= Utilities.getTimeZoneList();        for (int i=0; i < list.length; i++)            System.out.println(list[i]);	}*/}