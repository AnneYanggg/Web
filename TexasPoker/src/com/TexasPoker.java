package com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TexasPoker {
	
	static String[] num2Name = {"0", "0", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "Ace"};
	
	static Map<String, Integer> mapName  = new HashMap<String, Integer>();
	
	static String msg;
	
	static{
		
		mapName.put("A", 14);
		mapName.put("2", 2);
		mapName.put("3", 3);
		mapName.put("4", 4);
		mapName.put("5", 5);
		mapName.put("6", 6);
		mapName.put("7", 7);
		mapName.put("8", 8);
		mapName.put("9", 9);
		mapName.put("10", 10);
		mapName.put("J", 11);
		mapName.put("Q", 12);
		mapName.put("K", 13);
		
	}
	
	public static ArrayList<Integer> create_list(String[] str_Arr) {
		ArrayList<Integer> numList = new ArrayList<Integer>();
		for (int i = 0 ; i < str_Arr.length; i++) {
			numList.add(mapName.get(str_Arr[i].substring(0, str_Arr[i].length()-1)));
		}
		return numList;
	}
	
	public static int Max_num(String[] str_Arr) {
		ArrayList<Integer> numList = create_list(str_Arr);

		Collections.sort(numList);
		
		return numList.get(str_Arr.length-1);
	}
	
	static int color_flag = 0;
	public static int compare(String[] white_Arr, String[] black_Arr) {
		ArrayList<Integer> whiteList = create_list(white_Arr);
		ArrayList<Integer> blackList = create_list(black_Arr);
		
		Collections.sort(whiteList);
		Collections.sort(blackList);
		
		boolean flag = true;
		int max_num = 0;
		int max_a = white_Arr.length-1;
		int max_b = black_Arr.length-1;
		
		while (flag) {
			if (whiteList.get(max_a) > blackList.get(max_b)) {
				max_num = whiteList.get(max_a);
				color_flag = 1;
				flag = false;
			}
			else if (whiteList.get(max_a) < blackList.get(max_b)){
				max_num = blackList.get(max_b);
				color_flag = 2;
				flag = false;
			}
			else {
				max_a = max_a - 1;
				max_b = max_b - 1;
			}
		}
		
		return max_num;
	}

	public static boolean isTONGHUASHUN(String[] str_Arr)
	{
		
		boolean th_flag = isTONGHUA(str_Arr);
		boolean sz_flag = isSHUN(str_Arr);
		
		if(th_flag && sz_flag) {
			return true;
		}
		return false;
	}
	
	static int tiezhi;	
	public static boolean isTIEZHI(String[] str_Arr){
		ArrayList<Integer> numList = create_list(str_Arr);
		
		Collections.sort(numList);
		
		int count = 1;
		
		int first_num = numList.get(0);
		for (int j = 1; j < str_Arr.length; j++) {
			if (numList.get(j) == first_num) {
				count = count + 1;
			}
			else if (count == 1) {
				first_num = numList.get(j);
			}
		}
		if (count == 4) {
			tiezhi = first_num;
			return true;
		}
		return false;
	}
	
	static int hulu, single_dui; 
	public static boolean isHULU(String[] str_Arr) {
		ArrayList<Integer> numList = create_list(str_Arr);
		Collections.sort(numList);
		
		int num_a = numList.get(0);
		int num_b = numList.get(str_Arr.length - 1);
		
		if (numList.get(1) != num_a) {
			return false;
		}
		
		if (numList.get(str_Arr.length - 2) != num_b) {
			return false;
		}
		
		if (numList.get(2) == num_a) {
			hulu = num_a;
			single_dui = num_b;
		}
		else if (numList.get(2) == num_b) {
			hulu = num_b;
			single_dui = num_a;
		}
		else {
			return false;
		}
		
		return true;
	}
	
	public static boolean isTONGHUA(String[] str_Arr) {
		char str_HUASE = str_Arr[0].charAt(str_Arr[0].length()-1);
		
		for (int i = 1; i < 5; i++) {
			if(str_Arr[i].charAt(str_Arr[i].length()-1) != str_HUASE) {
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean isSHUN(String[] str_Arr)
	{
		ArrayList<Integer> numList = create_list(str_Arr);
		
		Collections.sort(numList);
		
		int first_num = numList.get(0);
		for (int i = 1; i < numList.size(); i++) {
			if(numList.get(i) != first_num + 1) {
				return false;
			}
			first_num = numList.get(i);
		}
		return true;
		
	}
	
	static int santiao;
	public static boolean isSANTIAO(String[] str_Arr)
	{
		ArrayList<Integer> numList = create_list(str_Arr);
		
		Collections.sort(numList);	
		
		for (int i = 0; i < str_Arr.length-1; i++) {
			int num = numList.get(i);
			int count = 1;
			for (int j = i+1; j < str_Arr.length; j++) {
				if (numList.get(j) == num) {
					count = count + 1;
					}
			}
			if (count == 3) {
				santiao = num;
				return true;
			}
		}	
		return false;
	}
	
	static int[] double_num = {0,0,0,0};
	public static boolean isDOUBLEDUI(String[] str_Arr)
	{
		ArrayList<Integer> numList = create_list(str_Arr);
		
		Collections.sort(numList);
		
		int num = numList.get(0);
		int count = 1;
		for (int j = 1; j < str_Arr.length; j++) {
			if (numList.get(j) != num) {
				num = numList.get(j);
			}
			else {
				double_num[count] = numList.get(j);
				count = count + 1;
			}
		}
		if (count == 2) {
			return true;
		}
		
		return false;
	}
	
	static int dui;
	static int maxNum_dui;
	public static boolean isDUI(String[] str_Arr)
	{
		ArrayList<Integer> numList = create_list(str_Arr);
		
		Collections.sort(numList);	
		
		for (int i = 0; i < str_Arr.length-1; i++) {
			int num = numList.get(i);
			for (int j = i+1; j < str_Arr.length; j++) {
				if (numList.get(j) != num) {
					num = numList.get(j);
				}
				else {
					dui = num;
					if(j != 4)
						maxNum_dui = numList.get(4);
					else
						maxNum_dui = numList.get(2);
					return true;
				}
			}
		}
		
		return false;
	}
	
	public static String judge(boolean white_flag, boolean black_flag, String name, int white_num, int black_num) {
		if (white_flag == true && black_flag == false) {
//			System.out.println("White win - " + name);
			msg = "White wins - " + name;
			return msg;
		}
		
		if (white_flag == false && black_flag == true) {
//			System.out.println("Black win - " + name);
			msg = "Black wins - " + name;
			return msg;
		}
		
		if (white_flag == true && black_flag == true) {
			if (white_num > black_num) {
//				System.out.println("White win - " + name + " - high card: " + num2Name[white_num]);
				msg = "White wins - " + name + " - high card: " + num2Name[white_num];
			}
			else if(white_num < black_num) {
//				System.out.println("Black win - " + name + " - high card: " + num2Name[black_num]);
				msg = "Black wins - " + name + " - high card: " + num2Name[black_num];
			}
			else {
//				System.out.println("Tie");
				msg = "Tie";
			}
			System.exit(0);
		}
		return msg;
	}
	
	public static String TONGHUASHUN(String[] white_Arr, String[] black_Arr)
	{
		boolean white_flag = isTONGHUASHUN(white_Arr);
		boolean black_flag = isTONGHUASHUN(black_Arr);
		
		int max_white = Max_num(white_Arr);
		int max_black = Max_num(black_Arr);
		
		msg = judge(white_flag, black_flag, "straight flush", max_white, max_black);
		
		return msg;
	}
	
	public static String TIEZHI(String[] white_Arr, String[] black_Arr) {
		boolean white_flag = isTIEZHI(white_Arr);
		int max_white = tiezhi;
		boolean black_flag = isTIEZHI(black_Arr);
		int max_black = tiezhi;
		
		msg = judge(white_flag, black_flag, "four of a kind", max_white, max_black);
		
		return msg;
	}
	
	public static String HULU(String[] white_Arr, String[] black_Arr)
	{
		boolean white_flag = isHULU(white_Arr);
		int max_white = hulu;
		int white_dui = single_dui;
		boolean black_flag = isHULU(black_Arr);
		int max_black = hulu;
		int black_dui = single_dui;
		
		if (white_flag == true && black_flag == false) {
//			System.out.println("White win - hulu");
			msg = "White wins - full house";
			return msg;
		}
		
		if (white_flag == false && black_flag == true) {
//			System.out.println("Black win - hulu");
			msg = "Black wins - full house";
			return msg;
		}
		
		if (white_flag == true && black_flag == true) {
			if (max_white > max_black) {
//				System.out.println("White win - hulu - high card: " + num2Name[max_white]);
				msg = "White wins - full house - high card: " + num2Name[max_white];
				return msg;
			}
			else if(max_white < max_black) {
//				System.out.println("Black win - hulu - high card: " + num2Name[max_black]);
				msg = "Black wins - full house - high card: " + num2Name[max_black];
				return msg;
			}
			
			if (white_dui > black_dui) {
//				System.out.println("White win - hulu - high card: " + num2Name[white_dui]);
				msg = "White wins - full house - high card: " + num2Name[white_dui];
				return msg;
			}
			else if (white_dui < black_dui) {
//				System.out.println("Black win - hulu - high card: " + num2Name[black_dui]);
				msg = "Black wins - full house - high card: " + num2Name[black_dui];
				return msg;
			}
			else {
//				System.out.println("Tie");
				msg = "Tie";
				return msg;
			}
			
		}
		return msg;
	}
	
	public static String TONGHUA(String[] white_Arr, String[] black_Arr)
	{

		boolean white_flag = isTONGHUA(white_Arr);
		boolean black_flag = isTONGHUA(black_Arr);
		
		if (white_flag == true && black_flag == false) {
//			System.out.println("White win - Tonghua");
			msg = "White wins - flush";
			return msg;
		}
		
		if (white_flag == false && black_flag == true) {
//			System.out.println("Black win - Tonghua");
			msg = "Black wins - flush";
			return msg;
		}
		
		if (white_flag == true && black_flag == true) {
			int max_num = compare(white_Arr, black_Arr);
			int cl_flag = color_flag;
			if (cl_flag == 1) {
//				System.out.println("White win - tonghua - high card: " + num2Name[max_num]);
				msg = "White wins - flush - high card: " + num2Name[max_num];
				return msg;
			}
			if (cl_flag == 2) {
//				System.out.println("Black win - tonghua - high card: " + num2Name[max_num]);
				msg = "Black wins - flush - high card: " + num2Name[max_num];
				return msg;
			}
		}
		return msg;	
	}
	
	public static String SHUN(String[] white_Arr, String[] black_Arr)
	{

		boolean white_flag = isSHUN(white_Arr);
		int max_white = Max_num(white_Arr);
		boolean black_flag = isSHUN(black_Arr);
		int max_black = Max_num(black_Arr);
				
		msg = judge(white_flag, black_flag, "straight", max_white, max_black);
		
		return msg;
	}
	
	public static String SANTIAO(String[] white_Arr, String[] black_Arr)
	{

		boolean white_flag = isSANTIAO(white_Arr);
		int max_white = santiao;
		boolean black_flag = isSANTIAO(black_Arr);
		int max_black = santiao;
				
		msg = judge(white_flag, black_flag, "three of a kind", max_white, max_black);
		
		return msg;
	}
	
	//输出两个数并比较大小如何实现？
	public static String DOUBLEDUI(String[] white_Arr, String[] black_Arr)
	{
		boolean white_flag = isDOUBLEDUI(white_Arr);
		int[] max_white = double_num;
		boolean black_flag = isDOUBLEDUI(black_Arr);
		int[] max_black = double_num;
				
		boolean dd_flag = true;
		if (white_flag == true && black_flag == false) {
//			System.out.println("White win - DoubleDui");
			msg = "White wins - two pairs";
			return msg;
		}
		
		if (white_flag == false && black_flag == true) {
//			System.out.println("Black win - DoubleDui");
			msg = "Black wins - two pairs";
			return msg;
		}
		
		if (white_flag == true && black_flag == true) {
			int num = 2;
			if (max_white == null || max_black == null) {
				System.err.println("Null number in the List!");
			}
			while (dd_flag && num > 0) {
				if (max_white[num] > max_black[num]) {
//					System.out.println("White win - DoubleDui - high card: " + num2Name[max_white[num]]);
					msg = "White wins - two pairs- high card: " + num2Name[max_white[num]];
					dd_flag = false;
					return msg;
				}
				else if (max_white[num] < max_black[num]) {
//					System.out.println("Black win - DoubleDui - high card: " + num2Name[max_black[num]]);
					msg = "Black wins - two pairs- high card: " + num2Name[max_black[num]];
					dd_flag = false;
					return msg;
				}
				else {
					num = num - 1;
				}
			}
		}
		return msg;
	}
	
	public static String DUI(String[] white_Arr, String[] black_Arr)
	{

		boolean white_flag = isDUI(white_Arr);
		int white_dui = dui;
		boolean black_flag = isDUI(black_Arr);
		int black_dui = dui;
				
		if (white_flag == true && black_flag == false) {
//			System.out.println("White win - DuiZi");
			msg = "White wins - one pair";
			return msg;
		}
		
		if (white_flag == false && black_flag == true) {
//			System.out.println("Black win - DuiZi");
			msg = "Black wins - one pair";
			return msg;
		}
		
		if (white_flag == true && black_flag == true) {
			if (white_dui > black_dui) {
//				System.out.println("White win - DuiZi - high card: " + num2Name[white_dui]);
				msg = "White wins - one pair - high card: " + num2Name[white_dui];
			}
			else if(white_dui < black_dui) {
//				System.out.println("Black win - DuiZi - high card: " + num2Name[black_dui]);
				msg = "Black wins - one pair - high card: " + num2Name[black_dui];
			}
			else {
//				System.out.println("Tie");
				msg = "Tie";
			}
			return msg;
		}
		return msg;
	}
	
	//这里没有问题 怎么把他加到tonghua里
	public static String SANLIE(String[] white_Arr, String[] black_Arr)
	{
		boolean sl_flag = true;
		ArrayList<Integer> whiteList = create_list(white_Arr);
		ArrayList<Integer> blackList = create_list(black_Arr);
		
		Collections.sort(whiteList);
		Collections.sort(blackList);
		
		int white_index = white_Arr.length-1;
		int black_index = black_Arr.length-1; 
		while (sl_flag) {
			if (whiteList.get(white_index) > blackList.get(black_index)) {
				sl_flag = false;
//				System.out.println("White win - high card: " + num2Name[whiteList.get(white_index)]);
				msg = "White wins - high card: " + num2Name[whiteList.get(white_index)];
				return msg;
			}
			
			if (whiteList.get(white_index) < blackList.get(black_index)) {
				sl_flag = false;
//				System.out.println("Black win - high card: " + num2Name[blackList.get(black_index)]);
				msg = "Black wins - high card: " + num2Name[blackList.get(white_index)];
				return msg;
			}
			
			if (whiteList.get(white_index) == blackList.get(black_index)) {
				white_index = white_index - 1;
				black_index = black_index - 1;
			}
			
			if (white_index == 0) {
				sl_flag = false;
//				System.out.println("Tie");
				msg = "Tie";
				return msg;
			}
		}
		return msg;
	}
	
	public static String contest(String white, String black) {
		String[] white_Arr = white.split(" ");
		String[] black_Arr = black.split(" ");
		
		String msg = null;
		msg = TONGHUASHUN(white_Arr, black_Arr);
		msg = TIEZHI(white_Arr, black_Arr);
		msg = HULU(white_Arr, black_Arr);
		msg = TONGHUA(white_Arr, black_Arr);
		msg = SHUN(white_Arr, black_Arr);
		msg = SANTIAO(white_Arr, black_Arr);
		msg = DOUBLEDUI(white_Arr, black_Arr);
		msg = DUI(white_Arr, black_Arr);
		msg = SANLIE(white_Arr, black_Arr);
		return msg;
	}
	
	public static void main(String[] args) {
		String white = "2S 8S AS QS 3S";
		String black = "2H 4S 4C 2D 4H";
		String result = contest(white, black);
		System.out.println(result);
	}
}
