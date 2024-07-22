package org.example.p0005;

import static org.example.Utils.getCurrentNano;
import static org.example.Utils.printTimeElapsed;

public class P0005_LongestPalindromicSubstring {

    public static void main(String[] args) {
        long start = getCurrentNano();

//        String pattern = "a";
        String pattern = "cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc";
//        String pattern = "fkyidosnupvunmklebjiepwdmfhqjfjgtcdivzgibcewxviirtneumvhcwzvstvtnzrnzknehahdipswtvgmqhmexnjtqcpngvojdxmhwqhrdcgybehvrfsqkroaztrhyeuuzkthfhwtbfnyghlzjqsqjpqvsrkabcxylpgylzzgyzmhruqyezfcvzcmzzuvtxlbfyukhvnytetagrhsebodddqiowahvflakfkefzlwkdjyxtymypkqkeniriybvdcfnqogilpeiviatavcbtxogxenbfhpfqklrekqefzjunpzrenqhorpqnhxllceubkndibdypbmbjscnryafertbursmghissihgmsrubtrefayrncsjbmbpydbidnkbuecllxhnqprohqnerzpnujzfeqkerlkqfphfbnexgoxtbcvataiviepligoqnfcdvbyirinekqkpymytxyjdkwlzfekfkalfvhawoiqdddobeshrgatetynvhkuyfblxtvuzzmczvcfzeyqurhmzygzzlygplyxcbakrsvqpjqsqjzlhgynfbtwhfhtkzuueyhrtzaorkqsfrvhebygcdrhqwhmxdjovgnpcqtjnxemhqmgvtwspidhahenkznrzntvtsvzwchvmuentriivxwecbigzvidctgjfjqhfmdwpeijbelkmnuvpunsodiykf";
//        String pattern = "qbmhukucteihghldwdobtvgwwnhflpceiwhbkmvxavmqxedfndegztlpjptpdowwavemasyrjxxnhldnloyizyxgqlhejsdylvkpdzllrzoywfkcamhljminikvwwvqlerdilrdgzifojjlgeayprejhaequyhcohoeonagsmfrqhfzllobwjhxdxzadwxiglvzwiqyzlnamqqsastxlojpcsleohgtcuzzrvwzqugyimaqtorkafyebrgmrfmczwiexdzcokbqymnzigifbqzvfzjcjuugdmvegnvkgbmdowpacyspszvgdapklrhlhcmwkwwqatfswmxyfnxkepdotnvwndjrcclvewomyniaefhhcqkefkyovqxyswqpnysafnydbiuanqphfhfbfovxuezlovokrsocdqrqfzbqhntjafzfjisexcdlnjbhwrvnyabjbshqsxnaxhvtmqlfgdumtpeqzyuvmbkvmmdtywquydontkugdayjqewcgtyajofmbpdmykqobcxgqivmpzmhhcqiyleqitojrrsknhwepoxawpsxcbtsvagybnghqnlpcxlnshihcjdjxxjjwyplnemojhodksckmqdvnzewhzzuswzctnlyvyttuhlreynuternbqonlsfuchxtsyhqlvifcxerzqepthwqrsftaquzuxwcmjjulvjrkatlfqshpyjsbaqwawgpabkkjrtchqmriykbdsxwnkpaktrvmxjtfhwpzmieuqevlodtroiulzgbocrtiuvpywtcxvajkpfmaqckgrcmofkxynjxgvxqvkmhdbvumdaprijkjxxvpqnxakiavuwnifvyfolwlekptxbnctjijppickuqhguvtoqfgepcufbiysfljgmfepwyaxusvnsratn";
//        String pattern = "adda";
//        String pattern = "civic";
//        String pattern = "bb";
//        String pattern = "ABCIVICICA";
//        String pattern = "glwhcebdjbdroiurzfxxrbhzibilmcfasshhtyngwrsnbdpzgjphujzuawbebyhvxfhtoozcitaqibvvowyluvdbvoqikgojxcefzpdgahujuxpiclrrmalncdrotsgkpnfyujgvmhydrzdpiudkfchtklsaprptkzhwxsgafsvkahkbsighlyhjvbburdfjdfvjbaiivqxdqwivsjzztzkzygcsyxlvvwlckbsmvwjvrhvqfewjxgefeowfhrcturolvfgxilqdqvitbcebuooclugypurlsbdfquzsqngbscqwlrdpxeahricvtfqpnrfwbyjvahrtosovsbzhxtutyfjwjbpkfujeoueykmbcjtluuxvmffwgqjgrtsxtdimsescgahnudmsmyfijtfrcbkibbypenxnpiozzrnljazjgrftitldcueswqitrcvjzvlhionutppppzxoepvtzhkzjetpfqsuirdcyqfjsqhdewswldawhdyijhpqtrwgyfmmyhhkrafisicstqxokdmynnnqxaekzcgygsuzfiguujyxowqdfylesbzhnpznayzlinerzdqjrylyfzndgqokovabhzuskwozuxcsmyclvfwkbimhkdmjacesnvorrrvdwcgfewchbsyzrkktsjxgyybgwbvktvxyurufsrdufcunnfswqddukqrxyrueienhccpeuqbkbumlpxnudmwqdkzvsqsozkifpznwapxaxdclxjxuciyulsbxvwdoiolgxkhlrytiwrpvtjdwsssahupoyyjveedgqsthefdyxvjweaimadykubntfqcpbjyqbtnunuxzyytxfedrycsdhkfymaykeubowvkszzwmbbjezrphqildkmllskfawmcohdqalgccffxursvbyikjoglnillapcbcjuhaxukfhalcslemluvornmijbeawxzokgnlzugxkshrpojrwaasgfmjvkghpdyxt";

//        Solution solution = new Solution();
        SolutionON2 solution = new SolutionON2();
        String palindrome = solution.longestPalindrome(pattern);
        System.out.printf("Pattern length %d, palindrome with length %d has been found: %s%n", pattern.length(), palindrome.length(), palindrome);
        printTimeElapsed(start, new Object(){}.getClass().getEnclosingMethod().getName());
    }
}

