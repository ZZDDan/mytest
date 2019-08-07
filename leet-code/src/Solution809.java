/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2019/7/18 10:54
 * <p>
 * 809. 情感丰富的文字
 * 有时候人们会用重复写一些字母来表示额外的感受，比如 "hello" -> "heeellooo", "hi" -> "hiii"。
 * 我们将相邻字母都相同的一串字符定义为相同字母组，例如："h", "eee", "ll", "ooo"。
 * 对于一个给定的字符串 S ，如果另一个单词能够通过将一些字母组扩张从而使其和 S 相同，我们将这个单词定义为可扩张的（stretchy）。
 * 扩张操作定义如下：选择一个字母组（包含字母 c ），然后往其中添加相同的字母 c 使其长度达到 3 或以上。
 * 例如，以 "hello" 为例，我们可以对字母组 "o" 扩张得到 "hellooo"，但是无法以同样的方法得到 "helloo" 因为字母组 "oo" 长度小于 3。
 * 此外，我们可以进行另一种扩张 "ll" -> "lllll" 以获得 "helllllooo"。如果 S = "helllllooo"，那么查询词 "hello" 是可扩张的，
 * 因为可以对它执行这两种扩张操作使得 query = "hello" -> "hellooo" -> "helllllooo" = S。
 * 输入一组查询单词，输出其中可扩张的单词数量。
 * <p>
 * 示例：
 * 输入：
 * S = "heeellooo"
 * words = ["hello", "hi", "helo"]
 * 输出：1
 * 解释：
 * 我们能通过扩张 "hello" 的 "e" 和 "o" 来得到 "heeellooo"。
 * 我们不能通过扩张 "helo" 来得到 "heeellooo" 因为 "ll" 的长度小于 3 。
 * <p>
 * 说明：
 * 0 <= len(S) <= 100。
 * 0 <= len(words) <= 100。
 * 0 <= len(words[i]) <= 100。
 * S 和所有在 words 中的单词都只由小写字母组成。
 */
public class Solution809 {

