import java.util.*;

public class Main
{
	public static void main(String[] args)
	{

		Scanner input = new Scanner(System.in);

		System.out.println("Enter a number: ");
		String number = input.nextLine();
		String num = ""+number;
		String nw = "";
		String dec = "";
		Boolean zero = true;
		for(int i = 0;i<num.length();i++){
			char c = num.charAt(i);
			if(c == ' ')continue;
			if(zero && c == '0')continue;
			if(sieve(c).length() == 1 )zero = false;
			if(c != '.' && c != ','){
				nw += sieve(c);
			}
			else {
				for(int j = i+1;j<num.length();j++)dec += num.charAt(j);
				break;
			}
		}
		num = nw;
		int numlen = num.length();
		double groups = Math.floor(numlen / 3);
		String word = "";
		int rem;
		Boolean ok = true;
		for(int i = 1;i<=numlen;i+=3){
			int g = (i-1)/3 + 1;
			String[] fs = {
				"thousand","million","billion","trillion",
				"quadrillion","quintillion","sextillion",
				"septillion","octillion","nonillion",
				"decillion","undecillion","duodecillion",
				"tredecillion","Quattuordecillion",
				"quindecillion","sexdecillion",
				"septendecillion","octodecillion",
				"Novemdecillion","Vigintillion",
				"unvigintillion","duovigintillion",
				"trevigintillion","quattuorvigintillion",
				"quinvigintillion","sexvigintillion",
				"septenvigintillion","octovigintillion",
				"novemvigintillion","trigintillion",
				"untrigintillion","duotrigintillion"
				
			};
			int ind = g - 2;
			if(ind >= 0 && ind < fs.length)word = " "+fs[ind]+word;
			else if(ind != -1){
				word = "";
				System.out.println("You're drunk... aren't you?");
				break;
			}
			char r = 'n';
			char l = 'n';
			char m = 'n';
			rem = numlen - i+1;
			r = num.charAt(numlen-i);
			if(numlen-i-1 >= 0) m = num.charAt(numlen-1-i);
			if(numlen-i-2 >= 0) l = num.charAt(numlen-2-i);
			if(rem>=1 && m != '1'){
				if(r == '1')word = " one" + word;
				if(r == '2')word = " two"  + word;
				if(r == '3')word = " three"  + word;
				if(r == '4')word = " four"  + word;
				if(r == '5')word = " five" + word;
				if(r == '6')word = " six" + word;
				if(r == '7')word = " seven" + word;
				if(r == '8')word = " eight" + word;
				if(r == '9')word = " nine" + word;
			}
		if(rem >= 2){
			if(m == '1'){
				if(r == '0')word = " ten" + word;
				if(r == '1')word = " eleven" + word;
				if(r == '2')word = " twelve" + word;
				if(r == '3')word = " thirteen" + word;
				if(r == '4')word = " fourteen" + word;
				if(r == '5')word = " fifteen" + word;
				if(r == '6')word = " sixteen" + word;
				if(r == '7')word = " seventeen" + word;
				if(r == '8')word = " eighteen" + word;
				if(r == '9')word = " nineteen" + word;
			}
		    if(m == '2')word = " twenty" + word;
			if(m == '3')word = " thirty" + word;
			if(m == '4')word = " fourty" + word;
			if(m == '5')word = " fifty" + word;
			if(m == '6')word = " sixty" + word;
			if(m == '7')word = " seventy" + word;
			if(m == '8')word = " eighty" + word;
			if(m == '9')word = " ninety" + word;
		}
	if(rem >= 3){
		if(!(m =='0' && r== '0') && !(g > 1 && l == '0') )word = " and" + word;
		if(l != '0')word = " hundred" + word;
		if(l == '1')word = " one" + word;
		if(l == '2')word = " two" + word;
		if(l == '3')word = " three" + word;
		if(l == '4')word = " four" + word;
		if(l == '5')word = " five" + word;
		if(l == '6')word = " six" + word;
		if(l == '7')word = " seven" + word;
		if(l == '8')word = " eight" + word;
		if(l == '9')word = " nine" + word;
	}}
	String[] w = word.split(" ");
	word = w[0];
		String[] fs = {
			"thousand","million","billion","trillion",
			"quadrillion","quintillion","sextillion",
			"septillion","octillion","nonillion",
			"decillion","undecillion","duodecillion",
			"tredecillion","Quattuordecillion",
			"quindecillion","sexdecillion",
			"septendecillion","octodecillion",
			"Novemdecillion","Vigintillion",
			"unvigintillion","duovigintillion",
			"trevigintillion","quattuorvigintillion",
			"quinvigintillion","sexvigintillion",
			"septenvigintillion","octovigintillion",
			"novemvigintillion","trigintillion",
			"untrigintillion","duotrigintillion"

		};
	for(int wor = 1; wor<w.length;wor++){
		if(!(con(fs,w[wor]) && con(fs,w[wor -1])))word += w[wor] + " ";
	}
	if(dec.length() > 0){
		word += "point";
		for(int i = 0;i<dec.length();i++){
			char l = dec.charAt(i);
			if(l == '0')word += " zero";
			if(l == '1')word += " one";
			if(l == '2')word += " two";
			if(l == '3')word += " three";
			if(l == '4')word += " four";
			if(l == '5')word += " five";
			if(l == '6')word += " six";
			if(l == '7')word += " seven";
			if(l == '8')word += " eight";
			if(l == '9')word += " nine";
		}
	}
	System.out.println(word);
	}
	public static String sieve(char k){
		char[] valid = {
			'0','1','2','3','4','5','6','7','8','9'
		};
		for(int i = 0;i<valid.length;i++)if( valid[i] == k)return ""+k;
		return "";
	}
	public static boolean con(String[] ar,String elt){
		for(int i = 0; i<ar.length;i++)if(ar[i].equals(elt))return true;
	return false;
		}
}