class SolutionON3 {
    int loop = 0;

    public String longestPalindrome(String s) {
        String result = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            String substringToCheck = s.substring(i);

            if (result.length() >= substringToCheck.length()) {
                System.out.println("Breaking main.....");
                break;
            }

            String palindrome = reverseMove(substringToCheck, result);
            if (!"".equals(palindrome)) {
                if (palindrome.length() > result.length()) {
                    result = palindrome;
                }
            }
        }
        return result;
    }

    protected String reverseMove(String pattern, String result) {
        for (int i = pattern.length(); i > 1; i--) {
            String testLine = pattern.substring(0, i);

            if (testLine.length() <= result.length()) {
                System.out.println("Breaking reverse .....");
                break;
            }
            boolean isPalindrome = checkIfPalindrome(testLine);
            if (isPalindrome) {
                System.out.println("Palindrome has been found ...");
                return testLine;
            }
        }
        return "";
    }

    protected boolean checkIfPalindrome1(String pattern) {
        System.out.println("Iteration: " + ++loop + ", testing: " + pattern);
        char[] array = pattern.toCharArray();
        for (int i = 0; i < array.length / 2; i++) {
            if (array[i] != array[array.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    protected boolean checkIfPalindrome2(String pattern) {
        System.out.println("Iteration: " + ++loop + ", testing: " + pattern);
        String reversed = new StringBuilder(pattern).reverse().toString();
        return pattern.equals(reversed);
    }


    protected boolean checkIfPalindrome(String pattern) {
        System.out.println("Iteration: " + ++loop + ", testing: " + pattern);
        return recursive(pattern);
    }

    protected boolean recursive(String input) {
        boolean result;
        if (input.substring(0, 1).equals(input.substring(input.length() - 1))) {
            if (input.length() <= 3) {
                return true;
            }
            String recursiveInput = input.substring(1, input.length() - 1);
            result = recursive(recursiveInput);
        } else {
            return false;
        }
        return result;
    }
}
