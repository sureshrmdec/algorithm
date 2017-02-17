package SocialOA;

import java.util.*; //这次差点儿忘了这个

//http://www.lintcode.com/en/problem/anagrams/#


public class Anagrams {
    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public static List<String> anagrams(String[] strs) {
        if (strs == null || strs.length == 0)
            return new ArrayList<String>();

        if (strs.length == 1) {
            List<String> res = new ArrayList<String>();
            res.add(strs[0]);
        }

        List<String> res = new ArrayList<>();
        HashMap<String, String> backup = new HashMap<>(); //show once, but not sure whether it is anagrams
        HashMap<String, String> store = new HashMap<>();//anagrams prototype
        backup.put(strs[0], strs[0]);
        for (int i = 1; i < strs.length; i++) {
            boolean inBackup = false;
            boolean isInStore = false; // if new string is in store hashmap, then we don't need to check backup hashmap
            //match any strings in store hashmap?
            for (String key : store.keySet()) {
                if (checkAnagram(store.get(key), strs[i])) {
                    res.add(strs[i]);
                    isInStore = true;
                }
            }

            //match any strings in backup hashmap?
            if (!isInStore) {
                for (String key : backup.keySet()) {
                    if (checkAnagram(backup.get(key), strs[i])) {
                        store.put(key, backup.get(key));
                        //backup.remove(key);  we cannot use remove here, it would cause hashmap coroutine error, adding while deleting?
                        res.add(key);
                        res.add(strs[i]);
                        inBackup = true;
                    }
                }
            }


            if (!isInStore && !inBackup)
                backup.put(strs[i], strs[i]);
        }
        return res;
    }

    //helper function is base on Two Strings Are Anagrams
    private static boolean checkAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) {
            count[(int) s.charAt(i)]++;
        }
        for (int i = 0; i < t.length(); i++) {
            count[(int) t.charAt(i)]--;
            if (count[(int) t.charAt(i)] < 0) {
                return false;
            }
        }
        return true;
    }

    public static  void main(String[] args) {
        //String[] test = {"ray","cod","abe","ned","arc","jar","owl","pop","paw","sky","yup","fed","jul","woo","ado","why","ben","mys","den","dem","fat","you","eon","sui","oct","asp","ago","lea","sow","hus","fee","yup","eve","red","flo","ids","tic","pup","hag","ito","zoo"};
        //String[] test =   {"ray","cod","abe","ned","arc","jar","owl","pop","paw","sky","yup","fed","jul","woo","ado","whx","ben","mys","den","dem","fat","you","eon","sui","oct","asp","ago","lea","sow","hus","fee","yup","eve","red","flo","ids","tic","pup","hag","ito","zoo"};
        String[] test = {"","c",""};
        for ( String item : anagrams(test) ){
            System.out.print(item + " ");
        }

    }
}