    public static void main(String[] args) {
        int count = new Solution809().expressiveWords("vvvppppeeezzzzztttttkkkkkkugggggbbffffffywwwwwwbbbccccddddddkkkkksssppppddpzzzzzhhhhbbbbbmmmy",
                new String[]{"vvpeezztkkugbbffywwbccdkkspddpzzhbmmyy","vvpeezzttkkuuggbbffyywbbccdkspdppzhhbmy","vvppeezztkkuggbbfywbcdkspdpzhhbmyy","vvppeezzttkkuugbffyywwbbccddkkspddpzzhbmyy","vppezztkuuggbffywwbcdksspdppzhhbmyy","vvppeezzttkuuggbffywbccddkksspddppzzhhbmmy","vvppezzttkuggbffywbbccdkspddppzzhhbmy","vvpezzttkuugbbfywwbccdkssppdpzhbbmmy","vvpeezzttkuugbbffyywbccdksppddppzhhbmyy","vpeezzttkkuggbbffywbccddksppddpzhhbbmy","vvpezttkuuggbffywwbbccddkspdppzhhbmmyy","vppeezzttkkuugbffywbccddksppddpzhhbmmyy","vvpezttkkuugbbfywbccdkspddppzzhbbmmy","vppezzttkkuugbbffywwbcddkssppddpzhhbmmy","vppezzttkugbfywbbcdksppddppzzhhbmyy","vppeeztkuggbbffywbbccdkkspddppzzhbbmmy","vvpeeztkuuggbbfywbcdkksspddppzhhbbmmyy","vpezttkkuuggbbffyywwbbcdksspddppzhhbmy","vpeezzttkkuuggbffywwbccdkksspddppzzhbmyy","vpezttkkuugbffyywbccdksspddppzhbbmmyy","vvppezztkugbbffyywbbccdkksppdppzhbmyy","vvpeezttkuggbbfyywwbbcddkksppdpzzhbbmyy","vvpeztkuuggbffyywbbccdkksspddppzzhbbmy","vppeezzttkugbbffyywbccddksppdppzzhbmmyy","vppeezttkkuugbbfywwbccddkksspdpzhhbmmy","vpeezzttkugbbffywbbccdkksspddppzhbbmyy","vpeezttkkuugbbfywbbccddksppddppzzhhbmmy","vpeezztkuuggbbffywwbbccddksspddpzzhhbbmmyy","vppeezttkkuggbbffyywwbccdksspdpzzhbmy","vpezzttkkuugbbfyywbbcdksspdppzzhbbmyy","vvppezttkkuggbbfyywbbccdkksspddpzhbbmyy","vvpezzttkuggbbffyywbbcdkksppdpzzhbmmyy","vvpeztkugbfywwbccddkkspddpzhhbbmyy","vvppezttkuugbbfyywwbcddkksspdppzhhbbmy","vvpeeztkkuuggbbfywwbcdkspddpzzhhbmmy","vvpeezttkugbffywbbccdkkssppddppzhhbbmyy","vpeztkuuggbbfyywwbcddksppddpzhbbmy","vppeztkuggbbfyywbcdksspdppzzhhbmy","vppeezttkkugbbffyywbccddkksppdpzhhbmy","vvppeeztkugbfyywbcdkksppdppzhbmyy","vpezttkuugbbffywbcdksppddpzzhhbbmmy","vppezzttkuugbfyywbcddkksspdpzhbbmmy","vppezzttkkuggbffywbbcdksspdpzzhhbbmmyy","vpezzttkuggbfyywbbccdksspdpzhhbbmmy","vvppezttkkugbffyywbcdkssppdpzzhbmy","vvpeezttkkuuggbbfyywbbccdkspdppzhhbmy","vpeezttkkuugbfywbccddkksppddpzzhhbmmy","vvppezttkuuggbbffywbbccdkksppdpzzhhbbmmy","vvppeeztkuggbbffyywbccdksspddppzzhbmmyy","vvppeezztkuggbfywwbccddkkspddpzhbbmy","vpezttkuuggbfyywwbcdkkspdpzhhbbmmyy","vppezzttkuggbffywbbcdkkssppddppzhhbmyy","vppeztkuuggbffyywbccdkkspdppzzhhbmmyy","vppeezztkuuggbfywbccddkksspddppzhhbbmyy","vvppeztkuugbfywwbccdkkspddppzzhhbmmy","vvpezztkuugbbffyywwbbccddksppdpzhbbmmyy","vvpezzttkkuuggbffyywwbbcdkspdpzhbmmyy","vvppeztkkuuggbbfyywbbccdksppdppzzhbmmyy","vvppezztkuggbffyywwbcddkkssppdpzhbmmyy","vvpezzttkkuggbbffywwbcddkksspdpzzhhbbmmy","vpezztkkuuggbfyywwbccddkssppdppzhhbbmmy","vvppezztkuugbffywwbccdkkspdppzhhbmmy","vpeztkugbfyywwbcdkksspdppzzhbmmy","vvpeezzttkkugbbfywwbcdkkspdpzzhhbmmy","vpezzttkuuggbbfywbccdkspddppzzhhbbmmy","vppeztkkuugbffyywwbbcddksspddppzhbbmyy","vpeztkkuggbffyywbbccddkssppdppzhbmyy","vvppeezztkuggbffyywwbcddkksppdppzhbmyy","vpeezztkugbfyywbbccdkkspdppzhbmmyy","vvppeezttkugbfywwbcddkkssppdppzhbmmyy","vpeeztkuggbffywwbbccddksspdppzzhhbmmy","vvppeeztkuugbfywbcddkssppddppzzhhbbmyy","vpezzttkuggbbffyywwbbccdkssppddppzhbbmy","vpezttkugbfywbbcddkksspddppzhbbmy","vpeezzttkkuggbbffyywwbccddkspddppzhbmyy","vppeezzttkugbffywbccdkkspddpzhhbbmyy","vpezzttkuggbbfyywbbccdkksspddpzzhhbmmy","vvppezttkugbfywwbbcdkksspddpzzhhbbmyy","vppezztkkuggbffyywbcddkkssppddpzzhhbbmmy","vppeztkkuggbfywwbccdkksppdppzhhbmmy","vvpeezzttkugbffyywwbbcddkssppddpzzhbmmy","vvpezztkkuuggbfyywbccdkksspddpzhhbbmyy","vpezttkuuggbffywbbccdksppdpzhbmmyy","vvpezzttkuggbbfywbccddksspdpzzhhbmmy","vvpeezzttkkugbbfywwbcdkksppddpzhbmy","vppeezttkkuugbbfyywwbcddkkspdpzhhbbmmyy","vvppeeztkkuugbbfyywwbbcddkksspdppzhbbmyy","vvpeezzttkkuugbfywwbbcddkspdpzzhbbmyy"});
        System.out.println(count);
    }

    public int expressiveWords(String S, String[] words) {
        int wsl = words.length;
        int count = 0;


        System.out.println(S);

        for (int i = 0; i < wsl; i++) {
            count += compare(S, words[i]);
            System.out.println(count + " -> " + words[i]);
        }

        return count;
    }

    public int compare(String s, String word){
        int sl = s.length();
        int wl = word.length();

        // 如果 s 的长度小于 word+2，则直接返回
        if(sl - wl < 2){
            return 0;
        }

        int sIndex = 0;
        int count = 0;
        boolean flag = false;

        for (int i = 0; i < wl; i++) {
            if(sIndex >= sl){
                return 0;
            }

            // 相等，取下一个字符进行比较
            char scp = i > 0 ? s.charAt(sIndex - 1) : ' ';
            char sc = s.charAt(sIndex ++);
            char wc = word.charAt(i);

            if(sc == wc){
                if(scp == wc){
                    flag = ++count > 2 ? true:flag;
                } else {
                    count = 1;
                }
                continue;
            }

            // 不相等，判断是否和上一个相同
            //   不相等，return 0
            if(i == 0 || scp != sc){
                return 0;
            }

            //   相等，判断是否存在至少3个
            //       不足3个，return 0
            do {
                count ++;
                sc = s.charAt(sIndex ++);
            } while(scp == sc && sIndex < sl);

            flag = count > 2;
            if(!flag){
                return 0;
            }

            // count 归 0,重新计数，i-- 继续比较word 当前的操作
            count = 0;
            i-- ;
            sIndex--;

        }
        return flag ? 1 : 0;
    }
}
