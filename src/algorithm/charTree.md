```
    用26个字母的字符减去字符a，可以得出他们的位置，存到数组中对应的26个下标，相当于字典
    这个解法最早在242题中看到
```

```java
class Solution {
        public boolean isAnagram(String s, String t) {
            // hash法
            ****if(s.length()!=t.length())**** return false;
            int[] hash = new int[26];
            for(int i = 0; i < s.length(); i++){
                hash[s.charAt(i) - 'a']++;
            }
            for(int i = 0; i < t.length(); i++){
                hash[t.charAt(i) - 'a']--;
                // 这里可能会出现t中有3个a，s中有1个a，但是没关系，s中肯定会有其他的地方少于t。
                if(hash[t.charAt(i) - 'a'] < 0){
                    return false;
                }
            }
            return true;
        }
}
```
