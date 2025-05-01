package com.se.unit3;

/**
 * @author LTMAX
 * @version 1.0
 * @className: PrimeNumber
 * @package: com.se.unit3
 * @description: 埃拉托斯特尼筛法,用于查找小于非负整数n的质数。
 * @date 2024/1/17 18:33
 */
public class SieveOfEratosthenes {
    public static void main(String[] args) {
        int n = 100;
        boolean[] isPrime = sieveOfEratosthenes(n);

        // 输出所有质数
        System.out.println("100以内的质数：");
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                System.out.print(i + " ");
            }
        }
    }

    /**
     *算法原理:通过非质数的体征来判断，并标记它们。具体来说，该算法会遍历从2到n的每个数，并检查它是否被标记为非质数
     * 1. 初始时，将所有的数标记为质数。
     * 2. 遍历所有质数，将所有质数的倍数标记为非质数。
     * 3. 重复步骤2，直到遍历到平方根的数。
     * 4. 未被标记的数即为质数。
     */
    private static boolean[] sieveOfEratosthenes(int n) {
        // 初始化一个布尔数组，表示每个数是否为质数
        // 默认所有数都是质数
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        // 开始筛选过程
        for (int i = 2; i * i <= n; i++) {
            // 如果 i 是质数
            if (isPrime[i]) {
                // 将 i 的倍数标记为非质数
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        return isPrime;
    }
}

