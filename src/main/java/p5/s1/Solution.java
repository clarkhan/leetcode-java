package p5.s1;

/**
 * p5.s1
 * 思路是以回文的中间点为起点，向两边进行检查
 *
 * @author khan
 * @version 1.0.0
 *          Created by khan on 2015/3/22 18:32.
 */
public class Solution {

    /**
     * 求s包含的最长的回文字符串
     * @param s 给定字符串s
     * @return 包含的最长回文字符串
     */
    public String longestPalindrome(String s) {
        if (null == s || s.isEmpty()) {
            return "";
        }

        char[] chars = s.toCharArray();

        int l = 1;//单边长度
        boolean isPublic = true;//公用起点
        int offset = 0;//中间点（起点）index
        for (int i = 0; i < chars.length - l; i++) {
            // 从第1个，也就是索引为 0 开始
            // 到倒数第二个，也就是索引为 chars.length - 2 结束

            int cl = l - 1;// 需要检查的长度，公用起点长度减一
            int pub = findPalindrome(chars, i - 1, i + 1, cl);// 共用起点，起点不用判断，直接判断下一个 长度 2pub - 1
            if (pub > cl) {
                l = pub + 1;
                isPublic = true;
                offset = i;
            }

            // 上一次是公用起点得出的长度的话，需要减一求最长，因为单边长度相同，非公用起点的字符串长度更长
            if (isPublic) {
                cl = l - 1;
            }else {
                cl = l;
            }
            int nPub = findPalindrome(chars, i, i + 1, cl);// 非共用起点，长度 2nPub
            if (nPub > cl) {
                l = nPub;
                isPublic = false;
                offset = i;
            }
        }
        return new String(chars, offset - l + 1, isPublic ? 2 * l - 1 : 2 * l);
    }

    /**
     * 以给定的left和right位置，从chars中找出向两边延伸的相等的最大长度，如果不大于给定length则返回length
     * @param chars 字符数组
     * @param left 向左起始位置（index）
     * @param right 向右起始位置（index）
     * @param length 目前长度
     * @return 最终符合要求的最大长度
     */
    public int findPalindrome(char[] chars, int left,int right, int length) {

        if (left - length < 0 || right + length > chars.length - 1 || chars[left - length] != chars[right + length]) {
            // 长度不足以支撑更长的或者更长的已经不满足条件则退出
            return length;
        }
        // 第 l + 1个相同，可能会更长，前提是 < l + 1 之内的都相同
        for (int i = 0; i < length; i++) {
            if (chars[left - i] != chars[right + i]) {
                return length;
            }
        }
        // l + 1 也相同，肯定符合，判断能否更多
        for (int i = length + 1; i <= left && i <= chars.length - 1 - right ; i++) {
            if (chars[left - i] != chars[right + i]) {
                // 遇到不同的，说明只能到前一个了
                return i;
            }
        }
        // 如果都通过了，说明left的或right的都OK
        if (chars.length - 1 - right < left) {
            return chars.length - right;
        } else {
            return left + 1;
        }
    }


}
